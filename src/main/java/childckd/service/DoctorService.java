package childckd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.DoctorMapper;
import childckd.model.Doctor;


@Service
public class DoctorService {
	@Autowired
	DoctorMapper ddMapper;

	public List<Map<String,Object>> findPatientByNameAndDept(String ppName, String ppDept) {
		return ddMapper.findPatientByNameAndDept(ppName,ppDept);
	}
	
	@Transactional
	public boolean deleteDoctorIdList(String[] mmList) {
		try
		{
			for (int i = 0 ; i <mmList.length ; i++ ) 
			 {
				 delete(mmList[i]);
			 } 
			
		}catch (Exception e) {
			
			throw new RuntimeException("批量删除失败");
			
		}
		 
		return true;
	}
	
	public boolean delete(String ppDoctorId) {
		return ddMapper.deleteByPrimaryKey(ppDoctorId) == 1;
	}

	public Doctor findOne(String ppDoctorId) {
		return ddMapper.selectByPrimaryKey(ppDoctorId);
	}

	public boolean add(Doctor ppDoctor) {
		return ddMapper.insert(ppDoctor) == 1;
	}

	public boolean modify(Doctor ppDoctor) {
		return ddMapper.updateByPrimaryKey(ppDoctor) == 1;
	}

}
