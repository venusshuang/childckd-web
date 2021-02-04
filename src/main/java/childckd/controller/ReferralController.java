package childckd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Attatchment;
import childckd.model.Doctor;
import childckd.model.Referral;
import childckd.service.AttatchmentService;
import childckd.service.DoctorService;
import childckd.service.ReferralService;
import childckd.util.BooleanMessage;
import childckd.util.JsonResult;
import childckd.util.StringHandle;

@RestController
@RequestMapping("referral")
public class ReferralController {
	@Autowired
	ReferralService ddService;

	@Autowired
	DoctorService ddDoctorService;

	@Autowired
	AttatchmentService ddAttatchmentService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 根据输入的条件查找
	@RequestMapping("find_by_condition")
	public JsonResult<?> find_by_condition(
			@RequestParam("patientname") String ppPatientName,
			@RequestParam("doctorname") String ppDoctorName,
			@RequestParam("danwei") String ppDanwei){
		try {
			ppPatientName = ppPatientName.trim();
			ppDoctorName = ppDoctorName.trim();
			ppDanwei = ppDanwei.trim();
			if(!"".equals(ppDanwei)) {
				ppDanwei = ppDanwei + "%";
			}

			return JsonResult.getSuccessResult(ddService.findByCondition(ppPatientName,ppDoctorName,ppDanwei));
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> find_by_condition: "+e.getMessage());
			return JsonResult.getErrorResult("根据条件查找转诊列表失败！");
		}
	}


