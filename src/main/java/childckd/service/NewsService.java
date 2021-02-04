package childckd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.NewsMapper;
import childckd.model.News;
import childckd.model.NewsExample;

@Service
public class NewsService {

	@Autowired
	NewsMapper ddMapper;
	
	public boolean add(News ppNews) {
		return ddMapper.insert(ppNews)==1;
	}
	
	public boolean modify(News ppNews) {
		return ddMapper.updateByPrimaryKey(ppNews)==1;
	}
	
	public boolean delete(String ppNewsId) {
		return ddMapper.deleteByPrimaryKey(ppNewsId)==1;
	}
	
	public List<News> findByOwnerId(String ppOwnerId) {
		NewsExample mmExample = new NewsExample();
		mmExample.createCriteria().andOwneridEqualTo(ppOwnerId);
		mmExample.setOrderByClause("chuangjianshijian asc");
		return ddMapper.selectByExample(mmExample);
	}
	
	public List<News> findByOwnerIdAndShoujianrenId(String ppOwnerId,String ppShoujianrenId) {
		NewsExample mmExample = new NewsExample();
		mmExample.createCriteria().andOwneridEqualTo(ppOwnerId).andShoujianrenEqualTo(ppShoujianrenId);
		mmExample.setOrderByClause("chuangjianshijian asc");
		return ddMapper.selectByExample(mmExample);
	}
	
	public List<News> findWeiduByShoujianren(String ppNewstype,String ppShoujianren) {
		NewsExample mmExample = new NewsExample();
		mmExample.createCriteria().andShoujianrenEqualTo(ppShoujianren).andZhuangtaiEqualTo(0).andNewstypeEqualTo(Integer.valueOf(ppNewstype));
		mmExample.setOrderByClause("chuangjianshijian asc");
		return ddMapper.selectByExample(mmExample);
	}
	
	@Transactional
	public boolean	modifyNewsList(List<News> ppNewsList) {
		for (int i = 0; i < ppNewsList.size(); i++) {
			News mmNews = ppNewsList.get(i);
			mmNews.setZhuangtai(1);
			boolean modifyOne = this.modify(mmNews);
			if (!modifyOne) {
				return false;
			}
		}
		return true;
	}

}
