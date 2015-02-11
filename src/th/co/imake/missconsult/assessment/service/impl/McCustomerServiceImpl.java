package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McCustomerM;
import th.co.imake.missconsult.assessment.repository.McCustomerRepository;
import th.co.imake.missconsult.assessment.service.McCustomerService;

@Service("mcCustomerService")
public class McCustomerServiceImpl implements McCustomerService{
	@Autowired
	private McCustomerRepository mcCustomerRepository;

	@Override
	public List<McCustomerM> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveMcCustomer(McCustomerM mcCustomerDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMcCustomer(McCustomerM mcCustomerDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMcCustomer(McCustomerM mcCustomerDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchMcCustomer(McCustomerM mcCustomerDTO, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
	
}