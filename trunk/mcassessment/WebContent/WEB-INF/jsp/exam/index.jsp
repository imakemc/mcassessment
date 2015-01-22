<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>  
<html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
<title>MC Assessment</title>
 <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<%-- 
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9"/>
 --%>  
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>      
<c:url var="url" value="/" />
<c:url value="/logout" var="logoutUrl"/>
<link rel="icon" href="<c:url value='/resources/images/favicon.ico'/>" type="image/x-icon" />
<link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico'/>" type="image/x-icon" />   
<link href="<c:url value='/resources/css/smoothness/jquery-ui-1.9.1.custom.css'/>" type="text/css"  rel="stylesheet" /> 
<link href="<c:url value='/resources/bootstrap2.3.2/css/bootstrap.min.css'/>" rel="stylesheet"  media="all" type="text/css"/>  
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/demo.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style3.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/animate-custom.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/jquery.ui.timepicker.css'/>" /> 

<link rel="stylesheet" href="<c:url value='/resources/css/jquery.fileupload-ui.css'/>">
<%--
<link rel="stylesheet" href="<c:url value='/resources/css/fileupload/jquery.fileupload.css'/>">
 --%> 
<style>
.ui-widget { font-family: Trebuchet MS, Tahoma, Verdana,
 Arial, sans-serif; font-size: 12px; }
 </style>
<style type="text/css"> 
.th_class{text-align: center;
}
a{cursor: pointer;}
.ui-autocomplete-loading {
    background: white url('<%=request.getContextPath() %>/resources/css/smoothness/images/ui-anim_basic_16x16.gif') right center no-repeat;
  } 
  img.ui-datepicker-trigger{cursor: pointer;} 
</style> 

<script  src="<c:url value='/resources/js/jquery-1.8.3.min.js'/>" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value='/resources/js/smoothness/jquery-ui-1.9.1.custom.min.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/resources/ckeditor/ckeditor.js'/>"></script>
<script src="<c:url value='/resources/bootstrap2.3.2/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/bootbox.min.js'/>" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dateFormat-1.0.js'/>"></script>   
<%-- <script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-timepicker-addon.js'/>"></script> --%>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.ui.timepicker.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/resources/js/jshashtable-3.0.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.numberformatter-1.2.4.jsmin.js'/>"></script>
<script src="<c:url value='/resources/js/ajaxupload.js'/>"></script>  
 
<c:set var="aoeTest">
  <spring:message code='navigation_home'/>
</c:set>
<script type="text/javascript">
var _path=""; 
var mail_toG;
var mail_subjectG;
var mail_messageG;
var mail_attachG; 
var _perpageG=20;
var intRegex = /^\d+$/;
//var floatRegex = /^((\d+(\.\d *)?)|((\d*\.)?\d+))$/;
var floatRegex = /^((\d+(\.\d *)?)|((\d*\.)?\d+)|(-\d+(\.\d *)?)|((-\d*\.)?\d+))$/;

$(document).ready(function() { 
});
 
