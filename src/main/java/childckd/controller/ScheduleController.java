package childckd.controller;

import java.text.SimpleDateFormat;
import java.util.*;

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
import childckd.model.Tingzhen;
import childckd.service.ExpertService;
import childckd.service.PaiBanGuanLiService;
import childckd.service.ScheduleService;
import childckd.service.TingzhenService;
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
	@Autowired
	TingzhenService ddTingzhenService;

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
	public void testSchedule() {

		List<Date> mmTodayList = new ArrayList<>();

		//一周后
//		Calendar calendar = Calendar.getInstance();  	// 获取当前时间
//		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 7);  // 当前日期是这一年中的第几天，然后加7
//		Date today = calendar.getTime();  				// 得到当前日期
//		mmTodayList.add(today);
//		//两周后
//		Calendar calendar2 = Calendar.getInstance();  	// 获取当前时间
//		calendar2.set(Calendar.DAY_OF_YEAR, calendar2.get(Calendar.DAY_OF_YEAR) + 14);  // 当前日期是这一年中的第几天，然后加7
//		Date today2 = calendar2.getTime();  				// 得到当前日期
//		mmTodayList.add(today2);
		//三周后
		Calendar calendar3 = Calendar.getInstance();  	// 获取当前时间
		calendar3.set(Calendar.DAY_OF_YEAR, calendar3.get(Calendar.DAY_OF_YEAR) + 21);  // 当前日期是这一年中的第几天，然后加7
		Date today3 = calendar3.getTime();  				// 得到当前日期
		mmTodayList.add(today3);
		//四周后
//		Calendar calendar4 = Calendar.getInstance();  	// 获取当前时间
//		calendar4.set(Calendar.DAY_OF_YEAR, calendar4.get(Calendar.DAY_OF_YEAR) + 28);  // 当前日期是这一年中的第几天，然后加7
//		Date today4 = calendar4.getTime();  				// 得到当前日期
//		mmTodayList.add(today4);

		int mmXingqi = today3.getDay();					// 获取星期数

		if (mmXingqi == 0) {
			mmXingqi = 7;
		}
		
		// 根据星期数去查周排班信息
		List<Schedule> mmScheduleList = ddService.findByXingqi(mmXingqi);
		
		// 查找所有有效的停诊
		List<Tingzhen> mmTingzhenList = ddTingzhenService.findValid();
		
		// 循环周排班列表
		for (int i = 0; i < mmScheduleList.size(); i++) {
			
			String mmExpertId = mmScheduleList.get(i).getExpertid();
			String mmShangxiawu = mmScheduleList.get(i).getShangxiawu();
			
			// 循环有效的停诊列表
			for(int j = 0; j < mmTingzhenList.size(); j++) {
				
				String mmExpertId1 = mmTingzhenList.get(j).getExpertid();
				Date mmStarttime = mmTingzhenList.get(j).getStarttime();
				Date mmEndtime = mmTingzhenList.get(j).getEndtime();
				String mmIsAM = mmTingzhenList.get(j).getIsam().toString().equals("1") ? "上午" : "";
				String mmIsPM = mmTingzhenList.get(j).getIspm().toString().equals("1") ? "下午" : "";

				for (int k=0;k<mmTodayList.size();k++){
					Date mmToday = mmTodayList.get(k);
					// 如果 周排班中的专家id=停诊中的专家id、待排班日期在停诊起止日期内、上下午也对应  则这条记录不能插入排班表
					if(mmExpertId.equals(mmExpertId1) && mmToday.after(mmStarttime) && mmToday.before(mmEndtime) && (mmShangxiawu.equals(mmIsAM) || mmShangxiawu.equals(mmIsPM) )) {
						mmScheduleList.remove(i);
						break;
					}
				}
			}
		}

		for (int i=0;i<mmTodayList.size();i++){
			Date mmToday = mmTodayList.get(i);

			// 剩余有效的周排班，插入到排班管理中
			for(int k = 0 ; k < mmScheduleList.size() ; k++) {

				String mmExpertId = mmScheduleList.get(k).getExpertid();
				String mmXingming = mmScheduleList.get(k).getZhuanjiaxingming();
				String mmGuahaoleibie = mmScheduleList.get(k).getGuahaoleibie();
				String mmShangxiawu = mmScheduleList.get(k).getShangxiawu();
				int mmXianhaoshu = mmScheduleList.get(k).getXianhaoshu();
				float mmJiage = mmScheduleList.get(k).getJiage();

				Paibanguanli mmPaibanguanli = new Paibanguanli();
				mmPaibanguanli.setPaibanid(UUID.randomUUID().toString());
				mmPaibanguanli.setExpertid(mmExpertId);
				mmPaibanguanli.setName(mmXingming);
				mmPaibanguanli.setGuahaoleibie(mmGuahaoleibie);
				mmPaibanguanli.setPaibanriqi(mmToday);
				mmPaibanguanli.setShangxiawu(mmShangxiawu);
				mmPaibanguanli.setXianhaoshu(mmXianhaoshu);
				mmPaibanguanli.setShengyuhaoshu(mmXianhaoshu);
				mmPaibanguanli.setJiage(mmJiage);
				mmPaibanguanli.setZhuangtai(1);

				ddPaibanguanliService.add(mmPaibanguanli);
			}
		}
	}

}
