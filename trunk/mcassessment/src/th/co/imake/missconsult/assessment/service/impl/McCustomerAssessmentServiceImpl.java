package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McCustomerAssessmentRepository;
import th.co.imake.missconsult.assessment.service.McCustomerAssessmentService;

@Service("mcCustomerAssessmentService")
public class McCustomerAssessmentServiceImpl implements McCustomerAssessmentService{
	@Autowired
	private McCustomerAssessmentRepository mcCustomerAssessmentRepository;
}