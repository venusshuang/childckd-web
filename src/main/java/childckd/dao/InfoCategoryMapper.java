package childckd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import childckd.model.InfoCategory;
import childckd.model.InfoCategoryExample;

public interface InfoCategoryMapper {
    int countByExample(InfoCategoryExample example);

    int deleteByExample(InfoCategoryExample example);

    int deleteByPrimaryKey(String categoryid);

    int insert(InfoCategory record);

    int insertSelective(InfoCategory record);

    List<InfoCategory> selectByExample(InfoCategoryExample example);

    InfoCategory selectByPrimaryKey(String categoryid);

    int updateByExampleSelective(@Param("record") InfoCategory record, @Param("example") InfoCategoryExample example);

    int updateByExample(@Param("record") InfoCategory record, @Param("example") InfoCategoryExample example);

    int updateByPrimaryKeySelective(InfoCategory record);

    int updateByPrimaryKey(InfoCategory record);
    
	List<Map<String, Object>> findByParentCategoryId(@Param("parentcategoryid") String ppParentcategoryId);

	List<Map<String, Object>> findByDeptId(@Param("deptid") String ppDeptId);

	Object getMaxOrdernum(@Param("parentcategoryid") String ppParentCategoryId);

	Map<String, Object> findUp(@Param("ordernum") int ppOrdernum, @Param("parentcategoryid") String ppParentCategoryId);

	Map<String, Object> findDown(@Param("ordernum") int ppOrdernum,
			@Param("parentcategoryid") String ppParentCategoryId);
}