package childckd.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Attatchment;
import childckd.model.Expert;
import childckd.service.AttatchmentService;
import childckd.service.ExpertService;
import childckd.util.JsonResult;
import childckd.util.StringHandle;
import childckd.util.BooleanMessage;
import childckd.util.DateUtil;


@RestController
@RequestMapping("expert")
public class ExpertController {
	
	@Autowired
	ExpertService ddService;
	@Autowired
	AttatchmentService ddAttatchmentService;
	
	@RequestMapping("findAll")
	public JsonResult<?> findAll()
	{
		try {
			return JsonResult.getSuccessResult(ddService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult(e.getMessage());
		}
	}
	
	@RequestMapping("saveExpert")
	public JsonResult<?> save(@RequestParam("expertid") String ppExpertid,
			@RequestParam("name") String ppName,
			@RequestParam("danwei") String ppDanwei,
			@RequestParam("keshi") String ppKeshi,
			@RequestParam("zhiwu") String ppZhiwu,
			@RequestParam("chushengnianyue") String ppChushengnianyue,
			@RequestParam("jianjie") String ppJianjie,
			@RequestParam("zhuangtai") String ppZhuangtai,@RequestParam("imageurl") String ppImageurl){
		try {
			Expert mmExpert=ddService.findOne(ppExpertid);
			
			boolean isAddExpert=false;
			
			if (mmExpert==null) {
				isAddExpert=true;
				mmExpert=new Expert();
				mmExpert.setExpertid(UUID.randomUUID().toString());
			}
			
			boolean isDeleteImage = ddAttatchmentService.deleteByOwnerId(ppExpertid);
			if (!isDeleteImage) {
				return JsonResult.getErrorResult("专家照片删除出错");
			}
			Attatchment mmAttatchment = new Attatchment();
			mmAttatchment.setAttatchmentid(UUID.randomUUID().toString());
			mmAttatchment.setFilename(ppName);
			mmAttatchment.setOwnerid(ppExpertid);
			mmAttatchment.setShangchuanshijian(new Date());
			mmAttatchment.setUrl(ppImageurl);
			mmAttatchment.setZhuangtai(1);
			boolean mmIsAddImage = ddAttatchmentService.add(mmAttatchment);
			if (!mmIsAddImage) {
				return JsonResult.getErrorResult("上传专家照片出错");
			}

			BooleanMessage mmBooleanMessage = checkInputData(mmExpert,ppName,ppDanwei,ppKeshi,ppZhiwu,ppChushengnianyue,ppJianjie,ppZhuangtai);
			
			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}
			
			if(isAddExpert) {
				return ddService.add(mmExpert) ? JsonResult.getSuccessResult("新增专家成功！"):
					JsonResult.getErrorResult("新增专家失败！");
			}else {
				return ddService.modify(mmExpert) ? JsonResult.getSuccessResult("修改专家成功！"):
					JsonResult.getErrorResult("修改专家失败！");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult(e.getMessage());
		}
	}

	private BooleanMessage checkInputData(Expert mmExpert, String ppName, String ppDanwei, String ppKeshi,String ppZhiwu, String ppChushengnianyue, String ppJianjie, String ppZhuangtai) 
	{
		ppName=ppName.trim();
		ppZhiwu=ppZhiwu.trim();
		ppJianjie=ppJianjie.trim();
		
		if("".equals(ppName)) 
		{
			return BooleanMessage.getErrorMessage("专家姓名不能为空");
		}
		if("".equals(ppZhiwu)) 
		{
			return BooleanMessage.getErrorMessage("专家职位不能为空");
		}
		if("".equals(ppJianjie)) 
		{
			return BooleanMessage.getErrorMessage("专家简介不能为空");
		}
		
		if (StringHandle.getStringByteLength(ppName) > 255) {
			return BooleanMessage.getErrorMessage("专家姓名不能超过255字节");
		}
		if (StringHandle.getStringByteLength(ppZhiwu) > 255) {
			return BooleanMessage.getErrorMessage("专家职位不能超过255字节");
		}
		if (StringHandle.getStringByteLength(ppJianjie) > 2000) {
			return BooleanMessage.getErrorMessage("专家姓名不能超过2000字节");
		}
		
		mmExpert.setName(ppName);
		mmExpert.setDanwei(ppDanwei);
		mmExpert.setKeshi(ppKeshi);
		mmExpert.setZhiwu(ppZhiwu);
		Date mmChushengnianyue = DateUtil.convertShortStringToDate(ppChushengnianyue);
		mmExpert.setChushengnianyue(mmChushengnianyue);
		mmExpert.setJianjie(ppJianjie);
		mmExpert.setZhuangtai(1);
		
		return BooleanMessage.getSuccessMessage("输入信息合法");
	}
	
	
	@RequestMapping("deleteExpert")
	public JsonResult<?> delete(@RequestParam("expertid") String ppExpertId) 
	{
		try {
			if("".equals(ppExpertId)) {
				return JsonResult.getErrorResult("专家id不能为空");
			}
			
			Expert mmExpert = ddService.findOne(ppExpertId);
			if(mmExpert == null) {
				return JsonResult.getErrorResult("要删除的专家不存在");
			}
			
			return ddService.delete(ppExpertId) == true ? JsonResult.getSuccessResult("删除专家成功") : JsonResult.getErrorResult("删除专家失败");
		
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("Expert/delete:error " + e.getMessage());
		}
	}
	
	@RequestMapping("findExpertByName")
	public JsonResult<?> findExpertByName(@RequestParam("name") String ppName) {
		try {
			return JsonResult.getSuccessResult(ddService.findExpertByName(ppName));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("Expert/findExpertByName:error " + e.getMessage());
		}
	}
	
	@RequestMapping("deleteExpertIdList")
	public JsonResult<?> deleteExpertIdList(@RequestParam("expertIdList") String ppExpertIdList) {
		try {
			
			String[] mmList=ppExpertIdList.split("\\|");
			if(mmList==null)
			{
				return JsonResult.getErrorResult("专家id参数为空");
			}
			boolean mmResult=ddService.deleteExpertIdList(mmList); 
			return mmResult==true? JsonResult.getSuccessResult("批量删除成功"):JsonResult.getErrorResult("批量删除失败");
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("Expert/deleteExpertIdList:error " + e.getMessage());
		}
	}
	
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("expertid") String ppExpertId){
		try {
			Map<String, Object>mmMap = ddService.findCustomOne(ppExpertId);
			if (mmMap==null) {
				return JsonResult.getErrorResult("查询专家失败");
			}
			return JsonResult.getSuccessResult(mmMap);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("Expert/find_one！"+e.getMessage());
		}
	}

	
}
