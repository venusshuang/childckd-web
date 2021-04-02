package childckd.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.GuahaoMapper;
import childckd.dao.PaibanguanliMapper;
import childckd.model.GuahaoExample;
import childckd.model.Paibanguanli;
import childckd.model.PaibanguanliExample;
import childckd.model.Tingzhen;
import childckd.dao.TingzhenMapper;

@Service
public class PaiBanGuanLiService {

	@Autowired
	PaibanguanliMapper ddMapper;
	
	@Autowired
	GuahaoMapper ddGuahaoMapper;

	@Autowired
	TingzhenMapper ddTingzhenMapper;
	
	public List<Map<String, Object>> findWeekPaibanByExpertId(String ppExpertId) {
		List<Map<String,Object>> mmPaibanList = ddMapper.findWeekPaibanByExpertId(ppExpertId);

		// 处理剩余号数 改为动态的限号数-审核通过的数量
		for(int i = 0 ; i < mmPaibanList.size() ; i++){
			Map<String,Object> mmPaiban = mmPaibanList.get(i);
			String mmExpertId = mmPaiban.get("expertid") == null ? "" : mmPaiban.get("expertid").toString();
			String mmPaibanriqi =  mmPaiban.get("paibanriqi") == null ? "" : mmPaiban.get("paibanriqi").toString();
			String mmPaibanId = mmPaiban.get("paibanid").toString();
			int mmXianhaoshu = Integer.parseInt(mmPaiban.get("xianhaoshu").toString());
			int mmCountTongguo = countFindYuyue(mmPaibanId,1);

			int mmDangtianZongxianhaoshu = 0;
			int mmDangtianTongguoshu = 0;
			// 根据专家id和排版日期查找审核通过数量和限号数
			List<Paibanguanli> mmPaibanguanliList = findDayByExpertidAndPaibanriqi(mmExpertId,mmPaibanriqi);
			for(int j = 0 ; j < mmPaibanguanliList.size() ; j++){
				Paibanguanli mmTempPaibanguanli = mmPaibanguanliList.get(j);
				String mmTempPaibanId = mmTempPaibanguanli.getPaibanid();
				mmDangtianZongxianhaoshu += mmTempPaibanguanli.getXianhaoshu();

				// 当天通过数之和
				mmDangtianTongguoshu += countFindYuyue(mmTempPaibanId,1);
			}

			List<Tingzhen> mmTingzhenList = findTingzhenbythis(mmExpertId,mmPaibanriqi,"");

			if(mmTingzhenList.size()>0)
			{
				mmPaiban.put("shengyuhaoshu","-9999");//停诊
			}else{

				// 这个专家在这一天排版中的所有通过数量 小于 这个专家在这一天排版中的限号数之和 ，则剩余号数为实际号数 否则限号数为0
				if (mmDangtianTongguoshu < mmDangtianZongxianhaoshu) {
					mmPaiban.put("shengyuhaoshu",mmXianhaoshu-mmCountTongguo);
				}else{
					mmPaiban.put("shengyuhaoshu",0);
				}

			}
		}

		return mmPaibanList;
	}

	public List<Map<String,Object>> find_custom_one(String ppPaibanId) {
		return ddMapper.find_custom_one(ppPaibanId);
	}

	public List<Paibanguanli> findByExpertIdAndDateAndShangxiawu(String ppExpertId,Date ppDate,String ppShangxiawu){
		PaibanguanliExample mmExample = new PaibanguanliExample();
		mmExample.createCriteria().andExpertidEqualTo(ppExpertId).andPaibanriqiEqualTo(ppDate).andShangxiawuEqualTo(ppShangxiawu);
		return ddMapper.selectByExample(mmExample);
	}

