package childckd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import childckd.dao.DoctorLoginMapper;
import childckd.model.DoctorLogin;
import childckd.model.DoctorLoginExample;

@Service
public class DoctorLoginService {
	@Autowired
	DoctorLoginMapper ddMapper;
	
	public boolean add(DoctorLogin ppDoctorLogin) {
		return ddMapper.insert(ppDoctorLogin) == 1;
	}
	
	public boolean modify(DoctorLogin ppDoctorLogin) {
		return ddMapper.updateByPrimaryKey(ppDoctorLogin) == 1;
	}

	public DoctorLogin findByLoginNameAndPassword(String ppLoginName, String ppLoginPassword) {
		DoctorLoginExample mmExample = new DoctorLoginExample();
		DoctorLoginExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andLoginnameEqualTo(ppLoginName).andLoginpasswordEqualTo(ppLoginPassword).andZhuangtaiEqualTo(1);
		List<DoctorLogin> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

	public DoctorLogin findByLoginName(String ppLoginName) {
		DoctorLoginExample mmExample = new DoctorLoginExample();
		DoctorLoginExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andLoginnameEqualTo(ppLoginName).andZhuangtaiEqualTo(1);
		List<DoctorLogin> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

	public DoctorLogin findByLoginNameAndName(String ppLoginName, String ppName) {
		DoctorLoginExample mmExample = new DoctorLoginExample();
		DoctorLoginExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andLoginnameEqualTo(ppLoginName).andNameEqualTo(ppName).andZhuangtaiEqualTo(1);
		List<DoctorLogin> mmList = ddMapper.selectByExample(mmExample);
		return mmList.size() > 0 ? mmList.get(0) : null;
	}

	

}
