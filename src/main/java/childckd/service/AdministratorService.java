package childckd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.AdministratorMapper;
import childckd.model.Administrator;
import childckd.model.AdministratorExample;


@Service
public class AdministratorService {
	
	@Autowired
	AdministratorMapper ddMapper;

	public Administrator findByLoginNameAndPassword(String ppLoginName, String ppLoginPassword) {
		AdministratorExample mmExample = new AdministratorExample();
		AdministratorExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andZhanghaoEqualTo(ppLoginName).andPasswordEqualTo(ppLoginPassword).andZhuangtaiEqualTo(1);
		List<Administrator> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

	public List<Map<String,Object>> findAdministratorByZhanghao(String ppZhanghao) {
		return ddMapper.findAdministratorByZhanghao(ppZhanghao);
	}

	public Administrator findOne(String ppAdministratorId) {
		return ddMapper.selectByPrimaryKey(ppAdministratorId);
	}

	public boolean delete(String ppAdministratorId) {
		return ddMapper.deleteByPrimaryKey(ppAdministratorId) == 1;
	}
	@Transactional
	public boolean deleteAdministratorIdList(String[] mmList) {
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

	public boolean add(Administrator mmAdministrator) {
		return ddMapper.insert(mmAdministrator) == 1;
	}

	public boolean modify(Administrator mmAdministrator) {
		return ddMapper.updateByPrimaryKey(mmAdministrator) == 1 ;
	}

	public Administrator findByZhanghao(String ppZhanghao) {
		AdministratorExample mmExample = new AdministratorExample();
		AdministratorExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andZhanghaoEqualTo(ppZhanghao).andZhuangtaiEqualTo(1);
		List<Administrator> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

}
