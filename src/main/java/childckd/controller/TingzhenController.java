package childckd.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Expert;
import childckd.model.Tingzhen;
import childckd.service.ExpertService;
import childckd.service.TingzhenService;
import childckd.util.BooleanMessage;
import childckd.util.DateUtil;
import childckd.util.JsonResult;

@RestController
@RequestMapping("tingzhen")
public class TingzhenController {
	@Autowired
	TingzhenService ddService;

	@Autowired
	ExpertService ddExpertService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 根据停诊id查找停诊信息
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("tingzhenid") String ppTingzhenId){
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppTingzhenId));
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("TingzhenController -> find_one: "+e.getMessage());
			return JsonResult.getErrorResult("根据停诊id查找停诊信息失败！");
		}
	}

	// 查找所有未删除的停诊信息--状态为1
	@RequestMapping("find_valid")
	public JsonResult<?> find_valid(){
		try {
			return JsonResult.getSuccessResult(ddService.findValid());
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("TingzhenController -> find_valid: "+e.getMessage());
			return JsonResult.getErrorResult("查找所有未删除的停诊信息失败！");
		}
	}

	// 根据停诊id删除停诊信息--假删，修改状态
	@RequestMapping("delete")
	public JsonResult<?> delete(@RequestParam("tingzhenid") String ppTingzhenId){
		try {
			Tingzhen mmTingzhen = ddService.findOne(ppTingzhenId);
			if(mmTingzhen == null) {
				return JsonResult.getErrorResult("不存在此停诊信息！");
			}

			mmTingzhen.setZhuangtai(0);

			return ddService.modify(mmTingzhen) ?  JsonResult.getSuccessResult("删除成功！") : 
				JsonResult.getErrorResult("删除失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("TingzhenController -> delete: "+e.getMessage());
			return JsonResult.getErrorResult("根据停诊id删除停诊信息失败！");
		}
	}

	// 批量删除停诊信息
	@RequestMapping("delete_by_tingzhenidlist")
	public JsonResult<?> delete_by_tingzhenidlist(
			@RequestParam("tingzhenidlist") String ppTingzhenIdList) {
		try {
			String[] mmTingzhenIdArray = ppTingzhenIdList.split(",");

			if(mmTingzhenIdArray == null)
			{
				return JsonResult.getErrorResult("停诊id不能为空！");
			}

			return ddService.deleteByTingzhenIdList(mmTingzhenIdArray) ? JsonResult.getSuccessResult("删除成功") : 
				JsonResult.getErrorResult("删除失败");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ReferralController -> delete_by_tingzhenidlist: "+e.getMessage());
			return JsonResult.getErrorResult("批量删除停诊信息失败");
		}
	}

	// 新增停诊信息
	@RequestMapping("add")
	public JsonResult<?> add(
			@RequestParam("expertid") String ppExpertId,
			@RequestParam("starttime") String ppStarttime,
			@RequestParam("endtime") String ppEndtime,
			@RequestParam("isam") String ppIsAM,
			@RequestParam("ispm") String ppIsPM){
		try {
			// 根据专家id查找此专家
			Expert mmExpert = ddExpertService.findOne(ppExpertId);
			if(mmExpert == null) {
				return JsonResult.getErrorResult("不存在此专家！");
			}
			String mmExpertName = mmExpert.getName() == null ? "" : mmExpert.getName();

			Tingzhen mmTingzhen = new Tingzhen();
			mmTingzhen.setTingzhenid(UUID.randomUUID().toString());
			mmTingzhen.setExpertid(ppExpertId);
			mmTingzhen.setName(mmExpertName);
			mmTingzhen.setZhuangtai(1);

			BooleanMessage mmBooleanMessage = checkInputData(mmTingzhen,ppStarttime,ppEndtime,
					ppIsAM,ppIsPM);

			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}

			return ddService.add(mmTingzhen) ?  JsonResult.getSuccessResult("新增成功！") : 
				JsonResult.getErrorResult("新增失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("TingzhenController -> add: "+e.getMessage());
			return JsonResult.getErrorResult("新增停诊信息失败！");
		}
	}

	// 修改停诊信息
	@RequestMapping("modify")
	public JsonResult<?> modify(
			@RequestParam("tingzhenid") String ppTingzhenId,
			@RequestParam("expertid") String ppExpertId,
			@RequestParam("starttime") String ppStarttime,
			@RequestParam("endtime") String ppEndtime,
			@RequestParam("isam") String ppIsAM,
			@RequestParam("ispm") String ppIsPM){
		try {
			Tingzhen mmTingzhen = ddService.findOne(ppTingzhenId);
			if(mmTingzhen == null) {
				return JsonResult.getErrorResult("不存在此停诊信息！");
			}

			// 根据专家id查找此专家
			Expert mmExpert = ddExpertService.findOne(ppExpertId);
			if(mmExpert == null) {
				return JsonResult.getErrorResult("不存在此专家！");
			}
			String mmExpertName = mmExpert.getName() == null ? "" : mmExpert.getName();

			mmTingzhen.setExpertid(ppExpertId);
			mmTingzhen.setName(mmExpertName);
			mmTingzhen.setZhuangtai(1);

			BooleanMessage mmBooleanMessage = checkInputData(mmTingzhen,ppStarttime,ppEndtime,
					ppIsAM,ppIsPM);

			if(!mmBooleanMessage.isOk()) {
				return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
			}

			return ddService.modify(mmTingzhen) ?  JsonResult.getSuccessResult("修改成功！") : 
				JsonResult.getErrorResult("修改失败！");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("TingzhenController -> modify: "+e.getMessage());
			return JsonResult.getErrorResult("修改停诊信息失败！");
		}
	}


	// 数据验证
	private BooleanMessage checkInputData(Tingzhen mmTingzhen,String ppStarttime, String ppEndtime,
			String ppIsAM, String ppIsPM) {
		if("".equals(ppStarttime)) {
			return BooleanMessage.getErrorMessage("停诊开始时间不能为空！");
		}

		if("".equals(ppEndtime)) {
			return BooleanMessage.getErrorMessage("停诊结束时间不能为空！");
		}

		if("".equals(ppIsAM)) {
			return BooleanMessage.getErrorMessage("是否上午停诊不能为空！");
		}

		if("".equals(ppIsPM)) {
			return BooleanMessage.getErrorMessage("是否下午停诊不能为空！");
		}

		ppStarttime = ppStarttime + " 00:00:00";
		ppEndtime = ppEndtime + " 23:59:59";
		
		Date mmStarttime = DateUtil.convertStringToDate(ppStarttime);
		Date mmEndtime = DateUtil.convertStringToDate(ppEndtime);

		mmTingzhen.setStarttime(mmStarttime);
		mmTingzhen.setEndtime(mmEndtime);
		mmTingzhen.setIsam(Integer.valueOf(ppIsAM));
		mmTingzhen.setIspm(Integer.valueOf(ppIsPM));

		return BooleanMessage.getSuccessMessage(mmTingzhen);
	}



}
