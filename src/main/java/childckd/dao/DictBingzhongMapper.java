package childckd.dao;

import childckd.model.DictBingzhong;
import childckd.model.DictBingzhongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictBingzhongMapper {
    int countByExample(DictBingzhongExample example);

    int deleteByExample(DictBingzhongExample example);

    int deleteByPrimaryKey(String id);

    int insert(DictBingzhong record);

    int insertSelective(DictBingzhong record);

    List<DictBingzhong> selectByExample(DictBingzhongExample example);

    DictBingzhong selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DictBingzhong record, @Param("example") DictBingzhongExample example);

    int updateByExample(@Param("record") DictBingzhong record, @Param("example") DictBingzhongExample example);

    int updateByPrimaryKeySelective(DictBingzhong record);

    int updateByPrimaryKey(DictBingzhong record);
}