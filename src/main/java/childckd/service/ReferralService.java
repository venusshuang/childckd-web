package childckd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.ReferralMapper;
import childckd.model.Doctor;
import childckd.model.Referral;
import childckd.model.ReferralExample;

@Service
public class ReferralService {
	@Autowired
	ReferralMapper ddMapper;

	@Autowired
	DoctorService ddDoctorService;

	@Autowired
	AttatchmentService ddAttatchmentService;

	public boolean add(Referral ppReferral) {
		return ddMapper.insert(ppReferral) == 1;
	}

	public boolean modify(Referral ppReferral) {
		return ddMapper.updateByPrimaryKey(ppReferral) == 1;
	}

	private boolean delete(String ppReferralId) {
		return ddMapper.deleteByPrimaryKey(ppReferralId) == 1;
	}

	public Referral findOne(String ppReferraId) {
		return ddMapper.selectByPrimaryKey(ppReferraId);
	}

	public List<Referral> findByDoctorId(String ppDoctorId) {
		ReferralExample mmExample = new ReferralExample();
		ReferralExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andDoctoridEqualTo(ppDoctorId).andZhuangtaiEqualTo(1);
		return ddMapper.selectByExample(mmExample);
	}

	@Transactional
	public boolean add_custom(Referral ppReferral, Doctor ppDoctor,String ppImageUrls) {
		if(!add(ppReferral)) {
			throw new RuntimeException("添加转诊信息失败！");
		}

		if(!ddDoctorService.add(ppDoctor)) {
			throw new RuntimeException("添加医生信息失败！");
		}

		if (!ddAttatchmentService.addCustom(ppReferral.getReferralid(), ppImageUrls)) {
			throw new RuntimeException("添加附件失败！");
		}

		return true;
	}

	@Transactional
	public boolean addReferralAndModifyDoctor(Referral ppReferral, Doctor ppDoctor,String ppImageUrls) {
		if(!add(ppReferral)) {
			throw new RuntimeException("添加转诊信息失败！");
		}

		if(!ddDoctorService.modify(ppDoctor)) {
			throw new RuntimeException("修改医生信息失败！");
		}
		if (!"".equals(ppImageUrls)) {
			if (!ddAttatchmentService.addCustom(ppReferral.getReferralid(), ppImageUrls)) {
				throw new RuntimeException("添加附件失败！");
			}
		}

		return true;
	}

	@Transactional
	public boolean modifyReferral(Referral ppReferral, String ppImageUrls) {
		// 修改转诊信息
		if(!modify(ppReferral)) {
			throw new RuntimeException("修改转诊信息失败！");
		}

		// 删除附件
		if (!ddAttatchmentService.deleteByOwnerId(ppReferral.getReferralid())) {
			throw new RuntimeException("删除附件失败！");
		}

		if (!"".equals(ppImageUrls)) {
			// 新增附件
			if (!ddAttatchmentService.addCustom(ppReferral.getReferralid(), ppImageUrls)) {
				throw new RuntimeException("添加附件失败！");
			}
		}

		return true;
	}

	public List<Map<String,Object>> findByCondition(String ppPatientName, String ppDoctorName, String ppDanwei) {
		return ddMapper.findByCondition(ppPatientName,ppDoctorName,ppDanwei);
	}

	@Transactional
	public boolean deleteByZhuanzhenIdList(String[] mmZhuanzhenIdArray) {
		try
		{
			for (int i = 0 ; i < mmZhuanzhenIdArray.length ; i++ ) 
			{
				delete(mmZhuanzhenIdArray[i]);
			} 

		}catch (Exception e) {

			throw new RuntimeException("批量删除失败");

		}

		return true;
	}



}
