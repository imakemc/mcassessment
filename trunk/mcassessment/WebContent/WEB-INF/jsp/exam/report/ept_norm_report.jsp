<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
	    <!--Body content-->
<html>
<head>
<title></title> 
<script  src="<c:url value='/resources/js/jquery-1.7.2.min.js'/>" type="text/javascript"></script> 
<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value='/resources/js/smoothness/jquery-ui-1.8.21.custom.min.js'/>"></script> 
<%-- </sec:authorize> --%>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.ui.selectmenu.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.jstree.js'/>"></script>
<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"  type="text/css">
<link href="<c:url value='/resources/css/smoothness/jquery-ui-1.8.21.custom.css'/>" type="text/css"  rel="stylesheet" />
<link  href="<c:url value='/resources/css/jquery.ui.selectmenu.css'/>" rel="stylesheet" type="text/css">

<link href="<c:url value='/resources/css/3column.css'/>"  type="text/css" rel="stylesheet" />
<link href="<c:url value='/resources/css/menubar.css'/>"  type="text/css" rel="stylesheet" /> 
<style>
.ui-widget { font-family: Trebuchet MS, Tahoma, Verdana,
 Arial, sans-serif; font-size: 12px; }
 </style> 
<style type="text/css"> 
.th_class{text-align: center;
}
a{cursor: pointer;}
</style>
<style type="text/css"> 
th{ font-family:Tahoma; font-size:12px; font-weight:bold;
 color: #fff;background:url(<c:url value='/resources/images/${missAccount.missTheme.mtTr}'/>) repeat-x scroll 0 0 ${missAccount.missTheme.mtTrColor};padding: 5px 8px;border:1px solid #fff; 
}
input[type="text"],[type="password"]{height:30px}
img.ui-datepicker-trigger{cursor: pointer;}
 .span8 {
   padding: 2px;
}
.span2 {
   padding: 2px;
}  
.stable-striped{
   background-color: #F9F9F9;
}
table[id=table_list] tr:nth-child(even) {background: #FFFFFF}
</style>
<script type="text/javascript">
$(document).ready(function() {
	initCompanyList();
});
function initCompanyList(){
	 //alert('${maId}');
	$.ajax({
		  type: "get",
		  url: "/MISSExamBackOffice/reportExport/eptNormReportListCompany",
		  cache: false
		}).done(function( data ) {
			if(data!=null){
				var str="เลือก กลุ่ม : <select id=\"companyListElement\" onchange=\"findEPTNorm('1')\">";
				var str_new="";
				var haveSale=false;
				if(data.companyList.length>0){
					haveSale=true;
					for(var i=0;i<data.companyList.length;i++){
						//alert(data.companyList[i][0]);
						str=str+"<option value=\""+data.companyList[i][0]+"\">"+data.companyList[i][1]+"</option>";
						if(data.companyList[i][0]=='${maId}'){
							//alert("equit")
							str_new="&nbsp;&nbsp;<b>"+data.companyList[i][1]+"</b><br></br>";
							break;
						}
					}
				}
				str=str+"</select>";
				$("#_companyList").html(str_new);
				if(haveSale)
					findEPTNorm("1");
			}
		});
}
function findEPTNorm(mode){
	var val = '${maId}';//document.getElementById("companyListElement").value;
	var url= "/MISSExamBackOffice/reportExport/eptNormReportFind/"+val;
	//alert(url)
	$.ajax({
		  type: "get",
		  url:url,
		  cache: false
		}).done(function( data ) {
			if(data!=null){
				var obj = data;
				var _str="";
				if(mode=="1"){
					// set All 
					//1a  
					 if(obj.eptCount!=null && obj.eptCount!='0'){
						 $("#_content_eptCount").html(obj.eptCount);
						// 1b 
					       	_str="<table class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
						   "<thead>"+
						   	 "<tr>"+        	 
					   		"<th width=\"20%\"><div class=\"th_class\">ประเภท</div></th>"+ 
					   		"<th width=\"20%\"><div class=\"th_class\">อายุ</div></th>"+
					   		"<th width=\"20%\"><div class=\"th_class\">เพศ</div></th>"+
					   		"<th width=\"20%\"><div class=\"th_class\">อาชีพ</div></th>"+
					   		"<th width=\"20%\"><div class=\"th_class\">อุตสาหกรรม</div></th>"+ 
					 		"</tr>"+
					 	   "</thead>"+
						     "<tbody>";
									  if(obj.liePercent!=null)
										  for(var i=0;i<obj.liePercent.length;i++){
												_str=_str+"<tr>"+
												 	"<td>&nbsp;"+obj.liePercent[i][0]+"&nbsp;</td>"+
												 	"<td>&nbsp;"+((obj.liePercent[i][2]=="")?"":""+obj.liePercent[i][1]+"&nbsp;&nbsp;("+obj.liePercent[i][2]+"%)")+"&nbsp;</td>"+
												 	//"<td>&nbsp;"+obj.liePercent[i][1]+"&nbsp;&nbsp;("+obj.liePercent[i][2]+"%)</td>"+
												 	"<td>&nbsp;"+((obj.liePercent[i][4]=="")?"":""+((obj.liePercent[i][3]=='1')?"ชาย":"หญิง")+"&nbsp;&nbsp;("+obj.liePercent[i][4]+"%)")+"&nbsp;</td>"+
												 	"<td>&nbsp;"+((obj.liePercent[i][6]=="")?"":""+obj.liePercent[i][5]+"&nbsp;&nbsp;("+obj.liePercent[i][6]+"%)")+"&nbsp;</td>"+
												 	"<td>&nbsp;"+((obj.liePercent[i][8]=="")?"":""+obj.liePercent[i][7]+"&nbsp;&nbsp;("+obj.liePercent[i][8]+"%)")+"&nbsp;</td>"+
												 	 
												 	"</tr>"; 
											} 
											_str=_str+"</tbody>"+
										      "</table>";
										$("#_content_liePercent").html(_str); 
										
										 // 1c
										_str="<table class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
										   "<thead>"+
										   	 "<tr>";
										     if(obj.groupPercent!=null)
													for(var i=0;i<obj.groupPercent.length;i++){
														_str=_str+"<th width=\"6%\"><div class=\"th_class\">"+obj.groupPercent[i][0]+"</div></th>";
													}
									   		 
										     _str=_str+"</tr>"+
									 	   "</thead>"+
										     "<tbody>"; 
										  if(obj.groupPercent!=null){
											  _str=_str+"<tr>";
											for(var i=0;i<obj.groupPercent.length;i++){ 
												 _str=_str+"<td>&nbsp;"+((obj.groupPercent[i][1]=="")?"":(obj.groupPercent[i][1]+"&nbsp;%"))+"</td>";
											}
											  _str=_str+"</tr>";
										  }
													_str=_str+"</tbody>"+
												      "</table>";
										$("#_content_groupPercent").html(_str); 
										
										//1d 
										_str="<table class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
										   "<thead>"+
										   	 "<tr>";
										     if(obj.careerPercent!=null)
													for(var i=0;i<8;i++){
														_str=_str+"<th width=\"12%\"><div class=\"th_class\">"+obj.careerPercent[i][0]+"</div></th>";
													}
									   		 
										     _str=_str+"</tr>"+
									 	   "</thead>"+
										     "<tbody>"; 
										     if(obj.careerPercent!=null){
												  
											   for(var i=0;i<3;i++){ 
												   _str=_str+"<tr>";
												for(var k=0;k<8;k++){ 
													 _str=_str+"<td>&nbsp;"+obj.careerPercent[k][i+1]+"</td>";
												}
												 _str=_str+"</tr>";
											   }
												 
											  }
														_str=_str+"</tbody>"+
													      "</table>";
										  // part 2
										  _str=_str+"<table class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
										   "<thead>"+
										   	 "<tr>";
										     if(obj.careerPercent!=null)
													for(var i=8;i<obj.careerPercent.length;i++){
														_str=_str+"<th width=\"12%\"><div class=\"th_class\">"+obj.careerPercent[i][0]+"</div></th>";
													}
									   		 
										     _str=_str+"</tr>"+
									 	   "</thead>"+
										     "<tbody>"; 
										     if(obj.careerPercent!=null){
												  
											   for(var i=0;i<3;i++){ 
												   _str=_str+"<tr>";
												for(var k=8;k<obj.careerPercent.length;k++){ 
													 _str=_str+"<td>&nbsp;"+obj.careerPercent[k][i+1]+"</td>";
												}
												 _str=_str+"</tr>";
											   }
												 
											  }
														_str=_str+"</tbody>"+
													      "</table>";
											$("#_content_careerPercent").html(_str); 
										 
										//1e
										_str="<table class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
										   "<thead>"+
										   	 "<tr>"; 
										   	_str=_str+"<th width=\"6%\"><div class=\"th_class\">เพศ</div></th>";
										     if(obj.genderPercent!=null)
													for(var i=0;i<obj.genderPercent.length;i++){
														_str=_str+"<th width=\"6%\"><div class=\"th_class\">"+obj.genderPercent[i][0]+"</div></th>";
													}				   		 
										     _str=_str+"</tr>"+
									 	   "</thead>"+
										     "<tbody>"; 
										   if(obj.genderPercent!=null){
												  _str=_str+"<tr>"; 
												  _str=_str+"<td>&nbsp;ชาย</td>";
												for(var i=0;i<obj.genderPercent.length;i++){ 
													 _str=_str+"<td>&nbsp;"+(obj.genderPercent[i][1]==''?"":obj.genderPercent[i][1]+"&nbsp;%")+"</td>";
												}
												  _str=_str+"</tr>";
												  _str=_str+"<tr>"; 
												  _str=_str+"<td>&nbsp;หญิง</td>";
												for(var i=0;i<obj.genderPercent.length;i++){ 
													 _str=_str+"<td>&nbsp;"+(obj.genderPercent[i][2]==''?"":obj.genderPercent[i][2]+"&nbsp;%")+"</td>";
												}
												  _str=_str+"</tr>";
											  }
														_str=_str+"</tbody>"+
													      "</table>";
											$("#_content_genderPercent").html(_str);  
											
											//1f 
											_str="<table class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
											   "<thead>"+
											   	 "<tr>";
											     if(obj.industryPercent!=null)
														for(var i=0;i<8;i++){
															_str=_str+"<th width=\"12%\"><div class=\"th_class\">"+obj.industryPercent[i][0]+"</div></th>";
														}
										   		 
											     _str=_str+"</tr>"+
										 	   "</thead>"+
											     "<tbody>"; 
											     if(obj.industryPercent!=null){
													  
												   for(var i=0;i<3;i++){ 
													   _str=_str+"<tr>";
													for(var k=0;k<8;k++){ 
														 _str=_str+"<td>&nbsp;"+obj.industryPercent[k][i+1]+"</td>";
													}
													 _str=_str+"</tr>";
												   }
													 
												  }
															_str=_str+"</tbody>"+
														      "</table>";
											  // part 2
											  _str=_str+"<table class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
											   "<thead>"+
											   	 "<tr>";
											     if(obj.industryPercent!=null)
														for(var i=8;i<obj.industryPercent.length;i++){
															_str=_str+"<th width=\"12%\"><div class=\"th_class\">"+obj.industryPercent[i][0]+"</div></th>";
														}
										   		 
											     _str=_str+"</tr>"+
										 	   "</thead>"+
											     "<tbody>"; 
											     if(obj.industryPercent!=null){
													  
												   for(var i=0;i<3;i++){ 
													   _str=_str+"<tr>";
													for(var k=8;k<obj.industryPercent.length;k++){ 
														 _str=_str+"<td>&nbsp;"+obj.industryPercent[k][i+1]+"</td>";
													}
													 _str=_str+"</tr>";
												   }
													 
												  }
															_str=_str+"</tbody>"+
														      "</table>";
												$("#_content_industryPercent").html(_str); 
												
											 
											
												//1g
												_str="<table class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
												   "<thead>"+
												   	 "<tr>"; 
												   	_str=_str+"<th width=\"6%\"><div class=\"th_class\">ช่วงอาขุ</div></th>";
												     if(obj.agePercent!=null)
															for(var i=0;i<obj.agePercent.length;i++){
																_str=_str+"<th width=\"6%\"><div class=\"th_class\">"+obj.agePercent[i][0]+"</div></th>";
															}				   		 
												     _str=_str+"</tr>"+
											 	   "</thead>"+
												     "<tbody>"; 
												    if(obj.agePercent!=null){
													   for(var k=0;k<4;k++){
														  _str=_str+"<tr>"; 
														  var age="";
														  switch (k) {
														case 0:
															age="< 15";
															break;
														case 1:
															age="15-35";
															break;
														case 2:
															age="36-60";
															break;
														case 3:
															age="> 60";
															break;
														default:
															break;
														}
														  _str=_str+"<td>&nbsp;"+age+"</td>";
														for(var i=0;i<obj.agePercent.length;i++){ 
															 _str=_str+"<td>&nbsp;"+(obj.agePercent[i][k+1]=='0.00'?"":obj.agePercent[i][k+1]+"&nbsp;%")+"</td>";
														}
														  _str=_str+"</tr>"; 
													   }
													 }
																_str=_str+"</tbody>"+
															      "</table>";
													$("#_content_agePercent").html(_str);	
					 }else{ 
						 $("#_content_liePercent").html(""); 
						 $("#_content_groupPercent").html("");
						 $("#_content_careerPercent").html(""); 
						 $("#_content_genderPercent").html(""); 
						 $("#_content_industryPercent").html(""); 
						 $("#_content_agePercent").html("");  
					 }
					
				}
			  }
		});
}

</script>

<style>
th{ font-family:Tahoma; font-size:12px; font-weight:bold;
 color: #fff;background:url(<c:url value='/resources/images/${missAccount.missTheme.mtTr}'/>) repeat-x scroll 0 0 ${missAccount.missTheme.mtTrColor};padding: 5px 8px;border:1px solid #fff; 
}
</style>
<div id="dialog-confirmDelete" title="Delete Candidate" style="display: none;background: ('images/ui-bg_highlight-soft_75_cccccc_1x100.png') repeat-x scroll 50% 50% rgb(204, 204, 204)">
	Are you sure you want to delete Candidate ?
</div>
<fieldset style="font-family: sans-serif;">
  <form   class="well" style="border:2px solid #DDD;background: url(<c:url value='/resources/images/${missAccount.missTheme.mtWaterWall}'/>) no-repeat scroll right bottom ${missAccount.missTheme.mtBgColor}">
           <strong style="font-family: sans-serif;font-size: 14px">1. EPT Norm Report: อันนี้จะเป็นรายงานที่รวบรวมข้อมูลของผู้ทำข้อสอบในชุด EPT ทั้งหมด โดยรูปแบบของ EPT จะแบ่งออกเป็น 16 ประเภท พี่ต้องการได้ข้อมูลดังนี้คะ</strong><br/>
- เพิ่ม search criteria แยก company<br/>
<div id="_companyList">เลือก Company : <select id="companyListElement" onchange="findEPTNorm('1')">
<!--  
<option value="">A</option>
<option value="">B</option>
<option value="">C</option>
<option value="">D</option>
 -->
</select></div>

<!--  
 <div>เลือก Company : <select>
<option value="">Company A</option>
<option value="">Company B</option>
</select></div>
 -->
<b>a. จำนวนผู้ทดสอบ EPT ทั้งหมด<br/>
- count(*)</b><br/>
<table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>
            		<th width="100%"><div class="th_class">จำนวนผู้เข้าสอบ</div></th> 
          		</tr>
        	</thead>
        	<tbody>
          	<tr>
            	<td>&nbsp;<span id="_content_eptCount"></span></td> 
         	</tr>
         	
        	</tbody>
      </table>
     
<b>b. จำนวนอัตราการโกหก คิดเป็นเปอร์เซนต์ของแต่ละประเภทว่าอยู่ที่เท่าไหร่ อายุใดมากสุด เพศใดมากสุด อาชีพใด อุตสาหกรรมใดมากสุด</b><br/>
- แสดงเป็นตาราง<br/>
<span id="_content_liePercent">
<table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>
            		<th width="20%"><div class="th_class">ประเภท</div></th> 
            		<th width="20%"><div class="th_class">อายุ</div></th> 
            		<th width="20%"><div class="th_class">เพศ</div></th>
            		<th width="20%"><div class="th_class">อาชีพ</div></th> 
            		<th width="20%"><div class="th_class">อุตสาหกรรม</div></th>  
          		</tr>
        	</thead>
        	<tbody> 
         
        	</tbody>
      </table>
</span>
<b>c. คิดเป็นเปอร์เซนต์ในแต่ละกลุ่มของ 16 ประเภท ว่า แต่ละกลุ่มแบ่งออกเป็นกี่เปอร์เซนต์</b><br/>
<span id="_content_groupPercent">
<table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>
            		<th width="6%"><div class="th_class">ABCD</div></th> 
            		<th width="6%"><div class="th_class">EFGH</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">MNOP</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>  
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>  
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th>    
          		</tr>
        	</thead>
        	<tbody> 
        	 
        	</tbody>
      </table>
</span>
d. แต่ละกลุ่มของ 16 ประเภท มีสายอาชีพอะไรได้เปอร์เซนต์มากสุด ออกมาเป็น 3 ลำดับ<br/>
<span id="_content_careerPercent">
<table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr> 
            		<th width="12%"><div class="th_class">ABCD</div></th> 
            		<th width="12%"><div class="th_class">EFGH</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>
            		<th width="12%"><div class="th_class">MNOP</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>  
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th> 
          		</tr>
        	</thead>
        	<tbody> 
        	 
        	</tbody>
      </table>

      <table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>  
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>  
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>
            		<th width="12%"><div class="th_class">IJKL</div></th>    
          		</tr>
        	</thead>
        	<tbody> 
        
        	</tbody>
      </table>
</span>
e. แต่ละกลุ่มของ 16 ประเภท เพศหญิง เพศชายได้เปอร์เซนต์เท่าไหร่<br/>
<span id="_content_genderPercent">
<table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>
          		   <th width="6%"><div class="th_class">เพศ</div></th>
            		<th width="6%"><div class="th_class">ABCD</div></th> 
            		<th width="6%"><div class="th_class">EFGH</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">MNOP</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>  
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>  
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th>    
          		</tr>
        	</thead>
        	<tbody> 
         
        	</tbody>
      </table>
</span>
f. แต่ละกลุ่มของ 16 ประเภท มี อุตสาหกรรม อะไรได้เปอร์เซนต์มากสุด ออกมาเป็น 3 ลำดับ<br/>
<span id="_content_industryPercent">
<table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr> 
            		<th width="12%"><div class="th_class">ABCD</div></th> 
            		<th width="12%"><div class="th_class">EFGH</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>
            		<th width="12%"><div class="th_class">MNOP</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>  
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th> 
          		</tr>
        	</thead>
        	<tbody> 
        	</tbody>
      </table>
      <table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>  
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>  
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>
            		<th width="12%"><div class="th_class">IJKL</div></th> 
            		<th width="12%"><div class="th_class">IJKL</div></th>
            		<th width="12%"><div class="th_class">IJKL</div></th>    
          		</tr>
        	</thead>
        	<tbody> 
        	</tbody>
      </table>
</span>
<b>g. แต่ละกลุ่มของ 16 ประเภท แบ่งอายุออกมา ว่าอายุกลุ่มใดได้เปอร์เซนต์เท่าไหร่</b><br/>
<span id="_content_agePercent">
<table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>
          		   <th width="6%"><div class="th_class">ช่วงอาขุ</div></th>
            		<th width="6%"><div class="th_class">ABCD</div></th> 
            		<th width="6%"><div class="th_class">EFGH</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">MNOP</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>  
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>  
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th> 
            		<th width="6%"><div class="th_class">IJKL</div></th>
            		<th width="6%"><div class="th_class">IJKL</div></th>    
          		</tr>
        	</thead>
        	<tbody> 
        	</tbody>
      </table>
</span>
</form>
      </fieldset> 
  