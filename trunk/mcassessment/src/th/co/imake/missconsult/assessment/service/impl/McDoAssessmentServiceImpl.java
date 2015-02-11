package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McDoAssessmentM;
import th.co.imake.missconsult.assessment.repository.McDoAssessmentRepository;
import th.co.imake.missconsult.assessment.service.McDoAssessmentService;
@Service("mcDoAssessmentService")
public class McDoAssessmentServiceImpl implements McDoAssessmentService{
	@Autowired
	private McDoAssessmentRepository mcDoAssessmentRepository;

	@Override
	public List<McDoAssessmentM> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveMcDoAssessment(McDoAssessmentM mcDoAssessmentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMcDoAssessment(McDoAssessmentM mcDoAssessmentDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMcDoAssessment(McDoAssessmentM mcDoAssessmentDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchMcDoAssessment(McDoAssessmentM mcDoAssessmentDTO,
			Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
}