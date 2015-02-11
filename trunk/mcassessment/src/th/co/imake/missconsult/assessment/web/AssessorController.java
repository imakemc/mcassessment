package th.co.imake.missconsult.assessment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.imake.missconsult.assessment.model.McDoAssessmentM;
import th.co.imake.missconsult.assessment.service.McDoAssessmentService;

@Controller
@RequestMapping(value={"/assessor"})
@SessionAttributes(value={"McDoAssessment"})
public class AssessorController {
	@Autowired
	private McDoAssessmentService mcDoAssessmentService;
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
		 List<McDoAssessmentM> mcDoAssessmentList=mcDoAssessmentService.selectAll();
		 	model.addAttribute("mcDoAssessmentList", mcDoAssessmentList);
	        return "assesment/assessor";
	    } 
}
