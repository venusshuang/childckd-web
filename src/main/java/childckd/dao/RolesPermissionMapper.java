package childckd.dao;

import childckd.model.RolesPermission;
import childckd.model.RolesPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesPermissionMapper {
    int countByExample(RolesPermissionExample example);

    int deleteByExample(RolesPermissionExample example);

    int deleteByPrimaryKey(String rpid);

    int insert(RolesPermission record);

    int insertSelective(RolesPermission record);

    List<RolesPermission> selectByExample(RolesPermissionExample example);

    RolesPermission selectByPrimaryKey(String rpid);

    int updateByExampleSelective(@Param("record") RolesPermission record, @Param("example") RolesPermissionExample example);

    int updateByExample(@Param("record") RolesPermission record, @Param("example") RolesPermissionExample example);

    int updateByPrimaryKeySelective(RolesPermission record);

    int updateByPrimaryKey(RolesPermission record);
}