package childckd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import childckd.dao.GuahaoMapper;
import childckd.model.Guahao;
import childckd.model.News;
import childckd.model.Paibanguanli;

@Service
public class GuahaoService {

	@Autowired
	GuahaoMapper ddMapper;
	@Autowired
	PaiBanGuanLiService ddPaiBanGuanLiService;
	@Autowired
	NewsService ddNewsService;
	@Autowired
	AttatchmentService ddAttatchmentService;

	public boolean add(Guahao ppGuahao) {
		return ddMapper.insert(ppGuahao) == 1;
	}

	public boolean modify(Guahao ppGuahao) {
		return ddMapper.updateByPrimaryKey(ppGuahao) == 1;
	}

	public boolean delete(String ppGuahaoId) {
		return ddMapper.deleteByPrimaryKey(ppGuahaoId) == 1;
	}

	public Guahao findOne(String ppGuahaoId) {
		return ddMapper.selectByPrimaryKey(ppGuahaoId);
	}
	
	public List<Map<String, Object>> findByDateAndUserId(String ppUserId,String ppDate) {
		return ddMapper.findByDateAndUserId(ppUserId, ppDate);
	}

	public List<Map<String, Object>> findYuyueByUserId(String ppUserId) {
		return ddMapper.findYuyueByUserId(ppUserId);
	}

	/*public List<Map<String, Object>> findCustomAll(String ppXingming, String ppShoujihao, String ppExpertId, String ppYuyueriqi) {
		return ddMapper.findCustomAll(ppXingming, ppShoujihao, ppExpertId, ppYuyueriqi);
	}*/
	
	public Map<String, Object> findCustomOne(String ppGuahaoId) {
		return ddMapper.findCustomOne(ppGuahaoId);
	}
	
	@Transactional
	public boolean shenhe(Guahao ppGuahao,News ppNews) {
		boolean modifyGuahao = this.modify(ppGuahao);
		if (!modifyGuahao) {
			throw new RuntimeException("修改挂号失败");
		}
		boolean addNews = ddNewsService.add(ppNews);
		if (!addNews) {
			throw new RuntimeException("添加消息失败");
		}
		return true;
	}

	@Transactional
	public boolean addCustom(Guahao ppGuahao, Paibanguanli ppPaibanguanli,News ppNews) {
		boolean addGuahao = this.add(ppGuahao);
		if (!addGuahao) {
			throw new RuntimeException("添加挂号失败");
		}
		
		boolean modifyPaiban = ddPaiBanGuanLiService.modify(ppPaibanguanli);
		if (!modifyPaiban) {
			throw new RuntimeException("修改排班失败");
		}
		
		if(ppNews != null) {
			boolean addNews = ddNewsService.add(ppNews);
			if (!addNews) {
				throw new RuntimeException("添加消息失败");
			}
		}
				
		return true;
	}


	public int countFindCustomAll(String ppXingming, String ppShoujihao,String ppBingzhong, String ppExpertId, String ppYuyueriqi,int ppShenhejieguo) {
		Object mmCount = ddMapper.countFindCustomAll(ppXingming,ppShoujihao,ppBingzhong,ppExpertId,ppYuyueriqi,ppShenhejieguo);
		return (mmCount == null) ? 0 : Integer.parseInt(mmCount.toString());
	}

	public List<Map<String, Object>> findCustomAll(String ppXingming, String ppShoujihao,String ppBingzhong, String ppExpertId,
		String ppYuyueriqi,int ppShenhejieguo, int ppPageIndex, int ppPageSize) {
		int mmStartIndex = (ppPageIndex-1)*ppPageSize;
		return ddMapper.findCustomAll(ppXingming, ppShoujihao,ppBingzhong,ppExpertId,ppYuyueriqi,ppShenhejieguo, mmStartIndex, ppPageSize);
	}
	
	public List<Map<String, Object>> tongjiRenshu() {
		return ddMapper.tongjiRenshu();
	}
	
	public List<Map<String, Object>> tongjiNianling() {
		return ddMapper.tongjiNianling();
	}

	public List<Map<String, Object>> tongjiBingzhong() {
		return ddMapper.tongjiBingzhong();
	}
}
