package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McQuestionRepository;
import th.co.imake.missconsult.assessment.service.McQuestionService;
@Service("mcQuestionService")
public class McQuestionServiceImpl implements McQuestionService{
	@Autowired
	private McQuestionRepository mcQuestionRepository;
}