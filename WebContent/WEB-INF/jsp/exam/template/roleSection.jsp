<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<script type="text/javascript">
var role_name_G; 
$(document).ready(function() {
//	$('#tabs').tabs();
  //   $("fieldset.collapsibleClosed").collapse( { closed : true } );
//	$('#tabs').tabs('select', parseInt($("#_test_section").val()));
	/* $('#tabs').bind('tabsselect', function(event, ui) {

	    // Objects available in the function context:
	  
	   //alert("index="+ui.index+",panel="+ui.panel+",tab="+ui.tab)
	   if(ui.index==2){
		   alert($("#_meId").val())
		   $("#tabs-3").html("");
	   }

	}); */
	role_name_G=$( "#rolename" );
	if($("#message_element_role").attr("style").indexOf("block")!=-1){ 
		 $('html, body').animate({ scrollTop: 0 }, 'slow');
	 	setTimeout(function(){$("#message_element_role").slideUp(300)},5000);
	 }
});
function toggleCheckbox(){
	var _check=document.getElementById("rtIdCheckboxAll").checked;
	var rtIdCheckbox=document.getElementsByName("rtIdCheckbox"); 
	for(var i=0;i<rtIdCheckbox.length;i++){ 
		rtIdCheckbox[i].checked=_check;
	}
}
function goUpdateRole(){
  var rcActionId=document.getElementById("rcActionId");
  var rcAction=rcActionId.value;
  $("#rolename").val($("select[id=rcId] option:selected").text());
  var rcId=$("select[id=rcId] option:selected").val();
  if(rcAction=='1'){// Add
	//  $('#dialog-createOrUpdate-role').dialog('option', 'title', 'Add Role');
	  $("#rolename").val("");
	  $( "#dialog-createOrUpdate-role" ).dialog({
			/* height: 140, */
			modal: true,
			title:'Add Role',
			buttons: {
				"Yes": function() { 
					$( this ).dialog( "close" );
					goActionRole("addRole");
				},
				"No": function() {
					$( this ).dialog( "close" );
					return false;
				}
			}
		});
  }else  if(rcAction=='2'){// Edit
	 // $('#dialog-createOrUpdate-role').dialog('option', 'title', 'Edit Role');
	  if(rcId=='0'){
		  alert("Please select Role name to Edit");
	  }else{
		  $( "#dialog-createOrUpdate-role" ).dialog({
			/* height: 140, */
			modal: true,
			title:'Edit Role',
			buttons: {
				"Yes": function() { 
					$( this ).dialog( "close" );
					goActionRole("updateRole");
				},
				"No": function() {
					$( this ).dialog( "close" );
					return false;
				}
			}
		});
	  }
  }else  if(rcAction=='3'){// Delete
	  if(rcId=='0'){
		  alert("Please select Role name to Delete");
	  }else{
	  	$( "#dialog-confirmDelete" ).dialog({
			/* height: 140, */
			modal: true,
			buttons: {
				"Yes": function() { 
					$( this ).dialog( "close" );
					goActionRole("deleteRole");
				},
				"No": function() {
					$( this ).dialog( "close" );
					return false;
				}
			}
		});
	  }
	}
	
}
function goActionRole(_mode){
	/*  if($("#_maId").val().length>0){
		  $.ajax({
			  type: "post",
			  url: "role/"+$("#_maId").val(),
			  cache: false
			 // data: { name: "John", location: "Boston" }
			}).done(function( data ) {
				if(data!=null){
					appendContentWithId(data,"tabs-3_1");
					// $("#tabs-3").html(data);
				  }
			});
		//  $("#tabs-3").html("");
		//  $("#tabs-4").html("");
		 }	 */
	//alert(document.getElementById("rolename").value)
    //	$("#roleName").val(document.getElementById("rolename").value); 
		// alert($("#rolename").val())
		// alert(document.getElementById("rolename").value)
	//	alert(role_name_G.val())
	$("#roleName").val(role_name_G.val());
//	alert(_mode);
	$("#mode").val(_mode);
	$("#modeExt").val(_mode);
	//$("#mode").val(_mode);
	//document.getElementById("mode").value=_mode;
	//alert($("#mode").val())
	/* if(_mode!='load')
	  return false; */
	//  alert($("#_maId").val())
	 $.post("role/"+$("#_maId").val(),$("#roleFormG").serialize(), function(data) {
		 appendContentWithId(data,"tabs-3_1");
		});
}
function goUpdateRoleReportMapping(rcId,msId){
	$.post("role/updateRoleReportMapping/"+rcId+"/"+msId,$("#report_template_role_form").serialize(), function(data) {
	 //appendContentWithId(data,"tabs-3_1");
	 //alert(data)
	 if(data!=null){
		 $('#dialog-setRoleReportTemplate-element').html('');
		 $( "#dialog-setRoleReportTemplate" ).dialog( "option", "height", 130 );
		 $('#dialog-setRoleReportTemplate-element').slideUp('slow');
		 $('#dialog-setRoleReportTemplate-element').html('<div align=\"center\">Update Success.</div><br></br><div align=\"center\"><a class=\"btn btn-primary\"  onclick=\"_closeDialog()\"><i class=\"icon-ok icon-white\"></i>&nbsp;<span style=\"color: white;font-weight: bold;\">Ok</span></a></div>');
		 $('#dialog-setRoleReportTemplate-element').slideDown('slow');
	 }
	 //alert(data)
	});
}
function _closeDialog(){

	$("#dialog-setRoleReportTemplate").dialog('close');
	//$(this).remove();
	//$("#dialog-setRoleReportTemplate").remove();
	//$("#dialog-setRoleReportTemplate" ).dialog( "destroy" );
	
}
function setRoleReportTemplate(id){
	 
	   $("#dialog-setRoleReportTemplate-element").html("");
	 var rcId=$("select[id=rcId] option:selected").val();
	// alert(rcId+","+id);
	//	var _str_table=	"<div id=\"dialog-setRoleReportTemplate-element\"><form id=\"report_template_role_form\" name=\"report_template_role_form\">"+
		var _str_table=	"<form id=\"report_template_role_form\" name=\"report_template_role_form\">"+
	    "	<table id=\"table_role_report_list\"  class=\"table stable-striped table-bordered table-condensed\" border=\"1\" style=\"font-size: 12px\">"+
        "	<thead>"+
        "  		<tr>"+
        "    		<th width=\"42%\"><div class=\"th_class\">Thai</div></th>"+ 
        "    		<th width=\"42%\"><div class=\"th_class\">English</div></th>"+
        "    		<th width=\"16%\"><div class=\"th_class\">Permission</div></th>"+              		 
        "  		</tr>"+
        "	</thead>"+
        "	<tbody>"; 

	 $.get("role/get/templateSection/"+rcId+"/"+id, function(data) {
		 var height_dialog=100;
		if(data!=null && data.length>0){
			for(var i=0;i<data.length;i++){
				var no_checked_str="";
				var yes_checked_str="checked=\"checked\"";
				_str_table=_str_table+"<tr>"+ 
            					"<td>&nbsp;"+data[i][0].mraReportName+"</td>"+
            					"<td>&nbsp;"+data[i][1].mraReportName+"</td>"+
            					"<td> ";
            					if(data[i][0].selected=='1'){
            						no_checked_str="checked=\"checked\"";
            						yes_checked_str="";
            					}
            					_str_table=_str_table+"<input type=\"radio\" value=\""+data[i][0].msOrder+"\" "+no_checked_str+" name=\"rtIdCheckbox_radio_report_template_"+rcId+"_"+id+"_"+data[i][0].msOrder+"\">"+
            					"<img src=\"<c:url value='/resources/images/Select.png'/>\"/>&nbsp;"+
            					"<input type=\"radio\" value=\"0\" "+yes_checked_str+" name=\"rtIdCheckbox_radio_report_template_"+rcId+"_"+id+"_"+data[i][0].msOrder+"\">"+
            					"<img src=\"<c:url value='/resources/images/deSelect.png'/>\"/>"+
            			 
            	 	"</td>"+
          			"</tr>";
			}
			_str_table=_str_table+"</tbody>"+
		      "</table>"+
		       "<div align=\"center\"><a class=\"btn btn-primary\"  onclick=\"goUpdateRoleReportMapping('"+rcId+"','"+id+"')\"><i class=\"icon-ok icon-white\"></i>&nbsp;<span style=\"color: white;font-weight: bold;\">Save</span></a></div>"+
		       "</form>";
		       
		       //"</form></div>";
			height_dialog=230;
		}else{
			_str_table="<div align=\"center\">Not Found.</div>";
		}
		
		   // alert(_str_table)
		   $("#dialog-setRoleReportTemplate-element").html(_str_table);
		//alert(data.length);
		//alert($(".ui-dialog,.ui-widget,.ui-widget-content,.ui-corner-all,.ui-draggable,.ui-resizable").length)
		 // $('.ui-dialog').remove(); 
		 //$('#dialog-setRoleReportTemplate').remove(); 
		//alert($('div[class=".ui-dialog .ui-widget .ui-widget-content .ui-corner-all .ui-draggable .ui-resizable"]').length)
	//	$(".ui-dialog,.ui-widget,.ui-widget-content,.ui-corner-all,.ui-draggable,.ui-resizable").remove();
		$( "#dialog-setRoleReportTemplate" ).dialog({
			//height: height_dialog,
			height:"auto",
			width:810,
			modal: true   ,
			beforeClose: function( event, ui ) {
				//alert("close");
				//$(this).remove();
				//$("#dialog-setRoleReportTemplate").remove();
			}
			/*
			 buttons: {
				"Yes": function() { 
					//$( this ).dialog( "close" );
					goUpdateRoleReportMapping(rcId,id);
					
					//goActionRole("deleteRole");
				},
				"No": function() {
					$( this ).dialog( "close" );
					return false;
				}
			}  
		*/
		});
	});
	
}
</script>
<style>
th{ font-family:Tahoma; font-size:12px; font-weight:bold;
 color: #fff;background:url(<c:url value='/resources/images/${UserMissContact.missTheme.mtTr}'/>) repeat-x scroll 0 0 ${UserMissContact.missTheme.mtTrColor};padding: 5px 8px;border:1px solid #fff; 
}
</style>
<div id="dialog-confirmDelete" title="Delete Role" style="display: none;background: ('images/ui-bg_highlight-soft_75_cccccc_1x100.png') repeat-x scroll 50% 50% rgb(204, 204, 204)">
	Are you sure you want to delete Role ?
