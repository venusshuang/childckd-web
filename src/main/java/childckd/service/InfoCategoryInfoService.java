package childckd.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import childckd.dao.InfoCategoryInfoMapper;
import childckd.model.InfoCategoryInfo;
import childckd.model.InfoCategoryInfoExample;

@Service
public class InfoCategoryInfoService {

	@Autowired
	InfoCategoryInfoMapper ddMapper;

	public InfoCategoryInfo findByInfoIdAndCategoryId(String ppInfoId, String ppCategoryId) {
		return ddMapper.findByInfoIdAndCategoryId(ppInfoId, ppCategoryId);
	}

	public boolean add(InfoCategoryInfo ppInfoCategoryInfo) {
		return ddMapper.insert(ppInfoCategoryInfo) == 1;
	}

	public boolean modify(InfoCategoryInfo ppInfoCategoryInfo) {
		return ddMapper.updateByPrimaryKey(ppInfoCategoryInfo) == 1;
	}

	public boolean delete(String ppInfoId, String ppCategoryId) {
		InfoCategoryInfoExample mmExample = new InfoCategoryInfoExample();
		mmExample.createCriteria().andInfoidEqualTo(ppInfoId).andCategoryidEqualTo(ppCategoryId);
		return ddMapper.deleteByExample(mmExample) == 1;
	}

	public boolean moveUp(String ppInfoId, String ppCategoryId) {
		InfoCategoryInfo mmInfoCategoryInfo = this.findByInfoIdAndCategoryId(ppInfoId, ppCategoryId);
		Map<String, Object> map = ddMapper.findUp(mmInfoCategoryInfo.getOrdernum(), mmInfoCategoryInfo.getCategoryid());
		if (map == null) {
			return true;
		}
		String mmInfoCategoryInfo_up = map.get("infoid").toString();
		int mmOrdernum_up = Integer.parseInt(map.get("ordernum").toString());

		int mmOrdernum_temp = mmInfoCategoryInfo.getOrdernum();
		mmInfoCategoryInfo.setOrdernum(mmOrdernum_up);
		modify(mmInfoCategoryInfo);

		InfoCategoryInfo mmInfoCategoryInfo2 = this.findByInfoIdAndCategoryId(mmInfoCategoryInfo_up, ppCategoryId);
		mmInfoCategoryInfo2.setOrdernum(mmOrdernum_temp);
		modify(mmInfoCategoryInfo2);
		return true;
	}

	public boolean moveDown(String ppInfoId, String ppCategoryId) {
		InfoCategoryInfo mmInfoCategoryInfo = this.findByInfoIdAndCategoryId(ppInfoId, ppCategoryId);
		Map<String, Object> map = ddMapper.findDown(mmInfoCategoryInfo.getOrdernum(),
				mmInfoCategoryInfo.getCategoryid());
		if (map == null) {
			return true;
		}
		String mmInfoCategoryInfo_up = map.get("infoid").toString();
		int mmOrdernum_up = Integer.parseInt(map.get("ordernum").toString());

		int mmOrdernum_temp = mmInfoCategoryInfo.getOrdernum();
		mmInfoCategoryInfo.setOrdernum(mmOrdernum_up);
		modify(mmInfoCategoryInfo);

		InfoCategoryInfo mmInfoCategoryInfo2 = this.findByInfoIdAndCategoryId(mmInfoCategoryInfo_up, ppCategoryId);
		mmInfoCategoryInfo2.setOrdernum(mmOrdernum_temp);
		modify(mmInfoCategoryInfo2);
		return true;
	}

	public int getMaxOrdernum(String ppCategoryId) {
		Object mmMaxOrdernum = ddMapper.getMaxOrdernum(ppCategoryId);
		return mmMaxOrdernum == null ? 0 : Integer.parseInt(mmMaxOrdernum.toString());
	}

	//当前栏目下是否有信息
	public boolean existInfoCategoryInfo(String ppCategoryId) {
		InfoCategoryInfoExample mmExample = new InfoCategoryInfoExample();
		mmExample.createCriteria().andCategoryidEqualTo(ppCategoryId);
		int mmResult = ddMapper.countByExample(mmExample);
		return mmResult >= 1 ? true : false;
	}
	
	//当前栏目下是否存在该条信息
	public boolean existInfoInInfoCategory(String ppCategoryId,String ppInfoId) {
		InfoCategoryInfoExample mmExample = new InfoCategoryInfoExample();
		mmExample.createCriteria().andCategoryidEqualTo(ppCategoryId).andInfoidEqualTo(ppInfoId);
		int mmResult = ddMapper.countByExample(mmExample);
		return mmResult >= 1 ? true : false;
	}
}
