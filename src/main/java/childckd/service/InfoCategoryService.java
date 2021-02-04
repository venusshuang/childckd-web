package childckd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import childckd.dao.InfoCategoryMapper;
import childckd.model.InfoCategory;
import childckd.model.InfoCategoryExample;

@Service
public class InfoCategoryService {

	@Autowired
	InfoCategoryMapper ddMapper;

	public InfoCategory findOne(String ppCategoryId) {
		return ddMapper.selectByPrimaryKey(ppCategoryId);
	}

	public boolean add(InfoCategory ppInfoCategory) {
		return ddMapper.insertSelective(ppInfoCategory)==1;
	}

	public boolean modify(InfoCategory ppInfoCategory) {
		return ddMapper.updateByPrimaryKey(ppInfoCategory) == 1;
	}

	public boolean delete(String ppCategoryId) {
		return ddMapper.deleteByPrimaryKey(ppCategoryId) == 1;
	}

	public List<InfoCategory> findAll() {
		InfoCategoryExample mmExample = new InfoCategoryExample();
		mmExample.setOrderByClause("ordernum asc");
		return ddMapper.selectByExample(mmExample);
	}

	public List<InfoCategory> findValid() {
		InfoCategoryExample mmExample = new InfoCategoryExample();
		mmExample.createCriteria().andIsvalidEqualTo(1);
		mmExample.setOrderByClause("ordernum asc");
		return ddMapper.selectByExample(mmExample);
	}

	public List<InfoCategory> findAllowTougao() {
		InfoCategoryExample mmExample = new InfoCategoryExample();
		mmExample.createCriteria().andIsvalidEqualTo(1).andAllowtougaoEqualTo(1);
		mmExample.setOrderByClause("ordernum asc");
		return ddMapper.selectByExample(mmExample);
	}
	
	public List<Map<String, Object>> findByParentCategoryId(String ppParentCategoryId) {
		return ddMapper.findByParentCategoryId(ppParentCategoryId);
	}

	public List<Map<String, Object>> findByDeptId(String ppDeptId) {
		return ddMapper.findByDeptId(ppDeptId);
	}

	public boolean moveUp(String ppCategoryId) {
		InfoCategory mmCategory = this.findOne(ppCategoryId);
		Map<String, Object> map = ddMapper.findUp(mmCategory.getOrdernum(), mmCategory.getParentcategoryid());
		if (map == null) {
			return true;
		}
		String mmCategory_down = map.get("categoryid").toString();
		int mmOrdernum_down = Integer.parseInt(map.get("ordernum").toString());

		int odrenum_temp = mmCategory.getOrdernum();
		mmCategory.setOrdernum(mmOrdernum_down);
		modify(mmCategory);

		InfoCategory mmCategory2 = this.findOne(mmCategory_down);
		mmCategory2.setOrdernum(odrenum_temp);
		modify(mmCategory2);
		return true;
	}

	public boolean moveDown(String ppCategoryId) {
		InfoCategory mmCategory = this.findOne(ppCategoryId);
		Map<String, Object> map = ddMapper.findDown(mmCategory.getOrdernum(), mmCategory.getParentcategoryid());
		if (map == null) {
			return true;
		}
		String mmCategory_down = map.get("categoryid").toString();
		int mmOrdernum_down = Integer.parseInt(map.get("ordernum").toString());

		int odrenum_temp = mmCategory.getOrdernum();
		mmCategory.setOrdernum(mmOrdernum_down);
		modify(mmCategory);

		InfoCategory mmCategory2 = this.findOne(mmCategory_down);
		mmCategory2.setOrdernum(odrenum_temp);
		modify(mmCategory2);
		return true;
	}

	public int getMaxOrdernum(String ppParentCategoryId) {
		Object mmMaxOrdernum = ddMapper.getMaxOrdernum(ppParentCategoryId);
		return mmMaxOrdernum == null ? 0 : Integer.parseInt(mmMaxOrdernum.toString());
	}

	public boolean existSubInfocategory(String ppCategoryId) {
		InfoCategoryExample mmExample = new InfoCategoryExample();
		mmExample.createCriteria().andParentcategoryidEqualTo(ppCategoryId);
		int mmResult = ddMapper.countByExample(mmExample);
		return mmResult >= 1 ? true : false;
	}
}