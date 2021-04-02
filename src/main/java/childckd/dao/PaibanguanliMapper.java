package childckd.dao;

import childckd.model.Paibanguanli;
import childckd.model.PaibanguanliExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import childckd.model.Tingzhen;
import org.apache.ibatis.annotations.Param;

public interface PaibanguanliMapper {
    List<Map<String, Object>>findWeekPaibanByExpertId(@Param("expertid")String ppExpertId);

    List<Map<String,Object>> find_custom_one(String ppPaibanId);

    List<Map<String, Object>> findPaiBanGuanLiByNameAndDateAndShangxiawu(String ppName, String mmPaiBanRiQi, String ppShangxiawu);

    List<Map<String, Object>> findPaiBanGuanLiByExpertidAndDate(String ppExpertid, String mmPaiBanRiQi, String ppShangxiawu);

    int countByExample(PaibanguanliExample example);

    int deleteByExample(PaibanguanliExample example);

    int deleteByPrimaryKey(String paibanid);

    int insert(Paibanguanli record);

    int insertSelective(Paibanguanli record);

    List<Paibanguanli> selectByExample(PaibanguanliExample example);

    Paibanguanli selectByPrimaryKey(String paibanid);

    int updateByExampleSelective(@Param("record") Paibanguanli record, @Param("example") PaibanguanliExample example);

    int updateByExample(@Param("record") Paibanguanli record, @Param("example") PaibanguanliExample example);

    int updateByPrimaryKeySelective(Paibanguanli record);

    int updateByPrimaryKey(Paibanguanli record);



    List<Map<String, Object>> findByExpertidAndPaibanriqi(String ppExpertId, String ppPaiBanRiQi,@Param("startindex") int mmStartIndex, @Param("pagesize") int ppPageSize);

    Object CountByExpertidAndPaibanriqi(String ppExpertId, String ppPaiBanRiQi);


    List<Paibanguanli> findDayByExpertidAndPaibanriqi(String ppExpertId, String ppPaiBanRiQi);

}