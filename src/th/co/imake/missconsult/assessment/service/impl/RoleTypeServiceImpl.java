package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.RoleTypeRepository;
import th.co.imake.missconsult.assessment.service.RoleTypeService;

@Service("roleTypeService")
public class RoleTypeServiceImpl implements RoleTypeService{
	@Autowired
	private RoleTypeRepository roleTypeRepository;
}