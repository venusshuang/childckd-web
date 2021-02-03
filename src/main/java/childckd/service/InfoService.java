package childckd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import childckd.dao.InfoMapper;
import childckd.model.Info;
import childckd.model.InfoCategoryInfo;

@Service
public class InfoService {

	@Autowired
	InfoMapper ddMapper;
	@Autowired
	InfoCategoryInfoService ddInfoCategoryInfoService;
	public int updateLiulan(int ppliulannum) {
		return ddMapper.updateliulan(ppliulannum);
	}
	
	public int findliulan() {
		return ddMapper.findliulan();
	}
    
	public Info findtop(String ppInfoId) {
		
		return ddMapper.findtop(ppInfoId);
	}
	
	public Info findOne(String ppInfoId) {
		return ddMapper.selectByPrimaryKey(ppInfoId);
	}

	public Map<String, Object> findOneInfo(String ppInfoId) {
		return ddMapper.findOneInfo(ppInfoId);
	}

	public Map<String, Object> findCustomOne(String ppInfoId) {
		return ddMapper.findCustomOne(ppInfoId);
	}

	public boolean add(Info ppInfo) {
		return ddMapper.insert(ppInfo) == 1;
	}

	@Transactional
	public boolean addInfoAndInfoCategoryInfo(Info ppInfo, InfoCategoryInfo ppInfoCategoryInfo) {
		boolean ok1 = this.add(ppInfo);
		boolean ok2 = ddInfoCategoryInfoService.add(ppInfoCategoryInfo);

		if (!ok1) {
			throw new RuntimeException("添加Info失败");
		}

		if (!ok2) {
			throw new RuntimeException("添加InfoCategoryInfo失败");
		}

		return true;
	}

	public boolean modify(Info ppInfo) {
		return ddMapper.updateByPrimaryKeySelective(ppInfo) == 1;
	}

	public boolean delete(String ppInfoId) {
		return ddMapper.deleteByPrimaryKey(ppInfoId) == 1;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public PageInfo<List<Map<String, Object>>> findByCategoryIdPaging(String ppCategoryId, int ppPageIndex, int ppPageSize) {
		PageHelper.startPage(ppPageIndex, ppPageSize);
		List<Map<String, Object>> mmList = ddMapper.findByCategoryId(ppCategoryId);
		PageInfo mmInfoList = new PageInfo<>(mmList);
		return mmInfoList;
	}

	public int countByCategoryIdPaging(String ppCategoryId) {
		Object mmCount = ddMapper.countByCategoryIdPaging(ppCategoryId);
		return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<List<Map<String, Object>>> findPassedByCategoryIdPaging(String ppCategoryId, int ppPageIndex,
			int ppPageSize) {
		PageHelper.startPage(ppPageIndex, ppPageSize);
		List<Map<String, Object>> mmList = ddMapper.findPassedByCategoryId(ppCategoryId);
		PageInfo mmInfoList = new PageInfo<>(mmList);
		return mmInfoList;
	}

	public int countPassedByCategoryIdPaging(String ppCategoryId) {
		Object mmCount = ddMapper.countPassedByCategoryIdPaging(ppCategoryId);
		return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<List<Map<String, Object>>> findPassedPicNotNullByCategoryIdPaging(String ppCategoryId, int ppPageIndex,
			int ppPageSize) {
		PageHelper.startPage(ppPageIndex, ppPageSize);
		List<Map<String, Object>> mmList = ddMapper.findPassedPicNotNullByCategoryId(ppCategoryId);
		PageInfo mmInfoList = new PageInfo<>(mmList);
		return mmInfoList;
	}

	public int countPassedPicNotNullByCategoryIdPaging(String ppCategoryId) {
		Object mmCount = ddMapper.countPassedPicNotNullByCategoryIdPaging(ppCategoryId);
		return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
	}

	public List<Map<String, Object>> findTopOnePassedByCategoryId(String ppCategoryId) {
		return ddMapper.findTopOnePassedByCategoryId(ppCategoryId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<List<Map<String, Object>>> search(String ppSearchText, int ppPageIndex,
			int ppPageSize ) {
		PageHelper.startPage(ppPageIndex, ppPageSize);
		List<Map<String, Object>> mmList = ddMapper.search(ppSearchText);
		PageInfo mmInfoList = new PageInfo<>(mmList);
		return mmInfoList;
	}

	public int countSearch(String ppSearchText) {
		Object mmCount = ddMapper.countSearch(ppSearchText);
		return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
	}

	public float getScoreByDeptId(String ppDeptId, String ppCountTime) {
		Object mmCount = ddMapper.getScoreByDeptId(ppDeptId, ppCountTime);
		return mmCount == null ? 0 : Float.parseFloat(mmCount.toString());
	}

	public int addClicknum(String ppInfoId) {
		return ddMapper.selectByPrimaryKey(ppInfoId).getClicknum() + 1;
	}

	public int statisticsZongzhi(String ppDeptId,String ppTougaoshijian) {
		Object mmCount = ddMapper.statisticszongzhi(ppDeptId,ppTougaoshijian);
		return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
	}

	public List<Map<String, Object>> statisticskeshi(String ppTougaoshijian) {
		return ddMapper.statisticskeshi(ppTougaoshijian);
	}

	public Map<String, Object> findDeptByDeptId(String ppDeptId) {
		return ddMapper.findDeptByDeptId(ppDeptId);
	}
}
