package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.domain.McEvaluation;
import th.co.imake.missconsult.assessment.model.McEvaluationM;


public interface McEvaluationService {
	public List<McEvaluationM> selectAll();
	public Integer saveMcEvaluation(McEvaluationM mcEvaluationDTO);
	public int updateMcEvaluation(McEvaluationM mcEvaluationDTO);
	public int deleteMcEvaluation(McEvaluationM mcEvaluationDTO);
	public List searchMcEvaluation(McEvaluationM mcEvaluationDTO, Paging paging);
	public Integer insertAll(McEvaluation evaluation);
	List<McEvaluationM> selectByMdId(Integer mdid);
	int deleteByMeid(Integer meid);
	
}