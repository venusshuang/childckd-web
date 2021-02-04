package childckd.controller;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import childckd.model.Info;
import childckd.model.InfoCategoryInfo;
import childckd.service.InfoCategoryInfoService;
import childckd.service.InfoService;
import childckd.util.BooleanMessage;
import childckd.util.JsonResult;
import childckd.util.StringHandle;

@RequestMapping("info")
@RestController
public class InfoController {

	private static Log log = LogFactory.getLog(InfoController.class);

	@Autowired
	InfoService ddService;
	@Autowired
	InfoCategoryInfoService ddInfoCategoryInfoService;
	
	@RequestMapping("modfiy_liulan")
	@ResponseBody
	public int updateByLiulan() {
		
		int mmliulan=ddService.findliulan();
		ddService.updateLiulan(mmliulan+1);
		return mmliulan+1;
	}
	
	
	@RequestMapping("find_by_liulan")
	@ResponseBody
	public int findByLiulan2() {
		
		int mmliulan=ddService.findliulan();
		return mmliulan;
	}

	@RequestMapping("find_by_categoryid_paging")
	public JsonResult<?> findByCategoryIdPaging(@RequestParam("categoryid") String ppCategoryId,
			@RequestParam("pageindex") int ppPageIndex, @RequestParam("pagesize") int ppPageSize) {
		try {
			PageInfo<List<Map<String, Object>>> mmInfoList = ddService.findByCategoryIdPaging(ppCategoryId, ppPageIndex, ppPageSize);
			return JsonResult.getSuccessResult(mmInfoList);
		} catch (Exception e) {
			log.error("info/find_by_categoryid_paging错误", e);
			return JsonResult.getErrorResult("info/find_by_categoryid_paging错误");
		}
	}
	
	

	@RequestMapping("find_passed_by_categoryid_paging")
	public JsonResult<?> findPassedByCategoryIdPaging(@RequestParam("categoryid") String ppCategoryId,
			@RequestParam("pageindex") int ppPageIndex, @RequestParam("pagesize") int ppPageSize) {
		try {
			PageInfo<List<Map<String, Object>>> mmInfoList = ddService.findPassedByCategoryIdPaging(ppCategoryId, ppPageIndex,
					ppPageSize);
			return JsonResult.getSuccessResult(mmInfoList);
		} catch (Exception e) {
			log.error("info/find_passed_by_categoryid_paging错误", e);
			return JsonResult.getErrorResult("info/find_passed_by_categoryid_paging错误");
		}
	}

	@RequestMapping("find_pic_not_null_passed_by_categoryid_paging")
	public JsonResult<?> findPicNotNullPassedByCategoryIdPaging(@RequestParam("categoryid") String ppCategoryId,
			@RequestParam("pageindex") int ppPageIndex, @RequestParam("pagesize") int ppPageSize) {
		try {
			PageInfo<List<Map<String, Object>>> mmInfoList = ddService.findPassedPicNotNullByCategoryIdPaging(ppCategoryId,
					ppPageIndex, ppPageSize);
			return JsonResult.getSuccessResult(mmInfoList);
		} catch (Exception e) {
			log.error("info/find_pic_not_null_passed_by_categoryid_paging错误", e);
			return JsonResult.getErrorResult("info/find_pic_not_null_passed_by_categoryid_paging错误");
		}
	}

	@RequestMapping("find_custom_one")
	@ResponseBody
	public JsonResult<?> findCustomOne(@RequestParam("infoid") String ppInfoId) {
		try {
			Map<String, Object> mmMap = ddService.findCustomOne(ppInfoId);
			return mmMap == null ? JsonResult.getErrorResult("该Info不存在") : JsonResult.getSuccessResult(mmMap);
		} catch (Exception e) {
			log.error("info/find_custom_one错误", e);
			return JsonResult.getErrorResult("info/find_custom_one错误");
		}
	}

	@RequestMapping("search")
	public JsonResult<?> serch(@RequestParam("searchtext") String ppSearchText,
			@RequestParam("pageindex") int ppPageIndex, @RequestParam("pagesize") int ppPageSize) {
		try {
			PageInfo<List<Map<String, Object>>> mmInfoList = ddService.search(ppSearchText, ppPageIndex, ppPageSize);
			return JsonResult.getSuccessResult(mmInfoList);
		} catch (Exception e) {
			log.error("info/serch错误", e);
			return JsonResult.getErrorResult(e.getMessage());
		}
	}

