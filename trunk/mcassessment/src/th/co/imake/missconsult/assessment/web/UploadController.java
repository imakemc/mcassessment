package th.co.imake.missconsult.assessment.web;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import th.co.aoe.makedev.missconsult.xstream.MissAccount;
import th.co.aoe.makedev.missconsult.xstream.MissAttach;
import th.co.aoe.makedev.missconsult.xstream.MissCandidate;
import th.co.aoe.makedev.missconsult.xstream.MissContact;
import th.co.aoe.makedev.missconsult.xstream.MissDoc;
import th.co.aoe.makedev.missconsult.xstream.MissFile;
import th.co.aoe.makedev.missconsult.xstream.MissManual;
import th.co.aoe.makedev.missconsult.xstream.MissQuestion;
import th.co.aoe.makedev.missconsult.xstream.MissSeriesAttach;
import th.co.aoe.makedev.missconsult.xstream.MissSery;
import th.co.imake.missconsult.assessment.service.MissExamService;

import com.google.gson.Gson;
import com.mortennobel.imagescaling.ResampleOp;
@Controller
public class UploadController {	
	//private static SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
	//private static SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static Logger logger = Logger.getRootLogger();
	@Autowired
	private MissExamService missExamService;
	private static ResourceBundle bundle;
	static{
		bundle =  ResourceBundle.getBundle( "config" );				
	}
	
