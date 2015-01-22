package th.co.imake.missconsult.assessment.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.aoe.makedev.missconsult.constant.ServiceConstant;
import th.co.aoe.makedev.missconsult.xstream.ConsultantReport;
import th.co.aoe.makedev.missconsult.xstream.CustomerReport;
import th.co.aoe.makedev.missconsult.xstream.EPTNormReport;
import th.co.aoe.makedev.missconsult.xstream.ProductReport;
import th.co.aoe.makedev.missconsult.xstream.ServiceReport;
import th.co.imake.missconsult.assessment.form.ReportManagementForm;
import th.co.imake.missconsult.assessment.service.MissExamService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value={"/reportmanagement"})
@SessionAttributes(value={"reportManagementForm"})
public class ReportManagementController {
	//private static Logger logger = Logger.getRootLogger();
	@Autowired
	private MissExamService missExamService;
	 @RequestMapping(value={"/eptNormReport"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String eptNormReport(Model model)
	    {
	        return "exam/template/ept_norm_report";
	    }
	 @RequestMapping(value={"/eptNormReportListCompany"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public @ResponseBody EPTNormReport eptNormReportListCompany(Model model)
	    {
		 //Gson gson=new Gson();
		 EPTNormReport eptNormReport = new EPTNormReport();
		 eptNormReport.setMode(ServiceConstant.MANAGE_REPORT_MODE_SECTION);
		 eptNormReport.setQuery("");
		 return missExamService.findCompanies(eptNormReport);
	    }
	 @RequestMapping(value={"/eptNormReportFind/{maId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public  @ResponseBody EPTNormReport eptNormReportFind(Model model,@PathVariable String maId)
	    {
		 //Gson gson=new Gson();
		 EPTNormReport eptNormReport = new EPTNormReport();
		 eptNormReport.setMode(ServiceConstant.MANAGE_REPORT_MODE_ALL);
		 eptNormReport.setMaId(maId);
		 return missExamService.findEPTNormReport(eptNormReport);
	    }
	 @RequestMapping(value={"/customerReport"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String customerReport(Model model)
	    {
	        return "exam/template/customer_report";
	    }
	 @RequestMapping(value={"/customerReportListGroup"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public  @ResponseBody CustomerReport customerReportListGroup(Model model)
	    {
		// Gson gson=new Gson();
		 CustomerReport customerReport = new CustomerReport();
		 customerReport.setMode(ServiceConstant.MANAGE_REPORT_MODE_SECTION);
		 customerReport.setQuery("");
		 return missExamService.findGroups(customerReport);
	    }
	 @RequestMapping(value={"/customerReportFind/{magId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public @ResponseBody CustomerReport customerReportFind(Model model,@PathVariable String magId)
	    {
		 //Gson gson=new Gson();
		 CustomerReport customerReport = new CustomerReport();
		 customerReport.setMode(ServiceConstant.MANAGE_REPORT_MODE_ALL);
		 customerReport.setMagId(magId);
		 return missExamService.findCustomerReport(customerReport);
	    }
	 @RequestMapping(value={"/serviceReport"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String serviceReport(Model model)
	    {
		 ReportManagementForm reportManagementForm=null;
		 if(!model.containsAttribute("reportManagementForm")){
			  reportManagementForm =new ReportManagementForm();
			  //0=year,1=all			 
	      }else{
	    	    reportManagementForm= (ReportManagementForm)model.asMap().get("reportManagementForm");
	      }
		 DateTime datetime=new DateTime(new Date().getTime());   
		 reportManagementForm.getServiceReport().setMonth(datetime.monthOfYear().get()+"");
		 reportManagementForm.getServiceReport().setYear(datetime.year().get()+"");
		 model.addAttribute("reportManagementForm", reportManagementForm);
	        return "exam/template/service_report";
	    }
	 @RequestMapping(value={"/productReport"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String productReport(Model model)
	    {
		 ReportManagementForm reportManagementForm=null;
		 if(!model.containsAttribute("reportManagementForm")){
			  reportManagementForm =new ReportManagementForm();
			  //0=year,1=all
			/*reportManagementForm.setProductReport_mode("1");
			reportManagementForm.setProductReport_year("2012");*/
	      }else{
	    	    reportManagementForm= (ReportManagementForm)model.asMap().get("reportManagementForm");
	      }
		 reportManagementForm.getProductReport().setMode(ServiceConstant.MANAGE_REPORT_MODE_ALL); 
		 DateTime datetime=new DateTime(new Date().getTime());    
		 reportManagementForm.getProductReport().setYear(datetime.year().get()+"");
		 model.addAttribute("reportManagementForm", reportManagementForm);
		 model.addAttribute("reportManagement",   missExamService.findProductReport(reportManagementForm.getProductReport()));
	        return "exam/template/product_report";
	    }
	 @RequestMapping(value={"/productReportWithYear/{year}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 @ResponseBody
	 public String productReportWithYear(Model model,@PathVariable String year)
	    {  
		 Gson gson=new Gson();
		 ProductReport productReport = new ProductReport();
		 productReport.setMode(ServiceConstant.MANAGE_REPORT_MODE_SECTION);
		 productReport.setYear(year);
			return gson.toJson(missExamService.findProductReport(productReport));
	    }
	 
	 @RequestMapping(value={"/serviceReportWithYear/{mode}/{month}/{year}"}, 
			 method={org.springframework.web.bind.annotation.RequestMethod.GET})
	/* @ResponseBody
	 public String serviceReportWithYear(HttpServletResponse response,Model model,@PathVariable String mode,@PathVariable String month,@PathVariable String year)
	    { */ 
	/* public  String serviceReportWithYear(HttpServletResponse response,Model model,@PathVariable String mode,@PathVariable String month,@PathVariable String year)
		    {*/
	 public   @ResponseBody ServiceReport serviceReportWithYear(HttpServletResponse response,Model model,@PathVariable String mode,@PathVariable String month,@PathVariable String year)
	    {
		// Gson gson=new Gson();
		 ServiceReport serviceReport = new ServiceReport();
		 serviceReport.setMonth(month);
		 serviceReport.setYear(year);
		 serviceReport.setMode(mode);
		 ServiceReport report=missExamService.findServiceReport(serviceReport);
		// String value= gson.toJson(report);
		// model.addAttribute("value", value);
		// return "exam/report/data";
		 return report;
	    }
	 @RequestMapping(value={"/consultantReport"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String consultantReport(Model model)
	    {
		 ReportManagementForm reportManagementForm=null;
		 if(!model.containsAttribute("reportManagementForm")){
			  reportManagementForm =new ReportManagementForm();
			  //0=year,1=all			 
	      }else{
	    	    reportManagementForm= (ReportManagementForm)model.asMap().get("reportManagementForm");
	      }
		 DateTime datetime=new DateTime(new Date().getTime());   
		 reportManagementForm.getConsultantReport().setMonth(datetime.monthOfYear().get()+"");
		 reportManagementForm.getConsultantReport().setYear(datetime.year().get()+"");
		 model.addAttribute("reportManagementForm", reportManagementForm);
	        return "exam/template/consultant_report";
	    }
	 @RequestMapping(value={"/consultantReportListSale"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public  @ResponseBody ConsultantReport consultantReportListSale(Model model)
	    {
		// Gson gson=new Gson();
		 ConsultantReport consultantReport = new ConsultantReport();
		 consultantReport.setMode(ServiceConstant.MANAGE_REPORT_MODE_SECTION);
		 consultantReport.setQuery("");
		 return missExamService.findSales(consultantReport);
	    }
	 //reportmanagement/consultantReport/0/24/1
	 @RequestMapping(value={"/consultantReportFind/{mode}/{mcontactId}/{month}/{year}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public @ResponseBody ConsultantReport  consultantReportFind(Model model,@PathVariable String mode,@PathVariable String mcontactId,@PathVariable String month,@PathVariable String year)
	    {
		// Gson gson=new Gson();
		 ConsultantReport consultantReport = new ConsultantReport();
		 consultantReport.setMode(mode);
		 consultantReport.setMcontactId(mcontactId);
		 consultantReport.setMonth(month);
		 consultantReport.setYear(year);
		 return  missExamService.findConsultantReport(consultantReport);
	    }
	 @SuppressWarnings("unchecked")
	@RequestMapping(value={"/export"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public void export(HttpServletRequest request, HttpServletResponse response ,@RequestParam(required=false) Long maId){
	    		//@RequestParam(required=false) Long meId,@RequestParam(required=false) Long msId,@RequestParam(required=false) Long mcaId){
	    	try{
			 String  reportPath= "/opt/attach/ept_norm/export_ept_norm.jasper"; 
			 JasperPrint jasperPrint=null;
			 @SuppressWarnings("rawtypes")
			Map p =new HashMap();
			 p.put("URL", "http://203.150.20.37/MISSProcessImage/export?maId="+maId);
				 
			try {
				
				jasperPrint = JasperFillManager.fillReport(reportPath, p,new JREmptyDataSource());
				//jasperPrint = JasperFillManager.fillReport(reportPath, p, con);
				/*jasperPrint.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
				jasperPrint.setProperty("net.sf.jasperreports.default.font.name", defaultPDFFont);*/
				 
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		   //  String fileName="เทส.pdf";
			 response.addHeader("Content-disposition", "attachment; filename=ept_norm.pdf");  
			/* response.setHeader("Content-Disposition", "inline; filename="
						+ fileName);*/
		       ServletOutputStream servletOutputStream=null;
			try {
				servletOutputStream = response.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		       try {
				JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    try {
				servletOutputStream.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       try {
				servletOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       
	    	}catch (Exception e) {
				// TODO: handle exception
	    		e.printStackTrace();
			}finally{
				 
			}
		   
	    }
}
