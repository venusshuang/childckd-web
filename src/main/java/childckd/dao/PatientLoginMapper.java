package childckd.dao;

import childckd.model.PatientLogin;
import childckd.model.PatientLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientLoginMapper {
    int countByExample(PatientLoginExample example);

    int deleteByExample(PatientLoginExample example);

    int deleteByPrimaryKey(String userid);

    int insert(PatientLogin record);

    int insertSelective(PatientLogin record);

    List<PatientLogin> selectByExample(PatientLoginExample example);

    PatientLogin selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") PatientLogin record, @Param("example") PatientLoginExample example);

    int updateByExample(@Param("record") PatientLogin record, @Param("example") PatientLoginExample example);

    int updateByPrimaryKeySelective(PatientLogin record);

    int updateByPrimaryKey(PatientLogin record);
}