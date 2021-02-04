package childckd.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.service.InfoCategoryInfoService;
import childckd.util.JsonResult;

@RequestMapping("infocategoryinfo")
@RestController
public class InfoCategoryInfoController {

	private static Log log = LogFactory.getLog(InfoCategoryInfoController.class);

	@Autowired
	InfoCategoryInfoService ddService;

	@RequestMapping("delete")
	public JsonResult<?> delete(@RequestParam("infoid") String ppInfoId,
			@RequestParam("categoryid") String ppCategoryId) {
		try {
			boolean mmResult = ddService.delete(ppInfoId, ppCategoryId);
			return mmResult == true ? JsonResult.getSuccessResult("删除成功") : JsonResult.getErrorResult("删除失败");
		} catch (Exception e) {
			log.error("infocategoryinfo/delete错误", e);
			return JsonResult.getErrorResult("infocategoryinfo/delete错误");
		}
	}

	@RequestMapping("move_up")
	public JsonResult<?> moveUp(@RequestParam("infoid") String ppInfoId,
			@RequestParam("categoryid") String ppCategoryId) {
		try {
			boolean mmResult = ddService.moveUp(ppInfoId, ppCategoryId);
			return mmResult == true ? JsonResult.getSuccessResult("上移成功") : JsonResult.getErrorResult("上移失败");
		} catch (Exception e) {
			log.error("infocategoryinfo/move_up错误", e);
			return JsonResult.getErrorResult("infocategoryinfo/move_up错误");
		}
	}

	@RequestMapping("move_down")
	public JsonResult<?> moveDown(@RequestParam("infoid") String ppInfoId,
			@RequestParam("categoryid") String ppCategoryId) {
		try {
			boolean mmResult = ddService.moveDown(ppInfoId, ppCategoryId);
			return mmResult == true ? JsonResult.getSuccessResult("下移成功") : JsonResult.getErrorResult("下移失败");
		} catch (Exception e) {
			log.error("infocategoryinfo/move_down错误", e);
			return JsonResult.getErrorResult("infocategoryinfo/move_down错误");
		}
	}

}
