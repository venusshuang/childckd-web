package childckd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import childckd.model.PatientJiuzhenxinxi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Attatchment;
import childckd.service.AttatchmentService;
import childckd.service.PatientJiuzhenxinxiService;
import childckd.util.BooleanMessage;
import childckd.util.JsonResult;
import childckd.util.PageInfo;
import childckd.util.StringHandle;

@RestController
@RequestMapping("patient_jiuzhenxinxi")
public class PatientJiuzhenxinxiController {
	@Autowired
	PatientJiuzhenxinxiService ddService;

	@Autowired
	AttatchmentService ddAttatchmentService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("findPatientByNameAndShoujihao")
	public JsonResult<?> findPatientByNameAndShoujihao(@RequestParam("name") String ppName,@RequestParam("shoujihao") String ppShoujihao,@RequestParam("pageindex") int ppPageIndex, @RequestParam("pagesize") int ppPageSize) {
		try {
			int mmCount = ddService.countFindCustomAll(ppName, ppShoujihao);
			PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);
			List<Map<String, Object>> mmList = ddService.findCustomAll(ppName, ppShoujihao, ppPageIndex, ppPageSize);

			Map<String, Object> mmMap = new HashMap<String, Object>();
			mmMap.put("List", mmList);
			mmMap.put("PageInfo", mmPageInfo);
			return JsonResult.getSuccessResult(mmMap);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("patient_jiuzhenxinxi/findPatientByNameAndShoujihao:error " + e.getMessage());
		}
	}

	@RequestMapping("deleteJiuzhenxinxiIdList")
	public JsonResult<?> deleteJiuzhenxinxiIdList(@RequestParam("JiuzhenxinxiIdList") String ppJiuzhenxinxiIdList) {
		try {

			String[] mmList=ppJiuzhenxinxiIdList.split("\\|");
			if(mmList==null)
			{
				return JsonResult.getErrorResult("就诊信息id参数为空");
			}
			boolean mmResult=ddService.deleteJiuzhenxinxiIdList(mmList); 
			return mmResult==true? JsonResult.getSuccessResult("批量删除成功"):JsonResult.getErrorResult("批量删除失败");

		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.getErrorResult("patient_jiuzhenxinxi/deleteJiuzhenxinxiIdList:error " + e.getMessage());
		}
	}

	// 根据就诊信息id查找
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("jiuzhenxinxiid") String ppJiuzhenxinxiId){
		try {

			PatientJiuzhenxinxi mmJiuzhenxinxi = ddService.findOne(ppJiuzhenxinxiId);
			if(mmJiuzhenxinxi == null) {
				return JsonResult.getErrorResult("未查询到该就诊信息！");
			}

			// 附件信息
			List<Attatchment> mmAttatchmentList = ddAttatchmentService.findByOwnerId(ppJiuzhenxinxiId);

			Map<String, Object> mmResultMap = new HashMap<String, Object>();
			mmResultMap.put("Jiuzhenxinxi",mmJiuzhenxinxi);
			mmResultMap.put("AttatchmentList",mmAttatchmentList);

			return JsonResult.getSuccessResult(mmResultMap);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("PatientController -> find_one: "+e.getMessage());
			return JsonResult.getErrorResult("根据就诊信息id查找失败！");
		}
	}

	// 根据用户id查找
	@RequestMapping("find_by_userid")
	public JsonResult<?> find_by_userid(@RequestParam("userid") String ppUserId){
		try {
			return JsonResult.getSuccessResult(ddService.findByUserId(ppUserId));
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("PatientController -> find_by_userid: "+e.getMessage());
			return JsonResult.getErrorResult("根据用户id查找失败！");
		}
	}

	// 新增
	@RequestMapping("add")
	public JsonResult<?> add(
			@RequestParam("userid") String ppUserId,
			@RequestParam("name") String ppName,
			@RequestParam("shenfenzhenghaoma") String ppShenfenzhenghaoma,
			@RequestParam("xingbie") String ppXingbie,
			@RequestParam("zhuyaozhengzhuang") String ppZhuyaozhengzhuang,

			@RequestParam("shoujihao") String ppShoujihao,
			@RequestParam("age") String ppAge,
			@RequestParam("lianxidizhi") String ppLianxidizhi,
			@RequestParam("bingzhong") String ppBingzhong,
			@RequestParam("nianling") String ppNianling,
			@RequestParam("imageurls")String ppImageUrls){
		try{
			ppName = ppName.trim();
			ppShenfenzhenghaoma = ppShenfenzhenghaoma.trim();
			ppZhuyaozhengzhuang = ppZhuyaozhengzhuang.trim();	
			ppShoujihao = ppShoujihao.trim();
			ppAge = ppAge.trim();
			ppLianxidizhi = ppLianxidizhi.trim();
			ppNianling = ppNianling.trim();

			// 根据身份证号查询是否已存在相同身份证号的就诊信息，若存在则不能重复添加
			List<PatientJiuzhenxinxi> mmPatientJiuzhenxinxiList = ddService.findByShenfenzhenghao(ppShenfenzhenghaoma);
			if(mmPatientJiuzhenxinxiList.size() > 0){
				return JsonResult.getErrorResult("新增失败！已存在相同证件号码的就诊信息");
			}


			PatientJiuzhenxinxi mmPatientJiuzhenxinxi = new PatientJiuzhenxinxi();

			mmPatientJiuzhenxinxi.setJiuzhenxinxiid(UUID.randomUUID().toString());
			mmPatientJiuzhenxinxi.setUserid(ppUserId);
			mmPatientJiuzhenxinxi.setChuangjianshijian(new Date());

			BooleanMessage mmBooleanMessage = checkInputData(mmPatientJiuzhenxinxi,
					ppName,ppShenfenzhenghaoma,ppXingbie,ppZhuyaozhengzhuang,ppShoujihao,
					ppAge,ppLianxidizhi,ppBingzhong,ppNianling);

			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}

			return ddService.add_custom(mmPatientJiuzhenxinxi, ppImageUrls) ? JsonResult.getSuccessResult("新增成功！") : JsonResult.getErrorResult("新增失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("PatientController -> add: "+e.getMessage());
			return JsonResult.getErrorResult("新增就诊信息失败！");
		}
	}

	// 修改
	@RequestMapping("modify")
	public JsonResult<?> modify(
			@RequestParam("jiuzhenxinxiid") String ppJiuzhenxinxiId,
			@RequestParam("name") String ppName,
			@RequestParam("shenfenzhenghaoma") String ppShenfenzhenghaoma,
			@RequestParam("xingbie") String ppXingbie,
			@RequestParam("zhuyaozhengzhuang") String ppZhuyaozhengzhuang,

			@RequestParam("shoujihao") String ppShoujihao,
			@RequestParam("age") String ppAge,
			@RequestParam("lianxidizhi") String ppLianxidizhi,
			@RequestParam("bingzhong") String ppBingzhong,
			@RequestParam("nianling")String ppNianling,
			@RequestParam("imageurls")String ppImageUrls){
		try{
			ppName = ppName.trim();
			ppShenfenzhenghaoma = ppShenfenzhenghaoma.trim();
			ppZhuyaozhengzhuang = ppZhuyaozhengzhuang.trim();	
			ppShoujihao = ppShoujihao.trim();
			ppAge = ppAge.trim();
			ppLianxidizhi = ppLianxidizhi.trim();
			ppNianling = ppNianling.trim();

			PatientJiuzhenxinxi mmPatientJiuzhenxinxi = ddService.findOne(ppJiuzhenxinxiId);
			if(mmPatientJiuzhenxinxi == null) {
				return JsonResult.getErrorResult("不存在此就诊信息！");
			}

			// 根据身份证号查询是否已存在相同身份证号的就诊信息，若存在则不能重复添加
			List<PatientJiuzhenxinxi> mmPatientJiuzhenxinxiList = ddService.findByShenfenzhenghaoNotIncludeThis(ppJiuzhenxinxiId,ppShenfenzhenghaoma);
			if(mmPatientJiuzhenxinxiList.size() > 0){
				return JsonResult.getErrorResult("修改失败！已存在相同证件号码的就诊信息");
			}

			BooleanMessage mmBooleanMessage = checkInputData(mmPatientJiuzhenxinxi,
					ppName,ppShenfenzhenghaoma,ppXingbie,ppZhuyaozhengzhuang,ppShoujihao,
					ppAge,ppLianxidizhi,ppBingzhong,ppNianling);

			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}

			return ddService.modifyJiuzhen(mmPatientJiuzhenxinxi,ppImageUrls) ? JsonResult.getSuccessResult("修改成功！") : JsonResult.getErrorResult("修改失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("PatientController -> modify: "+e.getMessage());
			return JsonResult.getErrorResult("修改就诊信息失败！");
		}
	}

	// 检查数据
	private BooleanMessage checkInputData(PatientJiuzhenxinxi mmPatientJiuzhenxinxi, String ppName,
			String ppShenfenzhenghaoma, String ppXingbie, String ppZhuyaozhengzhuang, String ppShoujihao,
			String ppAge, String ppLianxidizhi, String ppBingzhong,String ppNianling) {
		if("".equals(ppName)) {
			return BooleanMessage.getErrorMessage("姓名不能为空！");
		}
		if (StringHandle.getStringByteLength(ppName) > 255) {
			return BooleanMessage.getErrorMessage("姓名长度不可超过255字节！");
		}

		if("".equals(ppShenfenzhenghaoma)) {
			return BooleanMessage.getErrorMessage("身份证不能为空！");
		}
		if (StringHandle.getStringByteLength(ppShenfenzhenghaoma) > 255) {
			return BooleanMessage.getErrorMessage("身份证长度不可超过255字节！");
		}

		if("".equals(ppXingbie)) {
			return BooleanMessage.getErrorMessage("性别不能为空！");
		}		

		if("".equals(ppAge)) {
			return BooleanMessage.getErrorMessage("年龄不能为空！");
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		if (!pattern.matcher(ppAge).matches()) {
			return BooleanMessage.getErrorMessage("年龄必须为数字！");
		}
		if (StringHandle.getStringByteLength(ppAge) > 11) {
			return BooleanMessage.getErrorMessage("年龄不可超过11字节！");
		}

		if("".equals(ppBingzhong)) {
			return BooleanMessage.getErrorMessage("病种不能为空！");
		}
		if (StringHandle.getStringByteLength(ppBingzhong) > 50) {
			return BooleanMessage.getErrorMessage("病种不可超过50字节！");
		}

		if("".equals(ppShoujihao)) {
			return BooleanMessage.getErrorMessage("手机号码不能为空！");
		}
		if (StringHandle.getStringByteLength(ppShoujihao) > 255) {
			return BooleanMessage.getErrorMessage("手机号码不可超过255字节！");
		}

		/*if("".equals(ppLianxidizhi)) {
			return BooleanMessage.getErrorMessage("联系地址不能为空！");
		}*/
		if (StringHandle.getStringByteLength(ppLianxidizhi) > 255) {
			return BooleanMessage.getErrorMessage("联系地址长度不可超过255字节！");
		}

		if (StringHandle.getStringByteLength(ppZhuyaozhengzhuang) > 255) {
			return BooleanMessage.getErrorMessage("主要症状长度不可超过255字节！");
		}

		mmPatientJiuzhenxinxi.setName(ppName);
		mmPatientJiuzhenxinxi.setShenfenzhenghaoma(ppShenfenzhenghaoma);
		mmPatientJiuzhenxinxi.setXingbie(ppXingbie);
		mmPatientJiuzhenxinxi.setAge(Integer.parseInt(ppAge));
		mmPatientJiuzhenxinxi.setShoujihao(ppShoujihao);
		mmPatientJiuzhenxinxi.setLianxidizhi(ppLianxidizhi);
		mmPatientJiuzhenxinxi.setZhuyaozhengzhuang(ppZhuyaozhengzhuang);
		mmPatientJiuzhenxinxi.setBingzhong(ppBingzhong);
		mmPatientJiuzhenxinxi.setZhuangtai(1);

		if ("1".equals(ppAge)){
			mmPatientJiuzhenxinxi.setNianling("0-6个月");
		}else if ("2".equals(ppAge)){
			mmPatientJiuzhenxinxi.setNianling("7-12个月");
		}else{
			mmPatientJiuzhenxinxi.setNianling(ppNianling);
		}

		return BooleanMessage.getSuccessMessage(mmPatientJiuzhenxinxi);
	}

}
