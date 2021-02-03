package childckd.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import childckd.model.Guahao;
import childckd.model.News;
import childckd.service.GuahaoService;
import childckd.service.NewsService;
import childckd.util.JsonResult;

@RestController
@RequestMapping("news")
public class NewsController {
	@Autowired
	NewsService ddService;
	@Autowired
	GuahaoService ddGuahaoService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 根据收件人查找未读信息
	@RequestMapping("find_weidu_by_shoujianren")
	public JsonResult<?> find_weidu_by_shoujianren(
			@RequestParam("shoujianren") String ppShoujianren,
			@RequestParam("newstype") String ppNewstype) {
		try {
			List<News> mmList = ddService.findWeiduByShoujianren(ppNewstype,ppShoujianren);
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("NewsController -> find_weidu_by_shoujianren: " + e.getMessage());
			return JsonResult.getErrorResult("根据收件人查找未读消息失败");
		}
	}

	// 根据ownerid
	@RequestMapping("find_by_ownerid")
	public JsonResult<?> findByOwnerId(@RequestParam("ownerid") String ppOwnerId) {
		try {
			List<News> mmList = ddService.findByOwnerId(ppOwnerId);
			return JsonResult.getSuccessResult(mmList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("NewsController -> findByOwnerId: " + e.getMessage());
			return JsonResult.getErrorResult("根据ownerid查找失败");
		}
	}

	@RequestMapping("add")
	public JsonResult<?> add(
			@RequestParam("fajianrenid") String ppFajianrenId,
			@RequestParam("fajianrenname") String ppFajianrenname,
			@RequestParam("shoujianrenid") String ppShoujianrenId,
			@RequestParam("shoujianrenname") String ppShoujianrenname,
			@RequestParam("neirong") String ppNeirong,
			@RequestParam("newstype") int ppNewsType,
			@RequestParam("ownerid") String ppOwnerId) {

		try {
			ppNeirong = ppNeirong.trim();
			if ("".equals(ppNeirong)) {
				return JsonResult.getErrorResult("消息内容不可为空");
			}
			if ("".equals(ppOwnerId)) {
				return JsonResult.getErrorResult("ownerId不可为空");
			}

			// 预约挂号批量发送消息的时候收件人信息不好取，前台传过来空，后台根据ppOwnerId获取
			if("".equals(ppShoujianrenId) && ppNewsType == 1) {
				Guahao mmGuahao = ddGuahaoService.findOne(ppOwnerId);
				if(mmGuahao == null) {
					return JsonResult.getErrorResult("未查询到挂号信息！");
				}
				
				ppShoujianrenId = mmGuahao.getUserid() == null ? "" : mmGuahao.getUserid();
				ppShoujianrenname = mmGuahao.getName() == null ? "" : mmGuahao.getName();
			}
			
			News mmNews = new News();
			mmNews.setNewsid(UUID.randomUUID().toString());
			mmNews.setFajianren(ppFajianrenId);
			mmNews.setFajianrenname(ppFajianrenname);
			mmNews.setShoujianren(ppShoujianrenId);
			mmNews.setShoujianrenname(ppShoujianrenname);
			mmNews.setNeirong(ppNeirong);
			mmNews.setNewstype(ppNewsType);
			mmNews.setChuangjianshijian(new Date());
			mmNews.setZhuangtai(0);// 新增0位未读
			mmNews.setOwnerid(ppOwnerId);

			return ddService.add(mmNews) ? JsonResult.getSuccessResult("新增消息成功") : JsonResult.getErrorResult("新增消息失败");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("NewsController -> add: " + e.getMessage());
			return JsonResult.getErrorResult("新增消息失败");
		}

	}

	@RequestMapping("set_yidu")
	public JsonResult<?> setYidu(@RequestParam("ownerid") String ppOwnerId, @RequestParam("shoujianrenid") String ppShoujianrenId) {
		try {
			List<News> mmList = ddService.findByOwnerIdAndShoujianrenId(ppOwnerId, ppShoujianrenId);
			boolean mmResult = ddService.modifyNewsList(mmList);
			return mmResult ? JsonResult.getSuccessResult("设置已读成功") : JsonResult.getErrorResult("设置已读失败");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("NewsController -> setYidu: " + e.getMessage());
			return JsonResult.getErrorResult("设置已读失败");
		}
	}

	@RequestMapping("find_news_by_userid")
	public JsonResult<?> findNewsByUserId(@RequestParam("userid")String ppUserId){
		//根据UserID查询到预约列表
		List<Map<String, Object>>mmList = ddGuahaoService.findYuyueByUserId(ppUserId);
		for (int i = 0; i < mmList.size(); i++) {
			// 获得OwnerId
			String mmOwnerId = mmList.get(i).get("id").toString();
			// 查询该ownerid下接收的消息
			List<News> mmNewsList = ddService.findByOwnerIdAndShoujianrenId(mmOwnerId, ppUserId);
			String mmZhuangtaiText = "";
			String mmLastNews = "";
			if (mmNewsList.size()<1) {
				mmList.remove(i);
				i--;
			}
			else if(mmNewsList.size()>0){
				// 获得最新一条接收消息的阅读状态
				int mmZhuangtai = mmNewsList.get(mmNewsList.size()-1).getZhuangtai();
				mmZhuangtaiText = mmZhuangtai==1?"已读":"未读";
				mmLastNews = mmNewsList.get(mmNewsList.size()-1).getNeirong();
				mmList.get(i).put("yuedu", mmZhuangtaiText);
				mmList.get(i).put("neirong", mmLastNews);
				mmList.get(i).put("time", mmNewsList.get(mmNewsList.size()-1).getChuangjianshijian());
			}
		}

		return JsonResult.getSuccessResult(mmList);

	}
}
