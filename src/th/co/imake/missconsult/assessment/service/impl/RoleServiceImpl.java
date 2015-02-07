package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.RoleRepository;
import th.co.imake.missconsult.assessment.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository roleRepository;
}