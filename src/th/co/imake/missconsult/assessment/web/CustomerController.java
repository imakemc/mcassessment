package th.co.imake.missconsult.assessment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.imake.missconsult.assessment.model.McCustomerM;
import th.co.imake.missconsult.assessment.service.McCustomerService;

@Controller
@RequestMapping(value={"/customer"})
@SessionAttributes(value={"McCustomer"})
public class CustomerController {
	@Autowired
	private McCustomerService mcCustomerService;
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
         List<McCustomerM> mcCustomerList=mcCustomerService.selectAll();
         	model.addAttribute("mcCustomer", mcCustomerList);
	        return "assesment/customer";
	    } 
}
