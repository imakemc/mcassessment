package th.co.imake.missconsult.assessment.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.imake.missconsult.assessment.domain.McEvaluation;
import th.co.imake.missconsult.assessment.domain.McQuestion;
import th.co.imake.missconsult.assessment.model.McEvaluationM;
import th.co.imake.missconsult.assessment.model.McQuestionM;
import th.co.imake.missconsult.assessment.service.McEvaluationService;
import th.co.imake.missconsult.assessment.service.McQuestionService;

@Controller
@RequestMapping(value={"/evaluation"})
@SessionAttributes(value={"McEvaluation"})
public class EvaluationController {
	@Autowired
	private McEvaluationService mcEvaluationService;
	
	@Autowired
	private McQuestionService mcQuestionService;
	
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
//		 List<McEvaluationM> mcEvaluationList=mcEvaluationService.selectAll();
//		 	model.addAttribute("mcEvaluationList", mcEvaluationList);
		 	model.addAttribute("title", "Evaluation"); 
	        return "assesment/evaluation";
	    } 
	 
		@RequestMapping(value = "/ajaxGetEvaluationAll", method = RequestMethod.GET)
	    public @ResponseBody
	    List<McEvaluationM>  ajaxGetEvaluationAlll(@RequestParam String organizationId) {
			System.out.println("organizationId : "+organizationId);

			List<McEvaluationM> list =  mcEvaluationService.selectAll();

	        return list;
	    }
		
		@RequestMapping(value = "/ajaxGetEvaluationByEvalId", method = RequestMethod.GET)
	    public @ResponseBody
	    List<McEvaluationM>  ajaxGetEvaluationByEvalId(@RequestParam Integer evalId) {
			System.out.println("evalId : "+evalId);
			List<McEvaluationM> list =  mcEvaluationService.selectByMdId(evalId);
	        return list;
	    }
		
		@RequestMapping(value = "/ajaxGetQuestionAll", method = RequestMethod.GET)
		public @ResponseBody
		List<McQuestionM>  ajaxGetQuestionAll(@RequestParam Integer meid) {
			System.out.println("meid : "+meid);
			List<McQuestionM> list =  mcQuestionService.selectAllByMeId(meid);
			return list;
		}
		
		@RequestMapping(value = "/ajaxSaveAndGetIdEvaluation", method = RequestMethod.GET)
		public @ResponseBody
		List<Map<String, Integer>>  ajaxSaveAndGetIdEvaluation(@RequestParam String evalName, String evalIntro) {
			System.out.println("evalName : "+evalName);
			System.out.println("evalIntro : "+evalIntro);
			McEvaluation evaluation = new McEvaluation();
			evaluation.setMcIntro(evalIntro);
			evaluation.setMeName(evalName);
			Integer id =  mcEvaluationService.insertAll(evaluation);
			List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
			Map<String, Integer> maps = new HashMap<String, Integer>();
			maps.put("id", id);
			list.add(maps);
			return list;
		}
		
		@RequestMapping(value = "/ajaxDeleteEvaluation", method = RequestMethod.GET)
		public @ResponseBody
		List<Map<String, Integer>>  ajaxDeleteEvaluation(@RequestParam Integer id) {
			System.out.println("id : "+id);
			Integer record =  mcEvaluationService.deleteByMeid(id);
			List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
			Map<String, Integer> maps = new HashMap<String, Integer>();
			maps.put("record", record);
			list.add(maps);
			return list;
		}
		
		@RequestMapping(value = "/ajaxDeleteQuestion", method = RequestMethod.GET)
		public @ResponseBody
		List<Map<String, Integer>>  ajaxDeleteQuestion(@RequestParam Integer id) {
			System.out.println("id : "+id);
			Integer record =  mcQuestionService.deleteByMqId(id);
			List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
			Map<String, Integer> maps = new HashMap<String, Integer>();
			maps.put("record", record);
			list.add(maps);
			return list;
		}
		
		@RequestMapping(value = "/ajaxAddEditQuestion", method = RequestMethod.GET)
		public @ResponseBody
		List<Map<String, Integer>>  ajaxAddEditQuestion(@RequestParam Integer id,Integer evalId,String qthai, String qeng,String type) {
			System.out.println("id : "+id);
			System.out.println("evalId : "+evalId);
			System.out.println("qthai : "+qthai);
			System.out.println("qeng : "+qeng);
			System.out.println("type : "+type);
			
			McQuestion mcQuestion = new McQuestion();
			mcQuestion.setMaNameEng(qeng);
			try {
				mcQuestion.setMqNameThai(URLDecoder.decode(qthai, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mcQuestion.setMqId(id);
			McEvaluation mcEvaluation = new McEvaluation();
			mcEvaluation.setMeId(evalId);
			mcQuestion.setMcEvaluation(mcEvaluation);
			
			if("Add".equalsIgnoreCase(type)){
				System.out.println("Add Question");
				id = mcQuestionService.insertAll(mcQuestion);
				
			}else{
				System.out.println("Edit Question");
				
			}
					
			
//			Integer record =  mcQuestionService.deleteByMqId(id);
			List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
			Map<String, Integer> maps = new HashMap<String, Integer>();
			maps.put("id", id);
			
			
//			maps.put("record", record);
			list.add(maps);
			
			return list;
		}
		
}
