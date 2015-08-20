package th.co.imake.missconsult.assessment.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import th.co.imake.missconsult.assessment.model.McCustomerM;
import th.co.imake.missconsult.assessment.model.McDoAssessmentM;
import th.co.imake.missconsult.assessment.service.McCustomerService;

@Controller
@RequestMapping(value={"/customer"})
@SessionAttributes(value={"McCustomer"})
public class CustomerController {
	@Autowired
	private McCustomerService mcCustomerService;
	
	ModelAndView mav = null;
	
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
         List<McCustomerM> mcCustomerList=mcCustomerService.selectAll();
         	model.addAttribute("mcCustomer", mcCustomerList);
	        return "assesment/customer";
	    } 
	 
//		@ModelAttribute("countryList")
//		public List getCountry()
//		{
//			List countryList = new ArrayList<E>();
//			countryList.add("India");
//			countryList.add("Australia");
//			countryList.add("England");
//			return countryList;
//		}
		
		@RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
		public ModelAndView getQuestionsPage() {
		    List<McDoAssessmentM> questionsList = new ArrayList<McDoAssessmentM>();
		    for (int i = 0; i < 5; i++) {
		    	McDoAssessmentM assessmentM = new McDoAssessmentM();
//		    	assessmentM.set
			}
//		    questionsList.
		    return new ModelAndView("questions", "questionsList", questionsList);
		}
		
}