	@RequestMapping("find_one")
	public JsonResult<?> findOne(@RequestParam("infoid") String ppInfoId) {
		try {
			Info mmInfo = ddService.findOne(ppInfoId);
			return mmInfo == null ? JsonResult.getErrorResult("该信息不存在") : JsonResult.getSuccessResult(mmInfo);
		} catch (Exception e) {
			log.error("info/find_one错误", e);
			return JsonResult.getErrorResult("info/find_one错误");
		}
	}

	@RequestMapping("find_one_info")
	public JsonResult<?> findOneInfo(@RequestParam("infoid") String ppInfoId) {
		try {
			Map<String, Object> mmMap = ddService.findOneInfo(ppInfoId);
			return mmMap == null ? JsonResult.getErrorResult("该信息不存在") : JsonResult.getSuccessResult(mmMap);
		} catch (Exception e) {
			log.error("info/find_one_info错误", e);
			return JsonResult.getErrorResult(e.getMessage());
		}
	}

	@RequestMapping("add")
	public JsonResult<?> add(@RequestParam("categoryid") String ppCategoryId, @RequestParam("jianti") String ppJianti,
			@RequestParam("infotitle") String ppInfotitle, @RequestParam("infotitle2") String ppInfotitle2,
			@RequestParam("summary") String ppSummary, @RequestParam("source") String ppSource,
			@RequestParam("author") String ppAuthor, @RequestParam("infocontent") String ppInfoContent,
			@RequestParam("releasetime") String ppReleaseTime, @RequestParam("imageurl") String ppImageurl,
			@RequestParam("videourl") String ppVideourl, @RequestParam("returnurl") String ppReturnurl,
			@RequestParam("checkpass") int ppCheckPass) {
		try {
			Info mmInfo = new Info();
			InfoCategoryInfo mmInfoCategoryInfo = new InfoCategoryInfo();

			String mmInfoId = UUID.randomUUID().toString();

			mmInfoCategoryInfo.setId(UUID.randomUUID().toString());
			mmInfoCategoryInfo.setCategoryid(ppCategoryId);
			mmInfoCategoryInfo.setInfoid(mmInfoId);

			int mmOrdernum = ddInfoCategoryInfoService.getMaxOrdernum(ppCategoryId) + 1;

			mmInfoCategoryInfo.setOrdernum(mmOrdernum);

			mmInfo.setInfoid(mmInfoId);
			mmInfo.setInfocontent(ppInfoContent);
			mmInfo.setAddtime(new Date());

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date mmReleaseTime = format.parse(ppReleaseTime);

			mmInfo.setReleasetime(mmReleaseTime);
			mmInfo.setClicknum(0);
			mmInfo.setCheckpass(ppCheckPass);

			BooleanMessage mmBooleanMessage = checkInputData(mmInfo, ppJianti, ppInfotitle, ppInfotitle2, ppSummary,
					ppSource, ppAuthor, ppImageurl, ppVideourl, ppReturnurl);
			if (mmBooleanMessage.isOk()) {
				mmInfo = (Info) mmBooleanMessage.getMessage();
				boolean mmResult = ddService.addInfoAndInfoCategoryInfo(mmInfo, mmInfoCategoryInfo);
				return mmResult == true ? JsonResult.getSuccessResult("添加成功") : JsonResult.getErrorResult("添加失败");
			} else {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}
		} catch (Exception e) {
			log.error("info/add错误", e);
			return JsonResult.getErrorResult("info/add错误");
		}
	}

	@RequestMapping("modify")
	public JsonResult<?> modify(@RequestParam("infoid") String ppInfoId, @RequestParam("jianti") String ppJianti,
			@RequestParam("infotitle") String ppInfotitle, @RequestParam("infotitle2") String ppInfotitle2,
			@RequestParam("summary") String ppSummary, @RequestParam("source") String ppSource,
			@RequestParam("author") String ppAuthor, @RequestParam("infocontent") String ppInfoContent,
			@RequestParam("releasetime") String ppReleaseTime, @RequestParam("imageurl") String ppImageurl,
			@RequestParam("videourl") String ppVideourl, @RequestParam("returnurl") String ppReturnurl,
			@RequestParam("checkpass") int ppCheckPass) {
		try {
			Info mmInfo = ddService.findOne(ppInfoId);

			mmInfo.setInfocontent(ppInfoContent);

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date mmReleaseTime = format.parse(ppReleaseTime);

			mmInfo.setReleasetime(mmReleaseTime);
			mmInfo.setCheckpass(ppCheckPass);

			BooleanMessage mmBooleanMessage = checkInputData(mmInfo, ppJianti, ppInfotitle, ppInfotitle2, ppSummary,
					ppSource, ppAuthor, ppImageurl, ppVideourl, ppReturnurl);
			if (mmBooleanMessage.isOk()) {
				mmInfo = (Info) mmBooleanMessage.getMessage();
				boolean mmResult = ddService.modify(mmInfo);
				return mmResult == true ? JsonResult.getSuccessResult("修改成功") : JsonResult.getErrorResult("修改失败");
			} else {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}
		} catch (Exception e) {
			log.error("info/modify错误", e);
			return JsonResult.getErrorResult("info/modify错误");
		}
	}

