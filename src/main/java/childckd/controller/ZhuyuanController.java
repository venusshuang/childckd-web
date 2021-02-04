package childckd.controller;

import java.util.Date;
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

import childckd.model.News;
import childckd.model.PatientJiuzhenxinxi;
import childckd.model.Zhuyuan;
import childckd.service.ZhuyuanService;
import childckd.util.BooleanMessage;
import childckd.util.JsonResult;
import childckd.util.PageInfo;
import childckd.util.StringHandle;

@RestController
@RequestMapping("zhuyuan")
public class ZhuyuanController {
	@Autowired
	ZhuyuanService ddService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("find_custom_all")
	public JsonResult<?> findCustomAll(@RequestParam("xingming") String ppXingming, @RequestParam("shoujihao") String ppShoujihao, @RequestParam("bingzhong") String ppBingzhong,
			@RequestParam("yuyueriqi") String ppYuyueriqi,@RequestParam("shenhejieguo") int ppShenhejieguo,@RequestParam("pageindex") int ppPageIndex, @RequestParam("pagesize") int ppPageSize) {
		try {
			
			int mmCount = ddService.countFindCustomAll(ppXingming, ppShoujihao, ppBingzhong, ppYuyueriqi,ppShenhejieguo);
			PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);
			List<Map<String, Object>> mmList = ddService.findCustomAll(ppXingming, ppShoujihao, ppBingzhong, ppYuyueriqi,ppShenhejieguo, ppPageIndex, ppPageSize);

			Map<String, Object> mmMap = new HashMap<String, Object>();
			mmMap.put("List", mmList);
			mmMap.put("PageInfo", mmPageInfo);
			return JsonResult.getSuccessResult(mmMap);

			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ZhuyuanController -> findCustomAll: " + e.getMessage());
			return JsonResult.getErrorResult("查找所有失败！");
		}
	}

	@RequestMapping("shenhe")
	public JsonResult<?> shenhe(@RequestParam("zhuyuanid") String ppZhuyuanId, @RequestParam("shenhejieguo") int ppShenhejieguo, @RequestParam("shenheyijian") String ppShenheyijian,
			@RequestParam("fajianrenid") String ppFajianrenId, @RequestParam("neirong") String ppNeirong) {
		try {
			Zhuyuan mmZhuyuan = ddService.findOne(ppZhuyuanId);
			if (mmZhuyuan == null) {
				return JsonResult.getErrorResult("该住院不存在");
			}

			ppShenheyijian = ppShenheyijian.trim();

			mmZhuyuan.setShenhejieguo(ppShenhejieguo);
			mmZhuyuan.setShenheshijian(new Date());
			mmZhuyuan.setShenheyijian(ppShenheyijian);

			News mmNews = new News();
			mmNews.setNewsid(UUID.randomUUID().toString());
			mmNews.setFajianren(ppFajianrenId);
			mmNews.setFajianrenname("住院管理员");
			mmNews.setShoujianren(mmZhuyuan.getUserid());
			mmNews.setShoujianrenname(mmZhuyuan.getXingming());
			mmNews.setNeirong(ppNeirong);
			mmNews.setNewstype(2);// 1:挂号
			mmNews.setZhuangtai(0);
			mmNews.setChuangjianshijian(new Date());
			mmNews.setOwnerid(ppZhuyuanId);

			boolean mmResult = ddService.shenhe(mmZhuyuan, mmNews);
			return mmResult ? JsonResult.getSuccessResult("审核成功") : JsonResult.getErrorResult("审核失败");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ZhuyuanController -> zhuyuan: " + e.getMessage());
			return JsonResult.getErrorResult("审核失败！");
		}
	}
	
	
	
	// 根据住院id查找
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("zhuyuanid") String ppZhuyuanId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppZhuyuanId));
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ZhuyuanController -> find_one: "+e.getMessage());
			return JsonResult.getErrorResult("根据住院id查找失败！");
		}
	}
	
	// 取消预约--设置状态
	@RequestMapping("cancel")
	public JsonResult<?> set_zhuangtai(
			@RequestParam("zhuyuanid") String ppZhuyuanId,
			@RequestParam("shenhejieguo") String ppShenhejieguo){
		try {
			Zhuyuan mmZhuyuan = ddService.findOne(ppZhuyuanId);
			if(mmZhuyuan == null) {
				return JsonResult.getErrorResult("不存在该住院申请！");
			}
			
			mmZhuyuan.setShenhejieguo(Integer.parseInt(ppShenhejieguo));
			
			return ddService.modify(mmZhuyuan) ? JsonResult.getSuccessResult("取消成功！") : 
				JsonResult.getErrorResult("取消失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ZhuyuanController -> set_zhuangtai: "+e.getMessage());
			return JsonResult.getErrorResult("取消预约失败！");
		}
	}

	// 新增住院信息和就诊信息
	@RequestMapping("add_custom")
	public JsonResult<?> add_custom(
			@RequestParam("userid") String ppUserId,
			@RequestParam("name") String ppName,
			@RequestParam("shenfenzhenghaoma") String ppShenfenzhenghaoma,
			@RequestParam("xingbie") String ppXingbie,
			@RequestParam("age") String ppAge,
			
			@RequestParam("bingzhong") String ppBingzhong,
			@RequestParam("shoujihao") String ppShoujihao,			
			@RequestParam("lianxidizhi") String ppLianxidizhi,
			@RequestParam("imageurls")String ppImageUrls){
		try {
			ppName = ppName.trim();
			ppShenfenzhenghaoma = ppShenfenzhenghaoma.trim();
			ppBingzhong = ppBingzhong.trim();
			ppAge = ppAge.trim();
			ppShoujihao = ppShoujihao.trim();
			ppLianxidizhi = ppLianxidizhi.trim();
			
			// 若这个人有一条未审核通过的住院信息，则不能再新增
			Zhuyuan mmIsCunzaiZhuyuan = ddService.findDaishenheByUserId(ppUserId);
			if(mmIsCunzaiZhuyuan != null) {
				return JsonResult.getErrorResult("已存在待审核的住院信息，请等待审核后再进行此操作！");
			}
			
			// 往转院表和就诊信息表中新添数据
			String mmJiuzhenxinxiId = UUID.randomUUID().toString();
			
			Zhuyuan mmZhuyuan = new Zhuyuan();
			mmZhuyuan.setZhuyuanid(UUID.randomUUID().toString());
			mmZhuyuan.setJiuzhenxinxiid(mmJiuzhenxinxiId);
			mmZhuyuan.setUserid(ppUserId);
			
			PatientJiuzhenxinxi mmPatientJiuzhenxinxi = new PatientJiuzhenxinxi();
			mmPatientJiuzhenxinxi.setJiuzhenxinxiid(mmJiuzhenxinxiId);
			mmPatientJiuzhenxinxi.setUserid(ppUserId);

			BooleanMessage mmBooleanMessage = checkInputData(mmZhuyuan,mmPatientJiuzhenxinxi,
					ppName,ppShenfenzhenghaoma,ppXingbie,ppAge,ppBingzhong,
					ppShoujihao,ppLianxidizhi);
			
			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}

			return ddService.add_custom(mmZhuyuan,mmPatientJiuzhenxinxi,ppImageUrls) ? 
					JsonResult.getSuccessResult("新增成功！") : JsonResult.getErrorResult("新增失败！");
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("ZhuyuanController -> add_custom: "+e.getMessage());
			return JsonResult.getErrorResult("新增住院信息和就诊信息失败！");
		}
	}

	private BooleanMessage checkInputData(Zhuyuan mmZhuyuan, PatientJiuzhenxinxi mmPatientJiuzhenxinxi, String ppName,
			String ppShenfenzhenghaoma, String ppXingbie, String ppAge, String ppBingzhong,
			String ppShoujihao, String ppLianxidizhi) {
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
		
		if("".equals(ppShoujihao)) {
			return BooleanMessage.getErrorMessage("手机号码不能为空！");
		}
		if (StringHandle.getStringByteLength(ppShoujihao) > 255) {
			return BooleanMessage.getErrorMessage("手机号码不可超过255字节！");
		}

		if("".equals(ppLianxidizhi)) {
			return BooleanMessage.getErrorMessage("联系地址不能为空！");
		}
		if (StringHandle.getStringByteLength(ppLianxidizhi) > 255) {
			return BooleanMessage.getErrorMessage("联系地址长度不可超过255字节！");
		}

		mmZhuyuan.setXingming(ppName);
		mmZhuyuan.setBingzhong(ppBingzhong);
		mmZhuyuan.setChuangjianshijian(new Date());
		mmZhuyuan.setZhuangtai(1);
		mmZhuyuan.setShenhejieguo(0);//待审核

		mmPatientJiuzhenxinxi.setName(ppName);
		mmPatientJiuzhenxinxi.setShenfenzhenghaoma(ppShenfenzhenghaoma);
		mmPatientJiuzhenxinxi.setXingbie(ppXingbie);
		mmPatientJiuzhenxinxi.setAge(Integer.parseInt(ppAge));
		mmPatientJiuzhenxinxi.setShoujihao(ppShoujihao);
		mmPatientJiuzhenxinxi.setLianxidizhi(ppLianxidizhi);
		mmPatientJiuzhenxinxi.setZhuangtai(0); // 防止挂号的就诊信息查出来				

		return BooleanMessage.getSuccessMessage("验证成功！");
	}
	
	@RequestMapping("tongji_bingzhong")
	public JsonResult<?>tongjiBingzhong(){
		try {
			List<Map<String, Object>> mmList = ddService.tongjiBingzhong();
			
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ZhuyuanController -> tongjiBingzhong: "+e.getMessage());
			return JsonResult.getErrorResult("统计病种失败！");
		}
	}
}
