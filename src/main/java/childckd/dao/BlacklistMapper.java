package childckd.dao;

import childckd.model.Blacklist;
import childckd.model.BlacklistExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BlacklistMapper {
    int countByExample(BlacklistExample example);

    int deleteByExample(BlacklistExample example);

    int deleteByPrimaryKey(String blacklistid);

    int insert(Blacklist record);

    int insertSelective(Blacklist record);

    List<Blacklist> selectByExample(BlacklistExample example);

    Blacklist selectByPrimaryKey(String blacklistid);

    int updateByExampleSelective(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    int updateByExample(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    int updateByPrimaryKeySelective(Blacklist record);

    int updateByPrimaryKey(Blacklist record);

	List<Map<String, Object>> findBlackByNameAndDeptAndShoujihao(String ppName, String ppDept, String ppShoujihao);

	Blacklist findOneByUserId(String ppUserId);

	
}