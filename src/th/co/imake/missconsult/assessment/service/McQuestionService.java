package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.imake.missconsult.assessment.domain.McDegree;
import th.co.imake.missconsult.assessment.domain.McQuestion;
import th.co.imake.missconsult.assessment.model.McQuestionM;

public interface McQuestionService {
	public List<McQuestionM> selectAllByMeId(Integer meid);
	public McQuestionM selectAllByMqId(Integer mqid);
	public Integer insertAll(McQuestion mcQuestion);
	public Integer updateByMqId(McQuestion mcQuestion);
	Integer deleteByMqId(Integer mqid);
}