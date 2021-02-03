package childckd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import childckd.model.InfoCategoryInfo;
import childckd.model.InfoCategoryInfoExample;


public interface InfoCategoryInfoMapper {
    int countByExample(InfoCategoryInfoExample example);

    int deleteByExample(InfoCategoryInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(InfoCategoryInfo record);

    int insertSelective(InfoCategoryInfo record);

    List<InfoCategoryInfo> selectByExample(InfoCategoryInfoExample example);

    InfoCategoryInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InfoCategoryInfo record, @Param("example") InfoCategoryInfoExample example);

    int updateByExample(@Param("record") InfoCategoryInfo record, @Param("example") InfoCategoryInfoExample example);

    int updateByPrimaryKeySelective(InfoCategoryInfo record);

    int updateByPrimaryKey(InfoCategoryInfo record);
    
    InfoCategoryInfo findByInfoIdAndCategoryId(@Param("infoid")String ppInfoId,@Param("categoryid")String ppCategoryId);

	Map<String, Object> findUp(@Param("ordernum") int ordernum,
			@Param("categoryid") String ppCategoryId);

	Map<String, Object> findDown(@Param("ordernum") int ordernum,
			@Param("categoryid") String ppCategoryId);
	
	Object getMaxOrdernum(@Param("categoryid")String ppCategoryId);
}