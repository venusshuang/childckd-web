package childckd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.service.DoctorService;

import childckd.util.JsonResult;

@RestController
@RequestMapping("doctor")
public class DoctorController {
	@Autowired
	DoctorService ddService;
	
	@RequestMapping("findPatientByNameAndDept")
	public JsonResult<?> findPatientByNameAndDept(@RequestParam("name") String ppName,@RequestParam("dept") String ppDept) {
		try {
			return JsonResult.getSuccessResult(ddService.findPatientByNameAndDept(ppName,ppDept));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("doctor/findPatientByNameAndDept:error " + e.getMessage());
		}
	}
	
	@RequestMapping("deleteDoctorIdList")
	public JsonResult<?> deleteDoctorIdList(@RequestParam("DoctorIdList") String ppDoctorIdList) {
		try {
			
			String[] mmList=ppDoctorIdList.split("\\|");
			if(mmList==null)
			{
				return JsonResult.getErrorResult("医生id参数为空");
			}
			boolean mmResult=ddService.deleteDoctorIdList(mmList); 
			return mmResult==true? JsonResult.getSuccessResult("批量删除成功"):JsonResult.getErrorResult("批量删除失败");
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("doctor/deleteDoctorIdList:error " + e.getMessage());
		}
	}

	
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("doctorid") String ppDoctorId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppDoctorId));
		}catch(Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("根据医生id查找失败！");
		}
	}
}
