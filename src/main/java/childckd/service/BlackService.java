package childckd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.BlacklistMapper;
import childckd.model.Blacklist;
import childckd.model.BlacklistExample;




@Service
public class BlackService {
	
	@Autowired
	BlacklistMapper ddMapper;
	
	@Transactional
	public boolean deleteBlackIdList(String[] mmList) {
		try
		{
			for (int i = 0 ; i <mmList.length ; i++ ) 
			 {
				 delete(mmList[i]);
			 } 
			
		}catch (Exception e) {
			
			throw new RuntimeException("批量删除失败");
			
		}
		 
		return true;
	}

	public List<Map<String,Object>> findBlackByNameAndDeptAndShoujihao(String ppName, String ppDept, String ppShoujihao) {
		return ddMapper.findBlackByNameAndDeptAndShoujihao(ppName,ppDept,ppShoujihao);
	}

	public Blacklist findOneByUserId(String ppUserId) {
		
		BlacklistExample mmExample = new BlacklistExample();
		BlacklistExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andUseridEqualTo(ppUserId);
		List<Blacklist> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

	public boolean add(Blacklist mmBlack) {
		return ddMapper.insert(mmBlack) == 1;
	}

	public Blacklist findOne(String ppBlacklistId) {
		return ddMapper.selectByPrimaryKey(ppBlacklistId);
	}

	public boolean delete(String ppBlacklistId) {
		return ddMapper.deleteByPrimaryKey(ppBlacklistId) == 1;
	}
	

	
}
