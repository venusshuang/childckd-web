package childckd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import childckd.service.DictBingzhongService;
import childckd.util.JsonResult;

@RestController
@RequestMapping("dict_bingzhong")
public class DictBingzhongController {
	@Autowired
	DictBingzhongService ddService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("find_valid")
	public JsonResult<?> find_valid(){
		try {
			return JsonResult.getSuccessResult(ddService.findValue());
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("DictBingzhongController -> find_valid: "+e.getMessage());
			return JsonResult.getErrorResult("查找有效的病种失败！");
		}
	}
}
