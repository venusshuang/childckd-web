package childckd.controller;

import java.util.*;

import childckd.model.AdminPermission;
import childckd.model.Administrator;
import childckd.model.Role;
import childckd.model.RolesPermission;
import childckd.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

import childckd.service.RoleService;
import childckd.util.BooleanMessage;

import childckd.util.JsonResult;
import childckd.util.StringHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("Role")
public class RoleController {
	@Autowired
	RoleService ddService;

	@Autowired
	AdministratorService ddAdministratorService;

	private List<Map<String, Object>> ppReturnRoleList =null;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("findPermission")
	public JsonResult<?> findPermission(@RequestParam("type") String ppType,HttpServletRequest request){
		try {
			String mmID=null;
			if("administrator".equals(ppType))
			{
				mmID = request.getSession().getAttribute("AdministratorId").toString();
			}else if("role".equals(ppType))
			{
				mmID = request.getSession().getAttribute("RoleType").toString();
			}


			List<Map<String, Object>> mmFirstPermission = ddService.findFirstOrNotByFatherid(mmID,1,ppType);
			List<Map<String, Object>> mmNotFirstPermission = ddService.findFirstOrNotByFatherid(mmID,0,ppType);


			Map<String, Object> mmResultMap = new HashMap<String, Object>();
			mmResultMap.put("FirstPermission",mmFirstPermission);
			mmResultMap.put("NotFirstPermission",mmNotFirstPermission);

			return JsonResult.getSuccessResult(mmResultMap);

		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> findPermission: "+e.getMessage());
			return JsonResult.getErrorResult("根据当前登录的mmAdministratorId查找失败！");
		}
	}

	@RequestMapping("findPermissionByAdminid_V1")
	public JsonResult<?> findPermissionByAdminid_V1(HttpServletRequest request){
		try {
			String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();

			List<Map<String, Object>> mmFirstPermission = ddService.findFirstOrNotByFatherid(mmAdministratorId,1,"administrator");
			List<Map<String, Object>> mmNotFirstPermission = ddService.findFirstOrNotByFatherid(mmAdministratorId,0,"administrator");


			Map<String, Object> mmResultMap = new HashMap<String, Object>();
			mmResultMap.put("FirstPermission",mmFirstPermission);
			mmResultMap.put("NotFirstPermission",mmNotFirstPermission);



			return JsonResult.getSuccessResult(mmResultMap);

		}catch(Exception e) {
			e.printStackTrace();
			logger.error("RoleController -> findPermissionByAdminid_V1: "+e.getMessage());
			return JsonResult.getErrorResult("根据AdministratorId查找失败！");
		}
	}


	@RequestMapping("findPermissionByAdminid")
	public JsonResult<?> findPermissionByAdminid(@RequestParam("administratorid") String ppAdministratorId){
		try {

			List<AdminPermission> mmFirstPermission = ddService.findPermissionByAdminid(ppAdministratorId);
			return JsonResult.getSuccessResult(mmFirstPermission);

		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> findPermissionByAdminid: "+e.getMessage());
			return JsonResult.getErrorResult("根据AdministratorId查找失败！");
		}
	}

	@RequestMapping("findPermissionByRoleid")
	public JsonResult<?> findPermissionByRoleid(@RequestParam("roleid") String ppRoleId){
		try {

			List<RolesPermission> mmFirstPermission = ddService.findPermissionByRoleid(ppRoleId);

			return JsonResult.getSuccessResult(mmFirstPermission);

		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> findPermissionByRoleid: "+e.getMessage());
			return JsonResult.getErrorResult("根据RoleId查找失败！");
		}
	}


