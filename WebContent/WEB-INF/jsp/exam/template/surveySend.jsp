<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	 if($("#message_element_survey").attr("style").indexOf("block")!=-1){ 
		 $('html, body').animate({ scrollTop: 0 }, 'slow');
	 	setTimeout(function(){$("#message_element_survey").slideUp(300)},5000);
	 } 
	 loadParticipantSection();
});
function goBackUnitList(){
	
	  $.ajax({
		  type: "get",
		  url: "company/item/unit/${surveyForm.maId}",
		  cache: false
		 // data: { name: "John", location: "Boston" }
		}).done(function( data ) {
			if(data!=null){
				appendContentWithId(data,"tabs-4");
				// $("#tabs-3").html(data);
			  }
		});
}
function setSample(tableID) {
	 var str="<table id=\"dataTable\" class=\"table stable-striped table-bordered table-condensed\" border=\"0\" style=\"font-size: 12px\">"+
	 		"<thead>"+
   			"<tr>"+
     		"<th width=\"5%\"><div class=\"th_class\">#</div></th>"+
     		"<th width=\"15%\"><div class=\"th_class\">Name</div></th>"+
     		"<th width=\"80%\"><div class=\"th_class\">Email</div></th>"+             		 
   		"</tr>"+
 	"</thead>"+
 	"<tbody>";
	 var sample=$("#_sample").val();
	 for(var i=0;i<sample;i++){
		 str=str+"<tr>"+
	        "<td>"+(i+1)+"</td>"+
	     	"<td><INPUT type=\"text\" name=\"survey_name\"/></td>"+
	     	"<td><input type=\"text\" name=\"survey_email\"/></td>"+ 
	   	"</tr>";
	 } 
	 str=str+"</tbody>"+
		"</table>";
	//	alert(str)
	$("#"+tableID).html(str);	
}

function doSendMailAction(){
	//return false;
	$("#mailMessage").val(CKEDITOR.instances["mailMessage"].getData());
 	$.post("survey/sendmail",$("#surveyForm").serialize(), function(data) {
		  // alert(data);
		   appendContentWithId(data,"tabs-4");
		  // alert($("#_content").html());
		}); 
  }
 function loadParticipantSection(){
	 var msId=$("#msId").val();
	 $.get("survey/participantSection/"+msId,function(data) {
		 // alert(data);
		  appendContentWithId(data,"dataTableElement");
		 
		});
 }
</script>
<style>
th{ font-family:Tahoma; font-size:12px; font-weight:bold;
 color: #fff;background:url(<c:url value='/resources/images/${UserMissContact.missTheme.mtTr}'/>) repeat-x scroll 0 0 ${UserMissContact.missTheme.mtTrColor};padding: 5px 8px;border:1px solid #fff; 
}
</style>
 <div id="message_element_survey" class="alert alert-${message_class}" style="${display}">
    <button class="close" data-dismiss="alert"><span style="font-size: 12px">x</span></button>
    <strong>${message}</strong> 
  </div>
<form:form  id="surveyForm" name="surveyForm" modelAttribute="surveyForm"   method="post" action="">
		<div>
			    <table border="0" width="100%" style="font-size: 12px">
			     <%--
   		 			<tr>
    					<td width="20%">&nbsp;</td>
    					<td width="60%">จำนวนสุ่ม <input type="text" style="width: 35px" name="_sample" id="_sample"/>
    					&nbsp;<a class="btn btn-primary"  onclick="setSample('dataTable')"><span style="color: white;font-weight: bold;">Set</span></a></td>
    					<td width="20%">&nbsp;</td> 
    				</tr> 
    			 --%>
    				<tr>
    					<td width="20%" align="right">Subject :&nbsp;</td>
    					<td width="60%"><input type="text" style="width: 509px" name="subject" id="subject"/>
    					</td>
    					<td width="20%">&nbsp;</td> 
    				</tr>
    				<tr>
    					<td width="20%" align="right" valign="top">Message :&nbsp;</td>
    					<td width="60%"><textarea name="mailMessage"  id="mailMessage" rows="4" cols="4"></textarea>
    					<script>
    					if (CKEDITOR.instances['mailMessage']) {
    			            CKEDITOR.remove(CKEDITOR.instances['mailMessage']);
    			         }
    					CKEDITOR.replace( 'mailMessage',
    						    {
    						        toolbar : 'Basic',
    						      //  uiColor : '#9AB8F3'
    						    });
    					</script>
    					</td>
    					<td width="20%">&nbsp;</td> 
    				</tr>
    			</table>
    			 
    			</div>
    			 
    			 <!-- <div> 
    			 จำนวนสุ่ม : <input type="text" style="width: 35px" name="_sample" id="_sample"/>
    					&nbsp;<a class="btn btn-primary"  onclick="setSample('dataTable')"><span style="color: white;font-weight: bold;">Set</span></a>    			
    			 </div> -->
    			 <div>
    			 Series :
    					<form:select path="msId" onchange="loadParticipantSection()" >
    						 <form:options items="${missSeries}" itemLabel="msSeriesName" itemValue="msId"></form:options>
	    					     
    					</form:select> 
    			<!-- &nbsp;&nbsp;จำนวนที่ต้องการจะส่ง : <input type="text" style="width: 35px" name="amountSend" id="amountSend"/> -->
    			 </div>
			<span id="dataTableElement">
			
			<table id="dataTable" class="table stable-striped table-bordered table-condensed" border="0" style="font-size: 12px">
        	<thead>
          		<tr>
            		<th width="5%"><div class="th_class">#</div></th>
            		<th width="15%"><div class="th_class">Name</div></th>
            		<th width="80%"><div class="th_class">Email</div></th>             		 
          		</tr>
        	</thead>
        	<tbody>
        	<!--  
           <tr>
               <td>1</td>
            	<td><INPUT type="text" name="namem"/></td>
            	<td><input type="text" value="emailm"/></td> 
          	</tr>
          	<tr>
          		<td>2</td>
            	<td><INPUT type="text" name="namem"/></td>
            	<td><input type="text" value="emailm"/></td> 
          	</tr>
          	<tr>
          		<td>3</td>
            	<td><INPUT type="text" name="namem"/></td>
            	<td><input type="text" value="emailm"/></td> 
          	</tr> 
             -->
        	</tbody>
      </table>
      </span>
</form:form>
<div align="center">
			<a class="btn btn-info"  onclick="goBackUnitList()"><i class="icon-chevron-left icon-white"></i>&nbsp;<span style="color: white;font-weight: bold;">Back</span></a>	
    		<a class="btn btn-primary"  onclick="doSendMailAction()"><i class="icon-ok icon-white"></i>&nbsp;<span style="color: white;font-weight: bold;">Send</span></a> 
			</div>