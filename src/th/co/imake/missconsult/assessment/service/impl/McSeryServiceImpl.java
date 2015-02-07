package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McSeryRepository;
import th.co.imake.missconsult.assessment.service.McSeryService;
@Service("mcSeryService")
public class McSeryServiceImpl implements McSeryService{
	@Autowired
	private McSeryRepository mcSeryRepository;
}