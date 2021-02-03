package childckd.dao;

import childckd.model.Attatchment;
import childckd.model.AttatchmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttatchmentMapper {
    int countByExample(AttatchmentExample example);

    int deleteByExample(AttatchmentExample example);

    int deleteByPrimaryKey(String attatchmentid);

    int insert(Attatchment record);

    int insertSelective(Attatchment record);

    List<Attatchment> selectByExample(AttatchmentExample example);

    Attatchment selectByPrimaryKey(String attatchmentid);

    int updateByExampleSelective(@Param("record") Attatchment record, @Param("example") AttatchmentExample example);

    int updateByExample(@Param("record") Attatchment record, @Param("example") AttatchmentExample example);

    int updateByPrimaryKeySelective(Attatchment record);

    int updateByPrimaryKey(Attatchment record);
}