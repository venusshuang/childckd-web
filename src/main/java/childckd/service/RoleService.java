package childckd.service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import childckd.dao.AdminPermissionMapper;
import childckd.dao.RoleMapper;
import childckd.dao.RolesPermissionMapper;
import childckd.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {
	@Autowired
	RoleMapper ddMapper;

	@Autowired
	AdminPermissionMapper ddAdminPermissionMapper;

	@Autowired
	RolesPermissionMapper ddRolesPermissionMapper;

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

	@Transactional
	public boolean savePermission(String ppId,String ppType, String[] mmList) {
		try
		{
			AdminPermission mmAdminPermission=null;
			RolesPermission mmRolesPermission=null;

			//删除权限
			if("administrator".equals(ppType))
			{
				AdminPermissionExample mmExample = new AdminPermissionExample();
				AdminPermissionExample.Criteria mmCriteria = mmExample.createCriteria();
				mmCriteria.andAdministratoridEqualTo(ppId).andZhuangtaiEqualTo(1);
				ddAdminPermissionMapper.deleteByExample(mmExample);

				for (int i = 0 ; i <mmList.length ; i++ )
				{
					mmAdminPermission=new AdminPermission();
					mmAdminPermission.setApid(UUID.randomUUID().toString());
					mmAdminPermission.setAdministratorid(ppId);
					mmAdminPermission.setPermissionid(mmList[i]);
					mmAdminPermission.setZhuangtai(1);
					mmAdminPermission.setBeizhu("管理员自定义权限");
					mmAdminPermission.setChuangjianshijian(new Date());
					ddAdminPermissionMapper.insert(mmAdminPermission);
				}

			}else if("role".equals(ppType))
			{
				RolesPermissionExample mmExample = new RolesPermissionExample();
				RolesPermissionExample.Criteria mmCriteria = mmExample.createCriteria();
				mmCriteria.andRoleidEqualTo(ppId).andZhuangtaiEqualTo(1);
				ddRolesPermissionMapper.deleteByExample(mmExample);

				for (int i = 0 ; i <mmList.length ; i++ )
				{
					mmRolesPermission=new RolesPermission();
					mmRolesPermission.setRpid(UUID.randomUUID().toString());
					mmRolesPermission.setRoleid(ppId);
					mmRolesPermission.setPermissionid(mmList[i]);
					mmRolesPermission.setZhuangtai(1);
					mmRolesPermission.setBeizhu("管理员自定义权限");
					mmRolesPermission.setChuangjianshijian(new Date());
					ddRolesPermissionMapper.insert(mmRolesPermission);
				}

			}

		}catch (Exception e) {

			throw new RuntimeException("权限插入失败");

		}

		return true;
	}


	public boolean add(Role mmRole) {
		return ddMapper.insert(mmRole) == 1;
	}

	public boolean modify(Role mmRole) {
		return ddMapper.updateByPrimaryKey(mmRole) == 1 ;
	}

	public List<Map<String,Object>> findFirstOrNotByFatherid(String ppId,int ppState,String ppType) {
		return ddMapper.findFirstOrNotByFatherid(ppId,ppState,ppType);
	}


	public List<AdminPermission> findPermissionByAdminid(String ppAdministratorId) {
		AdminPermissionExample mmExample = new AdminPermissionExample();
		AdminPermissionExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andAdministratoridEqualTo(ppAdministratorId).andZhuangtaiEqualTo(1);
		return ddAdminPermissionMapper.selectByExample(mmExample);
	}

	public List<RolesPermission> findPermissionByRoleid(String ppRoleId) {
		RolesPermissionExample mmExample = new RolesPermissionExample();
		RolesPermissionExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andRoleidEqualTo(ppRoleId).andZhuangtaiEqualTo(1);
		return ddRolesPermissionMapper.selectByExample(mmExample);
	}
}
