package th.co.imake.missconsult.assessment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.imake.missconsult.assessment.model.McCustomerAssessmentM;
import th.co.imake.missconsult.assessment.service.McCustomerAssessmentService;

@Controller
@RequestMapping(value={"/HRAssessment"})
@SessionAttributes(value={"McCustomerAssessment"})
public class HRAssessmentController {
	@Autowired
	private McCustomerAssessmentService mcCustomerAssessmentService;
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
		 List<McCustomerAssessmentM> mcCustomerAssessmentList=mcCustomerAssessmentService.selectAll();
		 	model.addAttribute("mcCustomerAssessment", mcCustomerAssessmentList);
	        return "assesment/HRAssessment";
	    } 
}
