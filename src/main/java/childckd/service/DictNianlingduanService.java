package childckd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import childckd.dao.DictBingzhongMapper;
import childckd.dao.DictNianlingduanMapper;
import childckd.model.DictBingzhong;
import childckd.model.DictBingzhongExample;
import childckd.model.DictNianlingduan;
import childckd.model.DictNianlingduanExample;

@Service
public class DictNianlingduanService {
	@Autowired
	DictNianlingduanMapper ddMapper;

	public List<DictNianlingduan> findValue() {
		DictNianlingduanExample mmExample = new DictNianlingduanExample();
		DictNianlingduanExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andStatusEqualTo(100);
		mmExample.setOrderByClause("ordernum asc");
		return ddMapper.selectByExample(mmExample);
	}

}
