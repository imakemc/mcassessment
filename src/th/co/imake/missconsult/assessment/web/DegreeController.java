package th.co.imake.missconsult.assessment.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import th.co.imake.missconsult.assessment.domain.McDegreeGroup;
import th.co.imake.missconsult.assessment.form.McDegreeForm;
import th.co.imake.missconsult.assessment.form.McDegreeGroupForm;
import th.co.imake.missconsult.assessment.model.McDegreeM;
import th.co.imake.missconsult.assessment.service.McDegreeGroupService;
import th.co.imake.missconsult.assessment.service.McDegreeService;

@Controller
@RequestMapping(value={"/degree"})
@SessionAttributes(value={"McDegree"})
public class DegreeController {
	
	McDegreeForm mcDegreeForm ;
	
//	McDegreeGroupForm  mcDegreeGroupForm;
	
	@Autowired
	private McDegreeService mcDegreeService;
	
	@Autowired
	private McDegreeGroupService mcDegreeGroupService;
	
	 @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public ModelAndView list(Model model, @RequestParam(value="pageNo", required=false) String pageNoStr)
	    {
		 List<McDegreeM> mcDegreeList= mcDegreeService.selectAll();
		 for (McDegreeM mcDegreeM : mcDegreeList) {
			 System.out.println(mcDegreeM.getMdName());
		}
		 McDegreeM degreeM ;
		 for(int i=0;i<50;i++){
			 degreeM = new McDegreeM();
			 degreeM.setMdId(i);
			 degreeM.setMdName("Name "+i);
			 mcDegreeList.add(degreeM);
		 }
		 
	        model.addAttribute("mcDegreeList", mcDegreeList);
	        model.addAttribute("title", "degreeGuop");
//	        return "assesment/degreeGoup"; 
	        
	        return new ModelAndView("assesment/degreeGoup" , "mcDegreeForm", mcDegreeList);
	    } 
	 
		@RequestMapping(value="{/getLsonTest}", method = org.springframework.web.bind.annotation.RequestMethod.GET)
		@ResponseBody
		public  List<McDegreeM>  getLsonTest( @RequestParam int iDisplayStart,
                @RequestParam int iDisplayLength,
                @RequestParam int iColumns,
                @RequestParam String sEcho) {//@PathVariable String name
			System.out.println("#### into getShopInJSON()");
	 
			List<McDegreeM> list = new ArrayList<McDegreeM>();
			McDegreeM degreeM;
			for(int i=0 ; i <5 ; i++){
			degreeM = new McDegreeM();
			degreeM.setMdId(i+20);
			degreeM.setMdName("XX"+(i+20));
			list.add(degreeM);
			}
			return list;
	 
		}
		
		@RequestMapping(value = "/ajaxGetDegreeGroupAll", method = RequestMethod.GET)
	    public @ResponseBody
	    List<McDegreeM>  ajaxGetDegreeGroupAll(@RequestParam String organizationId) {
			System.out.println("organizationId : "+organizationId);

			List<McDegreeM> list =  mcDegreeService.selectAllGroup();

	        return list;
	    }
		
		@RequestMapping(value = "/ajaxGetDegreeGroup", method = RequestMethod.GET)
		public @ResponseBody
		List<McDegreeGroup>  getDegreeGroup(@RequestParam String degreeId) {
			System.out.println("###DegreeId : "+degreeId);
			List<McDegreeGroup> list = new ArrayList<McDegreeGroup>();
			McDegreeGroup degreeGroupM;
			Random rand = new Random();
	        float r = rand.nextFloat() * 100;
			for(int i=0 ; i <50 ; i++){
				degreeGroupM = new McDegreeGroup();
				degreeGroupM.setMdgId(i);
				degreeGroupM.setMdgAssessor(rand.nextInt()+i);
				degreeGroupM.setMdgName("Group"+i);
				list.add(degreeGroupM);
			}
			return mcDegreeGroupService.getAllByDegreeId(Integer.parseInt(degreeId));
//			return list;
		}
		
