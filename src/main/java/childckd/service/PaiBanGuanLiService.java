package childckd.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.GuahaoMapper;
import childckd.dao.PaibanguanliMapper;
import childckd.model.Guahao;
import childckd.model.GuahaoExample;
import childckd.model.Paibanguanli;
import childckd.model.PaibanguanliExample;
import childckd.model.ScheduleExample;

@Service
public class PaiBanGuanLiService {

	@Autowired
	PaibanguanliMapper ddMapper;
	
	@Autowired
	GuahaoMapper ddGuahaoMapper;
	
	public List<Map<String, Object>> findWeekPaibanByExpertId(String ppExpertId) {
		return ddMapper.findWeekPaibanByExpertId(ppExpertId);
	}

	public List<Map<String,Object>> find_custom_one(String ppPaibanId) {
		return ddMapper.find_custom_one(ppPaibanId);
	}
	
	public List<Map<String,Object>> findPaiBanGuanLiByNameAndDateAndShangxiawu(String ppName, String mmPaiBanRiQi, String ppShangxiawu) {
		return ddMapper.findPaiBanGuanLiByNameAndDateAndShangxiawu(ppName,mmPaiBanRiQi,ppShangxiawu);
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

	

	
}
