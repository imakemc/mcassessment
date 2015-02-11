package th.co.imake.missconsult.assessment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.imake.missconsult.assessment.model.McOrderM;
import th.co.imake.missconsult.assessment.service.McOrderService;

@Controller
@RequestMapping(value={"/order"})
@SessionAttributes(value={"McOrder"})
public class OrderController {
	@Autowired
	private McOrderService mcOrderService;
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
		 List<McOrderM> mcOrderList=mcOrderService.selectAll();
		 	model.addAttribute("mcOrder", mcOrderList);
	        return "assesment/order";
	    } 
}
