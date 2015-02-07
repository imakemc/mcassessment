package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McDoAssessmentRepository;
import th.co.imake.missconsult.assessment.service.McDoAssessmentService;
@Service("mcDoAssessmentService")
public class McDoAssessmentServiceImpl implements McDoAssessmentService{
	@Autowired
	private McDoAssessmentRepository mcDoAssessmentRepository;
}