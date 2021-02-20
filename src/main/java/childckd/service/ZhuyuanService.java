package childckd.service;

import java.util.List;
import java.util.Map;

import childckd.model.PatientJiuzhenxinxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.ZhuyuanMapper;
import childckd.model.News;
import childckd.model.Zhuyuan;
import childckd.model.ZhuyuanExample;

@Service
public class ZhuyuanService {
	@Autowired
	ZhuyuanMapper ddMapper;
	
	@Autowired
	PatientJiuzhenxinxiService ddPatientJiuzhenxinxiService;

	@Autowired
	NewsService ddNewsService;

	@Autowired
	AttatchmentService ddAttatchmentService;
	
	public Zhuyuan findOne(String ppZhuyuanId) {
		return ddMapper.selectByPrimaryKey(ppZhuyuanId);
	}
	
	private boolean add(Zhuyuan ppZhuyuan) {
		return ddMapper.insert(ppZhuyuan) == 1;
	}
	
	public boolean modify(Zhuyuan ppZhuyuan) {
		return ddMapper.updateByPrimaryKey(ppZhuyuan) == 1;
	}
	
	public Zhuyuan findDaishenheByUserId(String ppUserId) {
		ZhuyuanExample mmExample = new ZhuyuanExample();
		ZhuyuanExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andZhuangtaiEqualTo(1).andUseridEqualTo(ppUserId).andShenhejieguoEqualTo(0);
		List<Zhuyuan> mmZhuyuanList = ddMapper.selectByExample(mmExample);
		return mmZhuyuanList.size() > 0 ? mmZhuyuanList.get(0) : null;
	}


	@Transactional
	public boolean add_custom(Zhuyuan ppZhuyuan, PatientJiuzhenxinxi ppPatientJiuzhenxinxi, String ppImageUrls) {
		if(!add(ppZhuyuan)) {
			throw new RuntimeException("添加住院信息失败！");
		}
		
		if(!ddPatientJiuzhenxinxiService.add(ppPatientJiuzhenxinxi)) {
			throw new RuntimeException("添加就诊信息失败！");
		}
		if (!"".equals(ppImageUrls)) {
			if (!ddAttatchmentService.addCustom(ppZhuyuan.getZhuyuanid(), ppImageUrls)) {
				throw new RuntimeException("添加附件失败！");
			}
		}
		
		return true;
	}

	public boolean shenhe(Zhuyuan mmZhuyuan, News mmNews) {
		boolean modifyZhuyuan = this.modify(mmZhuyuan);
		if (!modifyZhuyuan) {
			throw new RuntimeException("修改住院失败");
		}
		boolean addNews = ddNewsService.add(mmNews);
		if (!addNews) {
			throw new RuntimeException("添加消息失败");
		}
		return true;
	}

	public int countFindCustomAll(String ppXingming, String ppShoujihao, String ppBingzhong, String ppYuyueriqi,int ppShenhejieguo) {
		Object mmCount = ddMapper.countFindCustomAll(ppXingming,ppShoujihao,ppBingzhong,ppYuyueriqi,ppShenhejieguo);
		return (mmCount == null) ? 0 : Integer.parseInt(mmCount.toString());
	}

	public List<Map<String, Object>> findCustomAll(String ppXingming, String ppShoujihao, String ppBingzhong,
			String ppYuyueriqi,int ppShenhejieguo, int ppPageIndex, int ppPageSize) {
		int mmStartIndex = (ppPageIndex-1)*ppPageSize;
		return ddMapper.findCustomAll(ppXingming, ppShoujihao,ppBingzhong,ppYuyueriqi,ppShenhejieguo, mmStartIndex, ppPageSize);
	}

	public List<Map<String, Object>> tongjiBingzhong() {
		return ddMapper.tongjiBingzhong();
	}
	

}
