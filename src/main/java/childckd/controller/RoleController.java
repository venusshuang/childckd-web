package childckd.controller;

import java.util.Date;
import java.util.UUID;

import childckd.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import childckd.service.RoleService;
import childckd.util.BooleanMessage;

import childckd.util.JsonResult;
import childckd.util.StringHandle;

@RestController
@RequestMapping("Role")
public class RoleController {
	@Autowired
	RoleService ddService;
	
	@RequestMapping("findRoleByRoleName")
	public JsonResult<?> findRoleByRoleName(@RequestParam("rolename") String ppRoleName) {
		try {
			return JsonResult.getSuccessResult(ddService.findRoleByRoleName(ppRoleName));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("Role/findRoleByRoleName:error " + e.getMessage());
		}
	}
	
	@RequestMapping("deleteRole")
	public JsonResult<?> delete(@RequestParam("roleid") String ppRoleId) 
	{
		try {
			if("".equals(ppRoleId)) {
				return JsonResult.getErrorResult("角色id不能为空");
			}
			
			Role mmExpert = ddService.findOne(ppRoleId);
			if(mmExpert == null) {
				return JsonResult.getErrorResult("要删除的角色不存在");
			}
			
			return ddService.delete(ppRoleId) == true ? JsonResult.getSuccessResult("删除角色成功") : JsonResult.getErrorResult("删除角色失败");
		
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("role/delete:error " + e.getMessage());
		}
	}
	
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("roleid") String ppRoleId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppRoleId));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("role/find_one！"+e.getMessage());
		}
	}
	
	@RequestMapping("saveRole")
	public JsonResult<?> save(@RequestParam("roleid") String ppRoleId,
			@RequestParam("rolename") String ppRoleName,
			@RequestParam("displayname") String ppDisplayName,
			@RequestParam("beizhu") String ppBeiZhu){
		try {
			Role mmRole=ddService.findOne(ppRoleId);
			
			boolean isAddRole=false;
			
			if (mmRole==null) {
				isAddRole=true;
				mmRole=new Role();
				mmRole.setRoleid(UUID.randomUUID().toString());
			}

			BooleanMessage mmBooleanMessage = checkInputData(mmRole,ppRoleName,ppDisplayName,ppBeiZhu);
			
			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}
			
			if(isAddRole) {
				return ddService.add(mmRole) ? JsonResult.getSuccessResult("新增角色成功！"):
					JsonResult.getErrorResult("新增角色失败！");
			}else {
				return ddService.modify(mmRole) ? JsonResult.getSuccessResult("修改角色成功！"):
					JsonResult.getErrorResult("修改角色失败！");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult(e.getMessage());
		}
	}

	private BooleanMessage checkInputData(Role mmRole, String ppRoleName, String ppDisplayName, String ppBeiZhu) {
		ppRoleName=ppRoleName.trim();
		ppDisplayName=ppDisplayName.trim();
		ppBeiZhu=ppBeiZhu.trim();
		
		if("".equals(ppRoleName)) 
		{
			return BooleanMessage.getErrorMessage("角色名不能为空");
		}
		if("".equals(ppDisplayName)) 
		{
			return BooleanMessage.getErrorMessage("展示名称不能为空");
		}
		if("".equals(ppBeiZhu)) 
		{
			return BooleanMessage.getErrorMessage("备注不能为空");
		}
		
		if (StringHandle.getStringByteLength(ppRoleName) > 255) {
			return BooleanMessage.getErrorMessage("角色名不能超过255字节");
		}
		if (StringHandle.getStringByteLength(ppDisplayName) > 255) {
			return BooleanMessage.getErrorMessage("展示名称不能超过255字节");
		}
		if (StringHandle.getStringByteLength(ppBeiZhu) > 255) {
			return BooleanMessage.getErrorMessage("备注不能超过255字节");
		}
		
		mmRole.setRolename(ppRoleName);
		mmRole.setDisplayname(ppDisplayName);
		mmRole.setBeizhu(ppBeiZhu);
		 
		mmRole.setChuangjianshijian(new Date());
		mmRole.setZhuangtai(1);
		
		return BooleanMessage.getSuccessMessage("输入信息合法");
	}
	
	@RequestMapping("deleteRoleIdList")
	public JsonResult<?> deleteRoleIdList(@RequestParam("roleIdList") String ppRoleIdList) {
		try {
			
			String[] mmList=ppRoleIdList.split("\\|");
			if(mmList==null)
			{
				return JsonResult.getErrorResult("角色id参数为空");
			}
			boolean mmResult=ddService.deleteRoleIdList(mmList); 
			return mmResult==true? JsonResult.getSuccessResult("批量删除成功"):JsonResult.getErrorResult("批量删除失败");
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("role/deleteRoleIdList:error " + e.getMessage());
		}
	}
}
