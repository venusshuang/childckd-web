package childckd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import childckd.dao.PatientLoginMapper;
import childckd.model.PatientLogin;
import childckd.model.PatientLoginExample;

@Service
public class PatientLoginService {
	@Autowired
	PatientLoginMapper ddMapper;

	public boolean add(PatientLogin ppPatientLogin) {
		return ddMapper.insert(ppPatientLogin) == 1;
	}

	public boolean modify(PatientLogin ppPatientLogin) {
		return ddMapper.updateByPrimaryKey(ppPatientLogin) ==1;
	}
	
	public PatientLogin findOne(String ppUserId) {
		return ddMapper.selectByPrimaryKey(ppUserId);
	}
	
	public PatientLogin findByLoginName(String ppLoginName) {
		PatientLoginExample mmExample = new PatientLoginExample();
		PatientLoginExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andLoginnameEqualTo(ppLoginName).andZhuangtaiEqualTo(1);
		List<PatientLogin> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

	public PatientLogin findByLoginNameAndPassword(String ppLoginName, String ppLoginPassword) {
		PatientLoginExample mmExample = new PatientLoginExample();
		PatientLoginExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andLoginnameEqualTo(ppLoginName).andLoginpasswordEqualTo(ppLoginPassword).andZhuangtaiEqualTo(1);
		List<PatientLogin> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

	public PatientLogin findByLoginNameAndName(String ppLoginName, String ppName) {
		PatientLoginExample mmExample = new PatientLoginExample();
		PatientLoginExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andLoginnameEqualTo(ppLoginName).andNameEqualTo(ppName).andZhuangtaiEqualTo(1);
		List<PatientLogin> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

}
