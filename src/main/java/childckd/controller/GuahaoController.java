package childckd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Blacklist;
import childckd.model.Guahao;
import childckd.model.News;
import childckd.model.Paibanguanli;
import childckd.service.BlackService;
import childckd.service.GuahaoService;
import childckd.service.PaiBanGuanLiService;
import childckd.service.PatientJiuzhenxinxiService;
import childckd.util.JsonResult;
import childckd.util.PageInfo;
@RestController
@RequestMapping("guahao")
public class GuahaoController {
	@Autowired
	GuahaoService ddService;
	@Autowired
	PatientJiuzhenxinxiService ddPatientJiuzhenxinxiService;
	@Autowired
	PaiBanGuanLiService ddPaiBanGuanLiService;
	@Autowired
	BlackService ddBlackService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("find_custom_all")
	public JsonResult<?> findCustomAll(
			@RequestParam("xingming") String ppXingming, 
			@RequestParam("shoujihao") String ppShoujihao, 
			@RequestParam("bingzhong") String ppBingzhong, 
			@RequestParam("expertid") String ppExpertId,
			@RequestParam("yuyueriqi") String ppYuyueriqi,
			@RequestParam("shenhejieguo") int ppShenhejieguo,
			@RequestParam("pageindex") int ppPageIndex, 
			@RequestParam("pagesize") int ppPageSize) {
		try {
			int mmCount = ddService.countFindCustomAll(ppXingming, ppShoujihao,ppBingzhong,ppExpertId, ppYuyueriqi,ppShenhejieguo);
			PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);
			List<Map<String, Object>> mmList = ddService.findCustomAll(ppXingming, ppShoujihao,ppBingzhong,ppExpertId, ppYuyueriqi,ppShenhejieguo, ppPageIndex, ppPageSize);

			Map<String, Object> mmMap = new HashMap<String, Object>();
			mmMap.put("List", mmList);
			mmMap.put("PageInfo", mmPageInfo);
			return JsonResult.getSuccessResult(mmMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> findCustomAll: " + e.getMessage());
			return JsonResult.getErrorResult("查找所有失败！");
		}
	}
	

	@RequestMapping("shenhe")
	public JsonResult<?> shenhe(
			@RequestParam("guahaoid") String ppGuahaoId, 
			@RequestParam("shenhejieguo") int ppShenhejieguo,
			@RequestParam("shenheyijian") String ppShenheyijian,
			@RequestParam("fajianrenid") String ppFajianrenId,
			@RequestParam("neirong") String ppNeirong) {
		try {
			Guahao mmGuahao = ddService.findOne(ppGuahaoId);
			if (mmGuahao == null) {
				return JsonResult.getErrorResult("该挂号不存在");
			}
			Paibanguanli mmPaibanguanli = ddPaiBanGuanLiService.findOne(mmGuahao.getPaibanid());
			if (mmPaibanguanli == null) {
				return JsonResult.getErrorResult("该排班不存在");
			}

			ppShenheyijian = ppShenheyijian.trim();

			mmGuahao.setShenhejieguo(ppShenhejieguo);
			mmGuahao.setShenheshijian(new Date());
			mmGuahao.setShenheyijian(ppShenheyijian);

			News mmNews = new News();
			mmNews.setNewsid(UUID.randomUUID().toString());
			mmNews.setFajianren(ppFajianrenId);
			mmNews.setFajianrenname(mmPaibanguanli.getName());
			mmNews.setShoujianren(mmGuahao.getUserid());
			mmNews.setShoujianrenname(mmGuahao.getName());
			mmNews.setNeirong(ppNeirong);
			mmNews.setNewstype(1);// 1:挂号
			mmNews.setZhuangtai(0);
			mmNews.setChuangjianshijian(new Date());
			mmNews.setOwnerid(ppGuahaoId);

			boolean mmResult = ddService.shenhe(mmGuahao, mmNews);
			return mmResult ? JsonResult.getSuccessResult("审核成功") : JsonResult.getErrorResult("审核失败");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> shenhe: " + e.getMessage());
			return JsonResult.getErrorResult("审核失败！");
		}
	}

	// 我的预约，根据userid查询挂号和住院预约
	@RequestMapping("find_yuyue_by_userid")
	public JsonResult<?> findYuyueByUserId(@RequestParam("userid") String ppUserId) {
		try {
			List<Map<String, Object>> mmList = ddService.findYuyueByUserId(ppUserId);

			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> find_yuyue_by_userid: " + e.getMessage());
			return JsonResult.getErrorResult("根据userid查找失败！");
		}
	}
	
