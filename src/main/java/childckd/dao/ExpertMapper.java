package childckd.dao;

import childckd.model.Expert;
import childckd.model.ExpertExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ExpertMapper {
	Map<String, Object>findCustomOne(@Param("expertid")String ppExpertId);
	
    int countByExample(ExpertExample example);

    int deleteByExample(ExpertExample example);

    int deleteByPrimaryKey(String expertid);

    int insert(Expert record);

    int insertSelective(Expert record);

    List<Expert> selectByExample(ExpertExample example);

    Expert selectByPrimaryKey(String expertid);

    int updateByExampleSelective(@Param("record") Expert record, @Param("example") ExpertExample example);

    int updateByExample(@Param("record") Expert record, @Param("example") ExpertExample example);

    int updateByPrimaryKeySelective(Expert record);

    int updateByPrimaryKey(Expert record);
    
    List<Map<String, Object>> findAll();
    
    List<Map<String, Object>> findExpertByName(String ppName);
}