	// 根据转诊id查找
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("referraid") String ppReferraId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppReferraId));
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> find_one: "+e.getMessage());
			return JsonResult.getErrorResult("根据转诊id查找失败！");
		}
	}

	// 根据转诊id查找转诊和附件信息
	@RequestMapping("find_custom_one")
	public JsonResult<?> find_custom_one(@RequestParam("referraid") String ppReferraId){
		try {
			// 转诊信息
			Referral mmReferral = ddService.findOne(ppReferraId);
			if(mmReferral == null) {
				return JsonResult.getErrorResult("未查询到该转诊信息！");
			}

			// 附件信息
			List<Attatchment> mmAttatchmentList = ddAttatchmentService.findByOwnerId(ppReferraId);

			Map<String, Object> mmResultMap = new HashMap<String, Object>();
			mmResultMap.put("Referral",mmReferral);
			mmResultMap.put("AttatchmentList",mmAttatchmentList);

			return JsonResult.getSuccessResult(mmResultMap);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> find_custom_one: "+e.getMessage());
			return JsonResult.getErrorResult("根据转诊id查找转诊和附件信息失败！");
		}
	}

	// 根据医生id查找
	@RequestMapping("find_by_doctorid")
	public JsonResult<?> find_by_doctorid(@RequestParam("doctorid") String ppDoctorId){
		try {
			return JsonResult.getSuccessResult(ddService.findByDoctorId(ppDoctorId));
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> find_by_doctorid: "+e.getMessage());
			return JsonResult.getErrorResult("根据医生id查找失败！");
		}
	}

	// 医生_删除单个转诊信息
	@RequestMapping("delete")
	public JsonResult<?> delete(@RequestParam("referraid") String ppReferraId){
		try {
			Referral mmReferral = ddService.findOne(ppReferraId);
			if(mmReferral == null) {
				return JsonResult.getErrorResult("未查询到该转诊信息！");
			}

			mmReferral.setZhuangtai(0);

			return ddService.modify(mmReferral) ?  JsonResult.getSuccessResult("删除成功！") : 
				JsonResult.getErrorResult("删除失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> delete: "+e.getMessage());
			return JsonResult.getErrorResult("删除转诊信息失败！");
		}
	}

	// 管理员_批量删除转诊信息
	@RequestMapping("delete_by_zhuanzhenidlist")
	public JsonResult<?> delete_by_zhuanzhenidlist(
			@RequestParam("zhuanzhenidlist") String ppZhuanzhenIdList) {
		try {
			String[] mmZhuanzhenIdArray = ppZhuanzhenIdList.split(",");
			
			if(mmZhuanzhenIdArray == null)
			{
				return JsonResult.getErrorResult("转诊id不能为空！");
			}
			
			return ddService.deleteByZhuanzhenIdList(mmZhuanzhenIdArray) ? JsonResult.getSuccessResult("删除成功") : 
				JsonResult.getErrorResult("删除失败");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> delete_by_zhuanzhenidlist: "+e.getMessage());
			return JsonResult.getErrorResult("批量删除转诊信息失败");
		}
	}

	// 修改转诊病例
	@RequestMapping("modify")
	public JsonResult<?> modify(
			@RequestParam("referraid") String ppReferraId,
			@RequestParam("doctorid") String ppDoctorId,
			@RequestParam("doctorname") String ppDoctorName,
			@RequestParam("danwei") String ppDanwei,
			@RequestParam("patientname") String ppPatientName,
			@RequestParam("patientage") String ppPatientAge,

			@RequestParam("zhusu") String ppZhusu,
			@RequestParam("imageurls")String ppImageUrls
			){
		try {
			ppDoctorName = ppDoctorName.trim();
			ppDanwei = ppDanwei.trim();
			ppPatientName = ppPatientName.trim();
			ppPatientAge = ppPatientAge.trim();
			ppZhusu = ppZhusu.trim();

			Referral mmReferral = ddService.findOne(ppReferraId);
			if(mmReferral == null) {
				return JsonResult.getErrorResult("未查询到该转诊信息！");
			}

			// 检查数据
			BooleanMessage mmBooleanMessage = checkInputDataModify(mmReferral,ppDoctorName,
					ppDanwei,ppPatientName,ppPatientAge,ppZhusu);

			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}

			return ddService.modifyReferral(mmReferral,ppImageUrls) ? JsonResult.getSuccessResult("保存成功！") : 
				JsonResult.getErrorResult("保存失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> modify: "+e.getMessage());
			return JsonResult.getErrorResult("修改转诊病例失败！");
		}
	}

	private BooleanMessage checkInputDataModify(Referral mmReferral, String ppDoctorName, String ppDanwei,
			String ppPatientName, String ppPatientAge, String ppZhusu) {
		if("".equals(ppDoctorName)) {
			return BooleanMessage.getErrorMessage("医师姓名不能为空！");
		}
		if (StringHandle.getStringByteLength(ppDoctorName) > 255) {
			return BooleanMessage.getErrorMessage("医师姓名长度不可超过255字节！");
		}

		if("".equals(ppDanwei)) {
			return BooleanMessage.getErrorMessage("医院名称不能为空！");
		}
		if (StringHandle.getStringByteLength(ppDanwei) > 255) {
			return BooleanMessage.getErrorMessage("医院名称长度不可超过255字节！");
		}

		if("".equals(ppPatientName)) {
			return BooleanMessage.getErrorMessage("患者姓名不能为空！");
		}
		if (StringHandle.getStringByteLength(ppPatientName) > 255) {
			return BooleanMessage.getErrorMessage("患者姓名长度不可超过255字节！");
		}

		if("".equals(ppPatientAge)) {
			return BooleanMessage.getErrorMessage("患者年龄不能为空！");
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		if (!pattern.matcher(ppPatientAge).matches()) {
			return BooleanMessage.getErrorMessage("患者年龄必须为数字！");
		}
		if (StringHandle.getStringByteLength(ppPatientAge) > 11) {
			return BooleanMessage.getErrorMessage("患者年龄不可超过11字节！");
		}

		if (StringHandle.getStringByteLength(ppZhusu) > 2000) {
			return BooleanMessage.getErrorMessage("主诉不可超过2000字节！");
		}

		// Referral表set值
		mmReferral.setDoctorname(ppDoctorName);
		mmReferral.setDanwei(ppDanwei);
		mmReferral.setPatientname(ppPatientName);
		mmReferral.setPatientage(Integer.parseInt(ppPatientAge));
		mmReferral.setZhusu(ppZhusu);


		return BooleanMessage.getSuccessMessage("验证成功！");
	}

	// 新增转诊病例
	@RequestMapping("add_custom")
	public JsonResult<?> add_custom(
			@RequestParam("doctorid") String ppDoctorId,
			@RequestParam("doctorname") String ppDoctorName,
			@RequestParam("danwei") String ppDanwei,
			@RequestParam("patientname") String ppPatientName,
			@RequestParam("patientage") String ppPatientAge,

			@RequestParam("zhusu") String ppZhusu,
			@RequestParam("imageurls")String ppImageUrls
			){
		try {
			ppDoctorName = ppDoctorName.trim();
			ppDanwei = ppDanwei.trim();
			ppPatientName = ppPatientName.trim();
			ppPatientAge = ppPatientAge.trim();
			ppZhusu = ppZhusu.trim();

			// 根据医生id查询doctor表中是否存在该医生信息,不存在新建对象，存在修改信息
			Boolean mmIsAddDoctor = false;
			Doctor mmDoctor = ddDoctorService.findOne(ppDoctorId);
			if(mmDoctor == null) {
				mmIsAddDoctor = true;
				mmDoctor = new Doctor();

				mmDoctor.setDoctorid(ppDoctorId);
				mmDoctor.setZhuangtai(1);
			}

			Referral mmReferral = new Referral();

			mmReferral.setReferralid(UUID.randomUUID().toString());
			mmReferral.setDoctorid(ppDoctorId);
			mmReferral.setZhuangtai(1);

			BooleanMessage mmBooleanMessage = checkInputData(mmReferral,mmDoctor,ppDoctorName,
					ppDanwei,ppPatientName,ppPatientAge,ppZhusu);

			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}

			// 新加Doctor记录和Referral记录
			if(mmIsAddDoctor) {
				return ddService.add_custom(mmReferral,mmDoctor,ppImageUrls) ? JsonResult.getSuccessResult("保存成功！") : 
					JsonResult.getErrorResult("保存失败！");
			}

			// 新增Referral记录、修改Doctor记录
			return ddService.addReferralAndModifyDoctor(mmReferral,mmDoctor,ppImageUrls) ? JsonResult.getSuccessResult("保存成功！") : 
				JsonResult.getErrorResult("保存失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> add: "+e.getMessage());
			return JsonResult.getErrorResult("保存转诊病例失败！");
		}
	}


	private BooleanMessage checkInputData(Referral mmReferral,Doctor mmDoctor, String ppDoctorName,
			String ppDanwei,String ppPatientName, String ppPatientAge, String ppZhusu) {
		if("".equals(ppDoctorName)) {
			return BooleanMessage.getErrorMessage("医师姓名不能为空！");
		}
		if (StringHandle.getStringByteLength(ppDoctorName) > 255) {
			return BooleanMessage.getErrorMessage("医师姓名长度不可超过255字节！");
		}

		if("".equals(ppDanwei)) {
			return BooleanMessage.getErrorMessage("医院名称不能为空！");
		}
		if (StringHandle.getStringByteLength(ppDanwei) > 255) {
			return BooleanMessage.getErrorMessage("医院名称长度不可超过255字节！");
		}

		if("".equals(ppPatientName)) {
			return BooleanMessage.getErrorMessage("患者姓名不能为空！");
		}
		if (StringHandle.getStringByteLength(ppPatientName) > 255) {
			return BooleanMessage.getErrorMessage("患者姓名长度不可超过255字节！");
		}

		if("".equals(ppPatientAge)) {
			return BooleanMessage.getErrorMessage("患者年龄不能为空！");
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		if (!pattern.matcher(ppPatientAge).matches()) {
			return BooleanMessage.getErrorMessage("患者年龄必须为数字！");
		}
		if (StringHandle.getStringByteLength(ppPatientAge) > 11) {
			return BooleanMessage.getErrorMessage("患者年龄不可超过11字节！");
		}

		if (StringHandle.getStringByteLength(ppZhusu) > 2000) {
			return BooleanMessage.getErrorMessage("主诉不可超过2000字节！");
		}

		// Referral表set值
		mmReferral.setDoctorname(ppDoctorName);
		mmReferral.setDanwei(ppDanwei);
		mmReferral.setPatientname(ppPatientName);
		mmReferral.setPatientage(Integer.parseInt(ppPatientAge));
		mmReferral.setZhusu(ppZhusu);

		// Doctor表set值
		mmDoctor.setXingming(ppDoctorName);
		mmDoctor.setDanwei(ppDanwei);

		return BooleanMessage.getSuccessMessage("验证成功！");
	}

}
