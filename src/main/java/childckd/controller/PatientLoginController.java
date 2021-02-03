package childckd.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.PatientLogin;
import childckd.service.PatientLoginService;
import childckd.util.JsonResult;
import childckd.util.StringHandle;
import childckd.util.BooleanMessage;

@RestController
@RequestMapping("patient_login")
public class PatientLoginController {
	@Autowired
	PatientLoginService ddService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 根据用户id查找用户信息
	@RequestMapping("find_one")
	public JsonResult<?> find_one(
			@RequestParam("userid") String ppUserId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppUserId));
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("根据用户id查找信息失败！");
		}
	}
	
	// 修改密码
	@RequestMapping("modify_password")
	public JsonResult<?> modify_password(
			@RequestParam("loginname") String ppLoginName,
			@RequestParam("password") String ppPassword
			){
		try {
			ppLoginName = ppLoginName.trim();
			ppPassword = ppPassword.trim();			

			PatientLogin mmPatientLogin = ddService.findByLoginName(ppLoginName);

			if(mmPatientLogin == null) {
				return JsonResult.getErrorResult("根据您提供的登录账号未查询到登录信息，请核实！");
			}

			mmPatientLogin.setLoginpassword(ppPassword);

			return ddService.modify(mmPatientLogin) ? JsonResult.getSuccessResult("修改成功！") :
				JsonResult.getErrorResult("修改失败！");			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("PatientLoginController -> modify_password: "+e.getMessage());
			return JsonResult.getErrorResult("修改密码失败！");
		}
	}

	// 通过登录账号和姓名找回密码
	@RequestMapping("find_by_loginname_and_name")
	public JsonResult<?> find_by_loginname_and_name(
			@RequestParam("loginname") String ppLoginName,
			@RequestParam("name") String ppName){
		try {
			ppLoginName = ppLoginName.trim();
			ppName = ppName.trim();					

			PatientLogin mmPatientLogin = ddService.findByLoginNameAndName(ppLoginName,ppName);

			if(mmPatientLogin == null) {
				return JsonResult.getErrorResult("根据您提供的信息未查询到登录密码，请核实！");
			}

			return JsonResult.getSuccessResult(mmPatientLogin);				
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("PatientLoginController -> find_by_loginname_and_name: "+e.getMessage());
			return JsonResult.getErrorResult("找回密码失败！");
		}
	}

	// 登录检查
	@RequestMapping("check_patient_login")
	public JsonResult<?> check_patient_login(
			@RequestParam("loginname") String ppLoginName,
			@RequestParam("loginpassword") String ppLoginPassword,
			@RequestParam("rememberpassword") String ppRememberPassword,
			HttpServletRequest request,
			HttpServletResponse response){
		try {
			ppLoginName = ppLoginName.trim();
			ppLoginPassword = ppLoginPassword.trim();			

			PatientLogin mmPatientLogin = ddService.findByLoginNameAndPassword(ppLoginName,ppLoginPassword);

			// 登录失败
			if(mmPatientLogin == null) {
				return JsonResult.getErrorResult("登录失败！登录名密码错误或账号无效!");
			}

			String mmUserId = mmPatientLogin.getUserid();
			String mmUserType = "patient";

			// 登录成功,记录session
			HttpSession session = request.getSession();
			session.setAttribute("UserId", mmUserId);
			session.setAttribute("UserType", mmUserType);

			// 登录成功,创建cookie
			if("1".equals(ppRememberPassword)) {
				String mmLoginType = "2";
				String mmLoginInfo = ppLoginName + "&" + ppLoginPassword + "&" + mmLoginType;
				Cookie cookie = new Cookie("loginInfo",mmLoginInfo);
				cookie.setMaxAge(7 * 24 * 60 * 60);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			

			return JsonResult.getSuccessResult("登录成功");			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("PatientLoginController -> check_patient_login: "+e.getMessage());
			return JsonResult.getErrorResult("登录失败！");
		}
	}

	// 注册
	@RequestMapping("register_patient")
	public JsonResult<?> register_patient(
			@RequestParam("loginname") String ppLoginName,
			@RequestParam("loginpassword") String ppLoginPassword,
			@RequestParam("phonenum") String ppPhoneNum,
			@RequestParam("name") String ppName){
		try {
			ppLoginName = ppLoginName.trim();
			ppLoginPassword = ppLoginPassword.trim();
			ppPhoneNum = ppPhoneNum.trim();
			ppName = ppName.trim();

			PatientLogin mmCheckLoginName = ddService.findByLoginName(ppLoginName);

			if(mmCheckLoginName != null) {
				return JsonResult.getErrorResult("注册失败！该登录账号已被使用，请替换。");
			}

			PatientLogin mmPatientLogin = new PatientLogin();

			BooleanMessage mmBooleanmessage = checkInputData(mmPatientLogin,ppLoginName,ppLoginPassword,ppPhoneNum,ppName);

			if(!mmBooleanmessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanmessage.getMessage().toString());
			}

			return ddService.add(mmPatientLogin) ?  JsonResult.getSuccessResult("注册成功！") : JsonResult.getErrorResult("注册失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("PatientLoginController -> register_patient: "+e.getMessage());
			return JsonResult.getErrorResult("注册失败！");
		}
	}

	// 注册数据检查
	private BooleanMessage checkInputData(PatientLogin mmPatientLogin, String ppLoginName, String ppLoginPassword,
			String ppPhoneNum, String ppName) {

		if("".equals(ppLoginName)) {
			return BooleanMessage.getErrorMessage("登录账号不能为空！");
		}
		if (StringHandle.getStringByteLength(ppLoginName) > 255) {
			return BooleanMessage.getErrorMessage("登录账号长度不可超过255字节！");
		}

		if("".equals(ppLoginPassword)) {
			return BooleanMessage.getErrorMessage("登录密码不能为空！");
		}
		if (StringHandle.getStringByteLength(ppLoginPassword) > 255) {
			return BooleanMessage.getErrorMessage("登录密码长度不可超过255字节！");
		}

		if("".equals(ppPhoneNum)) {
			return BooleanMessage.getErrorMessage("手机号不能为空！");
		}
		if (StringHandle.getStringByteLength(ppPhoneNum) > 255) {
			return BooleanMessage.getErrorMessage("手机号长度不可超过255字节！");
		}

		if("".equals(ppName)) {
			return BooleanMessage.getErrorMessage("姓名不能为空！");
		}
		if (StringHandle.getStringByteLength(ppName) > 255) {
			return BooleanMessage.getErrorMessage("姓名长度不可超过255字节！");
		}

		mmPatientLogin.setUserid(UUID.randomUUID().toString());
		mmPatientLogin.setLoginname(ppLoginName);
		mmPatientLogin.setLoginpassword(ppLoginPassword);
		mmPatientLogin.setShoujihao(ppPhoneNum);
		mmPatientLogin.setName(ppName);
		mmPatientLogin.setZhuangtai(1);

		return BooleanMessage.getSuccessMessage(mmPatientLogin);
	}
}
