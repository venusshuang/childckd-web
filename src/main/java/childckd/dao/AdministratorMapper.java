package childckd.dao;

import childckd.model.Administrator;
import childckd.model.AdministratorExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdministratorMapper {
    List<Map<String, Object>> findAdministratorByZhanghao(String ppZhanghao);

    int countByExample(AdministratorExample example);

    int deleteByExample(AdministratorExample example);

    int deleteByPrimaryKey(String administratorid);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    List<Administrator> selectByExample(AdministratorExample example);

    Administrator selectByPrimaryKey(String administratorid);

    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}