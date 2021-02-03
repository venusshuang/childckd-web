package childckd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import childckd.service.DictBingzhongService;
import childckd.service.DictNianlingduanService;
import childckd.util.JsonResult;

@RestController
@RequestMapping("dict_nianlingduan")
public class DictNianlingduanController {
	@Autowired
	DictNianlingduanService ddService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("find_valid")
	public JsonResult<?> find_valid(){
		try {
			return JsonResult.getSuccessResult(ddService.findValue());
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("DictNianlingduanController -> find_valid: "+e.getMessage());
			return JsonResult.getErrorResult("查找有效的年龄段失败！");
		}
	}
}
