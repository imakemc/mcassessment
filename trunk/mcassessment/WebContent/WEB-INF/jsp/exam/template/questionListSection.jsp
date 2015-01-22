<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<style>
div.inner {
    width: 647px;
    text-overflow: ellipsis;
    white-space:nowrap;
    overflow:hidden;
 
   /*  color: red; */
    border: 1px dashed #333;
    margin: 5px;
    padding: 10px;
    font-size:12px;
}
div.inner > table
{
    font-size:12px;
}  
</style>
<script type="text/javascript">
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
	//removeP();
});
function removeP(){
	 $( ".inner" ).each(function(index){
	
		 	var size_text=$( this ).html().length;
		 	var vale_text=$( this ).html();
		 	//alert("index->"+index+",size_text="+size_text)
		 	if(size_text>=7){ 
				 var value_start=	vale_text.substring(0, 3);
				 var value_end=    vale_text.substring(size_text-5, size_text);
				// alert("end->"+value_end);
				// alert( ( value_start=='<p>' || value_start=='<P>'))
				// alert( )
		    if( ( value_start=='<p>' || value_start=='<P>') && ( value_end.indexOf('</p>')!=-1 || value_end.indexOf('</p>')!=-1)){
		    	alert("remove <p>");
		    	//alert(vale_text.substring(3,size_text-5));
		    	$( this ).html(vale_text.substring(3,size_text-5));
		    	$( this ).removeClass('inner')

		    	alert($( this ).hasClass('inner'));
		    	$( this ).addClass('inner')
		    	/* alert("start->"+value_start)
			 	alert("end->"+value_end)
		        alert("html->"+$( this ).html());
		        alert("text->"+$( this ).text()); */ 
		    }
		 //	alert("xx->"+$( this ).html().split(0,3))
		 	
		 }
	      });
}
function confirmDelete(mode,id){
	$( "#dialog-confirm-Question-Delete" ).dialog({
		/* height: 140, */
		modal: true,
		buttons: {
			"Yes": function() { 
				$( this ).dialog( "close" );
				doQuestionAction(mode,id);
			},
			"No": function() {
				$( this ).dialog( "close" );
				return false;
			}
		}
	});
}
function loadQuestion(_url){
	$.ajax({
		  type: "get",
		  url: _url,
		  cache: false
		 // data: { name: "John", location: "Boston" }
		}).done(function( data ) {
			if(data!=null){
				appendContentWithId(data,"tabs-3");
			  }
		});
	
}
 function doQuestionAction(mode,id){
	//alert($("#maCustomizePassMessage").val());
	 $("#mode").val(mode);
		if(mode=='deleteItems'){
			$("#mqIdArray").val(id);
		}else if(mode!='search'){
			$("#mqId").val(id);
		}else {
			$("#mqId").val("0");
		}
		$.post("test/exam/"+$("#meId").val()+"/questions",$("#testForm_question").serialize(), function(data) {
			    appendContentWithId(data,"tabs-3");
			});
  } 
</script>
<div id="dialog-confirm-Question-Delete" title="Delete Question" style="display: none;background: ('images/ui-bg_highlight-soft_75_cccccc_1x100.png') repeat-x scroll 50% 50% rgb(204, 204, 204)">
	Are you sure you want to delete Question ?