	public BooleanMessage checkInputData(Info ppInfo, String ppJianti, String ppInfotitle, String ppInfotitle2,
			String ppSummary, String ppSource, String ppAuthor, String ppImageurl, String ppVideourl,
			String ppReturnurl) {
		if (StringHandle.getStringByteLength(ppJianti) > 300) {
			return BooleanMessage.getErrorMessage("肩题长度不可超过300字节");
		}
		if (StringHandle.getStringByteLength(ppInfotitle) > 300) {
			return BooleanMessage.getErrorMessage("标题长度不可超过300字节");
		}
		if (StringHandle.getStringByteLength(ppInfotitle2) > 300) {
			return BooleanMessage.getErrorMessage("副标题长度不可超过300字节");
		}
		if (StringHandle.getStringByteLength(ppSummary) > 500) {
			return BooleanMessage.getErrorMessage("简介长度不可超过500字节");
		}
		if (StringHandle.getStringByteLength(ppSource) > 100) {
			return BooleanMessage.getErrorMessage("来源长度不可超过100字节");
		}
		if (StringHandle.getStringByteLength(ppAuthor) > 100) {
			return BooleanMessage.getErrorMessage("作者长度不可超过100字节");
		}
		if (StringHandle.getStringByteLength(ppImageurl) > 250) {
			return BooleanMessage.getErrorMessage("图片长度不可超过250字节");
		}
		if (StringHandle.getStringByteLength(ppVideourl) > 250) {
			return BooleanMessage.getErrorMessage("视频长度不可超过250字节");
		}
		if (StringHandle.getStringByteLength(ppReturnurl) > 250) {
			return BooleanMessage.getErrorMessage("转向地址长度不可超过250字节");
		}
		ppInfo.setJianti(ppJianti);
		ppInfo.setInfotitle(ppInfotitle);
		ppInfo.setInfotitle2(ppInfotitle2);
		ppInfo.setSummary(ppSummary);
		ppInfo.setSource(ppSource);
		ppInfo.setAuthor(ppAuthor);
		ppInfo.setImageurl(ppImageurl);
		ppInfo.setVideourl(ppVideourl);
		ppInfo.setReturnurl(ppReturnurl);
		return BooleanMessage.getSuccessMessage(ppInfo);
	}

	@RequestMapping("GenerateVideoName")
	public JsonResult<?> GenerateVideoName() {
		String result = UUID.randomUUID().toString() + ".flv";
		return JsonResult.getSuccessResult(result);
	}

	@RequestMapping("add_clicknum")
	public JsonResult<?> AddClickNum(@RequestParam("infoid") String ppInfoId) {
		try {
			int mmClicknum = ddService.addClicknum(ppInfoId);
			Info mmInfo = ddService.findOne(ppInfoId);
			mmInfo.setClicknum(mmClicknum);

			boolean mmResult = ddService.modify(mmInfo);

			return mmResult == true ? JsonResult.getSuccessResult("success") : JsonResult.getErrorResult("fail");
		} catch (Exception e) {
			log.error("info/add_clicknum错误", e);
			return JsonResult.getErrorResult("info/add_clicknum错误");
		}
	}

