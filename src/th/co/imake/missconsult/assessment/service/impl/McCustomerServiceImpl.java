package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McCustomerRepository;
import th.co.imake.missconsult.assessment.service.McCustomerService;

@Service("mcCustomerService")
public class McCustomerServiceImpl implements McCustomerService{
	@Autowired
	private McCustomerRepository mcCustomerRepository;
}