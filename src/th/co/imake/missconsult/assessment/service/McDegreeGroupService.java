package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.imake.missconsult.assessment.domain.McDegreeGroup;
import th.co.imake.missconsult.assessment.form.McDegreeGroupForm;


public interface McDegreeGroupService {
	public List<McDegreeGroup> getAllByDegreeId(Integer DegreeId);
	public Integer insertMcDegreeGroupByDegreeId(String DegreeId,String assessor,String mdgName);
	public Integer UpdateMcDegreeGroupByDegreeGroupId(String degreeGroupId,String assessor,String mdgName);
	Integer DeleteMcDegreeGroupByDegreeGroupId(String degreeGroupId);
}