		@RequestMapping(value = "/ajaxAddDegreeGroup", method = RequestMethod.GET)
		public @ResponseBody
		List  addDegreeGroup(@RequestParam String degreeId ,String groupName , String assessor) {
			System.out.println("###DegreeId : "+degreeId);
			System.out.println("###GroupName : "+groupName);
			System.out.println("###Assessor : "+assessor);
			Integer count =  mcDegreeGroupService.insertMcDegreeGroupByDegreeId(degreeId, assessor, groupName);
			List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
			Map<String , Integer> map = new HashMap<String, Integer>();
			map.put("count", count);
			list.add(map);
			return list;
		}		 
		
		@RequestMapping(value = "/ajaxEditDegreeGroup", method = RequestMethod.GET)
		public @ResponseBody
		List  editDegreeGroup(@RequestParam String mdgId ,String groupName , String assessor) {
			System.out.println("###DegreeGroupId : "+mdgId);
			System.out.println("###GroupName : "+groupName);
			System.out.println("###Assessor : "+assessor);
//			Integer count =  mcDegreeGroupService.insertMcDegreeGroupByDegreeId(degreeId, assessor, groupName);
			Integer count =  mcDegreeGroupService.UpdateMcDegreeGroupByDegreeGroupId(mdgId, assessor, groupName);
			List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
			Map<String , Integer> map = new HashMap<String, Integer>();
			map.put("count", count);
//			map.put("count", 1);
			list.add(map);
			return list;
		}		 
		
		@RequestMapping(value = "/ajaxDeleteDegreeGroup", method = RequestMethod.GET)
		public @ResponseBody
		List  deleteDegreeGroup(@RequestParam String mdgId ,String groupName , String assessor) {
			System.out.println("###DegreeGroupId : "+mdgId);
			System.out.println("###GroupName : "+groupName);
			System.out.println("###Assessor : "+assessor);
			Integer count =  mcDegreeGroupService.DeleteMcDegreeGroupByDegreeGroupId(mdgId);
			List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
			Map<String , Integer> map = new HashMap<String, Integer>();
			map.put("count", count);
//			map.put("count", 1);
			list.add(map);
			return list;
		}		 
		
//		    @RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
//		    public @ResponseBody String addUser(@ModelAttribute(value="user") User user, BindingResult result ){
//		        String returnText;
//		        if(!result.hasErrors()){
////		            userList.add(user);
//		            returnText = "User has been added to the list. Total number of users are ";
//		        }else{
//		            returnText = "Sorry, an error has occur. User has not been added to list.";
//		        }
//		        System.out.println("returnText : "+returnText);
//		        return returnText;
//		    }

		
//	    @RequestMapping(value="/data", method= RequestMethod.POST)
//	    public @ResponseBody
//	    DataTablesResponse<Object> getData(@RequestBody DataTablesRequest dtReq, HttpServletResponse response) {
//	        return new DataTablesResponse<Object>();
//	    }
		
//		@RequestMapping(value="{/xx}", method = org.springframework.web.bind.annotation.RequestMethod.GET)
//		public  String  getLsonTest() {//@PathVariable String name
//			System.out.println("#### into getShopInJSON()");
//	 
//
//			return "xxxx";
//	 
//		}
		
//		@RequestMapping(value="{/getLsonTest}", method = org.springframework.web.bind.annotation.RequestMethod.GET)
//		public @ResponseBody List<McDegreeM>  getLsonTest( @RequestParam int iDisplayStart,
//				@RequestParam int iDisplayLength,
//				@RequestParam int iColumns,
//				@RequestParam String sEcho) {//@PathVariable String name
//			System.out.println("#### into getShopInJSON()");
//			
//			List<McDegreeM> list = new ArrayList<McDegreeM>();
//			McDegreeM degreeM;
//			for(int i=0 ; i <5 ; i++){
//				degreeM = new McDegreeM();
//				degreeM.setMdId(i+20);
//				degreeM.setMdName("XX"+(i+20));
//				list.add(degreeM);
//			}
//			return list;
//			
//		}
}