</div>
<div id="message_element_test" class="alert alert-${message_class}" style="${display}">
    <button class="close" data-dismiss="alert"><span style="font-size: 12px">x</span></button>
    <strong>${message}</strong> 
    </div>
			<form:form  id="testForm_question" name="testForm_question" modelAttribute="testForm"  method="post" action="">
			<strong>Question Listx</strong>
    				<div>${testForm.missExam.meName}</div>
    		<form:hidden path="mode"/>
    		<form:hidden path="missExam.meId" id="meId"/>
            <form:hidden path="missQuestion.mqId" id="mqId"/>
            <form:hidden path="mqIdArray" id="mqIdArray"/>
            <form:hidden path="paging.pageNo" id="pageNo"/>
            <form:hidden path="paging.pageSize" id="pageSize"/> 
            <form:hidden path="pageCount" id="pageCount"/> 
    		<%-- </form:form>	 --%>
    		<table  border="0" width="100%" style="font-size: 13px">
	    					<tr>
	    					<td align="left" width="60%">
	    					<%-- <c:if test="${countNotOrdered != 0}"> --%>
	    					 <a class="btn btn-danger" onclick="doQuestionAction('setOrderItems','0')"><i class="icon-refresh icon-white" ></i>&nbsp;<span style="font-weight:bold;color:  white;">Set Order No</span></a>
	    					<%-- </c:if>	  --%>   					
	    					</td>
	    					<td align="right" width="40%">
	    					<a class="btn btn-primary"  onclick="loadQuestion('test/exam/${testForm.missExam.meId}/question/new')"><i class="icon-plus-sign icon-white"></i>&nbsp;<span style="font-weight:bold;color:  white;">Add</span></a>
	    					</td>
	    					</tr>
	    					</table> 
    		<div align="right"></div>	
    		<div style="width: 100%">
    	 <table class="table stable-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr>
            		<th width="5%"><div class="th_class">Order</div></th>
            		<th width="85%"><div class="th_class">Question</div></th> 
            		<th width="10%"><div class="th_class">Action</div></th>            		 
          		</tr>
        	</thead>
        	<tbody>
        	 <c:forEach items="${missQuestions}" var="missQuestion" varStatus="loop"> 
          	<tr>
            	<%-- <td>${loop.index+1}</td> --%>
            	 <td> 
            	 <form:hidden path="mqIds" value="${missQuestion.mqId}" />
            	 <form:input path="mqNos" value="${missQuestion.mqNo}" cssStyle="width: 30px;height: 20px" />
            	<%--  <input type="text"  value="${missQuestion.mqNo}" name="mqNo_array" style="width: 30px;height: 20px"/>
            	 <input type="hidden"  value="${missQuestion.mqId}" name="mqId_array"/> --%>
            	 </td> 
            	<td>
            	<div class="inner">${missQuestion.mqNameTh1}</div>
            	<div class="inner">${missQuestion.mqNameEng1}</div>
            	</td> 
            	 
            	
            	 
            	<td  style="text-align: center;">
            	<i title="Edit TH" onclick="loadQuestion('test/exam/${testForm.missExam.meId}/question/${missQuestion.mqId}/TH')" style="cursor: pointer;" class="icon-edit"></i>&nbsp;&nbsp;
            	<i title="Edit EN" onclick="loadQuestion('test/exam/${testForm.missExam.meId}/question/${missQuestion.mqId}/EN')" style="cursor: pointer;" class="icon-edit"></i>&nbsp;&nbsp;
            	<i title="Delete" onclick="confirmDelete('delete','${missQuestion.mqId}')" style="cursor: pointer;" class="icon-trash"></i>
            	<%-- <a href="<c:url value='/test/exam/1/question/2'/>">Edit</a> Delete --%>
            	</td> 
          	</tr>
          	</c:forEach>
          	<%-- <tr>
            	<td>2</td>
            	<td>Question2</td> 
            	<td><a href="<c:url value='/test/exam/1/question/2'/>">Edit</a> Delete</td> 
          	</tr>
          	<tr>
            	<td>3</td>
            	<td>Question3</td> 
            	<td><a href="<c:url value='/test/exam/1/question/2'/>">Edit</a> Delete</td> 
          	</tr>
          	<tr>
            	<td>4</td>
            	<td>Question4</td> 
            	<td><a href="<c:url value='/test/exam/1/question/2'/>">Edit</a> Delete</td> 
          	</tr> --%>
        	</tbody>
      </table>
      </div>
			</form:form>	
			<div>
			<!-- <input type="checkbox"> -->
			<form:form  id="testForm_fixanswer" name="testForm_fixanswer" modelAttribute="testForm" cssClass="well"  method="post" action="">
			<form:checkbox path="missExam.meFixAnswerOrder" value="1"/> Fix Answering Order
			</form:form>
			</div>
			<!-- <div align="center"><input type="button" class="btn" value="Save"/></div> -->
			<div align="center">
			<a class="btn btn-primary" onclick="doAction('action','testForm_fixanswer','2')"><i class="icon-ok icon-white"></i>&nbsp;<span style="color: white;font-weight: bold;">Save</span></a></div>
			