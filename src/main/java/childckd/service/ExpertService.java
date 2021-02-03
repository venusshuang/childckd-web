package childckd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.ExpertMapper;
import childckd.model.Expert;

@Service
public class ExpertService {
	@Autowired
	ExpertMapper ddMapper;
	
	@Transactional
	public boolean deleteExpertIdList(String[] mmList) {
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
	public List<Map<String, Object>> findAll() 
	{
		return ddMapper.findAll();
	}
	
	public boolean add(Expert mmExpert) 
	{
		return ddMapper.insert(mmExpert) == 1;
	}
	
	public Expert findOne(String ppExpertId) 
	{
		return ddMapper.selectByPrimaryKey(ppExpertId);
	}

	public boolean delete(String ppExpertId)
	{
		return ddMapper.deleteByPrimaryKey(ppExpertId) == 1;
	}

	public List<Map<String,Object>> findExpertByName(String ppName) {
		return ddMapper.findExpertByName(ppName);
	}

	public boolean modify(Expert mmExpert) {
		return ddMapper.updateByPrimaryKey(mmExpert) == 1 ;
	}

	public Map<String, Object> findCustomOne(String ppExpertId) {
		return ddMapper.findCustomOne(ppExpertId);
	}

}
