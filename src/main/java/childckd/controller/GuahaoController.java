package childckd.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import childckd.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

			//查询当天之前未审核的预约，自动驳回并发送信息
			List<Map<String,Object>>mmDaishenheList = ddService.findDaishenheBeforeToday();
			if (mmDaishenheList.size()!=0){
				for (int i=0;i<mmDaishenheList.size();i++){
					String mmGuahaoId = mmDaishenheList.get(i).get("guahaoid").toString();
					Guahao mmGuahao = ddService.findOne(mmGuahaoId);
					if (mmGuahao == null) {
						return JsonResult.getErrorResult("该挂号不存在");
					}
					Paibanguanli mmPaibanguanli = ddPaiBanGuanLiService.findOne(mmGuahao.getPaibanid());
					if (mmPaibanguanli == null) {
						return JsonResult.getErrorResult("该排班不存在");
					}
					mmGuahao.setShenhejieguo(2);
					mmGuahao.setShenheshijian(new Date());
					mmGuahao.setShenheyijian("超时自动驳回");

					News mmNews = new News();
					mmNews.setNewsid(UUID.randomUUID().toString());
					mmNews.setFajianren("1");
					mmNews.setFajianrenname(mmPaibanguanli.getName());
					mmNews.setShoujianren(mmGuahao.getUserid());
					mmNews.setShoujianrenname(mmGuahao.getName());
					mmNews.setNeirong("超时自动驳回预约");
					mmNews.setNewstype(1);// 1:挂号
					mmNews.setZhuangtai(0);
					mmNews.setChuangjianshijian(new Date());
					mmNews.setOwnerid(mmGuahaoId);

					boolean mmResult = ddService.shenhe(mmGuahao, mmNews);
					if (!mmResult){
						return JsonResult.getErrorResult("驳回超时预约失败："+mmGuahaoId);
					}
				}
			}

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
			// 黑名单之内的用户无法预约
			Blacklist mmBlack = ddBlackService.findOneByUserId(ppJiuzhenxinxiId);
			if (mmBlack != null) {
				return JsonResult.getErrorResult("该就诊信息在黑名单中，无法预约！");
			}




			
			// 获取排班信息
			Paibanguanli mmPaibanguanli = ddPaiBanGuanLiService.findOne(ppPaibanId);
			if (mmPaibanguanli == null) {
				return JsonResult.getErrorResult("该排班不存在");
			}



			int mmXianhaoshu = mmPaibanguanli.getXianhaoshu();
			String mmExpertId = mmPaibanguanli.getExpertid();

			// 获取排班信息中的排班时间，若在这天已有挂号信息，则不能重复挂号
			Date mmPaibanriqi = mmPaibanguanli.getPaibanriqi();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(mmPaibanriqi);
			List<Map<String, Object>> mmGuahaoList = ddService.findByDateAndUserId(ppUserId, dateString);
			if (mmGuahaoList.size()>0) {
				return JsonResult.getErrorResult("请勿重复挂号");
			}

			boolean allowJiahao=false;
			String mmShenheyijian="";

			boolean isShenhe=false;

			
			// 消息
			News mmNews = null;

			int mmDangtianZongxianhaoshu = 0;
			int mmDangtianTongguoshu = 0;
			// 根据专家id和排版日期查找审核通过数量和限号数
			List<Paibanguanli> mmPaibanguanliList = ddPaiBanGuanLiService.findDayByExpertidAndPaibanriqi(mmExpertId,dateString);
			for(int i = 0 ; i < mmPaibanguanliList.size() ; i++){
				Paibanguanli mmTempPaibanguanli = mmPaibanguanliList.get(i);
				String mmTempPaibanId = mmTempPaibanguanli.getPaibanid();
				mmDangtianZongxianhaoshu += mmTempPaibanguanli.getXianhaoshu();

				// 当天通过数之和
				mmDangtianTongguoshu += ddPaiBanGuanLiService.countFindYuyue(mmTempPaibanId,1);
			}

			PatientJiuzhenxinxi mmJiuzhenxinxi = ddPatientJiuzhenxinxiService.findOne(ppJiuzhenxinxiId);

			String[] Bingzhongvalues = mmPaibanguanli.getJiahaobingzhong().split(",");
			List<String> Bingzhonglist = Arrays.asList(Bingzhongvalues);


			if(mmDangtianTongguoshu < mmDangtianZongxianhaoshu) {
				allowJiahao=true;
				mmShenheyijian="限号数之内的预约直接通过";
			}else if((Bingzhonglist.size()==0)&&(mmPaibanguanli.getJiahaoshu()!=0))//只设置加号数，未设置加号病种的情况
			{
				if(mmDangtianTongguoshu >= mmDangtianZongxianhaoshu+mmPaibanguanli.getJiahaoshu()) {
					if("0401181f-ad2f-4ad7-8518-c7c631bd9d0a".equals(mmPaibanguanli.getExpertid()))
					{
						//return JsonResult.getErrorResult("各位患儿与家长好，您当前日期预约失败。夏教授是国内儿童肾病第一品牌专家，中国卓越贡献儿科医生，儿童肾病诊疗方案的制定者，接受全国患儿的预约，但一个人的精力是有限，你预约的门诊己约满，建议你预约下次夏教授的专家号，如夏教授时间允许也会给你加号的，请耐心等待，如显示预约成功即加号成功，如显示预约失败请预约夏教授下次专家号，祝孩子早日康复");
						return JsonResult.getErrorResult("您当前日期夏教授的号预约失败。该病种加号已满");
					}else
					{
						return JsonResult.getErrorResult("您当前日期专家号预约失败。该病种加号已满");
					}
				}else
				{
					allowJiahao=true;
					isShenhe=true;
					mmShenheyijian="当前预约正在审核";
				}
			}else if((Bingzhonglist.size()!=0)&&(mmPaibanguanli.getJiahaoshu()!=0))//设置加号病种及加号数
			{
				if(Bingzhonglist.contains(mmJiuzhenxinxi.getBingzhong()))
				{
					if(mmDangtianTongguoshu>=mmDangtianZongxianhaoshu+mmPaibanguanli.getJiahaoshu())
					{
						if("0401181f-ad2f-4ad7-8518-c7c631bd9d0a".equals(mmPaibanguanli.getExpertid()))
						{
							//return JsonResult.getErrorResult("各位患儿与家长好，您当前日期预约失败。夏教授是国内儿童肾病第一品牌专家，中国卓越贡献儿科医生，儿童肾病诊疗方案的制定者，接受全国患儿的预约，但一个人的精力是有限，你预约的门诊己约满，建议你预约下次夏教授的专家号，如夏教授时间允许也会给你加号的，请耐心等待，如显示预约成功即加号成功，如显示预约失败请预约夏教授下次专家号，祝孩子早日康复");
							return JsonResult.getErrorResult("您当前日期夏教授的号预约失败。该病种加号已满");
						}else
						{
							return JsonResult.getErrorResult("您当前日期专家号预约失败。该病种加号已满");
						}
					}else
					{
						allowJiahao=true;
						isShenhe=true;
						mmShenheyijian="当前预约正在审核";
					}
				}else
				{
					if("0401181f-ad2f-4ad7-8518-c7c631bd9d0a".equals(mmPaibanguanli.getExpertid()))
					{
						//return JsonResult.getErrorResult("各位患儿与家长好，您当前日期预约失败。夏教授是国内儿童肾病第一品牌专家，中国卓越贡献儿科医生，儿童肾病诊疗方案的制定者，接受全国患儿的预约，但一个人的精力是有限，你预约的门诊己约满，建议你预约下次夏教授的专家号，如夏教授时间允许也会给你加号的，请耐心等待，如显示预约成功即加号成功，如显示预约失败请预约夏教授下次专家号，祝孩子早日康复");
						return JsonResult.getErrorResult("您当前日期夏教授的号预约失败。该病种加号已满");
					}else
					{
						return JsonResult.getErrorResult("您当前日期专家号预约失败。该病种加号已满");
					}
				}
			}else //其他情况，例如加号病种及加号数都为0
			{
				if("0401181f-ad2f-4ad7-8518-c7c631bd9d0a".equals(mmPaibanguanli.getExpertid()))
				{
					//return JsonResult.getErrorResult("各位患儿与家长好，您当前日期预约失败。夏教授是国内儿童肾病第一品牌专家，中国卓越贡献儿科医生，儿童肾病诊疗方案的制定者，接受全国患儿的预约，但一个人的精力是有限，你预约的门诊己约满，建议你预约下次夏教授的专家号，如夏教授时间允许也会给你加号的，请耐心等待，如显示预约成功即加号成功，如显示预约失败请预约夏教授下次专家号，祝孩子早日康复");
					return JsonResult.getErrorResult("您当前日期夏教授的号预约失败。该病种加号已满");
				}else
				{
					return JsonResult.getErrorResult("您当前日期专家号预约失败。该病种加号已满");
				}
			}

			boolean mmResult =false;

			if(allowJiahao)
			{

				// 获取患者姓名
				String mmName = ddPatientJiuzhenxinxiService.findOne(ppJiuzhenxinxiId).getName();
				// 挂号
				String mmGuahaoId = UUID.randomUUID().toString();
				Guahao mmGuahao = new Guahao();
				mmGuahao.setGuahaoid(mmGuahaoId);
				mmGuahao.setJiuzhenxinxiid(ppJiuzhenxinxiId);
				mmGuahao.setUserid(ppUserId);
				mmGuahao.setPaibanid(ppPaibanId);
				mmGuahao.setName(mmName);
				mmGuahao.setChuangjianshijian(new Date());
				mmGuahao.setZhuangtai(1);

				if(isShenhe)
				{
					mmGuahao.setShenhejieguo(0);//待审核
				}else
				{
					mmGuahao.setShenhejieguo(1);//通过
				}

				mmGuahao.setShenheyijian(mmShenheyijian);
				mmGuahao.setShenheshijian(new Date());

				// 往消息中插入一条数据
				mmNews = new News();
				mmNews.setNewsid(UUID.randomUUID().toString());
				mmNews.setFajianren("guahaoguanliyuan");
				mmNews.setFajianrenname("挂号管理员");
				mmNews.setShoujianren(ppUserId);
				mmNews.setShoujianrenname(mmName);
				mmNews.setNeirong(mmShenheyijian);
				mmNews.setNewstype(1);		// 1:挂号
				mmNews.setZhuangtai(0);
				mmNews.setChuangjianshijian(new Date());
				mmNews.setOwnerid(mmGuahaoId);
				mmResult = ddService.addCustom(mmGuahao, mmPaibanguanli,mmNews);
			}




			


			if("0401181f-ad2f-4ad7-8518-c7c631bd9d0a".equals(mmPaibanguanli.getExpertid()))
			{
				if(isShenhe)
				{
					return mmResult ? JsonResult.getSuccessResult("夏教授待审核！") : JsonResult.getErrorResult("夏教授待审核失败！");
				}else
				{
					return mmResult ? JsonResult.getSuccessResult("夏教授审核通过！") : JsonResult.getErrorResult("夏教授审核失败！");
				}

				//return mmResult ? JsonResult.getSuccessResult("各位患儿与家长好，您当前日期预约成功。夏教授是国内儿童肾病第一品牌专家，中国卓越贡献儿科医生，儿童肾病诊疗方案的制定者，接受全国患儿的预约，祝孩子早日康复"): JsonResult.getErrorResult("各位患儿与家长好，您当前日期预约失败。夏教授是国内儿童肾病第一品牌专家，中国卓越贡献儿科医生，儿童肾病诊疗方案的制定者，接受全国患儿的预约，但一个人的精力是有限，你预约的门诊己约满，建议你预约下次夏教授的专家号，如夏教授时间允许也会给你加号的，请耐心等待，如显示预约成功即加号成功，如显示预约失败请预约夏教授下次专家号，祝孩子早日康复");

			}else
			{
				if(isShenhe)
				{
					return mmResult ? JsonResult.getSuccessResult("待审核！") : JsonResult.getErrorResult("待审核失败！");
				}else
				{
					return mmResult ? JsonResult.getSuccessResult("审核通过！") : JsonResult.getErrorResult("审核失败！");
				}

			}




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
