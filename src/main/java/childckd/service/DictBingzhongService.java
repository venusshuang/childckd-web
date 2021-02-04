package childckd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import childckd.dao.DictBingzhongMapper;
import childckd.model.DictBingzhong;
import childckd.model.DictBingzhongExample;

@Service
public class DictBingzhongService {
	@Autowired
	DictBingzhongMapper ddMapper;

	public List<DictBingzhong> findValue() {
		DictBingzhongExample mmExample = new DictBingzhongExample();
		DictBingzhongExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andStatusEqualTo(100);
		mmExample.setOrderByClause("ordernum asc");
		return ddMapper.selectByExample(mmExample);
	}

}
