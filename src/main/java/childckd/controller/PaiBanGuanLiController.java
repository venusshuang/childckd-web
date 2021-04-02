package childckd.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Paibanguanli;
import childckd.service.PaiBanGuanLiService;
import childckd.util.BooleanMessage;
import childckd.util.DateUtil;
import childckd.util.JsonResult;
import childckd.util.PageInfo;

@RestController
@RequestMapping("paiban")
public class PaiBanGuanLiController {
	
	@Autowired
	PaiBanGuanLiService ddService;
	
	@RequestMapping("find_weekpaiban_by_expertid")
	public JsonResult<?>findWeekPaibanByExpertId(@RequestParam("expertid")String ppExpertId){
		try {
			List<Map<String, Object>> mmList = ddService.findWeekPaibanByExpertId(ppExpertId);
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("paibanguanli/findWeekPaibanByExpertId:error " + e.getMessage());
		}
	}

	@RequestMapping("findPaiBanGuanLiByExpertidAndDate")
	public JsonResult<?> findPaiBanGuanLiByExpertidAndDate(@RequestParam("expertid_search") String ppExpertid_search,@RequestParam("paibanriqi") String ppPaiBanRiQi,@RequestParam("shangxiawu") String ppShangxiawu) {
		try {
			//Date mmPaiBanRiQi = DateUtil.convertShortStringToDate(ppPaiBanRiQi);
			return JsonResult.getSuccessResult(ddService.findPaiBanGuanLiByExpertidAndDate(ppExpertid_search,ppPaiBanRiQi,ppShangxiawu));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("paibanguanli/findPaiBanGuanLiByNameAndDate:error " + e.getMessage());
		}
	}
	
	@RequestMapping("findPaiBanGuanLiByNameAndDateAndShangxiawu")
	public JsonResult<?> findPaiBanGuanLiByNameAndDateAndShangxiawu(@RequestParam("name") String ppName,@RequestParam("paibanriqi") String ppPaiBanRiQi,@RequestParam("shangxiawu") String ppShangxiawu) {
		try {
			//Date mmPaiBanRiQi = DateUtil.convertShortStringToDate(ppPaiBanRiQi);
			return JsonResult.getSuccessResult(ddService.findPaiBanGuanLiByNameAndDateAndShangxiawu(ppName,ppPaiBanRiQi,ppShangxiawu));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("paibanguanli/findPaiBanGuanLiByNameAndDate:error " + e.getMessage());
		}
	}

