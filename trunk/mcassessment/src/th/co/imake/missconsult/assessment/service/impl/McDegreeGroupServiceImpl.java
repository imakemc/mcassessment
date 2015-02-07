package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McDegreeGroupRepository;
import th.co.imake.missconsult.assessment.service.McDegreeGroupService;
@Service("mcDegreeGroupService")
public class McDegreeGroupServiceImpl implements McDegreeGroupService{
	@Autowired
	private McDegreeGroupRepository mcDegreeGroupRepository;
}