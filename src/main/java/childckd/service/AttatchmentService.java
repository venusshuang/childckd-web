package childckd.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.AttatchmentMapper;
import childckd.model.Attatchment;
import childckd.model.AttatchmentExample;

@Service
public class AttatchmentService {

	@Autowired
	AttatchmentMapper ddMapper;
	
	public boolean add(Attatchment ppAttatchment) {
		return ddMapper.insert(ppAttatchment)==1;
	}
	
	public boolean deleteByOwnerId(String ppOwnerId) {
		AttatchmentExample mmExample = new AttatchmentExample();
		AttatchmentExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andOwneridEqualTo(ppOwnerId);
		return ddMapper.deleteByExample(mmExample) >= 0;
	}
	
	public List<Attatchment> findByOwnerId(String ppOwnerId) {
		AttatchmentExample mmExample = new AttatchmentExample();
		AttatchmentExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andOwneridEqualTo(ppOwnerId).andZhuangtaiEqualTo(1);
		return ddMapper.selectByExample(mmExample);
	}
	
	@Transactional
	public boolean addCustom(String ppOwnerId,String ppImageUrls) {
		String[] mmImageArray = ppImageUrls.split(";");
		for (int i = 0; i < mmImageArray.length; i++) {
			Attatchment mmAttatchment = new Attatchment();
			mmAttatchment.setAttatchmentid(UUID.randomUUID().toString());
			mmAttatchment.setOwnerid(ppOwnerId);
			mmAttatchment.setFilename("");
			mmAttatchment.setUrl(mmImageArray[i]);
			mmAttatchment.setShangchuanshijian(new Date());
			mmAttatchment.setZhuangtai(1);
			
			if (!add(mmAttatchment)) {
				return false;
			}
		}
		return true;
	}

	

	
}
