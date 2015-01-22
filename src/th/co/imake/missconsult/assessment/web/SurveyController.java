// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 5/27/2012 12:05:58 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SurveyController.java

package th.co.imake.missconsult.assessment.web;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.aoe.makedev.missconsult.xstream.MissSeriesParticipantsMap;
import th.co.aoe.makedev.missconsult.xstream.MissSery;
import th.co.aoe.makedev.missconsult.xstream.MissSurveySend;
import th.co.imake.missconsult.assessment.form.SurveyForm;
import th.co.imake.missconsult.assessment.mail.MailRunnable;
import th.co.imake.missconsult.assessment.service.MissExamService;

@Controller
@RequestMapping(value={"/survey"})
@SessionAttributes(value={"surveyForm"})
public class SurveyController
{
	  private static String MAIL_SERVER = "";
	  private static String MAIL_PROTOCAL = "";
	  private static String MAIL_PORT="";
	  private static String MAIL_USE_AUTHEN="";
	  private static String MAIL_EMAIL="";
	  private static String MAIL_PASSWORD=""; 
	  private static String MAIL_PERSONAL_NAME="";
	  private static String MAIL_TLS="";
	  private static ResourceBundle bundle;
		static{
			bundle =  ResourceBundle.getBundle( "config" );		
			MAIL_SERVER=bundle.getString("mail.host");
			MAIL_PROTOCAL=bundle.getString("mail.protocal");
			MAIL_USE_AUTHEN=bundle.getString("mail.useAuthen");
			MAIL_PORT=bundle.getString("mail.port");
			MAIL_EMAIL=bundle.getString("mail.email");
			MAIL_PASSWORD=bundle.getString("mail.password");
			MAIL_PERSONAL_NAME=bundle.getString("mail.personal_name");
			MAIL_TLS=bundle.getString("mail.TLS");
		}
   /* @Autowired
    public SurveyController(MissExamService missExamService)
    {
        logger.debug("########################### @Autowired SurveyController #######################");
        this.missExamService = missExamService;
    }*/

