package childckd.dao;

import childckd.model.Doctor;
import childckd.model.DoctorExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
	List<Map<String, Object>> findPatientByNameAndDept(String ppName, String ppDept);
	
    int countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(String doctorid);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(String doctorid);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

	
}