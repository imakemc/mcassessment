<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<jsp:include page="../header.jsp" />
<%-- <script type="text/javascript" src="<c:url value='/resources/js/mcassessment/assessment/degreeGoup.js'/>"></script> --%>
<%-- <%@ include file="/WEB-INF/jsp/header.jsp"%> --%>
<%
String contextPath = request.getContextPath();
%>
</head>
<body>
	<jsp:include page="../headerNavi.jsp" />
	<div class="paperContent container">
<!-- 	<button id="btnAjaxCall" onclick="ajaxtest(this)">Ajax call</button> -->
<!-- 	<button id="btnAjaxCall" onclick="doAjaxPost()">doAjaxPost call</button> -->
	 <div id="result"></div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2"
				style="background: #ffffff; margin-top: 30px; min-height: 400px;">
				<div class="table-responsive">
<!-- 				<button type="button" class="btn btn-info" style="margin-bottom: 5px;" data-toggle="modal" data-target="#degree-popup"><span class="glyphicon glyphicon-plus"></span> Add </button> -->
					<table id="degreeGuop" class="table tb table-hover border"style="margin-bottom: 15px;">
						<thead>
							<tr class="headerTables">
								<td class="col-md-2">Degree</td>
								<td class="col-md-7">Group</td>
								<td class="col-md-1"></td>
							</tr>
						</thead>
<!-- 						<tbody> -->
<%-- 							<c:forEach items="${mcDegreeList}" var="row"> --%>
<!-- 								<tr> -->
<%-- 									<td><c:out value="${row.mdId}" /></td> --%>
<%-- 									<td><c:out value="${row.mdName}" /></td> --%>
<!-- 									<td class="col-md-2" style="text-align: center;"> -->
<!-- 										<button class="btn btn-success btn-flat" data-toggle="modal" -->
<!-- 											data-target="#degree-popup"> -->
<!-- 											<i class="glyphicon glyphicon-edit"></i> -->
<!-- 										</button> -->
<!-- 									</td> -->
<!-- 								</tr> -->
<%-- 							</c:forEach> --%>
<!-- 							<tr> -->
<!-- 								<td colspan="3" class="dataTables_empty">Loading data from -->
<!-- 									server</td> -->
<!-- 							</tr> -->
<!-- 						</tbody> -->
					</table>
				</div>
			</div>
		</div>
	</div>
	

	
<!--  --------------------------------	 -->
 		<div id="degree-popup" class="modal fade" tabindex="-1">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
	        <h4 class="modal-title"><span id="degree-popup-title"></span></h4>
	      </div>
	      <div class="modal-body">
<!--         	<button type="button" class="btn btn-info btn-xs" style="margin-bottom: 5px;" data-toggle="modal" data-target="#group-popup"><span class="glyphicon glyphicon-plus"></span> Add </button> -->
           		<div class="table-responsive">	
	     			<table class="table tb table-hover border" id="groupTable" style="margin-bottom: 15px;">
		     			<thead>
		     				<tr class="headerTables">
			     				<td class="col-md-2" style="text-align:center; vertical-align: middle;">ID</td>
			     				<td class="col-md-4" style="text-align:center; vertical-align: middle;">Group</td>
			     			 	<td class="col-md-1" style="text-align:center; vertical-align: middle;">Assessor</td>
			     				<td class="" style="text-align:center; width:140px; vertical-align: middle;"></td>
			     			</tr>
			     		</thead>
	     			</table>
				</div>

	      </div>
	      <div class="modal-footer" style="margin-top: -30px;">
	      <br>
	      <table style="width: 100%">
	      <tr>
	      	<td>
	      	<label class="">Group Name :</label>
	      	</td>
	      	<td>
	      		<div class="">
		             <input id="input-groupName" class="form-control">
		         </div>
	      	</td>
	      	<td>
	      	<label class="">Assessor :</label>
	      	</td>
	      	<td>
	      		<div class="" style="width: 50px;">
		             <input id="input-assessor" class="form-control bfh-number">
		         </div>
	      	</td>
	      	<td>
	      		<div class="col-lg-7">
		             <button class="btn btn-material-blue-700"  id="btnSummitDegreeGroup" style="" onclick="onAddDegreeGroup();">Add</button>
		         </div>
	      	</td>
	      </tr>
	      </table>
	      </div>
	    </div>
	  </div>
	</div>	
	
	<!-- ----------------------------------group-popup------------------------------------------------------------- -->
<div id="group-popup" class="modal fade" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
      	<form class="form-horizontal">
			<fieldset>
	          	<div class="form-group">
	          		<br>
		            <label class="col-lg-3 col-md-offset-1 control-label">Group Name :</label>
					 <div class="col-lg-7">
		                <input class="form-control">
		            </div>
	        	</div>
	        	<div class="form-group">
	        		<br>
		            <label class="col-lg-3 col-md-offset-1 control-label">Assessor :</label>
					 <div class="col-lg-7">
		                <input class="form-control">
		            </div>
	        	</div>
	      	</fieldset>
	      </form>
      </div>
      <div class="modal-footer">
        <button class="btn btn-material-blue-700" data-dismiss="modal">Submit</button>
      </div>
    </div>
  </div>
</div>
<!-- --------------------------------------------------------------------------- -->
	<div id="delete-popup" class="modal fade" tabindex="-1">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-body">
      	<form class="form-horizontal">
			<fieldset>
	          	<div class="form-group">
		            <label class="col-lg-10 col-md-offset-1 control-label" style="text-align: center; font-size: 18px;">Are you sure?</label>
	        	</div>
	      	</fieldset>
	      </form>
      </div>
      <div class="modal-footer">
        <button class="btn btn-material-blue-700 btn-xs" data-dismiss="modal" onclick="onDeleteDegreeGroup();">Yes</button>
        <button class="btn btn-material-grey-100 btn-xs" data-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>
<!-- --------------------------------------------------------------------------- -->
	
</body>
</html>
<script >
var contextPath ="";
$(document).ready(function() {
	contextPath = "<%= request.getContextPath() %>";
	console.log("contextPath : "+contextPath);
	
// 	$.prompt("Open your javascript console to see the answer.", {
// 		title: "Are you Ready?",
// 		buttons: { "Yes, I'm Ready": true, "No, Lets Wait": false },
// 		submit: function(e,v,m,f){
// 			// use e.preventDefault() to prevent closing when needed or return false. 
// 			// e.preventDefault(); 

// 			console.log("Value clicked was: "+ v +" e: "+e+" m: "+m+" f: "+f+"  ");
// 		}
// 	});
	
// 	$.material.init();
	
// 	$("#groupTable").DataTable();
// 	$("#groupTablez").DataTable();
});

</script>
<script type="text/javascript" src="<c:url value='/resources/js/mcassessment/assessment/degreeGoup.js'/>"></script>