	public List<Map<String,Object>> findPaiBanGuanLiByExpertidAndDate(String ppExpertid_search, String mmPaiBanRiQi, String ppShangxiawu) {
		List<Map<String,Object>> mmPaibanList = ddMapper.findPaiBanGuanLiByExpertidAndDate(ppExpertid_search,mmPaiBanRiQi,ppShangxiawu);

		// 处理剩余号数 改为动态的限号数-审核通过的数量
		for(int i = 0 ; i < mmPaibanList.size() ; i++){
			Map<String,Object> mmPaiban = mmPaibanList.get(i);
			String mmExpertId = mmPaiban.get("expertid") == null ? "" : mmPaiban.get("expertid").toString();
			String mmPaibanriqi =  mmPaiban.get("paibanriqi") == null ? "" : mmPaiban.get("paibanriqi").toString();
			String mmPaibanId = mmPaiban.get("paibanid").toString();
			int mmXianhaoshu = Integer.parseInt(mmPaiban.get("xianhaoshu").toString());
			int mmCountTongguo = countFindYuyue(mmPaibanId,1);

			int mmDangtianZongxianhaoshu = 0;
			int mmDangtianTongguoshu = 0;
			// 根据专家id和排版日期查找审核通过数量和限号数
			List<Paibanguanli> mmPaibanguanliList = findDayByExpertidAndPaibanriqi(mmExpertId,mmPaibanriqi);
			for(int j = 0 ; j < mmPaibanguanliList.size() ; j++){
				Paibanguanli mmTempPaibanguanli = mmPaibanguanliList.get(j);
				String mmTempPaibanId = mmTempPaibanguanli.getPaibanid();
				mmDangtianZongxianhaoshu += mmTempPaibanguanli.getXianhaoshu();

				// 当天通过数之和
				mmDangtianTongguoshu += countFindYuyue(mmTempPaibanId,1);
			}

			List<Tingzhen> mmTingzhenList = findTingzhenbythis(mmExpertId,mmPaibanriqi,ppShangxiawu);

			if(mmTingzhenList.size()>0)
			{
				mmPaiban.put("shengyuhaoshu","-9999");//停诊
			}else{

				// 这个专家在这一天排版中的所有通过数量 小于 这个专家在这一天排版中的限号数之和 ，则剩余号数为实际号数 否则限号数为0
				if (mmDangtianTongguoshu < mmDangtianZongxianhaoshu) {
					mmPaiban.put("shengyuhaoshu",mmXianhaoshu-mmCountTongguo);
				}else{
					mmPaiban.put("shengyuhaoshu",0);
				}

			}




		}

		return mmPaibanList;
	}

	
	public List<Map<String,Object>> findPaiBanGuanLiByNameAndDateAndShangxiawu(String ppName, String mmPaiBanRiQi, String ppShangxiawu) {
		List<Map<String,Object>> mmPaibanList = ddMapper.findPaiBanGuanLiByNameAndDateAndShangxiawu(ppName,mmPaiBanRiQi,ppShangxiawu);

		// 处理剩余号数 改为动态的限号数-审核通过的数量
		for(int i = 0 ; i < mmPaibanList.size() ; i++){
			Map<String,Object> mmPaiban = mmPaibanList.get(i);
			String mmExpertId = mmPaiban.get("expertid") == null ? "" : mmPaiban.get("expertid").toString();
			String mmPaibanriqi =  mmPaiban.get("paibanriqi") == null ? "" : mmPaiban.get("paibanriqi").toString();
			String mmPaibanId = mmPaiban.get("paibanid").toString();
			int mmXianhaoshu = Integer.parseInt(mmPaiban.get("xianhaoshu").toString());
			int mmCountTongguo = countFindYuyue(mmPaibanId,1);

			int mmDangtianZongxianhaoshu = 0;
			int mmDangtianTongguoshu = 0;
			// 根据专家id和排版日期查找审核通过数量和限号数
			List<Paibanguanli> mmPaibanguanliList = findDayByExpertidAndPaibanriqi(mmExpertId,mmPaibanriqi);
			for(int j = 0 ; j < mmPaibanguanliList.size() ; j++){
				Paibanguanli mmTempPaibanguanli = mmPaibanguanliList.get(j);
				String mmTempPaibanId = mmTempPaibanguanli.getPaibanid();
				mmDangtianZongxianhaoshu += mmTempPaibanguanli.getXianhaoshu();

				// 当天通过数之和
				mmDangtianTongguoshu += countFindYuyue(mmTempPaibanId,1);
			}

			List<Tingzhen> mmTingzhenList = findTingzhenbythis(mmExpertId,mmPaibanriqi,ppShangxiawu);

			if(mmTingzhenList.size()>0)
			{
				mmPaiban.put("shengyuhaoshu","-9999");//停诊
			}else{

				// 这个专家在这一天排版中的所有通过数量 小于 这个专家在这一天排版中的限号数之和 ，则剩余号数为实际号数 否则限号数为0
				if (mmDangtianTongguoshu < mmDangtianZongxianhaoshu) {
					mmPaiban.put("shengyuhaoshu",mmXianhaoshu-mmCountTongguo);
				}else{
					mmPaiban.put("shengyuhaoshu",0);
				}

			}




		}

		return mmPaibanList;
	}

