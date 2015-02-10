package th.co.imake.missconsult.assessment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.imake.missconsult.assessment.model.McDegreeDTO;
import th.co.imake.missconsult.assessment.service.McDegreeService;

@Controller
@RequestMapping(value={"/degree"})
@SessionAttributes(value={"McDegree"})
public class DegreeController {
	@Autowired
	private McDegreeService mcDegreeService;
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
	       
		 List<McDegreeDTO> mcDegreeList= mcDegreeService.selectAll();
	        model.addAttribute("mcDegreeList", mcDegreeList);
	        return "assesment/degreeGoup";
	    } 
}
