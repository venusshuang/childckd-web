package childckd.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import childckd.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.service.AdministratorService;
import childckd.util.BooleanMessage;
import childckd.util.JsonResult;
import childckd.util.StringHandle;


@RestController
@RequestMapping("administrator")
public class AdministratorController {
	@Autowired
	AdministratorService ddService;

    private List<Map<String, Object>> ppReturnAdminList =null;

	@RequestMapping("login")
	public JsonResult<?> login(
			@RequestParam("zhanghao") String ppLoginName,
			@RequestParam("password") String ppLoginPassword,
			HttpServletRequest request){
		try {
			ppLoginName = ppLoginName.trim();
			ppLoginPassword = ppLoginPassword.trim();			

			Administrator mmLogin = ddService.findByLoginNameAndPassword(ppLoginName,ppLoginPassword);

			// 登录失败
			if(mmLogin == null) {
				return JsonResult.getErrorResult("登录失败！登录名密码错误或账号无效!");
			}

			String mmAdministratorId = mmLogin.getAdministratorid();
			String mmRoleId = mmLogin.getRoleid();

			// 登录成功,记录session
			HttpSession session = request.getSession();
			session.setAttribute("AdministratorId", mmAdministratorId);
			session.setAttribute("RoleType", mmRoleId);

			return JsonResult.getSuccessResult("登录成功");			
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("登录失败！");
		}
	}
	
