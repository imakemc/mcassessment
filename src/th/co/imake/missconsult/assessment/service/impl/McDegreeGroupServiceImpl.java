package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.domain.McDegree;
import th.co.imake.missconsult.assessment.domain.McDegreeGroup;
import th.co.imake.missconsult.assessment.repository.McDegreeGroupRepository;
import th.co.imake.missconsult.assessment.service.McDegreeGroupService;
@Service("mcDegreeGroupService")
public class McDegreeGroupServiceImpl implements McDegreeGroupService{
	@Autowired
	private McDegreeGroupRepository mcDegreeGroupRepository;
	
	public List<McDegreeGroup> getAllByDegreeId(Integer DegreeId){
		return mcDegreeGroupRepository.getAllByDegreeId(DegreeId);
	}

	@Override
	public Integer insertMcDegreeGroupByDegreeId(String degreeId,String assessor,String mdgName) {
		McDegreeGroup degreeGroup = new McDegreeGroup();
		degreeGroup.setMdgAssessor(Integer.parseInt(assessor));
//		degreeGroup.setMdiD(Integer.parseInt(degreeId));
		McDegree degree = new McDegree();
		degree.setMdId(Integer.parseInt(degreeId));
		degreeGroup.setMcdegree(degree);
		degreeGroup.setMdgName(mdgName);
	return mcDegreeGroupRepository.insertMcDegreeGroupByDegreeId(degreeGroup);
	}

	@Override
	public Integer UpdateMcDegreeGroupByDegreeGroupId(String degreeGroupId,
			String assessor, String mdgName) {
		Integer count =0;
		List<McDegreeGroup> degreeGroup  = mcDegreeGroupRepository.getAllByDegreeGroupId(Integer.parseInt(degreeGroupId));
		if(degreeGroup!=null || !degreeGroup.isEmpty()){
			degreeGroup.get(0).setMdgAssessor(Integer.parseInt(assessor));
			degreeGroup.get(0).setMdgName(mdgName);
			count = mcDegreeGroupRepository.updateMcDegreeGroupByDegreeGroupId(degreeGroup.get(0));
//			count=1;
		}
		return count;
	}
	@Override
	public Integer DeleteMcDegreeGroupByDegreeGroupId(String degreeGroupId) {
		Integer count =0;
		McDegreeGroup mcDegreeGroup = new McDegreeGroup();
		mcDegreeGroup.setMdgId(Integer.parseInt(degreeGroupId));
			count = mcDegreeGroupRepository.deleteMcDegreeGroupByDegreeGroupId(mcDegreeGroup);
//			count=1;
		return count;
	}
}