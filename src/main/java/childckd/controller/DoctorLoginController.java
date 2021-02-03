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

import childckd.model.DoctorLogin;
import childckd.service.DoctorLoginService;
import childckd.util.BooleanMessage;
import childckd.util.JsonResult;
import childckd.util.StringHandle;

@RestController
@RequestMapping("doctor_login")
public class DoctorLoginController {
	@Autowired
	DoctorLoginService ddService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 修改密码
	@RequestMapping("modify_password")
	public JsonResult<?> modify_password(
			@RequestParam("loginname") String ppLoginName,
			@RequestParam("password") String ppPassword
			){
		try {
			ppLoginName = ppLoginName.trim();
			ppPassword = ppPassword.trim();			

			DoctorLogin mmDoctorLogin = ddService.findByLoginName(ppLoginName);

			if(mmDoctorLogin == null) {
				return JsonResult.getErrorResult("根据您提供的登录账号未查询到登录信息，请核实！");
			}

			mmDoctorLogin.setLoginpassword(ppPassword);
			
			return ddService.modify(mmDoctorLogin) ? JsonResult.getSuccessResult("修改成功！") :
				JsonResult.getErrorResult("修改失败！");			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("DoctorLoginController -> modify_password: "+e.getMessage());
			return JsonResult.getErrorResult("修改密码失败！");
		}
	}

	// 通过登录账号和姓名找回密码
	@RequestMapping("find_by_loginname_and_name")
	public JsonResult<?> find_by_loginname_and_name(
			@RequestParam("loginname") String ppLoginName,
			@RequestParam("name") String ppName
			){
		try {
			ppLoginName = ppLoginName.trim();
			ppName = ppName.trim();			

			DoctorLogin mmDoctorLogin = ddService.findByLoginNameAndName(ppLoginName,ppName);

			if(mmDoctorLogin == null) {
				return JsonResult.getErrorResult("根据您提供的信息未查询到登录密码，请核实！");
			}

			return JsonResult.getSuccessResult(mmDoctorLogin);			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("DoctorLoginController -> find_by_loginname_and_name: "+e.getMessage());
			return JsonResult.getErrorResult("找回密码失败！");
		}
	}

	// 登录检查
	@RequestMapping("check_doctor_login")
	public JsonResult<?> check_doctor_login(
			@RequestParam("loginname") String ppLoginName,
			@RequestParam("loginpassword") String ppLoginPassword,
			@RequestParam("rememberpassword") String ppRememberPassword,
			HttpServletRequest request,
			HttpServletResponse response){
		try {
			ppLoginName = ppLoginName.trim();
			ppLoginPassword = ppLoginPassword.trim();			

			DoctorLogin mmDoctorLogin = ddService.findByLoginNameAndPassword(ppLoginName,ppLoginPassword);

			// 登录失败
			if(mmDoctorLogin == null) {
				return JsonResult.getErrorResult("登录失败！登录名密码错误或账号无效!");
			}

			String mmUserId = mmDoctorLogin.getDoctorid();
			String mmUserType = "doctor";

			// 登录成功,记录session
			HttpSession session = request.getSession();
			session.setAttribute("UserId", mmUserId);
			session.setAttribute("UserType", mmUserType);
			
			// 登录成功,创建cookie
			if("1".equals(ppRememberPassword)) {
				String mmLoginType = "1";
				String mmLoginInfo = ppLoginName + "&" + ppLoginPassword + "&" + mmLoginType;
				Cookie cookie = new Cookie("loginInfo",mmLoginInfo);
				cookie.setMaxAge(7 * 24 * 60 * 60);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			
			
			
			return JsonResult.getSuccessResult("登录成功！");			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("DoctorLoginController -> check_doctor_login: "+e.getMessage());
			return JsonResult.getErrorResult("登录失败！");
		}
	}

	// 注册
	@RequestMapping("register_doctor")
	public JsonResult<?> register_doctor(
			@RequestParam("loginname") String ppLoginName,
			@RequestParam("loginpassword") String ppLoginPassword,
			@RequestParam("phonenum") String ppPhoneNum,
			@RequestParam("name") String ppName){
		try {
			ppLoginName = ppLoginName.trim();
			ppLoginPassword = ppLoginPassword.trim();
			ppPhoneNum = ppPhoneNum.trim();
			ppName = ppName.trim();

			DoctorLogin mmCheckLoginName = ddService.findByLoginName(ppLoginName);

			if(mmCheckLoginName != null) {
				return JsonResult.getErrorResult("注册失败！该登录账号已被使用，请替换。");
			}

			DoctorLogin mmDoctorLogin = new DoctorLogin();

			BooleanMessage mmBooleanmessage = checkInputData(mmDoctorLogin,ppLoginName,ppLoginPassword,ppPhoneNum,ppName);

			if(!mmBooleanmessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanmessage.getMessage().toString());
			}

			return ddService.add(mmDoctorLogin) ?  JsonResult.getSuccessResult("注册成功！") : JsonResult.getErrorResult("注册失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("DoctorLoginController -> register_doctor: "+e.getMessage());
			return JsonResult.getErrorResult("注册失败！");
		}
	}

	// 注册数据检查
	private BooleanMessage checkInputData(DoctorLogin mmDoctorLogin, String ppLoginName, String ppLoginPassword,
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

		mmDoctorLogin.setDoctorid(UUID.randomUUID().toString());
		mmDoctorLogin.setLoginname(ppLoginName);
		mmDoctorLogin.setLoginpassword(ppLoginPassword);
		mmDoctorLogin.setShoujihao(ppPhoneNum);
		mmDoctorLogin.setName(ppName);
		mmDoctorLogin.setZhuangtai(1);

		return BooleanMessage.getSuccessMessage(mmDoctorLogin);
	}

}
