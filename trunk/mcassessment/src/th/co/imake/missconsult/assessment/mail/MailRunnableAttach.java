package th.co.imake.missconsult.assessment.mail;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.lang.StringEscapeUtils;

import th.co.aoe.makedev.missconsult.xstream.MissReportAttach;
import th.co.imake.missconsult.assessment.service.MissExamService;

import com.sun.mail.smtp.SMTPTransport;

public class MailRunnableAttach implements Runnable {
//	private static final Logger logger = Logger.getRootLogger();
	private MissExamService missExamService;
	private Long msId;
	private Long mtrId;
	private String mailAttachReport;
	private String msOrder;
	private String mraLang;
	private String rootPath;
	
	String subject = null;
	String messagebody = null;
	String sessionId= null;
	String protocal=null;
	String  host=null;
	String email =null;
	String  password=null;
	String  useAuthen=null;
	@SuppressWarnings("rawtypes")
	List recipients=null;
	@SuppressWarnings("rawtypes")
	List recipients_cc=null;
	@SuppressWarnings("rawtypes")
	List recipients_bcc=null;
	byte[] fileSize=null;
	String personal_name=null;
	String port=null;
	String tls=null;
/*	MailRunnableAttach mailRunnableToTeam = new MailRunnableAttach(resultForm.getMissTestResult().getMsId(),
			missExamService,resultForm.getMailAttachReport(),resultForm.getMsOrder(),resultForm.getMraLang(),*/
	public MailRunnableAttach(MissExamService missExamService,Long mtrId,Long msId,String mailAttachReport,
			String msOrder,String mraLang,String rootPath,String protocal_,String  host_,String email_ ,String  password_,String  useAuthen_,
			@SuppressWarnings("rawtypes") List recipients,
			String subject,String messagebody,String sessionId,String personal_name,String port,
			@SuppressWarnings("rawtypes") List recipients_cc,@SuppressWarnings("rawtypes") List recipients_bcc,String tls) {
		this.missExamService=missExamService;
		this.mtrId=mtrId;
		this.msId=msId;
		this.mailAttachReport=mailAttachReport;
		this.msOrder=msOrder;
		this.mraLang=mraLang;
		this.rootPath=rootPath;
		this.subject = subject;
		this.messagebody = messagebody;
		this.sessionId = sessionId;
		this.protocal=protocal_;
		this. host=host_;
		this.email =email_;
		this. password=password_;
		this. useAuthen=useAuthen_;
		this.recipients=recipients;
		this.personal_name=personal_name;
		this.port=port;
		this.recipients_cc=recipients_cc;
		this.recipients_bcc=recipients_bcc;
		//this.fileSize=fileSize;
		this.tls=tls;
	}
	public void run() { 
		File temp  = null;
		Properties props = new Properties();
		    // XXX - could use Session.getTransport() and Transport.connect()
		    // XXX - assume we're using SMTP
		    //if (mailhost != null)		
	/*	String protocal =protocal_;
		String host =host_;
		String useAuthen = useAuthen_;
		String email = email_;
		String password = password_; */
	    boolean isAuthen = false;
			//props.put("mail.transport.protocol", protocal);//"smtp");
	    props.put("protocol", protocal);//"smtp");
			if(tls!=null && tls.toLowerCase().equals("1"))
				props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host", host);//"smtp.gmail.com");
			props.put("mail.smtp.port",port);
			
			 
			//props.put("mail.smtp.ssl.enable", "true");
			if(useAuthen!=null && useAuthen.equals("1")){
				isAuthen = true;
			}
			if(isAuthen)
			  props.put("mail.smtp.auth", "true");
			// Get a Session object 
		   
		    
		   /* Construct the message and send it.
		     */
		   // MimeMessage msg = new MimeMessage(session); 
		    
		  /*  try {
				msg.setFrom(new InternetAddress(email));//"chatchai@vlink.co.th"));
			} catch (AddressException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
		//	String[] recipients=null;
			//if(ntcNewsLetterRecipient!=null && ntcNewsLetterRecipient.size()>0){
			 	int size = recipients.size();
				//recipients= new String[1];
			 	for (int i = 0; i < size; i++) {
					
					 //Session session = Session.getInstance(props, null);
					 Session session = Session.getDefaultInstance(props, null);
					    session.setDebug(false);
				//	NtcNewsLetterRecipient ntcNewsLetterRecipient = (NtcNewsLetterRecipient)ntcNewsLetterRecipientList.get(i);
				//	recipients[0] = "siripornc@pttep.com";//ntcNewsLetterRecipient.getNnlrAddress().trim();
				/*		recipients[0] = "chatchai@vlink.co.th";//ntcNewsLetterRecipient.getNnlrAddress().trim();
					logger.debug(" sent mail loopxx  email "+recipients[0]);*/
			/*else{
				recipients= new String[0];
			}*/
			MimeMessage msgArray[] = null;// new MimeMessage(session); 
			try {
				msgArray = new MimeMessage[1];//recipients.length];  
		    	InternetAddress[] addressTo = new InternetAddress[1];//recipients.length];
		    	Date date = new Date();
		    	StringBuffer sb = new StringBuffer();
				sb.append("<HTML>\n");
				sb.append("<HEAD>\n");
				sb.append("<TITLE>\n");
				sb.append(" MissConsult " + "\n");
				sb.append("</TITLE>\n");
				sb.append("</HEAD>\n");
				sb.append("<BODY>\n");
				sb.append(messagebody);
				sb.append("\n");
				sb.append("</BODY>\n");
				sb.append("</HTML>\n");
				MimeBodyPart mbp1 = new MimeBodyPart(); 
				String message = StringEscapeUtils.unescapeHtml(sb.toString());
				mbp1.setContent(message, "text/html; charset=UTF-8");		
				
				Multipart mp = new MimeMultipart();
				mp.addBodyPart(mbp1);	
				byte [] fileSize=null;
				String fileName ="Report";
		    	/*if(resultForm.getMailAttachReport()!=null && resultForm.getMailAttachReport().equals("1")){
		    		fileSize=getFileSize(resultForm.getMissTestResult().getMsId(),resultForm.getMissTestResult().getMtrId());
		    	}*/ 
		    	if(this.mailAttachReport!=null && this.mailAttachReport.equals("1")
		    			&& this.msOrder!=null && this.msOrder.length()>0 
		    			&& this.mraLang!=null && this.mraLang.length()>0 ){
		    		MissReportAttach missReportAttach=getMissReportAttachObject();
		    		fileSize=getFileSize(this.rootPath,missReportAttach.getMraPath());
		    		fileName=missReportAttach.getMraReportName();
		    		//  private byte[] getFileSize(Long msId,Long mtrId,Long msOrder,String mraLang){
		    	}
		    /*	System.out.println("this.mailAttachReport->"+this.mailAttachReport);
		    	System.out.println("this.msOrder->"+this.msOrder);
		    	System.out.println("this.mraLang->"+this.mraLang);
		    	System.out.println("this.rootPath->"+this.rootPath);
		    	System.out.println("this.fileSize->"+fileSize);*/
				if(fileSize!=null && fileSize.length>0){
					FileOutputStream fos = null;
					
					try {
					//	byte []filesize = multipart.getBytes();
						//if(filesize.length>0){
						 MimeBodyPart mbp2 = new MimeBodyPart();
						 temp = File.createTempFile(genToken(),".howto"); 
						 temp.deleteOnExit();
						 fos = new FileOutputStream(temp.getAbsolutePath());
						
						 fos.write(fileSize); 
						 
						 	mbp2.attachFile(temp);
							mbp2.setFileName(fileName+".pdf");
							mp.addBodyPart(mbp2);
					//	}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						if(fos!=null)
							try {
								fos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						 
					} 
				}
				/*MimeBodyPart attachFilePart = new
				 *  MimeBodyPart();
				FileDataSource fds = new FileDataSource("");
				attachFilePart.setDataHandler(new DataHandler(fds));
				attachFilePart.setFileName(fds.getName())*/
				/*if(multipartRequest!=null){							 
				MultipartFile multipart = multipartRequest.getFile("file");
					if(multipart!=null){
						FileOutputStream fos = null;
						
						try {
							byte []filesize = multipart.getBytes();
							if(filesize.length>0){
							 MimeBodyPart mbp2 = new MimeBodyPart();
							 temp = File.createTempFile(sessionId,".howto"); 
							 temp.deleteOnExit();
							 fos = new FileOutputStream(temp.getAbsolutePath());
							
							 fos.write(filesize); 
							 
							 	mbp2.attachFile(temp);
								mbp2.setFileName(multipart.getOriginalFilename());
								mp.addBodyPart(mbp2);
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							if(fos!=null)
								try {
									fos.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	
							 
						} 
					}
				}*/
				InternetAddress addressFrom=null;
				try {
					if(personal_name!=null && personal_name.length()>0)
						addressFrom = new InternetAddress(email,personal_name);
					else
						addressFrom = new InternetAddress(email);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		    	//for (int i = 0; i < recipients.length; i++) {
				// System.out.println("recipients==>"+recipients.get(i));
				  
					addressTo[0] = new InternetAddress(((String)recipients.get(i)).trim(),false);
				
					msgArray[0] = new MimeMessage(session);
					msgArray[0].setFrom(addressFrom); 
					msgArray[0].setRecipient(Message.RecipientType.TO,addressTo[0]);
					
					//set CC
					if(recipients_cc!=null && recipients_cc.size()>0){
						InternetAddress[] addressCC = new InternetAddress[recipients_cc.size()];
						for (int j = 0; j < recipients_cc.size(); j++) {
							InternetAddress	address = new InternetAddress(((String)recipients_cc.get(j)).trim(),false);
							addressCC[j]=address; 
						}
						msgArray[0].setRecipients(Message.RecipientType.CC,addressCC);
					}
					//set BCC
					if(recipients_bcc!=null && recipients_bcc.size()>0){
						InternetAddress[] addressBCC = new InternetAddress[recipients_bcc.size()];
						for (int j = 0; j < recipients_bcc.size(); j++) {
							InternetAddress	address= new InternetAddress(((String)recipients_bcc.get(j)).trim(),false);
							addressBCC[j]=address;							
						}
						msgArray[0].setRecipients(Message.RecipientType.BCC,addressBCC);
					}
					
					msgArray[0].setSentDate(date);
					 try {
						 msgArray[0].setSubject(subject,"UTF-8");
						 msgArray[0].setHeader("Content-Transfert-Encoding","8Bit");
						 msgArray[0].setContent(mp);
					 } catch (MessagingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
					 }
				//} 
			} catch (AddressException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			
		    SMTPTransport t =null;
			try {
				t = (SMTPTransport)session.getTransport("smtp");
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
				try {
					if(isAuthen)
						t.connect(host, email, password);
					else
						t.connect();
						//for (int i = 0; i < msgArray.length; i++) {
							//logger.debug("Chatchai Debug==>"+msgArray[0].getAllRecipients().toString());
						//	t.sendMessage(arg0, arg1)send(msgArray[i]);
							t.sendMessage(msgArray[0], msgArray[0].getAllRecipients());
						
						//}
						
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					//e.printStackTrace();
					//continue;
					e.printStackTrace();
				} 
				  finally {			 
			    	try {
						t.close();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(temp!=null){
						/*logger.error(" delete file================= "+temp.getAbsolutePath());
						logger.error(" recipients_cc.size()="+ recipients_cc.size());
						logger.error(" recipients_bcc.size()="+ recipients_bcc.size());*/
						if(temp.exists() && temp.isFile())
							temp.delete();
					}
			    } 
			}
		//}
	
	}
	 private String genToken(){
	  		StringBuffer sb = new StringBuffer();
	  	    for (int i = 36; i > 0; i -= 12) {
	  	      int n = Math.min(12, Math.abs(i));
	  	      sb.append(org.apache.commons.lang.StringUtils.leftPad(Long.toString(Math.round(Math.random() * Math.pow(36, n)), 36), n, '0'));
	  	    }
	  	    return sb.toString();
	   }
	 private  MissReportAttach getMissReportAttachObject(){
		 return missExamService.findMissReportAttachById(this.msId, Long.valueOf(this.msOrder),this.mraLang, null);
	 }
	 @SuppressWarnings({ "unchecked", "rawtypes" })
		//private byte[] getFileSize(Long msId,Long mtrId){
	    private byte[] getFileSize(String rootPath,String mraPath){
	    	byte [] fileSize=null;
	    	Context ctx =null;
			Connection con = null;
	    	try{
	    	// MissReportAttach missReportAttach =missExamService.findMissReportAttachById(msId, msOrder, mraLang, null);
			 //MissSeriesAttach missSeriesAttach=missExamService.findMissSeriesAttachSearch("template", msId, null, null);
			// System.out.println("missReportAttach->"+missReportAttach);
			 //String  reportPath=  bundle.getString("templatePath")+missSeriesAttach.getMsatPath();  
	    	 //String  reportPath=  rootPath+missReportAttach.getMraPath();;//bundle.getString("reportTemplatePath")+missReportAttach.getMraPath();
	    		String  reportPath=  rootPath+mraPath;//bundle.getString("reportTemplatePath")+missReportAttach.getMraPath();
			 JasperPrint jasperPrint=null;
			 
			 Map p =new HashMap();
			 p.put("mtrId",mtrId+"");
				try {
					ctx = new InitialContext();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				DataSource ds = null;
				try { 
					ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/missdb");
					//ds = (DataSource)ctx.lookup("jdbc/localOracle");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}               
				org.apache.tomcat.dbcp.dbcp.BasicDataSource basicDs = (org.apache.tomcat.dbcp.dbcp.BasicDataSource)ds;
				try {
					con = basicDs.getConnection();//("oracle", "password");//Connection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}           
			try {
				jasperPrint = JasperFillManager.fillReport(reportPath, p, con);
			 
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	       try {
	    	   fileSize=JasperExportManager.exportReportToPdf(jasperPrint);
	    	   
	       } catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		      // FacesContext.getCurrentInstance().responseComplete(); 
		   
		       
	    	}catch (Exception e) {
				// TODO: handle exception
	    		e.printStackTrace();
			}finally{
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
				if (ctx != null) {
					try {
						ctx.close();
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}	
			}
	    	return fileSize;
	    }
}