    @RequestMapping(value={"/init/{maId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getToDoList(Model model,@PathVariable Long maId)
    {
      //  logger.debug((new StringBuilder("testtttttttttt")).append(missExamService).toString());
    	SurveyForm surveyForm =new SurveyForm();
    	surveyForm.setMaId(maId);
    	model.addAttribute("surveyForm", surveyForm);
    	model.addAttribute("display", "display: none");
    	model.addAttribute("message", "");
    	 model.addAttribute("missSeries", missExamService.listMissSery(1l));
        return "exam/template/surveySend";
    }
 
  /*  @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value={"/sendmail"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String sendMail(@ModelAttribute(value="surveyForm") SurveyForm surveyForm, BindingResult result, Model model)
    {
    	int resultReturn=0;
    	if(surveyForm.getSurvey_email().length>=surveyForm.getAmountSend()){
    		 Random randomGenerator = new Random();
    		 
			Map map=new HashMap<String,String >();
    		 while (map.size()<surveyForm.getAmountSend()) {
    			  int randomInt = randomGenerator.nextInt(surveyForm.getSurvey_email().length-1);
    			  map.put(randomInt+"", randomInt+"");
    		}
    	
    		 List<List<String>> userEmail =new ArrayList<List<String>>(map.size());
    		 
    		 for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
    			 String key = (String) iterator.next();
    			 int keyInt=Integer.parseInt(key);
    			 List<String> email = new ArrayList<String>(2);
    			 email.add(surveyForm.getSurvey_name()[keyInt]);
    			 email.add(surveyForm.getSurvey_email()[keyInt]);
    			 userEmail.add(email);		
			}
    		 MissSurveySend missSurveySend =new MissSurveySend();
    		
    		 missSurveySend.setMaId(surveyForm.getMaId());
    		 MissSery missSery = new MissSery();
    		 missSery.setMsId(surveyForm.getMsId());
    		 missSurveySend.setMissSery(missSery);
    		 missSurveySend.setUserEmail(userEmail);
    		 //resultReturn=
    		 List<List<String>> candidateReturn= missExamService.sendSurvey(missSurveySend);
    		 if(candidateReturn!=null && candidateReturn.size()>0)
    			 resultReturn=1;
			List recipientsCC=null;
			List recipientsBCC=null;
    		 byte[] fileSize=null;
    		 String subject=surveyForm.getSubject();//"Aoe";
    		 String mailMessage=surveyForm.getMailMessage();//"Mail Message";
    		 
			List recipients=null;
    		 String message=null;
    		 if(candidateReturn!=null && candidateReturn.size()>0){
    			 for (int i = 0; i < candidateReturn.size(); i++) {
    				 List<String> list=candidateReturn.get(i);
    				 recipients=new ArrayList(1);    				 
    				 recipients.add(list.get(3));
    				 message=mailMessage.replaceAll("\\$\\{name\\}", list.get(2));
    				 message=message.replaceAll("\\$\\{username\\}", list.get(0));
    				 message=message.replaceAll("\\$\\{password\\}", list.get(1));
    				 // ${name} , ${candidate} , ${password}
    				 MailRunnable mailRunnableToTeam = new MailRunnable(
    		  					MAIL_PROTOCAL, MAIL_SERVER, MAIL_EMAIL
    		  							, MAIL_PASSWORD, MAIL_USE_AUTHEN,
    		  							recipients, subject,
    		  							message, "99",MAIL_PERSONAL_NAME,MAIL_PORT,recipientsCC,recipientsBCC,fileSize,MAIL_TLS);
    		    			 Thread mailThreadToTeam = new Thread(
    		  					mailRunnableToTeam);
    		    			 mailThreadToTeam.start();
				}
    			
    		 }
    	}
    	model.addAttribute("display", "display: block");
    	model.addAttribute("message", ((resultReturn==1)?"Send Success !!!":"Send not Success [ Unit not enough ] !!!"));
    	 model.addAttribute("missSeries", missExamService.listMissSery(1l));
    	 model.addAttribute("surveyForm", surveyForm);
    	 model.addAttribute("message_class", ((resultReturn==1)?"success":"error"));
     
    	 return "exam/template/surveySend";
    }*/
    @SuppressWarnings({ "unchecked", "rawtypes" })
  	@RequestMapping(value={"/sendmail"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
      public String sendMail(HttpServletRequest request,@ModelAttribute(value="surveyForm") SurveyForm surveyForm, BindingResult result, Model model)
      {
      	int resultReturn=0;
    	//System.out.println("surveyForm.getSurvey_email()->"+request.getParameterValues("survey_email"));
      	/* Random randomGenerator = new Random();
      	 String[] amountSendArray=surveyForm.getAmountSendArray();
    		Map map=new HashMap<String,String >();
		 while (map.size()<surveyForm.getAmountSend()) {
			  int randomInt = randomGenerator.nextInt(surveyForm.getSurvey_email().length-1);
			  map.put(randomInt+"", randomInt+"");
		}
   		 List<List<String>> userEmail =new ArrayList<List<String>>(map.size());
		 
		 for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			 String key = (String) iterator.next();
			 int keyInt=Integer.parseInt(key);
			 List<String> email = new ArrayList<String>(2);
			 email.add(surveyForm.getSurvey_name()[keyInt]);
			 email.add(surveyForm.getSurvey_email()[keyInt]);
			 userEmail.add(email);		
		}*/
      	/*System.out.println("surveyForm.getSurvey_email()->"+surveyForm.getSurvey_email());
      	System.out.println("surveyForm.getParticipant_msId()->"+surveyForm.getParticipant_msId());
      	System.out.println("surveyForm.getMaId())->"+surveyForm.getMaId());*/
      	if(surveyForm.getSurvey_email().length>0){
      		//amountSendArray
      		
      		int size=surveyForm.getSurvey_email().length;
      		MissSurveySend surveySend=new MissSurveySend();
      		List<MissSurveySend>  surveySends = new ArrayList<MissSurveySend>();
      		 MissSery missSery = new MissSery();
      		 String[] survey_emails=surveyForm.getSurvey_email();
      		 String[] survey_names=surveyForm.getSurvey_name();
      		 String[] survey_groups=surveyForm.getSurvey_group();
      		 missSery.setMsId(surveyForm.getParticipant_msId());
      		for (int i = 0; i < size; i++) {
      			 MissSurveySend missSurveySend =new MissSurveySend();
          		
          		 missSurveySend.setMissSery(missSery);
          		 missSurveySend.setMsEmail(survey_emails[i]);
          		 missSurveySend.setMsName(survey_names[i]);
          		 // missSurveySend.setUserEmail(survey_emails[i]);
          		 missSurveySend.setMssStatus("0");
          		 missSurveySend.setMspmGroupName(survey_groups[i]);
          		 missSurveySend.setMaId(surveyForm.getMaId());
          		 surveySends.add(missSurveySend);
			}
      		surveySend.setMaId(surveyForm.getMaId());
      		surveySend.setMissSurveySendList(surveySends);
      		 //resultReturn=
      		List<List<String>> candidateReturn= missExamService.sendSurvey(surveySend);
      		 if(candidateReturn!=null && candidateReturn.size()>0)
      			 resultReturn=1;
  			List recipientsCC=null;
  			List recipientsBCC=null;
      		 byte[] fileSize=null;
      		 String subject=surveyForm.getSubject();//"Aoe";
      		 String mailMessage=surveyForm.getMailMessage();//"Mail Message";
      		 
  			List recipients=null;
      		 String message=null;
      		 if(candidateReturn!=null && candidateReturn.size()>0){
      			 for (int i = 0; i < candidateReturn.size(); i++) {
      				 List<String> list=candidateReturn.get(i);
      				 recipients=new ArrayList(1);    				 
      				 recipients.add(list.get(3));
      				 message=mailMessage.replaceAll("\\$\\{name\\}", list.get(2));
      				 message=message.replaceAll("\\$\\{username\\}", list.get(0));
      				 message=message.replaceAll("\\$\\{password\\}", list.get(1));
      				 // ${name} , ${candidate} , ${password}
      				 MailRunnable mailRunnableToTeam = new MailRunnable(
      		  					MAIL_PROTOCAL, MAIL_SERVER, MAIL_EMAIL
      		  							, MAIL_PASSWORD, MAIL_USE_AUTHEN,
      		  							recipients, subject,
      		  							message, "99",MAIL_PERSONAL_NAME,MAIL_PORT,recipientsCC,recipientsBCC,fileSize,MAIL_TLS);
      		    			 Thread mailThreadToTeam = new Thread(
      		  					mailRunnableToTeam);
      		    			 mailThreadToTeam.start();
  				}
      			
      		 }
      	}
      	model.addAttribute("display", "display: block");
      	model.addAttribute("message", ((resultReturn==1)?"Send Success !!!":"Send not Success [ Unit not enough ] !!!"));
      	 model.addAttribute("missSeries", missExamService.listMissSery(1l));
      	 model.addAttribute("surveyForm", surveyForm);
      	 model.addAttribute("message_class", ((resultReturn==1)?"success":"error"));
       
      	 return "exam/template/surveySend";
      }
    @RequestMapping(value={"/participantSection/{msId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String participantSection(Model model,@PathVariable Long msId)
	    { 
   	List<MissSeriesParticipantsMap> missSeriesParticipantsMaps =	missExamService.listMissSeriesParticipantsMap(msId);
  	 model.addAttribute("missSeriesParticipantsMaps", missSeriesParticipantsMaps);
  //	System.out.println(vresult.getResultListObj());
  	 model.addAttribute("participant_msId", msId);
  	  return "exam/template/surveyParticipantSection";
	    }

  //  private static Logger logger = Logger.getRootLogger();
    @Autowired
    private MissExamService missExamService;

}
