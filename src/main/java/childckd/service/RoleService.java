package childckd.service;

import java.util.List;
import java.util.Map;

import childckd.dao.AdminPermissionMapper;
import childckd.dao.RoleMapper;
import childckd.model.AdminPermission;
import childckd.model.AdminPermissionExample;
import childckd.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {
	@Autowired
	RoleMapper ddMapper;

	@Autowired
	AdminPermissionMapper ddAdminPermissionMapper;

	public List<Map<String,Object>> findRoleByRoleName(String ppRoleName) {
		return ddMapper.findRoleByRoleName(ppRoleName);
	}

	public Role findOne(String ppRoleId) {
		return ddMapper.selectByPrimaryKey(ppRoleId);
	}

	public boolean delete(String ppRoleId) {
		return ddMapper.deleteByPrimaryKey(ppRoleId) == 1;
	}
	
	@Transactional
	public boolean deleteRoleIdList(String[] mmList) {
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
	
	public boolean add(Role mmRole) {
		return ddMapper.insert(mmRole) == 1;
	}

	public boolean modify(Role mmRole) {
		return ddMapper.updateByPrimaryKey(mmRole) == 1 ;
	}

	public List<Map<String,Object>> findFirstOrNotByFatherid(String ppAdministratorId,int ppState,String ppType) {
		return ddMapper.findFirstOrNotByFatherid(ppAdministratorId,ppState,ppType);
	}


	public List<AdminPermission> findPermissionByAdminid(String ppAdministratorId) {
		AdminPermissionExample mmExample = new AdminPermissionExample();
		AdminPermissionExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andAdministratoridEqualTo(ppAdministratorId).andZhuangtaiEqualTo(1);
		return ddAdminPermissionMapper.selectByExample(mmExample);
	}
}
