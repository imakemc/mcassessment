package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.domain.McEvaluation;
import th.co.imake.missconsult.assessment.model.McEvaluationM;
import th.co.imake.missconsult.assessment.repository.McEvaluationRepository;
import th.co.imake.missconsult.assessment.service.McEvaluationService;
@Service("mcEvaluationService")
public class McEvaluationServiceImpl implements McEvaluationService{
	@Autowired
	private McEvaluationRepository mcEvaluationRepository;

	@Override
	public List<McEvaluationM> selectAll() {
		return mcEvaluationRepository.selectAll();
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
		
		return 0;
	}
	
	@Override
	public int deleteByMeid(Integer meid) {
		
		return mcEvaluationRepository.deleteByMeId(meid);
	}

	@Override
	public List searchMcEvaluation(McEvaluationM mcEvaluationDTO, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertAll(McEvaluation evaluation) {
		Integer id = mcEvaluationRepository.insertAll(evaluation);
//			Integer id = mcEvaluationRepository.getLastId();
		return id;
	}
	@Override
	public List<McEvaluationM> selectByMdId(Integer mdid){
		return mcEvaluationRepository.selectByMdId(mdid);
	}
} 

