package childckd.dao;

import childckd.model.AdminPermission;
import childckd.model.AdminPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminPermissionMapper {
    int countByExample(AdminPermissionExample example);

    int deleteByExample(AdminPermissionExample example);

    int deleteByPrimaryKey(String apid);

    int insert(AdminPermission record);

    int insertSelective(AdminPermission record);

    List<AdminPermission> selectByExample(AdminPermissionExample example);

    AdminPermission selectByPrimaryKey(String apid);

    int updateByExampleSelective(@Param("record") AdminPermission record, @Param("example") AdminPermissionExample example);

    int updateByExample(@Param("record") AdminPermission record, @Param("example") AdminPermissionExample example);

    int updateByPrimaryKeySelective(AdminPermission record);

    int updateByPrimaryKey(AdminPermission record);
}