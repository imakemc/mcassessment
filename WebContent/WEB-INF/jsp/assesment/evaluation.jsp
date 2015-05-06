<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<jsp:include page="../header.jsp" />
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
				<button type="button" class="btn btn-info" style="margin-bottom: id="btnAdd" 5px;" data-toggle="modal" data-target="#add-edit-popup"><span class="glyphicon glyphicon-plus"></span> Add </button>
					<table id="evaluationTable" class="table tb table-hover border"style="margin-bottom: 15px;">
							<thead>
			     				<tr class="headerTables">
				     				<td class="col-md-2">ID</td>
				     				<td class="col-md-8">Evaluation</td>
				     				<td class="col-md-2"></td>
				     			</tr>
				     		</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	

	
<!--  --------------------------------	 -->
	<!-- ----------------------------------group-popup------------------------------------------------------------- -->
<div id="add-edit-popup" class="modal fade" tabindex="-1">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
	        <h4 class="modal-title"><span id="degree-popup-title">Add and Edit</span></h4>
	      </div>
	      <div class="modal-body">
<!--         	<button type="button" class="btn btn-info btn-xs" style="margin-bottom: 5px;" data-toggle="modal" data-target="#group-popup"><span class="glyphicon glyphicon-plus"></span> Add </button> -->
           		<div class="table-responsive">	
           		<div class="tabbable">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#pane1" data-toggle="tab">Information</a></li>
    <li class="disabled-link"><a href="#pane2" data-toggle="tab">Question</a></li>
<!--     <li><a href="#pane3" data-toggle="tab">Question</a></li> -->
  </ul>
  <div class="tab-content">
    <div id="pane1" class="tab-pane active">
      <h4> Information</h4>
<!--             	<form class="form-horizontal"> -->
			<fieldset>
	          	<div class="form-group">
	          		<br>
		            <label class="col-lg-3 col-md-offset-1 control-label">Evalution Name :</label>
					 <div class="col-lg-7">
		                <input id="evalName" class="form-control">
		            </div>
	        	</div>
	        	<div class="form-group">
	        		<br>
		            <label class="col-lg-3 col-md-offset-1 control-label">Introduction :</label>
					 <div class="col-lg-7">
		                <textarea class="form-control" rows="10" id="introduction"></textarea>
		            </div>
	        	</div>
	      	</fieldset>
	      	<div align="right">
	      	
	      	 <button class="btn btn-material-blue-700" id="summitInfo" onclick="saveEvaluationTable();">Submit</button>
	      	</div>
<!-- 	      </form> -->
      
      
    </div>
    <div id="pane2" class="tab-pane">
    <h4> Question</h4>
<!--       		<div class="row"> -->
<!-- 			<div class="col-md-8 col-md-offset-2" -->
<!-- 				style="background: #ffffff; margin-top: 30px; min-height: 400px;"> -->
<!-- 				<div class="table-responsive"> -->
				<button type="button" class="btn btn-info" style="margin-bottom: id= "btnAddQ" 5px;" data-toggle="modal" data-target="#add-edit-popup"><span class="glyphicon glyphicon-plus"></span> Add </button>
					<table id="evaluationTable" class="table tb table-hover border"style="margin-bottom: 15px;">
							<thead>
			     				<tr class="headerTables">
				     				<td class="col-md-2">ID</td>
				     				<td class="col-md-8">Question</td>
				     				<td class="col-md-2"></td>
				     			</tr>
				     		</thead>
					</table>
				</div>
			</div>
<!-- 		</div> -->
<!--     </div> -->
<!--     <div id="pane3" class="tab-pane"> -->
<!--       <h4>Pane 3 Content</h4> -->
<!--     </div> -->
  </div><!-- /.tab-content -->
</div><!-- /.tabbable -->
           		
           		
           		
           		
           		
           		
<!-- 	     			<table class="table tb table-hover border" id="groupTable" style="margin-bottom: 15px;"> -->
<!-- 		     			<thead> -->
<!-- 		     				<tr class="headerTables"> -->
<!-- 			     				<td class="col-md-2" style="text-align:center; vertical-align: middle;">ID</td> -->
<!-- 			     				<td class="col-md-4" style="text-align:center; vertical-align: middle;">Group</td> -->
<!-- 			     			 	<td class="col-md-1" style="text-align:center; vertical-align: middle;">Assessor</td> -->
<!-- 			     				<td class="" style="text-align:center; width:140px; vertical-align: middle;"></td> -->
<!-- 			     			</tr> -->
<!-- 			     		</thead> -->
<!-- 	     			</table> -->
				</div>

	      </div>
	      <div class="modal-footer" style="margin-top: -30px;">
<!-- 	      <br> -->
<!-- 	      <table style="width: 100%"> -->
<!-- 	      <tr> -->
<!-- 	      	<td> -->
<!-- 	      	<label class="">Group Name :</label> -->
<!-- 	      	</td> -->
<!-- 	      	<td> -->
<!-- 	      		<div class=""> -->
<!-- 		             <input id="input-groupName" class="form-control"> -->
<!-- 		         </div> -->
<!-- 	      	</td> -->
<!-- 	      	<td> -->
<!-- 	      	<label class="">Assessor :</label> -->
<!-- 	      	</td> -->
<!-- 	      	<td> -->
<!-- 	      		<div class="" style="width: 50px;"> -->
<!-- 		             <input id="input-assessor" class="form-control bfh-number"> -->
<!-- 		         </div> -->
<!-- 	      	</td> -->
<!-- 	      	<td> -->
<!-- 	      		<div class="col-lg-7"> -->
<!-- 		             <button class="btn btn-material-blue-700"  id="btnSummitDegreeGroup" style="" onclick="onAddDegreeGroup();">Add</button> -->
<!-- 		         </div> -->
<!-- 	      	</td> -->
<!-- 	      </tr> -->
<!-- 	      </table> -->
	      </div>
	    </div>
	  </div>
	</div>	
<!-- --------------------------------------------------------------------------- -->

 	 	<!-- ----------------------------------delete-popup------------------------------------------------------------- -->
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
        <button class="btn btn-material-blue-700 btn-xs" data-dismiss="modal">Yes</button>
        <button class="btn btn-material-grey-100 btn-xs" data-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>
<!-- --------------------------------------------------------------------------- -->

</body>
</html>
<script>
var contextPath ="";
$(document).ready(function() {
	contextPath = "<%= request.getContextPath() %>";
	console.log("contextPath : "+contextPath);
});
</script>
<script type="text/javascript" src="<c:url value='/resources/js/mcassessment/assessment/evaluation.js'/>"></script>