	@RequestMapping("findRoleByRoleName")
	public JsonResult<?> findRoleByRoleName(@RequestParam("rolename") String ppRoleName,HttpServletRequest request) {
		try {
			String mmRoleid = request.getSession().getAttribute("RoleType").toString();
			String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
			List<Map<String, Object>> mmAllRoleList=ddService.findRoleByRoleName("");
			Map<String, Object> mmMap = new HashMap<String, Object>();
			ppReturnRoleList =new ArrayList<Map<String, Object>>();

			Administrator mmAdministrator = ddAdministratorService.findOne(mmAdministratorId);
			Role mmRole = ddService.findOne(mmAdministrator.getRoleid());

			mmMap.put("roleid", mmRole.getRoleid());
			mmMap.put("rolename", mmRole.getRolename());
			mmMap.put("displayname", mmRole.getDisplayname());
			mmMap.put("beizhu", mmRole.getBeizhu());
			mmMap.put("parentroleid", mmRole.getParentroleid());
			mmMap.put("showshezhipermission", false);

			ppReturnRoleList.add(mmMap);


			findRoleByStep(mmAllRoleList,mmRoleid);


			return JsonResult.getSuccessResult(ppReturnRoleList);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("Role/findRoleByRoleName:error " + e.getMessage());
		}
	}

	void findRoleByStep(List<Map<String, Object>> ppAllRoleList,String ppRoleId)
	{
		for(int i=0;i<ppAllRoleList.size();i++)
		{
			if(ppRoleId.equals(ppAllRoleList.get(i).get("parentroleid").toString()))
			{
				Map<String, Object> ppMap = new HashMap<String, Object>();
				ppMap.put("roleid", ppAllRoleList.get(i).get("roleid").toString());
				ppMap.put("rolename", ppAllRoleList.get(i).get("rolename").toString());
				ppMap.put("displayname", ppAllRoleList.get(i).get("displayname").toString());
				ppMap.put("beizhu", ppAllRoleList.get(i).get("beizhu").toString());
				ppMap.put("parentroleid", ppRoleId);
				ppMap.put("showshezhipermission", true);
				ppReturnRoleList.add(ppMap);
				findRoleByStep(ppAllRoleList,ppAllRoleList.get(i).get("roleid").toString());
			}else
			{
				continue;
			}
		}
	}

	@RequestMapping("savePermission")
	public JsonResult<?> savePermission(@RequestParam("id") String ppId,@RequestParam("type") String ppType,@RequestParam("permissionIdList") String ppPermissionIdList) {
		try {

			String[] mmList=ppPermissionIdList.split("\\|");
			if(mmList==null)
			{
				return JsonResult.getErrorResult("Permissionid为空");
			}
			boolean mmResult=ddService.savePermission(ppId,ppType,mmList);
			return mmResult==true? JsonResult.getSuccessResult("权限设置成功"):JsonResult.getErrorResult("权限设置失败");

		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("role/saveRolePermission:error " + e.getMessage());
		}
	}
	
	@RequestMapping("deleteRole")
	public JsonResult<?> delete(@RequestParam("roleid") String ppRoleId) 
	{
		try {
			if("".equals(ppRoleId)) {
				return JsonResult.getErrorResult("角色id不能为空");
			}
			
			Role mmRole = ddService.findOne(ppRoleId);
			if(mmRole == null) {
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
			@RequestParam("beizhu") String ppBeiZhu,
			HttpServletRequest request){
		try {
			Role mmRole=ddService.findOne(ppRoleId);
			
			boolean isAddRole=false;
			
			if (mmRole==null) {
				isAddRole=true;
				mmRole=new Role();
				mmRole.setRoleid(UUID.randomUUID().toString());
			}
			String mmRoleId = request.getSession().getAttribute("RoleType").toString();
			String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
			BooleanMessage mmBooleanMessage = checkInputData(mmRole,ppRoleName,ppDisplayName,ppBeiZhu,mmRoleId,isAddRole,mmAdministratorId);
			
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

	private BooleanMessage checkInputData(Role mmRole, String ppRoleName, String ppDisplayName, String ppBeiZhu,String ppRoleid,boolean isAddRole,String ppAdministratorId) {
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
		mmRole.setChuangjianrenid(ppAdministratorId);
		if(isAddRole)
		{
			mmRole.setParentroleid(ppRoleid);
		}

		
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
