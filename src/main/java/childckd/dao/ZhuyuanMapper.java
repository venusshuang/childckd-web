package childckd.dao;

import childckd.model.Zhuyuan;
import childckd.model.ZhuyuanExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZhuyuanMapper {
    int countByExample(ZhuyuanExample example);

    int deleteByExample(ZhuyuanExample example);

    int deleteByPrimaryKey(String zhuyuanid);

    int insert(Zhuyuan record);

    int insertSelective(Zhuyuan record);

    List<Zhuyuan> selectByExample(ZhuyuanExample example);

    Zhuyuan selectByPrimaryKey(String zhuyuanid);

    int updateByExampleSelective(@Param("record") Zhuyuan record, @Param("example") ZhuyuanExample example);

    int updateByExample(@Param("record") Zhuyuan record, @Param("example") ZhuyuanExample example);

    int updateByPrimaryKeySelective(Zhuyuan record);

    int updateByPrimaryKey(Zhuyuan record);
    

    Object countFindCustomAll(@Param("xingming") String ppXingming,@Param("shoujihao") String ppShoujihao,@Param("bingzhong") String ppBingzhong,@Param("yuyueriqi") String ppYuyueriqi,@Param("shenhejieguo") int ppShenhejieguo);

	List<Map<String, Object>> findCustomAll(@Param("xingming") String ppXingming, @Param("shoujihao") String ppShoujihao, @Param("bingzhong") String ppBingzhong,
			@Param("yuyueriqi") String ppYuyueriqi,@Param("shenhejieguo") int ppShenhejieguo,@Param("startindex") int mmStartIndex, @Param("pagesize") int ppPageSize);

	List<Map<String, Object>>tongjiBingzhong();
}