	public Paibanguanli findOne(String ppPaiBanId) {
		return ddMapper.selectByPrimaryKey(ppPaiBanId);
	}

	public boolean add(Paibanguanli mmPaibanguanli) {
		return ddMapper.insert(mmPaibanguanli) == 1;
	}

	public boolean modify(Paibanguanli mmPaibanguanli) {
		return ddMapper.updateByPrimaryKey(mmPaibanguanli) == 1 ;
	}

	public boolean delete(String ppPaiBanId) {
		return ddMapper.deleteByPrimaryKey(ppPaiBanId) == 1;
	}

	@Transactional
	public boolean deletePaibanIdList(String[] mmList) {
		try
		{
			for (int i = 0 ; i <mmList.length ; i++ ) 
			 {
				 delete(mmList[i]);
			 } 
			
		}catch (Exception e) {
			
			throw new RuntimeException("批量删除失败");
			
		}
		 
		return true;
	}

	

	public List<Map<String, Object>> findByExpertidAndPaibanriqi(String ppExpertId, String ppPaiBanRiQi, int ppPageIndex, int ppPageSize) {
		int mmStartIndex = (ppPageIndex-1)*ppPageSize;
		return ddMapper.findByExpertidAndPaibanriqi(ppExpertId,ppPaiBanRiQi, mmStartIndex, ppPageSize);
	}

	public int countFindYuyue(String mmPaibanid, int ppShenhejieguo) {
		GuahaoExample mmExample = new GuahaoExample();
		mmExample.createCriteria().andPaibanidEqualTo(mmPaibanid).andShenhejieguoEqualTo(ppShenhejieguo).andZhuangtaiEqualTo(1);
		int mmCount = ddGuahaoMapper.countByExample(mmExample);
		return mmCount;
	}

	public int CountByExpertidAndPaibanriqi(String ppExpertId, String ppPaiBanRiQi) {
		
		Object mmCount = ddMapper.CountByExpertidAndPaibanriqi(ppExpertId,ppPaiBanRiQi);
		return (mmCount == null) ? 0 : Integer.parseInt(mmCount.toString());
		
	}


	public List<Paibanguanli> findDayByExpertidAndPaibanriqi(String ppExpertId, String ppPaiBanRiQi) {
		return ddMapper.findDayByExpertidAndPaibanriqi(ppExpertId,ppPaiBanRiQi);
	}

	public List<Tingzhen> findTingzhenbythis(String ppExpertId, String ppPaiBanRiQi,String ppShangxiawu) {
		return ddTingzhenMapper.findTingzhenbythis(ppExpertId,ppPaiBanRiQi,ppShangxiawu);
	}
}
