package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.domain.McQuestion;
import th.co.imake.missconsult.assessment.model.McQuestionM;
import th.co.imake.missconsult.assessment.repository.McQuestionRepository;
import th.co.imake.missconsult.assessment.service.McQuestionService;
@Service("mcQuestionService")
public class McQuestionServiceImpl implements McQuestionService{
	@Autowired
	private McQuestionRepository mcQuestionRepository;

	@Override
	public List<McQuestionM> selectAllByMeId(Integer meid) {
		return mcQuestionRepository.selectAllByMeId(meid);
	}

	@Override
	public Integer insertAll(McQuestion mcQuestion) {
		return mcQuestionRepository.insertAll(mcQuestion);
	}
	
	@Override
	public Integer deleteByMqId(Integer mqid){
		return mcQuestionRepository.deleteByMqId(mqid);
	}
}