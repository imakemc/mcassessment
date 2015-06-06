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
import th.co.imake.missconsult.assessment.model.McChoiceM;
import th.co.imake.missconsult.assessment.model.McEvaluationM;
import th.co.imake.missconsult.assessment.model.McQuestionM;
import th.co.imake.missconsult.assessment.service.McChoiceService;
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
	
	@Autowired
	private McChoiceService  mcChoiceService;
	
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
//			List<McChoiceM> choiceMs = mcChoiceService.findMcChoiceByMqId(list.get(0).getMqId());
//			List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("McQuestion", list);
//			map.put("McChoice", choiceMs);
//			result.add(map);
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
		
		@RequestMapping(value = "/ajaxAddEditQuestion", method = RequestMethod.POST)
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
				mcQuestion.setMqNameThai(qthai);
//				MCQUESTION.SETMQNAMETHAI(URLDECODER.DECODE(QTHAI, "UTF-8"));
			} catch (Exception e) {
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
				mcQuestionService.updateByMqId(mcQuestion);
			}
					
			
//			Integer record =  mcQuestionService.deleteByMqId(id);
			List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
			Map<String, Integer> maps = new HashMap<String, Integer>();
			maps.put("id", id);
			
			
//			maps.put("record", record);
			list.add(maps);
			
			return list;
		}
		
		
		@RequestMapping(value = "/ajaxAddEditChoices", method = RequestMethod.POST)
		public @ResponseBody
		List<Map<String, Integer>>  ajaxAddEditChoices(@RequestParam(value="choices", required=false) String[][] choices ,@RequestParam(value="choicesDelete", required=false) String[][] choicesDelete ,@RequestParam String questionId) {
			System.out.println("Choices : "+choices);
			System.out.println("choicesDelete : "+choicesDelete);
//			Integer record =  mcQuestionService.deleteByMqId(id);
			Map<String, Integer> maps = new HashMap<String, Integer>();
			Integer record =  mcChoiceService.updateAddMcChoice(choices,questionId);
			Integer recordDel=0;
			if(choicesDelete!=null && choicesDelete.length>0){
				recordDel =  mcChoiceService.deleteMcChoiceAll(choicesDelete);
			}
			List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
			maps.put("record", record);
			maps.put("recordDelete", recordDel);
//			maps.put("recordTotal", recordDel+record);
//			maps.put("record", 0);
			list.add(maps);
			return list;
		}
		
		@RequestMapping(value = "/ajaxGetAllQuestionAndChoices", method = RequestMethod.POST)
		public @ResponseBody
		List<Map<String, Object>>  ajaxGetAllQuestionAndChoices(@RequestParam Integer mqId ) {
			System.out.println("mqId : "+mqId);
//			System.out.println("mcId : "+mcId);
			
			McQuestionM mcQuestionM = mcQuestionService.selectAllByMqId(mqId);
			List<McChoiceM> choices = mcChoiceService.findMcChoiceByMqId(mqId);
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("mcQuestion", mcQuestionM);
			maps.put("McChoice", choices);
//			maps.put("record", 0);
			list.add(maps);
			return list;
		}
//		
//		
//		@RequestMapping(value = "/ajaxAddEditChoices", method = RequestMethod.POST)
//		public @ResponseBody
//		List<Map<String, Integer>>  ajaxAddEditChoices(@RequestParam String choices ) {
//			System.out.println("Choices : "+choices);
////			Integer record =  mcQuestionService.deleteByMqId(id);
//			List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
//			Map<String, Integer> maps = new HashMap<String, Integer>();
////			maps.put("record", record);
//			maps.put("record", 0);
//			list.add(maps);
//			return list;
//		}
}

