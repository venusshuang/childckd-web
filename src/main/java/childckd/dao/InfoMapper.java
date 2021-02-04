package childckd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import childckd.model.Info;
import childckd.model.InfoExample;


public interface InfoMapper {
	int updateliulan(@Param("liulannum")int ppliulannum);
	int findliulan();
	
	Info  findtop(@Param("Infoid")String ppInfoid);
	
    int countByExample(InfoExample example);

    int deleteByExample(InfoExample example);

    int deleteByPrimaryKey(String infoid);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExampleWithBLOBs(InfoExample example);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(String infoid);

    int updateByExampleSelective(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExample(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKeyWithBLOBs(Info record);

    int updateByPrimaryKey(Info record);
    
	List<Map<String, Object>> search(@Param("searchtext") String ppSearchText);

	Object countSearch(@Param("searchtext") String ppSearchText);
	
	List<Map<String, Object>> findByCategoryId(@Param("categoryid") String ppCategoryId);

	Object countByCategoryIdPaging(@Param("categoryid")String ppCategoryId);
	
	List<Map<String, Object>> findPassedByCategoryId(@Param("categoryid") String ppCategoryId);

	Object countPassedByCategoryIdPaging(@Param("categoryid")String ppCategoryId);

	Map<String, Object>findCustomOne(@Param("infoid")String ppInfoId);
	
	Map<String, Object>findOneInfo(@Param("infoid")String ppInfoId);

	List<Map<String, Object>>findPassedPicNotNullByCategoryId(@Param("categoryid") String ppCategoryId);
	
	Object countPassedPicNotNullByCategoryIdPaging(@Param("categoryid")String ppCategoryId);
	
	List<Map<String, Object>>findTopOnePassedByCategoryId(@Param("categoryid")String ppCategoryId);
	
	Object getScoreByDeptId(@Param("deptid")String ppDeptId,@Param("counttime")String ppCountTime);
	
	Object statisticszongzhi(@Param("parentdeptid")String ppDeptId,@Param("tougaoshijian")String ppTougaoshijian);
	
	List<Map<String, Object>>statisticskeshi(@Param("tougaoshijian")String ppTougaoshijian);
	
	Map<String, Object>findDeptByDeptId(@Param("deptid")String ppDeptId);
}