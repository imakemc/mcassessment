package th.co.imake.missconsult.assessment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.imake.missconsult.assessment.domain.McEvaluation;
import th.co.imake.missconsult.assessment.model.McEvaluationM;
import th.co.imake.missconsult.assessment.service.McEvaluationService;

@Controller
@RequestMapping(value={"/evaluation"})
@SessionAttributes(value={"McEvaluation"})
public class EvaluationController {
	@Autowired
	private McEvaluationService mcEvaluationService;
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
		 List<McEvaluationM> mcEvaluationList=mcEvaluationService.selectAll();
		 	model.addAttribute("mcEvaluationList", mcEvaluationList);
	        return "assesment/evaluation";
	    } 
}