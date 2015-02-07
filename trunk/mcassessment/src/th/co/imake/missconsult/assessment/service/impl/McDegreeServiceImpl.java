package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McDegreeRepository;
import th.co.imake.missconsult.assessment.service.McDegreeService;

@Service("mcDegreeService")
public class McDegreeServiceImpl implements McDegreeService{
	@Autowired
	private McDegreeRepository mcDegreeRepository;
}