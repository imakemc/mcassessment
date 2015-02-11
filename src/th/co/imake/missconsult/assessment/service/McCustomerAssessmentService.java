package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McCustomerAssessmentM;



public interface McCustomerAssessmentService {
	public List<McCustomerAssessmentM> selectAll();
	public Integer saveMcCustomerAssessment(McCustomerAssessmentM mcCustomerAssessmentDTO);
	public int updateMcCustomerAssessment(McCustomerAssessmentM mcCustomerAssessmentDTO);
	public int deleteMcCustomerAssessment(McCustomerAssessmentM mcCustomerAssessmentDTO);
	public List searchMcCustomerAssessment(McCustomerAssessmentM mcCustomerAssessmentDTO, Paging paning);
}