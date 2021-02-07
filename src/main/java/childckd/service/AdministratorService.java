package childckd.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import childckd.dao.AdminPermissionMapper;
import childckd.dao.AdministratorMapper;
import childckd.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AdministratorService {
	
	@Autowired
	AdministratorMapper ddMapper;

	@Autowired
	RoleService ddRoleService;

	@Autowired
	AdminPermissionMapper ddAdminPermissionMapper;

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

	@Transactional
	public boolean addAdministratorId(Administrator mmAdministrator,String ppRoleId,boolean isAddAdministrator) {
		try
		{
			//先删管理员权限
			AdminPermissionExample mmExample = new AdminPermissionExample();
			AdminPermissionExample.Criteria mmCriteria = mmExample.createCriteria();
			mmCriteria.andAdministratoridEqualTo(mmAdministrator.getAdministratorid()).andZhuangtaiEqualTo(1);
			ddAdminPermissionMapper.deleteByExample(mmExample);

			//找出角色权限
			List<RolesPermission> mmRolePermission =ddRoleService.findPermissionByRoleid(ppRoleId);

			//给管理员添加默认角色权限
			AdminPermission mmAdminPermission=new AdminPermission();
			for (int i = 0 ; i <mmRolePermission.size() ; i++ )
			{
				mmAdminPermission.setApid(UUID.randomUUID().toString());
				mmAdminPermission.setAdministratorid(mmAdministrator.getAdministratorid());
				mmAdminPermission.setPermissionid(mmRolePermission.get(i).getPermissionid());
				mmAdminPermission.setChuangjianshijian(new Date());
				mmAdminPermission.setBeizhu("创建管理员根据角色默认创建");
				mmAdminPermission.setZhuangtai(1);
				ddAdminPermissionMapper.insert(mmAdminPermission);
			}

			//添加或修改管理员
			if(isAddAdministrator)
			{
				add(mmAdministrator);
			}else
			{
				modify(mmAdministrator);
			}




		}catch (Exception e) {

			throw new RuntimeException("添加管理员失败");

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
