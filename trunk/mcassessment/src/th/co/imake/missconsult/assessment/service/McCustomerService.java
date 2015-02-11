package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McCustomerM;



public interface McCustomerService {
	public List<McCustomerM> selectAll();
	public Integer saveMcCustomer(McCustomerM mcCustomerDTO);
	public int updateMcCustomer(McCustomerM mcCustomerDTO);
	public int deleteMcCustomer(McCustomerM mcCustomerDTO);
	public List searchMcCustomer(McCustomerM mcCustomerDTO, Paging paging);

}