package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McChoiceRepository;
import th.co.imake.missconsult.assessment.service.McChoiceService;

@Service("mcChoiceService")
public class McChoiceServiceImpl implements McChoiceService{
	@Autowired
	private McChoiceRepository mcChoiceRepository;

}