	@RequestMapping("findByExpertidAndPaibanriqi")
	public JsonResult<?> findByExpertidAndPaibanriqi(@RequestParam("expertid") String ppExpertId,@RequestParam("paibanriqi") String ppPaiBanRiQi,@RequestParam("pageindex") int ppPageIndex, @RequestParam("pagesize") int ppPageSize) {
		try {
			int mmCount = ddService.CountByExpertidAndPaibanriqi(ppExpertId,ppPaiBanRiQi);
			PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);
			List<Map<String, Object>>mmList = ddService.findByExpertidAndPaibanriqi(ppExpertId,ppPaiBanRiQi, ppPageIndex, ppPageSize);

			String mmExpertName=null;
			String mmExpertId=null;
			String mmAllowYuyueCount=null;
			String mmConfirmYuyueCount=null;
			String mmUnConfirmYuyueCount=null;
			String mmPaibanriqi=null;

			Map<String, Object> mmMap = new HashMap<String, Object>();

			Map<String, Object> mmCountMap = new HashMap<String, Object>();

			List<Map<String, Object>> mmListMap =new ArrayList<Map<String, Object>>();

			for(int i=0;i<mmList.size();i++)
			{
				mmMap = new HashMap<String, Object>();


				mmExpertId=mmList.get(i).get("expertid").toString();
				mmExpertName=mmList.get(i).get("name").toString();
				mmPaibanriqi=mmList.get(i).get("paibanriqi").toString();
				mmCountMap= yuyueCount(mmExpertId,mmPaibanriqi);
				mmAllowYuyueCount=mmCountMap.get("AllowYuyueCount").toString();
				mmConfirmYuyueCount=mmCountMap.get("ConfirmYuyueCount").toString();
				mmUnConfirmYuyueCount=mmCountMap.get("UnConfirmYuyueCount").toString();

				mmMap.put("Paibanriqi", mmPaibanriqi);
				mmMap.put("ExpertName", mmExpertName);
				mmMap.put("AllowYuyueCount", mmAllowYuyueCount);
				mmMap.put("ConfirmYuyueCount", mmConfirmYuyueCount);
				mmMap.put("UnConfirmYuyueCount", mmUnConfirmYuyueCount);

				mmListMap.add(mmMap);

			}

			Map<String, Object> mmMapResult = new HashMap<String, Object>();
			mmMapResult.put("List", mmListMap);
			mmMapResult.put("PageInfo", mmPageInfo);

			return JsonResult.getSuccessResult(mmMapResult);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("paibanguanli/findByExpertidAndPaibanriqi:error " + e.getMessage());
		}
	}

	public Map<String, Object> yuyueCount(@RequestParam("expertid") String ppExpertId,@RequestParam("paibanriqi") String ppPaiBanRiQi)
	{

		List<Paibanguanli>mmList = ddService.findDayByExpertidAndPaibanriqi(ppExpertId,ppPaiBanRiQi);
		String mmPaibanid=null;
		int mmAllowYuyueCount=0;
		int mmConfirmYuyueCount=0;
		int mmUnConfirmYuyueCount=0;

		Map<String, Object> mmMap = new HashMap<String, Object>();

		for(int i=0;i<mmList.size();i++)
		{
			mmPaibanid=mmList.get(i).getPaibanid();
			mmAllowYuyueCount+= mmList.get(i).getXianhaoshu();
			mmConfirmYuyueCount+=ddService.countFindYuyue(mmPaibanid,1);
			mmUnConfirmYuyueCount+=ddService.countFindYuyue(mmPaibanid,0);
		}

		mmMap.put("AllowYuyueCount", mmAllowYuyueCount);
		mmMap.put("ConfirmYuyueCount", mmConfirmYuyueCount);
		mmMap.put("UnConfirmYuyueCount", mmUnConfirmYuyueCount);

		return mmMap;
	}
	
	
	
	@RequestMapping("savePaiban")
	public JsonResult<?> save(@RequestParam("paibanid") String ppPaiBanId,
			@RequestParam("expertid") String ppExpertId,
			@RequestParam("name") String ppName,
			@RequestParam("guahaoleibie") String ppGuaHaoLeiBie,
			@RequestParam("paibanriqi") String ppPaiBanRiQi,
			@RequestParam("shangxiawu") String ppShangXiaWu,
			@RequestParam("xianhaoshu") int ppXianHaoShu,
			@RequestParam("shengyuhaoshu") int ppShengYuHaoShu,
			@RequestParam("jiage") float ppJiaGe,
			@RequestParam("jiahaobingzhong") String jiahaobingzhong,
			@RequestParam("jiahaoshu") int jiahaoshu){
		try {
			Paibanguanli mmPaibanguanli=ddService.findOne(ppPaiBanId);
			
			boolean isAddPaibanguanli=false;
			
			if (mmPaibanguanli==null) {
				isAddPaibanguanli=true;
				mmPaibanguanli=new Paibanguanli();
				mmPaibanguanli.setPaibanid(UUID.randomUUID().toString());
			}

			BooleanMessage mmBooleanMessage = checkInputData(mmPaibanguanli,ppExpertId,ppName,ppPaiBanRiQi,ppShangXiaWu,ppXianHaoShu,ppJiaGe,isAddPaibanguanli,jiahaobingzhong,jiahaoshu);
			
			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}

			if(!isAddPaibanguanli)
			{

				Map<String, Object> mmCountMap= yuyueCount(ppExpertId,ppPaiBanRiQi);
				String mmConfirmYuyueCount =mmCountMap.get("ConfirmYuyueCount").toString();

				if((ppXianHaoShu+mmPaibanguanli.getJiahaoshu())<Integer.parseInt(mmConfirmYuyueCount))
				{
					return JsonResult.getErrorResult("当前日期的预约号数已超过要修改的限号数，不允许修改！");
				}
			}
			
			if(isAddPaibanguanli) {
				return ddService.add(mmPaibanguanli) ? JsonResult.getSuccessResult("新增排班成功！"):
					JsonResult.getErrorResult("新增排班失败！");
			}else {
				return ddService.modify(mmPaibanguanli) ? JsonResult.getSuccessResult("修改排班成功！"):
					JsonResult.getErrorResult("修改排班失败！");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult(e.getMessage());
		}
	}

	private BooleanMessage checkInputData(Paibanguanli mmPaibanguanli,String ppExpertId,String ppName,String ppPaiBanRiQi, String ppShangXiaWu,int ppXianHaoShu,float ppJiaGe,boolean isAddPaibanguanli,String ppJiahaobingzhong,int ppJiahaoshu) {
		

		if("".equals(ppExpertId)) 
		{
			return BooleanMessage.getErrorMessage("专家姓名不能为空");
		}
		if("".equals(ppPaiBanRiQi)) 
		{
			return BooleanMessage.getErrorMessage("排班日期不能为空");
		}
		if("".equals(ppShangXiaWu)) 
		{
			return BooleanMessage.getErrorMessage("排班时间不能为空");
		}
		/*if("".equals(String.valueOf(ppXianHaoShu))||ppXianHaoShu==0)
		{
			return BooleanMessage.getErrorMessage("预约人数不能为空或0");
		}*/
		
		if("".equals(ppJiaGe)) 
		{
			return BooleanMessage.getErrorMessage("价格不能为空");
		}

		/*if("".equals(ppJiahaobingzhong))
		{
			return BooleanMessage.getErrorMessage("加号病种不能为空");
		}*/

	/*	if("".equals(ppJiahaoshu))
		{
			return BooleanMessage.getErrorMessage("加号数不能为空");
		}*/

		mmPaibanguanli.setExpertid(ppExpertId);
		if(isAddPaibanguanli)
		{
			mmPaibanguanli.setName(ppName);
			mmPaibanguanli.setGuahaoleibie("专家号");
			Date mmPaiBanRiQi = DateUtil.convertShortStringToDate(ppPaiBanRiQi);
			mmPaibanguanli.setPaibanriqi(mmPaiBanRiQi);
			mmPaibanguanli.setShangxiawu(ppShangXiaWu);
			mmPaibanguanli.setXianhaoshu(ppXianHaoShu);
			mmPaibanguanli.setShengyuhaoshu(ppXianHaoShu);
			mmPaibanguanli.setJiage(ppJiaGe);
			mmPaibanguanli.setZhuangtai(1);
			mmPaibanguanli.setJiahaobingzhong(ppJiahaobingzhong);
			mmPaibanguanli.setJiahaoshu(ppJiahaoshu);
		}else
		{
			mmPaibanguanli.setXianhaoshu(ppXianHaoShu);
			mmPaibanguanli.setJiahaobingzhong(ppJiahaobingzhong);
			mmPaibanguanli.setJiahaoshu(ppJiahaoshu);
		}

		return BooleanMessage.getSuccessMessage("输入信息合法");
	}
	
	@RequestMapping("deletePaiban")
	public JsonResult<?> delete(@RequestParam("paibanid") String ppPaiBanId) 
	{
		try {
			if("".equals(ppPaiBanId)) {
				return JsonResult.getErrorResult("排班id不能为空");
			}
			
			Paibanguanli mmPaibanguanli = ddService.findOne(ppPaiBanId);
			if(mmPaibanguanli == null) {
				return JsonResult.getErrorResult("要删除的排班不存在");
			}
			
			return ddService.delete(ppPaiBanId) == true ? JsonResult.getSuccessResult("删除排班成功") : JsonResult.getErrorResult("删除排班失败");
		
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("paibanguanli/delete:error " + e.getMessage());
		}
	}
	
	@RequestMapping("deletePaibanIdList")
	public JsonResult<?> deletePaibanIdList(@RequestParam("paibanIdList") String ppPaibanIdList) {
		try {
			
			String[] mmList=ppPaibanIdList.split("\\|");
			if(mmList==null)
			{
				return JsonResult.getErrorResult("专家id参数为空");
			}
			boolean mmResult=ddService.deletePaibanIdList(mmList); 
			return mmResult==true? JsonResult.getSuccessResult("批量删除成功"):JsonResult.getErrorResult("批量删除失败");
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("paibanguanli/deletePaibanIdList:error " + e.getMessage());
		}
	}
	
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("paibanid") String ppPaibanId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppPaibanId));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("paiban/find_one！"+e.getMessage());
		}
	}
	
	@RequestMapping("find_custom_one")
	public JsonResult<?> find_custom_one(@RequestParam("paibanid") String ppPaibanId){
		try {
			return JsonResult.getSuccessResult(ddService.find_custom_one(ppPaibanId));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("paiban/find_one！"+e.getMessage());
		}
	}

	

}