</script>
</head> 
<body>
   <div class="container">  
      <div class="row-fluid"  style="position:fixed;z-index: 1030;background-image: url(<c:url value='/resources/css/smoothness/images/ui-bg_highlight-soft_75_cccccc_1x100.png'/>)">
         <div class="span12">
     	<span style="float:center;"> 
            <table border="0" width="100%">
            <tr><td>
            
            </td>
            <td><span style="padding: 10px">  </span> 
            </td>
            <td>
             <div class="navbar" style="float:right;position: relative;top: 8px">
              <div class="navbar-inner">
                <div class="container">
                  <div class="nav-collapse collapse navbar-responsive-collapse">
                    <ul class="nav" id="nav_element" > 
                   
                     	<li   id="stock_link"><a onclick="togle_page('dispatcher/page/stock','stock_link')">Stock</a></li>
                     
                     	<li   id="todolist_link"><a onclick="togle_page('dispatcher/page/todolist','todolist_link')">To-do-list</a></li>
                      
                     	<li   id="callCenterList_link"><a onclick="togle_page('dispatcher/page/callcenter','callCenterList_link')">แจ้งซ่อม</a></li> 
                      <li id="deliveryInstall_link"><a onclick="togle_page('dispatcher/page/delivery_install_search','deliveryInstall_link')">ส่งเครื่องใหม่/ติดตั้ง</a></li>
                  
                       <li id="pmMa_link"><a onclick="togle_page('dispatcher/page/pm_ma_search','pmMa_link')">PM/MA</a></li> 
                        <li id="pmMa_Planing_link"><a onclick="togle_page('dispatcher/page/pm_ma_planing','pmMa_Planing_link')">Planing</a></li> 
                          <li id="pmMa_Complete_link"><a onclick="togle_page('dispatcher/page/pm_ma_complete','pmMa_Complete_link')">Complete Job(PM)</a></li>  
                        <li id="monitor_job_link"><a onclick="togle_page('dispatcher/page/monitor_job','monitor_job_link')">Monitor Job</a></li>
                        
                        <li id="delivery_install_report_link"><a onclick="togle_page('dispatcher/page/delivery_install_report','delivery_install_report_link')">Daily Report</a></li>
                        
                       
                        <li id="prepare_job_link"><a onclick="togle_page('dispatcher/page/prepare_job','prepare_job_link')">จัดรายการแล้ว</a></li>
                          
                     <li class="dropdown" id="report_link"> 
                      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Report<b class="caret"></b></a>
                      	<ul class="dropdown-menu"> 
   						  
                           <li><a  href="javascript:void(0);"  onclick="togle_page('dispatcher/page/report1','report_link')"  style="text-align: left;">รายงาน ขนส่ง</a></li>
                           
                          <li><a  href="javascript:void(0);"  onclick="togle_page('dispatcher/page/report3','report_link')"  style="text-align: left;">รายงาน งานคงค้าง</a></li>
                          
                          <li><a  href="javascript:void(0);" onclick="togle_page('dispatcher/page/report4','report_link')"  style="text-align: left;">รายงาน SLA</a></li>
                          
                          <li><a  href="javascript:void(0);" onclick="togle_page('dispatcher/page/report5','report_link')"  style="text-align: left;">รายงาน SO</a></li>
                          
                          <li><a  href="javascript:void(0);" onclick="togle_page('dispatcher/page/report6','report_link')"  style="text-align: left;">รายงาน สถานะงานตามแผนก</a></li>
                         
                          <li><a  href="javascript:void(0);" onclick="togle_page('dispatcher/page/report7','report_link')"  style="text-align: left;">รายงาน สถานะงานตาม Line Operation</a></li>
                         
                          <li><a  href="javascript:void(0);" onclick="togle_page('dispatcher/page/report8','report_link')"  style="text-align: left;">รายงาน แผน PM/MA</a></li>
                        
                          <li><a  href="javascript:void(0);" onclick="togle_page('dispatcher/page/report10','report_link')"  style="text-align: left;">รายงานการขายเครื่องใหม่เป็นฐานMA</a></li>
                           
                         </ul>
                      </li> 
                     
                        
                       <li class="dropdown" id="setting_link"> 
                      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Setting<b class="caret"></b></a>
                      	<ul class="dropdown-menu"> 
                          <li><a href="javascript:void(0);"  onclick="togle_page('setting/page/department_search','setting_link')" style="text-align: left;">Department</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('setting/page/setting_sla','setting_link')"  style="text-align: left;">SLA</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('setting/page/role_search','setting_link')"  style="text-align: left;">Role</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('setting/page/problemType_search','setting_link')"  style="text-align: left;">ประเภทปัญหา</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('setting/page/solutionType_search','setting_link')"  style="text-align: left;">วิธีแก้ไข/ป้องกันปัญหา</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('setting/page/driver_search','setting_link')"  style="text-align: left;">คนขับรถ</a></li>
                        <li><a href="javascript:void(0);" onclick="togle_page('setting/page/registrationCar_search','setting_link')"  style="text-align: left;">ทะเบียนรถ</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('setting/page/saleManager_search','setting_link')"  style="text-align: left;">Sale Manager</a></li>
                        
                         </ul>
                      </li>
                      
                       <li class="dropdown" id="user_link"> 
                      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">${myUser.fullName}<b class="caret"></b></a>
                      	<ul class="dropdown-menu">
                       
                      	   <li><a href="javascript:void(0);" onclick="togle_page('dispatcher/page/user_search','user_link')" style="text-align: left;">Manage User</a></li>
                       
                      	 <li><a href="javascript:void(0);"  onclick="togle_page('setting/page/changePassword','user_link')"  style="text-align: left;">แก้ใขข้อมูลส่วนตัว</a></li>
                      	   <li><a href="<c:url value='/logout'/>"  style="text-align: left;">Log out</a></li>
                         </ul>
                      </li>
                    </ul>  
                  </div> 
                </div>
              </div> 
            </div>
            </td>
            </tr> 
            </table>
         </span> 
     	</div>
     </div>
     <div class="row-fluid" style="margin-top: 63px"> 
     	<!--  <div id="_content" class="span10 offset1">   -->
     	 <div id="_content" class="span12">
      	</div> 
    </div> 
  </div>  
</body>
</html>


