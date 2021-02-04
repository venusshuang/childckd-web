package childckd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import childckd.dao.ScheduleMapper;
import childckd.model.Schedule;
import childckd.model.ScheduleExample;

@Service
public class ScheduleService {

	@Autowired
	ScheduleMapper ddMapper;
	
	public boolean add(Schedule ppSchedule) {
		return ddMapper.insert(ppSchedule)==1;
	}
	
	public boolean modify(Schedule ppSchedule) {
		return ddMapper.updateByPrimaryKey(ppSchedule)==1;
	}
	
	public boolean delete(String ppScheduleId) {
		return ddMapper.deleteByPrimaryKey(ppScheduleId)==1;
	}
	
	public Schedule findOne(String ppScheduleId) {
		return ddMapper.selectByPrimaryKey(ppScheduleId);
	}
	
	public List<Schedule> findAll() {
		ScheduleExample mmExample = new ScheduleExample();
		mmExample.createCriteria().andZhuangtaiEqualTo(1);
		mmExample.setOrderByClause("xingqi asc");
		return ddMapper.selectByExample(mmExample);
	}
	
	public List<Schedule> findByXingqi(int ppXingqi) {
		ScheduleExample mmExample = new ScheduleExample();
		mmExample.createCriteria().andXingqiEqualTo(ppXingqi).andZhuangtaiEqualTo(1);
		return ddMapper.selectByExample(mmExample);
	}
	
	public List<Schedule> findByXingqiAndShangxiawu(int ppXingqi,String ppShangxiawu) {
		ScheduleExample mmExample = new ScheduleExample();
		mmExample.createCriteria().andXingqiEqualTo(ppXingqi).andShangxiawuEqualTo(ppShangxiawu);
		return ddMapper.selectByExample(mmExample);
	}
}