</div>
<div id="dialog-createOrUpdate-role" title="Role" style="display: none;background: ('images/ui-bg_highlight-soft_75_cccccc_1x100.png') repeat-x scroll 50% 50% rgb(204, 204, 204)">
	<form id="role_form" name="role_form">
	    Role name&nbsp;:&nbsp;<input type="text" name="rolename" id="rolename" /><br/>
	</form>
</div>
<div id="dialog-setRoleReportTemplate" title="Set Role Report" style="display: none;background:background: ('images/ui-bg_highlight-soft_75_cccccc_1x100.png') repeat-x scroll 50% 50% rgb(204, 204, 204)">
  <div id="dialog-setRoleReportTemplate-element">
	</div>
</div>
 <div id="message_element_role" class="alert alert-${message_class}" style="${display}">
    <button class="close" data-dismiss="alert"><span style="font-size: 12px">x</span></button>
    <strong>${message}</strong> 
  </div>
  <fieldset style="font-family: sans-serif;">   
           <%-- <form:form  id="roleForm" name="roleForm" modelAttribute="roleForm" cssStyle="border:2px solid #DDD" method="post" action=""> --%>
           <form:form  id="roleFormG" name="roleFormG" modelAttribute="roleForm"  method="post" action="">
               <form:hidden path="mode"/>
               <form:hidden path="roleName"/>
	 		   <input type="hidden" name="modeExt" id="modeExt" />
              <table border="0" width="100%" style="font-size: 13px">
              				<tr>
	    					 <td align="left" width="100%" colspan="6"><strong>Role Setting</strong></td>
	    					</tr>
	    					<tr>
	    					 <td align="center" width="100%" colspan="6">&nbsp;Role name : 
	    					 <form:select path="rcId" onchange="goActionRole('load')">
	    					 	<form:option  value="0" label="-- Select --"></form:option>
	    					 	 <form:options itemLabel="rcName" items="${roleContacts}" itemValue="rcId"/>
	    					  </form:select>
	    					  <form:select path="rcActionId" cssStyle="width:90px">
	    					 <%-- 	 <form:option  value="0" label="List Role"></form:option> --%>
	    					 	 <form:option  value="1" label="Add Role"></form:option>
	    					 	 <form:option  value="2" label="Edit Role"></form:option>
	    					 	 <form:option  value="3" label="Delete Role"></form:option> 
	    					  </form:select>&nbsp;&nbsp;
	    					  <a class="btn btn-primary"  onclick="goUpdateRole()">&nbsp;<span style="color: white;font-weight: bold;">Ok</span>&nbsp;</a>
	    					</td>
	    					</tr>
	    					</table> 
	    					
	    					 
		<table id="table_list"  class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>
            		<!-- <th width="5%"><div class="th_class"><input type="checkbox" id="rtIdCheckboxAll" onclick="toggleCheckbox()"/></div></th> -->
            		<th width="30%"><div class="th_class">Role</div></th> 
            		<th width="56%"><div class="th_class">Description</div></th>
            		<th width="14%"><div class="th_class">Permission</div></th>              		 
          		</tr>
        	</thead>
        	<tbody>
        	 <c:forEach items="${roleTypes}" var="roleType" varStatus="loop"> 
          	<tr>
            	<%-- <td>
            	<c:if test="${roleType.selected=='1'}">
            		<input type="checkbox" name="rtIdCheckbox" checked="checked" value="${roleType.rtId}"/>
            	</c:if>
            	<c:if test="${roleType.selected!='1'}">
            		<input type="checkbox" name="rtIdCheckbox" value="${roleType.rtId}"/>
            	</c:if>
            	</td>  --%>
            	<td>&nbsp;${roleType.role}</td>
            	<td>&nbsp;${roleType.roleDesc}</td>
            	<td>
            	 <c:if test="${not empty roleForm.rcId}"> 
            	 	<c:if test="${roleForm.rcId!=0}">
            	 		<c:if test="${roleType.selected=='1'}">
            				<input type="radio" value="${roleType.rtId}" checked="checked" name="rtIdCheckbox_radio_${roleType.rtId}">
            				<img src="<c:url value='/resources/images/Select.png'/>"/>&nbsp;
            				<input type="radio" value="0" name="rtIdCheckbox_radio_${roleType.rtId}">
            				<img src="<c:url value='/resources/images/deSelect.png'/>"/>
            			</c:if>
            			<c:if test="${roleType.selected!='1'}">
            				<input type="radio" value="${roleType.rtId}"  name="rtIdCheckbox_radio_${roleType.rtId}">
            				<img src="<c:url value='/resources/images/Select.png'/>"/>&nbsp;
            				<input type="radio" value="0" checked="checked" name="rtIdCheckbox_radio_${roleType.rtId}">
            				<img src="<c:url value='/resources/images/deSelect.png'/>"/>
            			</c:if>
            	 	</c:if>   
            	 	<c:if test="${roleForm.rcId==0}">
            	 		<input type="radio" value="${roleType.rtId}"  name="rtIdCheckbox_radio_${roleType.rtId}">
            	 		<img src="<c:url value='/resources/images/Select.png'/>"/>&nbsp;
            			<input type="radio" value="0" name="rtIdCheckbox_radio_${roleType.rtId}">
            			<img src="<c:url value='/resources/images/deSelect.png'/>"/>
            	 	</c:if>         	 	
            	 </c:if>
            	 <c:if test="${empty roleForm.rcId}"> 
            	 		<input type="radio" value="${roleType.rtId}"   name="rtIdCheckbox_radio_${roleType.rtId}">
            	 		<img src="<c:url value='/resources/images/Select.png'/>"/>&nbsp;
            			<input type="radio" value="0" name="rtIdCheckbox_radio_${roleType.rtId}">
            			<img src="<c:url value='/resources/images/deSelect.png'/>"/>
            	 </c:if>
            	 </td>
          	</tr>
          	</c:forEach>
        </tbody>
      </table>
      
      <table id="table_list2"  class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>
            		<!-- <th width="5%"><div class="th_class"><input type="checkbox" id="rtIdCheckboxAll" onclick="toggleCheckbox()"/></div></th> -->
            		<th align="left" colspan="2" width="88"><div style="margin-left: -400px" class="th_class">Series Name</div></th> 
            		<!-- <th width="58%"><div class="th_class"></div></th> -->
            		<th width="12%"><div class="th_class">Permission</div></th>              		 
          		</tr>
        	</thead>
        	<tbody>
        	 <c:forEach items="${missAccountSeriesMaps}" var="missAccountSeriesMap" varStatus="loop"> 
          	<tr> 
            	<td colspan="2">&nbsp;
            	<c:if test="${not empty roleForm.rcId}"> 
            	 	<c:if test="${roleForm.rcId!=0}">
            	 		<c:if test="${missAccountSeriesMap.selected!='1'}">
            				<span style="text-decoration: underline;cursor: pointer;" onclick="setRoleReportTemplate('${missAccountSeriesMap.missSery.msId}')">${missAccountSeriesMap.missSery.msSeriesName}</span>
            			</c:if>
            			<c:if test="${missAccountSeriesMap.selected=='1'}">
            				${missAccountSeriesMap.missSery.msSeriesName}
            			</c:if>
            	 	</c:if>
            	 	<c:if test="${roleForm.rcId==0}">
            	 		${missAccountSeriesMap.missSery.msSeriesName}
            	 	</c:if>
            	</c:if>
            	 <c:if test="${empty roleForm.rcId}">
            	 	${missAccountSeriesMap.missSery.msSeriesName}
            	 </c:if>
            	 
            	</td>
            	<td>
            	 <c:if test="${not empty roleForm.rcId}"> 
            	 	<c:if test="${roleForm.rcId!=0}">
            	 		<c:if test="${missAccountSeriesMap.selected=='1'}">
            				<input type="radio" value="0"  name="msIdCheckbox_radio_${missAccountSeriesMap.missSery.msId}">
            				<img src="<c:url value='/resources/images/Select.png'/>"/>&nbsp;
            				<input type="radio" value="${missAccountSeriesMap.missSery.msId}" checked="checked" name="msIdCheckbox_radio_${missAccountSeriesMap.missSery.msId}">
            				<img src="<c:url value='/resources/images/deSelect.png'/>"/>
            			</c:if>
            			<c:if test="${missAccountSeriesMap.selected!='1'}">
            				<input type="radio" value="0"  checked="checked" name="msIdCheckbox_radio_${missAccountSeriesMap.missSery.msId}">
            				<img src="<c:url value='/resources/images/Select.png'/>"/>&nbsp;
            				<input type="radio" value="${missAccountSeriesMap.missSery.msId}"  name="msIdCheckbox_radio_${missAccountSeriesMap.missSery.msId}">
            				<img src="<c:url value='/resources/images/deSelect.png'/>"/>
            			</c:if>
            	 	</c:if>   
            	 	<c:if test="${roleForm.rcId==0}">
            	 		<input type="radio" value="0"  name="msIdCheckbox_radio_${missAccountSeriesMap.missSery.msId}">
            	 		<img src="<c:url value='/resources/images/Select.png'/>"/>&nbsp;
            			<input type="radio" value="${missAccountSeriesMap.missSery.msId}" name="msIdCheckbox_radio_${missAccountSeriesMap.missSery.msId}">
            			<img src="<c:url value='/resources/images/deSelect.png'/>"/>
            	 	</c:if>         	 	
            	 </c:if>
            	 <c:if test="${empty roleForm.rcId}"> 
            	 		<input type="radio" value="0"   name="msIdCheckbox_radio_${missAccountSeriesMap.missSery.msId}">
            	 		<img src="<c:url value='/resources/images/Select.png'/>"/>&nbsp;
            			<input type="radio" value="${missAccountSeriesMap.missSery.msId}" name="msIdCheckbox_radio_${missAccountSeriesMap.missSery.msId}">
            			<img src="<c:url value='/resources/images/deSelect.png'/>"/>
            	 </c:if>
            	 </td>
          	</tr>
          	</c:forEach>
        </tbody>
      </table>
      <div align="center"><a class="btn btn-primary"  onclick="goActionRole('updateRoleMapping')"><i class="icon-ok icon-white"></i>&nbsp;<span style="color: white;font-weight: bold;">Save</span></a></div>
      </form:form>
</fieldset>
