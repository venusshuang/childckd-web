package childckd.dao;

import childckd.model.DoctorLogin;
import childckd.model.DoctorLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorLoginMapper {
    int countByExample(DoctorLoginExample example);

    int deleteByExample(DoctorLoginExample example);

    int deleteByPrimaryKey(String doctorid);

    int insert(DoctorLogin record);

    int insertSelective(DoctorLogin record);

    List<DoctorLogin> selectByExample(DoctorLoginExample example);

    DoctorLogin selectByPrimaryKey(String doctorid);

    int updateByExampleSelective(@Param("record") DoctorLogin record, @Param("example") DoctorLoginExample example);

    int updateByExample(@Param("record") DoctorLogin record, @Param("example") DoctorLoginExample example);

    int updateByPrimaryKeySelective(DoctorLogin record);

    int updateByPrimaryKey(DoctorLogin record);
}