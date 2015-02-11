package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McEvaluationM;
import th.co.imake.missconsult.assessment.repository.McEvaluationRepository;
import th.co.imake.missconsult.assessment.service.McEvaluationService;
@Service("mcEvaluationService")
public class McEvaluationServiceImpl implements McEvaluationService{
	@Autowired
	private McEvaluationRepository mcEvaluationRepository;

	@Override
	public List<McEvaluationM> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveMcEvaluation(McEvaluationM mcEvaluationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMcEvaluation(McEvaluationM mcEvaluationDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMcEvaluation(McEvaluationM mcEvaluationDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchMcEvaluation(McEvaluationM mcEvaluationDTO, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
} 

