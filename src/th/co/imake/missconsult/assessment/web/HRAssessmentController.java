package th.co.imake.missconsult.assessment.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value={"/hr"})
@SessionAttributes(value={"McDegree"})
public class HRAssessmentController {
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
	        return "assesment/degreeGoup";
	    } 
}
