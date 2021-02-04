package childckd.dao;

import childckd.model.Referral;
import childckd.model.ReferralExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReferralMapper {
	List<Map<String, Object>> findByCondition(
			@Param("patientname") String ppPatientName, 
			@Param("doctorname") String ppDoctorName, 
			@Param("danwei") String ppDanwei);
	
    int countByExample(ReferralExample example);

    int deleteByExample(ReferralExample example);

    int deleteByPrimaryKey(String referralid);

    int insert(Referral record);

    int insertSelective(Referral record);

    List<Referral> selectByExample(ReferralExample example);

    Referral selectByPrimaryKey(String referralid);

    int updateByExampleSelective(@Param("record") Referral record, @Param("example") ReferralExample example);

    int updateByExample(@Param("record") Referral record, @Param("example") ReferralExample example);

    int updateByPrimaryKeySelective(Referral record);

    int updateByPrimaryKey(Referral record);

}