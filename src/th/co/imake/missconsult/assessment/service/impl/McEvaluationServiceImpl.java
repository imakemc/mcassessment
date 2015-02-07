package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McEvaluationRepository;
import th.co.imake.missconsult.assessment.service.McEvaluationService;
@Service("mcEvaluationService")
public class McEvaluationServiceImpl implements McEvaluationService{
	@Autowired
	private McEvaluationRepository mcEvaluationRepository;
}