	/* @Autowired
    public UploadController(MissExamService missExamService)
    {
        logger.debug("########################### @Autowired WelcomeController #######################");
        this.missExamService = missExamService;
    }*/
    @RequestMapping(value={"/upload/{module}/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public  String doUpload(HttpServletRequest request, Model model, @PathVariable String module,@PathVariable String id)
    {
    	 String ndPathFileGen=null;
    	 MissFile missFile =new MissFile();
    	 String hotLink="";
    	 String s="";
    	 String pathFolder="";
    	 String ndFilePath="";
       /* logger.debug("xxxxxxxxxxxxxxxxxxxxxxxx="+request.getParameter("test"));
        Map m =request.getParameterMap();
        for (Iterator iterator = m.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			String[] key=(String[])m.get(type);
			for (int i = 0; i < key.length; i++) {
			}
		}*/
    	  MultipartHttpServletRequest multipartRequest =(MultipartHttpServletRequest)request;
        MultipartFile multipart = multipartRequest.getFile("userfile");
		if(multipart!=null){
                String contentType = multipart.getContentType();
                 s = multipart.getOriginalFilename();
                logger.debug("fileName ===> "+s);
                logger.debug("contentType ===> "+contentType);
                s = FilenameUtils.getName(s);
                logger.debug("fileName2 ===> "+s);
                String monthStr= "";
				  String yearStr="";
				  
				  //String pathFolder="";
                FileOutputStream fos = null;
					try {  
						byte []filesize = multipart.getBytes(); 
						logger.debug("xxxxxxxxxxxxx="+filesize.length);
						if(filesize.length>0){									
							long current = System.currentTimeMillis();
						org.joda.time.DateTime    dt1  = new org.joda.time.DateTime (new Date().getTime()); 
							
						  monthStr= dt1.getMonthOfYear()+"";
						  yearStr= dt1.getYear()+"";
						  monthStr = monthStr.length()>1?monthStr:"0"+monthStr;
					
						  pathFolder=yearStr+"_"+monthStr+"";
						  ndFilePath = bundle.getString(module+"Path")+pathFolder;
						  String path =ndFilePath;
						  createDirectoryIfNeeded(path);
						  String filename =s ;// multipart.getOriginalFilename();
						  String []filenameSplit  =filename.split("\\.");
						  String extension ="";
						  if(filenameSplit!=null && filenameSplit.length>0){
							  extension =filenameSplit[filenameSplit.length-1];
						  }
						  hotLink=current+""+genToken();
						 ndPathFileGen =hotLink+"."+extension; 
						 pathFolder=pathFolder+"/"+ndPathFileGen;
					//	 FileInputStream fin= new FileInputStream(file)
						 fos = new FileOutputStream(path+"/"+ndPathFileGen);								
						 fos.write(filesize);
						 if(module.equals("candidateImg")){
							/* System.out.println("xxxxxxxx->"+module);
							 System.out.println("path->"+path+"/"+ndPathFileGen);
							 System.out.println("extension->"+extension);*/
							 BufferedImage src=null;
							 
								try {
									src = ImageIO.read(new File(path+"/"+ndPathFileGen));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						         
						         ResampleOp resampleOp = new ResampleOp (180,180);
						      //   resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.VerySharp);
						         BufferedImage rescaled = resampleOp.filter(src, null);
						         
						         try {
									ImageIO.write(rescaled,extension, 
									                 new File(path+"/"+ndPathFileGen));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						 }
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					finally{
						if(fos!=null)
							try {
								fos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	 
					} 
				if(module.equals("mcLogo")){
					 MissAccount missAccount = new MissAccount();
					 missAccount.setMaId(Long.parseLong(id));
					 missAccount.setMaCustomizeLogoFileName(s);
					 missAccount.setMaCustomizeLogoHotlink(hotLink);
					  missAccount.setMaCustomizeLogoPath(pathFolder);
					  missExamService.updateMissAccountLogo(missAccount);
				}else if(module.equals("companyLogo")){
					 MissAccount missAccount = new MissAccount();
					 missAccount.setMaId(Long.parseLong(id));
					 missAccount.setMaCustomizeLogoFileName(s);
					 missAccount.setMaCustomizeLogoHotlink(hotLink);
					  missAccount.setMaCustomizeLogoPath(pathFolder);
					  missExamService.updateMissAccountLogo(missAccount);
				}else if(module.equals("candidateImg")){
					 MissCandidate missCandidate = new MissCandidate();
					 missCandidate.setMcaId(Long.parseLong(id));
					 missCandidate.setMcaPictureFileName(s);
					 missCandidate.setMcaPictureHotlink(hotLink);
					  missCandidate.setMcaPicturePath(pathFolder);
					  missExamService.updateMissCandidatePhoto(missCandidate);
				}else if(module.equals("contactImg")){
								
					 MissContact missContact = new MissContact();
					 missContact.setMcontactId(Long.parseLong(id));
					 missContact.setMcontactPictureFileName(s);
					 missContact.setMcontactPictureHotlink(hotLink);
					  missContact.setMcontactPicturePath(pathFolder);
					  missExamService.updateMissContactPhoto(missContact);
				}else if(module.equals("attachManual")){
					 MissManual missManual = new MissManual();
					 MissSery missSery=new MissSery();
					 missSery.setMsId(Long.parseLong(id));
					 missManual.setMissSery(missSery);
					 missManual.setMmId(Long.parseLong(id));
					 missManual.setMmFileName(s);
					 missManual.setMmHotlink(hotLink);
					 missManual.setMmPath(pathFolder);
					  missExamService.updateMissManual(missManual);
				}else if(module.equals("questionImg")){
					 MissAttach missAttach = new MissAttach();
					 //missAttach.setMatId((Long.parseLong(id));
					 missAttach.setMatFileName(s);
					 missAttach.setMatHotlink(hotLink);
					 missAttach.setMatPath(pathFolder);
					 missAttach.setMatRef(Long.parseLong(id));
					 missAttach.setMatModule(module);
					 missExamService.updateMissAttach(missAttach);
				}else if(module.equals("template")){
					 MissSeriesAttach missSeriesAttach = new MissSeriesAttach();
					 missSeriesAttach.setMsatRef1(Long.parseLong(id));
					 missSeriesAttach.setMsatModule(module);
					 missSeriesAttach.setMsatHotlink(hotLink);
					 missSeriesAttach.setMsatPath(pathFolder);
					 missSeriesAttach.setMsatFileName(s);
					 missExamService.updateMissSeriesAttach(missSeriesAttach);
				}else if(module.equals("evaluation")){
					//String[] ids=id.split("_");
					 MissSeriesAttach missSeriesAttach = new MissSeriesAttach();
					/* missSeriesAttach.setMsatRef1(Long.parseLong(ids[0])); //msId
					 missSeriesAttach.setMsatRef1(Long.parseLong(ids[1])); //meId
*/					 
					// missSeriesAttach.setMsatRef1(Long.parseLong(id)); //msId
					/* missSeriesAttach.setMsatRef1(Long.parseLong(request.getParameter("msId")));
					 missSeriesAttach.setMsatRef2(Long.parseLong(request.getParameter("meId")));*/
					 missSeriesAttach.setMsatRef1(Long.parseLong(id));
					 missSeriesAttach.setMsatModule(module);
					 missSeriesAttach.setMsatHotlink(hotLink);
					 missSeriesAttach.setMsatPath(pathFolder);
					 missSeriesAttach.setMsatFileName(s);
					 missSeriesAttach.setRootPath(bundle.getString(module+"Path"));
					 missExamService.updateMissSeriesAttach(missSeriesAttach);
				}else if(module.equals("doc")){
					//	String[] ids=id.split("_");
					MissDoc missDoc=new MissDoc();
					missDoc.setMdDocName(s);
					missDoc.setMdDocHotlink(hotLink);
					missDoc.setMdDocPath(pathFolder);
					missDoc.setMdDocFileName(s);
					missExamService.saveMissDoc(missDoc);
						//MissSeriesAttach missSeriesAttach =missExamService.findMissSeriesAttachSearch(module,Long.parseLong(ids[0]),Long.parseLong(ids[1]),hotlink);
						
					}
		}
       // return missCandidate;
		missFile.setHotlink(hotLink);
		missFile.setFilename(s);
		missFile.setFilepath(pathFolder);
		Gson gson=new Gson();
		gson.toJson(missFile );
	//	return hotLink;
	 	 return gson.toJson(missFile );
	//	 return "xx" ;
    }
    @RequestMapping(value={"/getfile/{module}/{id}/{hotlink}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public void getFile(HttpServletRequest request,HttpServletResponse response,@PathVariable String module
    		,@PathVariable String id,@PathVariable String hotlink)
    {
    	//String hotlink = request.getQueryString();
		//String []adminview = hotlink.split("&mode=");
    	
		//	String filePath = "/usr/local/Work/TestDownload/1338218105884kqyoujf6uwhsqqwgwqitedq89kpl01u8nitc.jpg";
    	 
    	                                          
    	String  content_type= "image/jpeg";
    	//String  content_disposition= "";
    	String  filename= "";
    	String path= bundle.getString(module+"Path");
    	String ndPathFileGen="";
    	//path+"/"+ndPathFileGen
    	if(module.equals("mcLogo")){
    		MissAccount missAccount= missExamService.findMissAccountById(Long.parseLong(id));
    		ndPathFileGen=path+missAccount.getMaCustomizeLogoPath();
		}else if(module.equals("companyLogo")){
			MissAccount missAccount=missExamService.findMissAccountById(Long.parseLong(id));
	    	ndPathFileGen=path+missAccount.getMaCustomizeLogoPath();
		}else if(module.equals("candidateImg")){
			MissCandidate missCandidate =missExamService.findMissCandidateById(Long.parseLong(id));
			 ndPathFileGen=path+missCandidate.getMcaPicturePath();
		}else if(module.equals("contactImg")){
			MissContact missContact=missExamService.findMissContactById(Long.parseLong(id));
			 ndPathFileGen=path+missContact.getMcontactPicturePath();
		}else if(module.equals("attachManual")){
			MissManual missManual=missExamService.findMissManualById(Long.parseLong(id));
			 ndPathFileGen=path+missManual.getMmPath();
			 content_type="application/pdf";
			 //content_disposition="attachment; filename="+missManual.getMmFileName();
			 filename=missManual.getMmFileName();
		}else if(module.equals("questionImg")){
			
			MissQuestion missQuestion =missExamService.findMissQuestionById(Long.parseLong(id));
			if(hotlink.equals("0")){//thai
				 ndPathFileGen=path+missQuestion.getMqImgTh1();
			}else{
				ndPathFileGen=path+missQuestion.getMqImgEng1();
			}
			
			/*MissAttach missAttach =missExamService.findMissAttachById(module,Long.parseLong(id),hotlink);
			 ndPathFileGen=path+missAttach.getMatPath();*/
		}else if(module.equals("template")){ // jasper
			MissSeriesAttach missSeriesAttach =missExamService.findMissSeriesAttachSearch(module,Long.parseLong(id),null,hotlink);
			 ndPathFileGen=path+missSeriesAttach.getMsatPath();
			 content_type="";
			 //content_disposition="attachment; filename="+missSeriesAttach.getMsatFileName();
			 filename=missSeriesAttach.getMsatFileName();
		}else if(module.equals("evaluation")){
		//	String[] ids=id.split("_");
			MissSeriesAttach missSeriesAttach =missExamService.findMissSeriesAttachSearch(module,Long.parseLong(id),null,hotlink);
			//MissSeriesAttach missSeriesAttach =missExamService.findMissSeriesAttachSearch(module,Long.parseLong(ids[0]),Long.parseLong(ids[1]),hotlink);
			 ndPathFileGen=path+missSeriesAttach.getMsatPath();
			 content_type="application/vnd.ms-excel";
			 //content_disposition="attachment; filename="+missSeriesAttach.getMsatFileName();
			 filename=missSeriesAttach.getMsatFileName();
			 //content_disposition="attachment; filename=ทดสอบ.xls";
		}
		else if(module.equals("doc")){
			//	String[] ids=id.split("_");
			MissDoc missDoc =missExamService.findMissDocById(Long.parseLong(id));
				//MissSeriesAttach missSeriesAttach =missExamService.findMissSeriesAttachSearch(module,Long.parseLong(ids[0]),Long.parseLong(ids[1]),hotlink);
				 ndPathFileGen=path+missDoc.getMdDocPath();
				 content_type="application/pdf";
				// content_disposition="attachment; filename="+missDoc.getMdDocFileName();
				 filename=missDoc.getMdDocFileName();
			}
    	//String filePath =  bundle.getString(module+"Path")+hotlink+".jpg";
		//	String fileName = null;
			  
			//	String filenameStr ="เทสfชาติชาย.jpg";// fileName.trim().replaceAll(" ","_");
				//response.setHeader("Content-Type", "application/octet-stream; charset=tis620");
    	    if(content_type.length()>0)
				response.setHeader("Content-Type", content_type);
			if(filename.length()>0){
				String userAgent = request.getHeader("user-agent");
				boolean isInternetExplorer = (userAgent.indexOf("MSIE") > -1);
				// filename="ทดสอบ โอ๋.xls";
				//System.out.println(fileName);
				byte[] fileNameBytes=null;
				try {
					fileNameBytes = filename.getBytes((isInternetExplorer) ? ("windows-1250") : ("utf-8"));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//byte[] fileNameBytes=null;
				/*try {
					fileNameBytes = fileName.getBytes(("utf-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			    String dispositionFileName = "";
				 //for (byte b: fileNameBytes) dispositionFileName += (char)(b & 0xff);
			    for (byte b: fileNameBytes) dispositionFileName += (char)(b & 0xff);

				 String disposition = "attachment; filename=\"" + dispositionFileName + "\"";
				 response.setHeader("Content-disposition", disposition);
				//response.addHeader("Content-Disposition",content_disposition);
			}
			//	logger.debug(" filenameStr==>"+filenameStr);
			/*	response.addHeader("content-disposition",
				        "attachment; filename=\"\u0e01เทสfชาติชาย.jpg\"");*/
			/*	response.addHeader("content-disposition",
				        "inline; filename="+filenameStr.trim());*/
			File file = new File(ndPathFileGen);

			boolean fileExists = file.exists();
			if(fileExists){
				InputStream in = null;
			      OutputStream out=null;
				try {
					out = response.getOutputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			      InputStream stream  = null;
			      try {   
			    		  stream = new FileInputStream(file);
			    		 
					         in = new BufferedInputStream(stream);
			         while (true) {
			            int data = in.read();
			            if (data == -1) {
			               break;
			            }
			            out.write(data);
			         }
			      }catch (Exception e) {
			    	  e.printStackTrace();
					// TODO: handle exception
				 } finally {
			         if (in != null) {
			            try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			         }
			         if (stream != null) {
			        	 try {
							stream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				         } 
			         if (out != null) {
			            try { 
							  out.flush();
						      out.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			         }
				 }
			    }
    }
    @RequestMapping(value={"/deletefile/doc/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    public  String deletefile(HttpServletRequest request, Model model,@PathVariable String id)
    {
    	MissDoc missDoc =new MissDoc();
    	missDoc.setMdId(Long.valueOf(id));
    	 missExamService.deleteMissDoc(missDoc); 
    	 return "";
    }
    private void createDirectoryIfNeeded(String directoryName)
  	 {
  	   File theDir = new File(directoryName);

  	   // if the directory does not exist, create it
  	   if (!theDir.exists())
  	   {
  		   //boolean cancreate = theDir.mkdir();
  		   theDir.mkdir();
  	   }
  	  
  	 }
      private String genToken(){
  		StringBuffer sb = new StringBuffer();
  	    for (int i = 36; i > 0; i -= 12) {
  	      int n = Math.min(12, Math.abs(i));
  	      sb.append(org.apache.commons.lang.StringUtils.leftPad(Long.toString(Math.round(Math.random() * Math.pow(36, n)), 36), n, '0'));
  	    }
  	    return sb.toString();
   }
}
