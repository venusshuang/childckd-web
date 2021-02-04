package childckd.controller;

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
import org.springframework.web.bind.annotation.RestController;

import childckd.model.InfoCategory;
import childckd.service.InfoCategoryInfoService;
import childckd.service.InfoCategoryService;
import childckd.util.JsonResult;
import childckd.util.StringHandle;


@RequestMapping("infocategory")
@RestController
public class InfoCategoryController {

	private static Log log = LogFactory.getLog(InfoCategoryController.class);

	@Autowired
	InfoCategoryService ddService;
	@Autowired
	InfoCategoryInfoService ddInfoCategoryInfoService;

	@RequestMapping("find_all")
	public JsonResult<?> findAll() {
		try {
			List<InfoCategory> mmList = ddService.findAll();
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			log.error("infocategory/find_all错误", e);
			return JsonResult.getErrorResult("infocategory/find_all错误");
		}
	}

	@RequestMapping("find_valid")
	public JsonResult<?> findValid() {
		try {
			List<InfoCategory> mmList = ddService.findValid();
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			log.error("infocategory/find_valid错误", e);
			return JsonResult.getErrorResult("infocategory/find_valid错误");
		}
	}
	
	@RequestMapping("find_allow_tougao")
	public JsonResult<?> findAllowTougao() {
		try {
			List<InfoCategory> mmList = ddService.findAllowTougao();
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			log.error("infocategory/find_allow_tougao错误", e);
			return JsonResult.getErrorResult(e.getMessage());
		}
	}

	@RequestMapping("find_all_by_deptid")
	public JsonResult<?> findByDeptId(@RequestParam("deptid") String ppDeptId) {
		try {
			List<Map<String, Object>> mmList = ddService.findByDeptId(ppDeptId);
			if (mmList.size() == 0) {
				return JsonResult.getErrorResult("当前单位没有管理权限");
			}
			List<String> mmParentCategoryIdList = new ArrayList<String>();
			for (int i = 0; i < mmList.size(); i++) {
				mmList.get(i).put("parentcategoryid", 0);
				mmParentCategoryIdList.add(mmList.get(i).get("categoryid").toString());
			}
			while (mmParentCategoryIdList.size() > 0) {
				List<Map<String, Object>> mmCategoryList = ddService
						.findByParentCategoryId(mmParentCategoryIdList.remove(0));
				mmList.addAll(mmCategoryList);
				for (int i = 0; i < mmCategoryList.size(); i++) {
					mmParentCategoryIdList.add(mmCategoryList.get(i).get("categoryid").toString());
				}
			}
			Map<String, Object> mmMap = new HashMap<String, Object>();
			mmMap.put("categoryid", 0);
			mmMap.put("parentcategoryid", 00);
			mmMap.put("categoryname", "单位栏目");
			mmList.add(mmMap);
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			log.error("infocategory/find_by_deptid错误", e);
			return JsonResult.getErrorResult("infocategory/find_by_deptid错误");
		}
	}

	@RequestMapping("find_one")
	public JsonResult<?> findOne(@RequestParam("categoryid") String ppCategoryId) {
		try {
			InfoCategory mmInfoCategory = ddService.findOne(ppCategoryId);
			return mmInfoCategory == null ? JsonResult.getErrorResult("该栏目不存在")
					: JsonResult.getSuccessResult(mmInfoCategory);
		} catch (Exception e) {
			log.error("infocategory/find_one错误", e);
			return JsonResult.getErrorResult("infocategory/find_one错误");
		}
	}
	
	@RequestMapping("find_by_parentcategoryid")
	public JsonResult<?>findByParentCategoryId(@RequestParam("parentcategoryid")String ppParentCategoryId){
		try {
			List<Map<String, Object>>mmList = ddService.findByParentCategoryId(ppParentCategoryId);
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			log.error("infocategory/find_by_parentcategoryid错误", e);
			return JsonResult.getErrorResult("infocategory/find_by_parentcategoryid错误");
		}
	}

