package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McResultRepository;
import th.co.imake.missconsult.assessment.service.McResultService;
@Service("mcResultService")
public class McResultServiceImpl implements McResultService{
	@Autowired
	private McResultRepository mcResultRepository;
}