	@RequestMapping("find_custom_one")
	public JsonResult<?> findCustomOne(@RequestParam("guahaoid") String ppGuahaoId) {
		try {
			Map<String, Object> mmMap = ddService.findCustomOne(ppGuahaoId);
			if (mmMap==null) {
				return JsonResult.getErrorResult("该挂号信息不存在");
			}

			return JsonResult.getSuccessResult(mmMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> findCustomOne: " + e.getMessage());
			return JsonResult.getErrorResult("查找失败！");
		}
	}

	// 根据挂号id查找
	@RequestMapping("find_one")
	public JsonResult<?> find_one(@RequestParam("guahaoid") String ppGuahaoId) {
		try {
			return JsonResult.getSuccessResult(ddService.findOne(ppGuahaoId));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> find_one: " + e.getMessage());
			return JsonResult.getErrorResult("根据挂号id查找失败！");
		}
	}

	// 取消预约--设置状态
	@RequestMapping("cancel")
	public JsonResult<?> set_zhuangtai(@RequestParam("guahaoid") String ppGuahaoId, @RequestParam("shenhejieguo") String ppShenhejieguo) {
		try {
			Guahao mmGuahao = ddService.findOne(ppGuahaoId);
			if (mmGuahao == null) {
				return JsonResult.getErrorResult("不存在该挂号申请！");
			}

			mmGuahao.setShenhejieguo(Integer.parseInt(ppShenhejieguo));

			return ddService.modify(mmGuahao) ? JsonResult.getSuccessResult("取消成功！") : JsonResult.getErrorResult("取消失败！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> set_zhuangtai: " + e.getMessage());
			return JsonResult.getErrorResult("取消预约失败！");
		}
	}

	// 新增挂号信息
	@RequestMapping("add")
	public JsonResult<?> add(
			@RequestParam("jiuzhenxinxiid") String ppJiuzhenxinxiId,
			@RequestParam("userid") String ppUserId, 
			@RequestParam("paibanid") String ppPaibanId) {
		try {
			
			Blacklist mmBlack = ddBlackService.findOneByUserId(ppJiuzhenxinxiId);
			if (mmBlack != null) {
				return JsonResult.getErrorResult("该就诊信息在黑名单中，无法预约！");
			}
			
			// 获取排班信息
			Paibanguanli mmPaibanguanli = ddPaiBanGuanLiService.findOne(ppPaibanId);
			if (mmPaibanguanli == null) {
				return JsonResult.getErrorResult("该排班不存在");
			}
			
			
			String mmName = ddPatientJiuzhenxinxiService.findOne(ppJiuzhenxinxiId).getName();

			String mmGuahaoId = UUID.randomUUID().toString();
			Guahao mmGuahao = new Guahao();
			mmGuahao.setGuahaoid(mmGuahaoId);
			mmGuahao.setJiuzhenxinxiid(ppJiuzhenxinxiId);
			mmGuahao.setUserid(ppUserId);
			mmGuahao.setPaibanid(ppPaibanId);
			mmGuahao.setName(mmName);
			mmGuahao.setChuangjianshijian(new Date());
			mmGuahao.setZhuangtai(1);
			
			// 消息
			News mmNews = null;
			
			// 若排版信息中的剩余号数小于1，则挂号为待审核状态，否则直接通过审核 并且 发送消息   20210129修改
			int mmShengyuhaoshu = mmPaibanguanli.getShengyuhaoshu();
			if (mmShengyuhaoshu < 1) {
				mmGuahao.setShenhejieguo(0);	// 待审核
			}else {
				mmGuahao.setShenhejieguo(1);	// 审核通过
				mmGuahao.setShenheshijian(new Date());
				
				// 往消息中插入一条数据
				mmNews = new News();
				mmNews.setNewsid(UUID.randomUUID().toString());
				mmNews.setFajianren("guahaoguanliyuan");
				mmNews.setFajianrenname("挂号管理员");
				mmNews.setShoujianren(ppUserId);
				mmNews.setShoujianrenname(mmName);
				mmNews.setNeirong("限号数之内的预约直接通过!");
				mmNews.setNewstype(1);		// 1:挂号
				mmNews.setZhuangtai(0);
				mmNews.setChuangjianshijian(new Date());
				mmNews.setOwnerid(mmGuahaoId);
			}
			
			// 获取排班信息中的排班时间，若在这天已有挂号信息，则不能重复挂号
			Date mmPaibanriqi = mmPaibanguanli.getPaibanriqi();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(mmPaibanriqi);
			List<Map<String, Object>> mmGuahaoList = ddService.findByDateAndUserId(ppUserId, dateString);
			if (mmGuahaoList.size()>0) {
				return JsonResult.getErrorResult("请勿重复挂号");
			}

			// 当剩余号数大于0
			if (mmShengyuhaoshu > 0) {
				// 预约挂号成功，剩余号数减一
				mmPaibanguanli.setShengyuhaoshu(mmShengyuhaoshu - 1);
			}		

			boolean mmResult = ddService.addCustom(mmGuahao, mmPaibanguanli,mmNews);
			
			if (mmShengyuhaoshu > 0) {
				return mmResult ? JsonResult.getSuccessResult("预约成功！") : JsonResult.getErrorResult("预约失败！");
			}
			
			return mmResult ? JsonResult.getSuccessResult("加号预约成功，待专家审核！") : JsonResult.getErrorResult("加号预约失败！");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> add: " + e.getMessage());
			return JsonResult.getErrorResult("新增预约挂号失败！");
		}
	}
	
	@RequestMapping("tongji_renshu")
	public JsonResult<?>tongjiRenshu(){
		try {
			List<Map<String, Object>>mmList = ddService.tongjiRenshu();
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> tongjiRenshu: " + e.getMessage());
			return JsonResult.getErrorResult("人数统计失败！");
		}
	}
	
	@RequestMapping("tongji_nianling")
	public JsonResult<?>tongjiNianling(){
		try {
			List<Map<String, Object>>mmList = ddService.tongjiNianling();
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> tongjiNianling: " + e.getMessage());
			return JsonResult.getErrorResult("年龄统计失败！");
		}
	}

	@RequestMapping("tongji_bingzhong")
	public JsonResult<?>tongjiBingzhong(){
		try {
			List<Map<String, Object>> mmList = ddService.tongjiBingzhong();
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GuahaoController -> tongjiBingzhong: "+e.getMessage());
			return JsonResult.getErrorResult("统计病种失败！");
		}
	}
}
