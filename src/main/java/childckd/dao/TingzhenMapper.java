package childckd.dao;

import childckd.model.Tingzhen;
import childckd.model.TingzhenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TingzhenMapper {
    int countByExample(TingzhenExample example);

    int deleteByExample(TingzhenExample example);

    int deleteByPrimaryKey(String tingzhenid);

    int insert(Tingzhen record);

    int insertSelective(Tingzhen record);

    List<Tingzhen> selectByExample(TingzhenExample example);

    Tingzhen selectByPrimaryKey(String tingzhenid);

    int updateByExampleSelective(@Param("record") Tingzhen record, @Param("example") TingzhenExample example);

    int updateByExample(@Param("record") Tingzhen record, @Param("example") TingzhenExample example);

    int updateByPrimaryKeySelective(Tingzhen record);

    int updateByPrimaryKey(Tingzhen record);
}