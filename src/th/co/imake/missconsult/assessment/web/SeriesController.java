package th.co.imake.missconsult.assessment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.imake.missconsult.assessment.model.McSeriesM;
import th.co.imake.missconsult.assessment.service.McSeriesService;

@Controller
@RequestMapping(value={"/series"})
@SessionAttributes(value={"McSeries"})
public class SeriesController {
	@Autowired
	private McSeriesService mcSeriesService;
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
		 List<McSeriesM> mcSeriesList=mcSeriesService.selectAll();
		 	model.addAttribute("mcSeriesList", mcSeriesList);
	        return "assesment/series";
	    } 
}
