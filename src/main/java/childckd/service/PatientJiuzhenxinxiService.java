package childckd.service;

import java.util.List;
import java.util.Map;

import childckd.dao.PatientJiuzhenxinxiMapper;
import childckd.model.PatientJiuzhenxinxi;
import childckd.model.PatientJiuzhenxinxiExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientJiuzhenxinxiService {
	@Autowired
	PatientJiuzhenxinxiMapper ddMapper;

	@Autowired
	AttatchmentService ddAttatchmentService;

	@Transactional
	public boolean deleteJiuzhenxinxiIdList(String[] mmList) {
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



	public boolean delete(String ppJiuzhenxinxiId) {
		return ddMapper.deleteByPrimaryKey(ppJiuzhenxinxiId) == 1;
	}

	public PatientJiuzhenxinxi findOne(String ppJiuzhenxinxiId) {
		return ddMapper.selectByPrimaryKey(ppJiuzhenxinxiId);
	}

	public List<PatientJiuzhenxinxi> findByUserId(String ppUserId) {
		PatientJiuzhenxinxiExample mmExample = new PatientJiuzhenxinxiExample();
		PatientJiuzhenxinxiExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andUseridEqualTo(ppUserId).andZhuangtaiEqualTo(1);
		return ddMapper.selectByExample(mmExample);
	}

	public boolean add(PatientJiuzhenxinxi ppPatientJiuzhenxinxi) {
		return ddMapper.insert(ppPatientJiuzhenxinxi) == 1;
	}

	public boolean modify(PatientJiuzhenxinxi ppPatientJiuzhenxinxi) {
		return ddMapper.updateByPrimaryKey(ppPatientJiuzhenxinxi) == 1;
	}

	public int countFindCustomAll(String ppName, String ppShoujihao) {
		Object mmCount = ddMapper.countFindCustomAll(ppName,ppShoujihao);
		return (mmCount == null) ? 0 : Integer.parseInt(mmCount.toString());
	}

	public List<Map<String, Object>> findCustomAll(String ppName, String ppShoujihao, int ppPageIndex, int ppPageSize) {
		int mmStartIndex = (ppPageIndex-1)*ppPageSize;
		return ddMapper.findCustomAll(ppName, ppShoujihao, mmStartIndex, ppPageSize);
	}

	@Transactional
	public boolean add_custom(PatientJiuzhenxinxi ppPatientJiuzhenxinxi, String ppImageUrls) {
		if(!add(ppPatientJiuzhenxinxi)) {
			throw new RuntimeException("添加就诊信息失败！");
		}



		if (!ddAttatchmentService.addCustom(ppPatientJiuzhenxinxi.getJiuzhenxinxiid(), ppImageUrls)) {
			throw new RuntimeException("添加附件失败！");
		}

		return true;
	}

	@Transactional
	public boolean modifyJiuzhen(PatientJiuzhenxinxi ppPatientJiuzhenxinxi, String ppImageUrls) {
		// 修改就诊信息
		if(!modify(ppPatientJiuzhenxinxi)) {
			throw new RuntimeException("修改就诊信息失败！");
		}

		// 删除附件
		if (!ddAttatchmentService.deleteByOwnerId(ppPatientJiuzhenxinxi.getJiuzhenxinxiid())) {
			throw new RuntimeException("删除附件失败！");
		}

		if (!"".equals(ppImageUrls)) {
			// 新增附件
			if (!ddAttatchmentService.addCustom(ppPatientJiuzhenxinxi.getJiuzhenxinxiid(), ppImageUrls)) {
				throw new RuntimeException("添加附件失败！");
			}
		}

		return true;
	}


    public List<PatientJiuzhenxinxi> findByShenfenzhenghao(String ppShenfenzhenghaoma) {
		PatientJiuzhenxinxiExample mmExample = new PatientJiuzhenxinxiExample();
		PatientJiuzhenxinxiExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andShenfenzhenghaomaEqualTo(ppShenfenzhenghaoma).andZhuangtaiEqualTo(1);
		List<PatientJiuzhenxinxi> mmList = ddMapper.selectByExample(mmExample);
		return mmList;
    }

	public List<PatientJiuzhenxinxi> findByShenfenzhenghaoNotIncludeThis(String ppJiuzhenxinxiId, String ppShenfenzhenghaoma) {
		PatientJiuzhenxinxiExample mmExample = new PatientJiuzhenxinxiExample();
		PatientJiuzhenxinxiExample.Criteria mmCriteria = mmExample.createCriteria();
		mmCriteria.andShenfenzhenghaomaEqualTo(ppShenfenzhenghaoma).andZhuangtaiEqualTo(1).andJiuzhenxinxiidNotEqualTo(ppJiuzhenxinxiId);
		List<PatientJiuzhenxinxi> mmList = ddMapper.selectByExample(mmExample);
		return mmList;
	}
}
