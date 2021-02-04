package childckd.dao;

import childckd.model.DictNianlingduan;
import childckd.model.DictNianlingduanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictNianlingduanMapper {
    int countByExample(DictNianlingduanExample example);

    int deleteByExample(DictNianlingduanExample example);

    int deleteByPrimaryKey(String id);

    int insert(DictNianlingduan record);

    int insertSelective(DictNianlingduan record);

    List<DictNianlingduan> selectByExample(DictNianlingduanExample example);

    DictNianlingduan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DictNianlingduan record, @Param("example") DictNianlingduanExample example);

    int updateByExample(@Param("record") DictNianlingduan record, @Param("example") DictNianlingduanExample example);

    int updateByPrimaryKeySelective(DictNianlingduan record);

    int updateByPrimaryKey(DictNianlingduan record);
}