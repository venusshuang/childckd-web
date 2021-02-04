package childckd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import childckd.dao.TingzhenMapper;
import childckd.model.Tingzhen;
import childckd.model.TingzhenExample;

@Service
public class TingzhenService {
	@Autowired
	TingzhenMapper ddMapper;

	public Tingzhen findOne(String ppTingzhenId) {
		return ddMapper.selectByPrimaryKey(ppTingzhenId);
	}
	
	public List<Tingzhen> findValid() {
		TingzhenExample mmExample = new  TingzhenExample();
		TingzhenExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andZhuangtaiEqualTo(1);
		mmExample.setOrderByClause("starttime desc");
		return ddMapper.selectByExample(mmExample);
	}
	
	public boolean add(Tingzhen ppTingzhen) {
		return ddMapper.insert(ppTingzhen) == 1;
	}

	public boolean modify(Tingzhen ppTingzhen) {
		return ddMapper.updateByPrimaryKey(ppTingzhen) == 1;
	}
	
	private boolean delete(String ppTingzhenId) {
		return ddMapper.deleteByPrimaryKey(ppTingzhenId) == 1;
	}

	public boolean deleteByTingzhenIdList(String[] mmTingzhenIdArray) {
		try
		{
			for (int i = 0 ; i < mmTingzhenIdArray.length ; i++ ) 
			{
				delete(mmTingzhenIdArray[i]);
			} 

		}catch (Exception e) {

			throw new RuntimeException("批量删除失败");

		}

		return true;
	}

	

	


}
