package childckd.dao;

import childckd.model.PatientJiuzhenxinxi;
import childckd.model.PatientJiuzhenxinxiExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PatientJiuzhenxinxiMapper {
    Object countFindCustomAll(String ppName, String ppShoujihao);

    List<Map<String, Object>> findCustomAll(String ppName, String ppShoujihao, int mmStartIndex, int ppPageSize);

    int countByExample(PatientJiuzhenxinxiExample example);

    int deleteByExample(PatientJiuzhenxinxiExample example);

    int deleteByPrimaryKey(String jiuzhenxinxiid);

    int insert(PatientJiuzhenxinxi record);

    int insertSelective(PatientJiuzhenxinxi record);

    List<PatientJiuzhenxinxi> selectByExample(PatientJiuzhenxinxiExample example);

    PatientJiuzhenxinxi selectByPrimaryKey(String jiuzhenxinxiid);

    int updateByExampleSelective(@Param("record") PatientJiuzhenxinxi record, @Param("example") PatientJiuzhenxinxiExample example);

    int updateByExample(@Param("record") PatientJiuzhenxinxi record, @Param("example") PatientJiuzhenxinxiExample example);

    int updateByPrimaryKeySelective(PatientJiuzhenxinxi record);

    int updateByPrimaryKey(PatientJiuzhenxinxi record);
}