	@RequestMapping("add")
	public JsonResult<?> add(@RequestParam("parentcategoryid") String ppParentCategoryId,
			@RequestParam("categoryname") String ppCategoryName, @RequestParam("picurl") String ppPicurl,
			@RequestParam("score") Float ppScore, @RequestParam("allowtougao") int ppAllowtougao,
			@RequestParam("isvalid") int ppIsvalid,@RequestParam("beizhu")String ppBeizhu) {
		try {
			if (StringHandle.getStringByteLength(ppCategoryName) > 100) {
				return JsonResult.getErrorResult("栏目名称长度不可超过100字节");
			}
			if (StringHandle.getStringByteLength(ppPicurl) > 250) {
				return JsonResult.getErrorResult("图片长度不可超过250字节");
			}
			if (StringHandle.getStringByteLength(ppBeizhu) > 500) {
				return JsonResult.getErrorResult("备注长度不可超过500字节");
			}
			InfoCategory mmInfoCategory = new InfoCategory();
			mmInfoCategory.setCategoryid(UUID.randomUUID().toString());
			mmInfoCategory.setParentcategoryid(ppParentCategoryId);
			mmInfoCategory.setCategoryname(ppCategoryName);
			mmInfoCategory.setPicurl(ppPicurl);
			mmInfoCategory.setScore(ppScore);
			mmInfoCategory.setAddtime(new Date());
			mmInfoCategory.setBeizhu(ppBeizhu);

			int mmOrdernum = ddService.getMaxOrdernum(ppParentCategoryId) + 1;

			mmInfoCategory.setOrdernum(mmOrdernum);
			mmInfoCategory.setAllowdelete(1);
			mmInfoCategory.setAllowtougao(ppAllowtougao);
			mmInfoCategory.setIsvalid(ppIsvalid);

			boolean mmResult = ddService.add(mmInfoCategory);

			return mmResult == true ? JsonResult.getSuccessResult("添加成功") : JsonResult.getErrorResult("添加失败");
		} catch (Exception e) {
			log.error("infocategory/add错误", e);
			return JsonResult.getErrorResult("infocategory/add错误");
		}
	}

	@RequestMapping("modify")
	public JsonResult<?> modify(@RequestParam("categoryid") String ppCategoryId,
			@RequestParam("categoryname") String ppCategoryName, @RequestParam("picurl") String ppPicurl,
			@RequestParam("score") float ppScore, @RequestParam("allowtougao") int ppAllowtougao,
			@RequestParam("isvalid") int ppIsvalid,@RequestParam("beizhu")String ppBeizhu) {
		try {
			if (StringHandle.getStringByteLength(ppCategoryName) > 100) {
				return JsonResult.getErrorResult("栏目名称长度不可超过100字节");
			}
			if (StringHandle.getStringByteLength(ppPicurl) > 250) {
				return JsonResult.getErrorResult("图片长度不可超过250字节");
			}
			if (StringHandle.getStringByteLength(ppBeizhu) > 500) {
				return JsonResult.getErrorResult("备注长度不可超过500字节");
			}
			InfoCategory mmInfoCategory = ddService.findOne(ppCategoryId);
			mmInfoCategory.setCategoryname(ppCategoryName);
			mmInfoCategory.setPicurl(ppPicurl);
			mmInfoCategory.setScore(ppScore);
			mmInfoCategory.setBeizhu(ppBeizhu);

			mmInfoCategory.setAllowtougao(ppAllowtougao);
			mmInfoCategory.setIsvalid(ppIsvalid);

			boolean mmResult = ddService.modify(mmInfoCategory);

			return mmResult == true ? JsonResult.getSuccessResult("修改成功") : JsonResult.getErrorResult("修改失败");
		} catch (Exception e) {
			log.error("infocategory/modify错误", e);
			return JsonResult.getErrorResult("infocategory/modify错误");
		}
	}

	@RequestMapping("delete")
	public JsonResult<?> delete(@RequestParam("categoryid") String ppCategoryId) {
		try {
			int mmAllowDelete = ddService.findOne(ppCategoryId).getAllowdelete();

			if (ddService.existSubInfocategory(ppCategoryId)) {
				return JsonResult.getErrorResult("当前栏目下有子栏目，无法删除");
			}
			if (ddInfoCategoryInfoService.existInfoCategoryInfo(ppCategoryId)) {
				return JsonResult.getErrorResult("当前栏目下有信息，无法删除");
			}
			if (mmAllowDelete == 0) {
				return JsonResult.getErrorResult("当前栏目不允许删除");
			}

			boolean mmResult = ddService.delete(ppCategoryId);
			return mmResult == true ? JsonResult.getSuccessResult("删除成功") : JsonResult.getErrorResult("删除失败");
		} catch (Exception e) {
			log.error("infocategory/delete错误", e);
			return JsonResult.getErrorResult("infocategory/delete错误");
		}
	}

	@RequestMapping("move_up")
	public JsonResult<?> moveUp(@RequestParam("categoryid") String ppCategoryId) {
		try {
			boolean mmResult = ddService.moveUp(ppCategoryId);
			return mmResult == true ? JsonResult.getSuccessResult("上移成功") : JsonResult.getErrorResult("上移失败");
		} catch (Exception e) {
			log.error("infocategory/move_up错误", e);
			return JsonResult.getErrorResult("infocategory/move_up错误");
		}
	}

	@RequestMapping("move_down")
	public JsonResult<?> moveDown(@RequestParam("categoryid") String ppCategoryId) {
		try {
			boolean mmResult = ddService.moveDown(ppCategoryId);
			return mmResult == true ? JsonResult.getSuccessResult("下移成功") : JsonResult.getErrorResult("下移失败");
		} catch (Exception e) {
			log.error("infocategory/move_down错误", e);
			return JsonResult.getErrorResult("infocategory/move_down错误");
		}
	}
}
