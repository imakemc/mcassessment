package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McDoAssessmentM;


public interface McDoAssessmentService {
	public List<McDoAssessmentM> selectAll();
	public Integer saveMcDoAssessment(McDoAssessmentM mcDoAssessmentDTO);
	public int updateMcDoAssessment(McDoAssessmentM mcDoAssessmentDTO);
	public int deleteMcDoAssessment(McDoAssessmentM mcDoAssessmentDTO);
	public List searchMcDoAssessment(McDoAssessmentM mcDoAssessmentDTO, Paging paging);
}