	@RequestMapping("statistics_zongzhi")
	public JsonResult<?> Statisticszongzhi(@RequestParam("deptids")String ppDeptIds,@RequestParam("tougaoshijian")String ppTougaoshijian,@RequestParam("position")String ppPosition) {
		try {
			String[] mmDeptId = ppDeptIds.split(";");
			List<Map<String, Object>> mmList = new ArrayList<Map<String, Object>>();
			for(int i=0;i<mmDeptId.length;i++) {
				if ("".equals(mmDeptId[i])) {
					continue;
				}
				Map<String, Object> mmMap = new HashMap<>();
				mmMap.put("DeptName", ddService.findDeptByDeptId(mmDeptId[i]).get("danweimingcheng"));
				mmMap.put("CountNum", ddService.statisticsZongzhi(mmDeptId[i],ppTougaoshijian));
				mmList.add(mmMap);
			}

			String xmlFile = parseNodeTreeToXML(mmList);
			
			FileWriter writer = new FileWriter(ppPosition);
			writer.write(xmlFile);
			writer.flush();
			writer.close();
			
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			log.error("info/statistics_zongzhi错误", e);
			return JsonResult.getErrorResult("info/statistics_zongzhi错误");
		}
	}

	@RequestMapping("statistics_jiguan")
	public JsonResult<?> Statisticsjiguan(@RequestParam("deptids")String ppDeptIds,@RequestParam("tougaoshijian")String ppTougaoshijian,@RequestParam("position")String ppPosition) {
		try {
			String[] mmDeptId = ppDeptIds.split(";");
			List<Map<String, Object>> mmList = new ArrayList<Map<String, Object>>();
			for(int i=0;i<mmDeptId.length;i++) {
				if ("".equals(mmDeptId[i])) {
					continue;
				}
				Map<String, Object> mmMap = new HashMap<>();
				mmMap.put("DeptName", ddService.findDeptByDeptId(mmDeptId[i]).get("danweimingcheng"));
				mmMap.put("CountNum", ddService.statisticsZongzhi(mmDeptId[i],ppTougaoshijian));
				mmList.add(mmMap);
			}

			String xmlFile = parseNodeTreeToXML(mmList);
			
			FileWriter writer = new FileWriter(ppPosition);
			writer.write(xmlFile);
			writer.flush();
			writer.close();
			
			return JsonResult.getSuccessResult("tongji_jiguan创建完成");
		} catch (Exception e) {
			log.error("info/statistics_jiguan错误", e);
			return JsonResult.getErrorResult("info/statistics_jiguan错误");
		}
	}

	@RequestMapping("statistics_keshi")
	public JsonResult<?> Statisticskeshi(@RequestParam("tougaoshijian")String ppTougaoshijian,@RequestParam("position")String ppPosition) {
		try {
			List<Map<String, Object>> mmList = ddService.statisticskeshi(ppTougaoshijian);
			String xmlFile = KeshiparseNodeTreeToXML(mmList);
			
			FileWriter writer = new FileWriter(ppPosition);
			writer.write(xmlFile);
			writer.flush();
			writer.close();
			
			return JsonResult.getSuccessResult("tongji_keshi创建完成");
		} catch (Exception e) {
			log.error("info/statistics_keshi错误", e);
			return JsonResult.getErrorResult("info/statistics_keshi错误");
		}
	}

	public String parseNodeTreeToXML(List<Map<String, Object>> ppList) {
		StringBuffer sb = new StringBuffer();
		if (ppList != null && ppList.size() > 0) {
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append(
					"<graph caption=\"\" baseFontSize=\"12\" xAxisName=\"\" yAxisName=\"\" showValues=\"1\" decimals=\"0\" formatNumberScale=\"0\" labelDisplay=\"Rotate\" slantLabels=\"1\">");
			for (int i = 0; i < ppList.size(); i++) {
				Map<String, Object> mmMap = ppList.get(i);
				sb.append("<set label=\"" + mmMap.get("DeptName") + "\" value=\"" + mmMap.get("CountNum") + "\"/>");
			}
			sb.append("</graph>");
		}
		return sb.toString();
	}
	
	public String KeshiparseNodeTreeToXML(List<Map<String, Object>> ppList) {
		StringBuffer sb = new StringBuffer();
		if (ppList != null && ppList.size() > 0) {
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append(
					"<graph caption=\"\" baseFontSize=\"12\" xAxisName=\"\" yAxisName=\"\" showValues=\"1\" decimals=\"0\" formatNumberScale=\"0\" labelDisplay=\"Rotate\" slantLabels=\"1\">");
			for (int i = 0; i < ppList.size(); i++) {
				Map<String, Object> mmMap = ppList.get(i);
				sb.append("<set label=\"" + mmMap.get("deptname") + "\" value=\"" + mmMap.get("countnum") + "\"/>");
			}
			sb.append("</graph>");
		}
		return sb.toString();
	}
}
