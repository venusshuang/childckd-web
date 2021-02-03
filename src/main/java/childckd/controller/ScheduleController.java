package childckd.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Paibanguanli;
import childckd.model.Schedule;
import childckd.service.ExpertService;
import childckd.service.PaiBanGuanLiService;
import childckd.service.ScheduleService;
import childckd.util.JsonResult;

@RequestMapping("schedule")
@RestController
@EnableScheduling
public class ScheduleController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	ScheduleService ddService;
	@Autowired
	ExpertService ddExpertService;
	@Autowired
	PaiBanGuanLiService ddPaibanguanliService;

	@RequestMapping("save")
	public JsonResult<?> save(@RequestParam("scheduleid") String ppScheduleId, @RequestParam("xingqi") int ppXingqi, @RequestParam("expertid") String ppExpertId,
			@RequestParam("guahaoleibie") String ppGuahaoleibie, @RequestParam("shangxiawu") String ppShangxiawu, @RequestParam("xianhaoshu") int ppXianhaoshu, @RequestParam("jiage") float ppJiage,
			@RequestParam("zhuangtai") int ppZhuangtai) {
		try {
			Schedule mmSchedule = new Schedule();

			boolean mmResult = true;

			if (!"".equals(ppScheduleId)) {// modify
				mmSchedule = ddService.findOne(ppScheduleId);
				mmSchedule.setXingqi(ppXingqi);
				mmSchedule.setExpertid(ppExpertId);
				mmSchedule.setZhuanjiaxingming(ddExpertService.findOne(ppExpertId).getName());
				mmSchedule.setGuahaoleibie(ppGuahaoleibie);
				mmSchedule.setShangxiawu(ppShangxiawu);
				mmSchedule.setXianhaoshu(ppXianhaoshu);
				mmSchedule.setJiage(ppJiage);
				mmSchedule.setZhuangtai(ppZhuangtai);
				mmResult = ddService.modify(mmSchedule);
			} else {// add
				mmSchedule.setId(UUID.randomUUID().toString());
				mmSchedule.setXingqi(ppXingqi);
				mmSchedule.setExpertid(ppExpertId);
				mmSchedule.setZhuanjiaxingming(ddExpertService.findOne(ppExpertId).getName());
				mmSchedule.setGuahaoleibie(ppGuahaoleibie);
				mmSchedule.setShangxiawu(ppShangxiawu);
				mmSchedule.setXianhaoshu(ppXianhaoshu);
				mmSchedule.setJiage(ppJiage);
				mmSchedule.setZhuangtai(ppZhuangtai);
				mmResult = ddService.add(mmSchedule);
			}

			return mmResult ? JsonResult.getSuccessResult("保存成功") : JsonResult.getErrorResult("保存失败");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ScheduleController -> save: " + e.getMessage());
			return JsonResult.getErrorResult("保存周排班失败！");
		}

	}
	
	@RequestMapping("find_by_xingqi_and_shangxiawu")
	public JsonResult<?>findByXingqiAndShangxiawu(@RequestParam("xingqi")int ppXingqi,@RequestParam("shangxiawu")String ppShangxiawu){
		try {
			List<Schedule> mmList = ddService.findByXingqiAndShangxiawu(ppXingqi, ppShangxiawu);
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ScheduleController -> find_by_xingqi_and_shangxiawu: " + e.getMessage());
			return JsonResult.getErrorResult("根据星期上下午查询周排班失败！");
		}
	}

	@RequestMapping("find_one")
	public JsonResult<?> findOne(@RequestParam("scheduleid") String ppScheduleId) {
		try {
			Schedule mmSchedule = ddService.findOne(ppScheduleId);
			if (mmSchedule==null) {
				return JsonResult.getErrorResult("该周排班不存在");
			}
			return JsonResult.getSuccessResult(mmSchedule);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ScheduleController -> findOne: " + e.getMessage());
			return JsonResult.getErrorResult("查询周排班失败！");
		}
	}

	@RequestMapping("find_all")
	public JsonResult<?> findAll() {
		try {
			List<Schedule> mmList = ddService.findAll();
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ScheduleController -> findAll: " + e.getMessage());
			return JsonResult.getErrorResult("查询周排班失败！");
		}
	}
	
	@RequestMapping("delete")
	public JsonResult<?>delete(@RequestParam("scheduleid") String ppScheduleId){
		try {
			Schedule mmSchedule = ddService.findOne(ppScheduleId);
			if (mmSchedule==null) {
				return JsonResult.getErrorResult("该周排班不存在");
			}
			
			boolean mmResult = ddService.delete(ppScheduleId);
			return mmResult?JsonResult.getSuccessResult("删除成功"):JsonResult.getErrorResult("删除失败");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ScheduleController -> delete: " + e.getMessage());
			return JsonResult.getErrorResult("删除周排班失败！");
		}
	}
	
	@RequestMapping("set_zhuangtai")
	public JsonResult<?> set_zhuangtai(
			@RequestParam("scheduleid") String ppScheduleId,
			@RequestParam("zhuangtai") String ppZhuangtai){
		try {
			Schedule mmSchedule = ddService.findOne(ppScheduleId);
			if (mmSchedule==null) {
				return JsonResult.getErrorResult("该周排班不存在");
			}
			
			mmSchedule.setZhuangtai(Integer.parseInt(ppZhuangtai));
			
			return ddService.modify(mmSchedule) ? JsonResult.getSuccessResult("停诊成功") : 
				JsonResult.getErrorResult("停诊失败");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ScheduleController -> set_zhuangtai: " + e.getMessage());
			return JsonResult.getErrorResult("设置周排班状态失败！");
		}
	}
	
	@RequestMapping("test_schedule")
	@Scheduled(fixedRate = 86400000)
	//@Scheduled(fixedRate = 5000)
	public void testSchedule() {
		
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 7);  
		Date today = calendar.getTime();  
		int mmXingqi = today.getDay();

		if (mmXingqi==0) {
			mmXingqi = 7;
		}
		
		List<Schedule>mmList = ddService.findByXingqi(mmXingqi);
		
		for (int i = 0; i < mmList.size(); i++) {
			String mmExpertId = mmList.get(i).getExpertid();
			String mmXingming = mmList.get(i).getZhuanjiaxingming();
			String mmGuahaoleibie = mmList.get(i).getGuahaoleibie();
			String mmShangxiawu = mmList.get(i).getShangxiawu();
			int mmXianhaoshu = mmList.get(i).getXianhaoshu();
			float mmJiage = mmList.get(i).getJiage();
			
			Paibanguanli mmPaibanguanli = new Paibanguanli();
			mmPaibanguanli.setPaibanid(UUID.randomUUID().toString());
			mmPaibanguanli.setExpertid(mmExpertId);
			mmPaibanguanli.setName(mmXingming);
			mmPaibanguanli.setGuahaoleibie(mmGuahaoleibie);
			mmPaibanguanli.setPaibanriqi(today);
			mmPaibanguanli.setShangxiawu(mmShangxiawu);
			mmPaibanguanli.setXianhaoshu(mmXianhaoshu);
			mmPaibanguanli.setShengyuhaoshu(mmXianhaoshu);
			mmPaibanguanli.setJiage(mmJiage);
			mmPaibanguanli.setZhuangtai(1);
			
			ddPaibanguanliService.add(mmPaibanguanli);
		}
	}

}