	@RequestMapping("logout")
	public boolean logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("AdministratorId");
		session.removeAttribute("RoleType");
		return true;
	}
	
	@RequestMapping("findAdministratorByZhanghao")
	public JsonResult<?> findAdministratorByZhanghao(@RequestParam("zhanghao") String ppZhanghao,HttpServletRequest request) {
		try {
			String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
			List<Map<String, Object>> mmAllAdminList=ddService.findAdministratorByZhanghao("");
			Map<String, Object> mmMap = new HashMap<String, Object>();
			ppReturnAdminList =new ArrayList<Map<String, Object>>();

			Administrator mmAdministrator = ddService.findOne(mmAdministratorId);
			mmMap.put("administratorid", mmAdministratorId);
			mmMap.put("rolename", mmAdministrator.getRolename());
			mmMap.put("zhanghao", mmAdministrator.getZhanghao());
			mmMap.put("beizhu", mmAdministrator.getBeizhu());
			mmMap.put("parentadminid", mmAdministrator.getParentadminid());
			mmMap.put("showshezhipermission", false);
			ppReturnAdminList.add(mmMap);


			findAdminByStep(mmAllAdminList,mmAdministratorId);


			return JsonResult.getSuccessResult(ppReturnAdminList);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("administrator/findAdministratorByZhanghao:error " + e.getMessage());
		}
	}

	void findAdminByStep(List<Map<String, Object>> ppAllAdminList,String ppAdministratorId)
	{
		for(int i=0;i<ppAllAdminList.size();i++)
		{
			if(ppAdministratorId.equals(ppAllAdminList.get(i).get("parentadminid").toString()))
			{
				Map<String, Object> ppMap = new HashMap<String, Object>();
				ppMap.put("administratorid", ppAllAdminList.get(i).get("administratorid").toString());
				ppMap.put("rolename", ppAllAdminList.get(i).get("rolename").toString());
				ppMap.put("zhanghao", ppAllAdminList.get(i).get("zhanghao").toString());
				ppMap.put("beizhu", ppAllAdminList.get(i).get("beizhu").toString());
				ppMap.put("parentadminid", ppAdministratorId);
				ppMap.put("showshezhipermission", true);
				ppReturnAdminList.add(ppMap);
				findAdminByStep(ppAllAdminList,ppAllAdminList.get(i).get("administratorid").toString());
			}else
			{
				continue;
			}
		}
	}

	
	@RequestMapping("deleteAdministrator")
	public JsonResult<?> delete(@RequestParam("administratorid") String ppAdministratorId) 
	{
		try {
			if("".equals(ppAdministratorId)) {
				return JsonResult.getErrorResult("管理员id不能为空");
			}
			
			Administrator mmAdministrator = ddService.findOne(ppAdministratorId);
			if(mmAdministrator == null) {
				return JsonResult.getErrorResult("要删除的管理员不存在");
			}
			
			return ddService.delete(ppAdministratorId) == true ? JsonResult.getSuccessResult("删除管理员成功") : JsonResult.getErrorResult("删除管理员失败");
		
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("administrator/delete:error " + e.getMessage());
		}
	}
	
	@RequestMapping("deleteAdministratorIdList")
	public JsonResult<?> deleteAdministratorIdList(@RequestParam("administratorIdList") String ppAdministratorIdList) {
		try {
			
			String[] mmList=ppAdministratorIdList.split("\\|");
			if(mmList==null)
			{
				return JsonResult.getErrorResult("管理员id参数为空");
			}
			boolean mmResult=ddService.deleteAdministratorIdList(mmList); 
			return mmResult==true? JsonResult.getSuccessResult("批量删除成功"):JsonResult.getErrorResult("批量删除失败");
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("administrator/deleteAdministratorIdList:error " + e.getMessage());
		}
	}
	
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("administratorid") String ppAdministratorId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppAdministratorId));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("Expert/find_one！"+e.getMessage());
		}
	}
	
	@RequestMapping("saveAdministrator")
	public JsonResult<?> save(@RequestParam("administratorid") String ppAdministratorId,
			@RequestParam("zhanghao") String ppZhanghao,
			@RequestParam("password") String ppPassword,
			@RequestParam("roleid") String ppRoleId,
			@RequestParam("rolename") String ppRoleName,
			@RequestParam("beizhu") String ppBeizhu,
			HttpServletRequest request){
		try {
			
			Administrator mmAdministrator=ddService.findOne(ppAdministratorId);
			
			boolean isAddAdministrator=false;
			
			if (mmAdministrator==null) {
				
				Administrator mmZhanghao = ddService.findByZhanghao(ppZhanghao);
				if(mmZhanghao != null) {
					return JsonResult.getErrorResult("添加失败！账户名重复");
				}
				
				isAddAdministrator=true;
				mmAdministrator=new Administrator();
				mmAdministrator.setAdministratorid(UUID.randomUUID().toString());
			}
			String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
			BooleanMessage mmBooleanMessage = checkInputData(mmAdministrator,ppZhanghao,ppPassword,ppRoleId,ppRoleName,ppBeizhu,mmAdministratorId,isAddAdministrator);
			
			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}
			

			return ddService.addAdministratorId(mmAdministrator,ppRoleId,isAddAdministrator) ? JsonResult.getSuccessResult("执行成功！"):
					JsonResult.getErrorResult("执行失败！");

			
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult(e.getMessage());
		}
	}

	private BooleanMessage checkInputData(Administrator mmAdministrator, String ppZhanghao, String ppPassword,String ppRoleId,String ppRoleName,String ppBeizhu,String ppAdministratorId,boolean isAddAdministrator) {
		ppZhanghao=ppZhanghao.trim();
		ppPassword=ppPassword.trim();
		ppBeizhu=ppBeizhu.trim();
		
		if("".equals(ppZhanghao)) 
		{
			return BooleanMessage.getErrorMessage("账户名不能为空");
		}
		if("".equals(ppPassword)) 
		{
			return BooleanMessage.getErrorMessage("密码不能为空");
		}
		if("".equals(ppRoleId)) 
		{
			return BooleanMessage.getErrorMessage("角色不能为空");
		}
		
		if (StringHandle.getStringByteLength(ppZhanghao) > 255) {
			return BooleanMessage.getErrorMessage("账户名不能超过255字节");
		}
		if (StringHandle.getStringByteLength(ppPassword) > 255) {
			return BooleanMessage.getErrorMessage("密码不能超过255字节");
		}
		if (StringHandle.getStringByteLength(ppBeizhu) > 2000) {
			return BooleanMessage.getErrorMessage("备注不能超过2000字节");
		}
		
		mmAdministrator.setZhanghao(ppZhanghao);
		mmAdministrator.setPassword(ppPassword);
		mmAdministrator.setRoleid(ppRoleId);
		mmAdministrator.setRolename(ppRoleName);
		mmAdministrator.setBeizhu(ppBeizhu);
		mmAdministrator.setZhuangtai(1);
		if(isAddAdministrator)
		{
			mmAdministrator.setParentadminid(ppAdministratorId);
		}

		
		return BooleanMessage.getSuccessMessage("输入信息合法");
	}
	
	
}
