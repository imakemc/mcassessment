package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McCustomerAssessmentM;
import th.co.imake.missconsult.assessment.repository.McCustomerAssessmentRepository;
import th.co.imake.missconsult.assessment.service.McCustomerAssessmentService;

@Service("mcCustomerAssessmentService")
public class McCustomerAssessmentServiceImpl implements McCustomerAssessmentService{
	@Autowired
	private McCustomerAssessmentRepository mcCustomerAssessmentRepository;

	@Override
	public List<McCustomerAssessmentM> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveMcCustomerAssessment(
			McCustomerAssessmentM mcCustomerAssessmentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMcCustomerAssessment(
			McCustomerAssessmentM mcCustomerAssessmentDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMcCustomerAssessment(
			McCustomerAssessmentM mcCustomerAssessmentDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchMcCustomerAssessment(
			McCustomerAssessmentM mcCustomerAssessmentDTO, Paging paning) {
		// TODO Auto-generated method stub
		return null;
	}
}