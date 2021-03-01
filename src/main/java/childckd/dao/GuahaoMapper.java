package childckd.dao;

import childckd.model.Guahao;
import childckd.model.GuahaoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GuahaoMapper {
	
	List<Map<String, Object>>tongjiRenshu();

	List<Map<String, Object>>tongjiNianling();

	List<Map<String, Object>> tongjiBingzhong();
	
	List<Map<String, Object>>findByDateAndUserId(@Param("userid")String ppUserId,@Param("date")String ppDate);
	
	Map<String, Object>findCustomOne(@Param("guahaoid")String ppGuahaoId);

	/*List<Map<String, Object>> findCustomAll(@Param("xingming") String ppXingming, @Param("shoujihao") String ppShoujihao, @Param("expertid") String ppExpertId,
			@Param("yuyueriqi") String ppYuyueriqi);*/

	List<Map<String, Object>> findYuyueByUserId(@Param("userid") String ppUserId);

	List<Map<String,Object>>findDaishenheBeforeToday();

	int countByExample(GuahaoExample example);

	int deleteByExample(GuahaoExample example);

	int deleteByPrimaryKey(String guahaoid);

	int insert(Guahao record);

	int insertSelective(Guahao record);

	List<Guahao> selectByExample(GuahaoExample example);

	Guahao selectByPrimaryKey(String guahaoid);

	int updateByExampleSelective(@Param("record") Guahao record, @Param("example") GuahaoExample example);

	int updateByExample(@Param("record") Guahao record, @Param("example") GuahaoExample example);

	int updateByPrimaryKeySelective(Guahao record);

	int updateByPrimaryKey(Guahao record);

	Object countFindCustomAll(
			@Param("xingming") String ppXingming,
			@Param("shoujihao") String ppShoujihao,
			@Param("bingzhong") String ppBingzhong,
			@Param("expertid") String ppExpertId,
			@Param("yuyueriqi") String ppYuyueriqi,
			@Param("shenhejieguo") int ppShenhejieguo);

	List<Map<String, Object>> findCustomAll(
			@Param("xingming") String ppXingming,
			@Param("shoujihao") String ppShoujihao,
			@Param("bingzhong") String ppBingzhong,
			@Param("expertid") String ppExpertId,
			@Param("yuyueriqi") String ppYuyueriqi,
			@Param("shenhejieguo") int ppShenhejieguo,
			@Param("startindex") int mmStartIndex,
			@Param("pagesize") int ppPageSize);


}