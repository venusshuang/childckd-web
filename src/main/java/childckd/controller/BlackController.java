package childckd.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Blacklist;
import childckd.service.BlackService;
import childckd.util.JsonResult;



@RestController
@RequestMapping("black")
public class BlackController {
	@Autowired
	BlackService ddService;
	
	@RequestMapping("findBlackByNameAndDeptAndShoujihao")
	public JsonResult<?> findBlackByNameAndDeptAndShoujihao(@RequestParam("name") String ppName,@RequestParam("dept") String ppDept,@RequestParam("shoujihao") String ppShoujihao) {
		try {
			return JsonResult.getSuccessResult(ddService.findBlackByNameAndDeptAndShoujihao(ppName,ppDept,ppShoujihao));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("black/findBlackByNameAndDeptAndShoujihao:error " + e.getMessage());
		}
	}
	
	@RequestMapping("saveBlack")
	public JsonResult<?> save(@RequestParam("blacklistid") String ppBlacklistiId,
			@RequestParam("roles") String ppRoles,
			@RequestParam("userid") String ppUserId,
			@RequestParam("name") String ppName,
			@RequestParam("dept") String ppDept,
			@RequestParam("shoujihao") String ppShoujihao){
		try {
			Blacklist mmBlack=ddService.findOneByUserId(ppUserId);
			
			if(mmBlack!=null)
			{
				return JsonResult.getErrorResult("该成员已在黑名单中");
			}
			
			mmBlack=new Blacklist();
			mmBlack.setBlacklistid(UUID.randomUUID().toString());
			mmBlack.setRoles(ppRoles);
			mmBlack.setUserid(ppUserId);
			mmBlack.setName(ppName);
			mmBlack.setDept(ppDept);
			mmBlack.setShoujihao(ppShoujihao);
			mmBlack.setChuangjianshijian(new Date());
			mmBlack.setZhuangtai(1);

			return ddService.add(mmBlack) ? JsonResult.getSuccessResult("新增黑名单成功！"):JsonResult.getErrorResult("新增黑名单失败！");
			
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult(e.getMessage());
		}
	}
	
	@RequestMapping("deleteBlack")
	public JsonResult<?> delete(@RequestParam("blacklistid") String ppBlacklistId) 
	{
		try {
			if("".equals(ppBlacklistId)) {
				return JsonResult.getErrorResult("黑名单id不能为空");
			}
			
			Blacklist mmBlack = ddService.findOne(ppBlacklistId);
			if(mmBlack == null) {
				return JsonResult.getErrorResult("要删除的黑名单不存在");
			}
			
			return ddService.delete(ppBlacklistId) == true ? JsonResult.getSuccessResult("删除黑名单成功") : JsonResult.getErrorResult("删除黑名单失败");
		
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("black/delete:error " + e.getMessage());
		}
	}
	
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("blacklistid") String ppBlacklistId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppBlacklistId));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("black/find_one！"+e.getMessage());
		}
	}
	
	@RequestMapping("deleteBlackIdList")
	public JsonResult<?> deleteBlackIdList(@RequestParam("blackIdList") String ppBlackIdList) {
		try {
			
			String[] mmList=ppBlackIdList.split("\\|");
			if(mmList==null)
			{
				return JsonResult.getErrorResult("黑名单id参数为空");
			}
			boolean mmResult=ddService.deleteBlackIdList(mmList); 
			return mmResult==true? JsonResult.getSuccessResult("批量删除成功"):JsonResult.getErrorResult("批量删除失败");
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("black/deleteBlackIdList:error " + e.getMessage());
		}
	}

}
