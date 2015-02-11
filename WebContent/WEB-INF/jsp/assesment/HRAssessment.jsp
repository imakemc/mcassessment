<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<jsp:include page="../header.jsp" />
	<div style="min-height: 645px;">
		<jsp:include page="../headerNavi.jsp" />
		<div class="container" style="background-color:#fff; box-shadow: 0px 5px 10px #3e4545; margin-bottom: 20px;">
			<div class="row">
	  			<div class="col-md-8 col-md-offset-2" style=" background: #ffffff; margin-top: 30px; min-height: 400px;">
	     			<button type="button" class="btn btn-info" style="margin-bottom: 5px;" data-toggle="modal" data-target="#add-popup"><span class="glyphicon glyphicon-plus"></span> Add Order </button>
		     		<span style="font-size: 27px; margin-left: 30px;">Total Balance Unit</span>
		     		<div class="table-responsive">	
		     			<table class="table tb table-hover">
			     			<tbody>
			     				<tr>
				     				<td class="col-md-1">Assessment</td>
				     				<td class="col-md-1">Degree</td>
				     				<td class="col-md-4">Evaluation</td>
				     				<td class="col-md-2">Employee</td>
				     				<td class="col-md-3">Amount Assessor</td>
				     				<td class="col-md-1">Report</td>
				     			</tr>
				     			<tr>
				     				<td class="col-md-1">Series 1</td>
				     				<td class="col-md-1">180</td>
				     				<td class="col-md-4">Evaluation 1 | Evaluation 2</td>
				     				<td class="col-md-2">chatchai</td>
				     				<td class="col-md-3">20/20</td>
				     				<td class="col-md-1">
				     					<button class="btn btn-default btn-flat"><i class="glyphicon glyphicon-print"></i></button>
				     				</td>
				     			</tr>
				     			<tr>
				     				<td class="col-md-1">Series 2</td>
				     				<td class="col-md-1">360</td>
				     				<td class="col-md-4">Evaluation 1</td>
				     				<td class="col-md-2">Oh</td>
				     				<td class="col-md-3">10/20</td>
				     				<td class="col-md-1"><button class="btn btn-default btn-flat" disabled="disabled"><i class="glyphicon glyphicon-print"></i></button></td>
				     			</tr>
				     			<tr>
				     				<td class="col-md-1">Series 3</td>
				     				<td class="col-md-1">180</td>
				     				<td class="col-md-4">Evaluation 1</td>
				     				<td class="col-md-2">AOe</td>
				     				<td class="col-md-3"><button class="btn btn-default btn-flat btn-xs" style="padding: 5px; margin-left: 0px;"  data-toggle="modal" data-target="#new-popup"> new </button></td>
				     				<td class="col-md-1"><button class="btn btn-default btn-flat" disabled="disabled"><i class="glyphicon glyphicon-print"></i></button></td>
				     			</tr>
				     			<tr>
				     				<td class="col-md-1"></td>
				     				<td class="col-md-1"></td>
				     				<td class="col-md-4"></td>
				     				<td class="col-md-2"></td>
				     				<td class="col-md-3"></td>
				     				<td class="col-md-1"><button class="btn btn-default btn-flat" disabled="disabled"><i class="glyphicon glyphicon-print"></i></button></td>
				     			</tr>
				     			<tr>
				     				<td class="col-md-1"></td>
				     				<td class="col-md-1"></td>
				     				<td class="col-md-4"></td>
				     				<td class="col-md-2"></td>
				     				<td class="col-md-3"></td>
				     				<td class="col-md-1"><button class="btn btn-default btn-flat" disabled="disabled"><i class="glyphicon glyphicon-print"></i></button></td>
				     			</tr>
		     				</tbody>
		     			</table>
		     		</div>
		     		<ul class="pagination pagination-sm" style="float: right;">
					    <li class="disabled"><a href="javascript:void(0)">Â«</a></li>
					    <li class="active"><a href="javascript:void(0)">1</a></li>
					    <li><a href="javascript:void(0)">2</a></li>
					    <li><a href="javascript:void(0)">3</a></li>
					    <li><a href="javascript:void(0)">4</a></li>
					    <li><a href="javascript:void(0)">5</a></li>
					    <li><a href="javascript:void(0)">Â»</a></li>
					</ul>
	     		</div>
     		</div>
		</div>
 	</div>
<!-- --------------------------------------new-popup--------------------------------------------------- -->
	<div id="new-popup" class="modal fade" tabindex="-1">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">Ã</button>
	        <h4 class="modal-title"><span>Assessment :</span><span>Series 1 [180 Degree]</span><br><span>Evaluation for Chatchai</span></h4>
	      </div>
	      <div class="modal-body">
        	<fieldset>
	          	<div class="form-group">
	          		<br>
	          		<h4>Group 1</h4>
					<div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Email --">
		            </div>
		            <div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Name --">
		            </div>
	        	</div>
	          	<div class="form-group">
					<div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Email --">
		            </div>
		            <div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Name --">
		            </div>
	        	</div>
	          	<div class="form-group">
	          		<br>
	          		<h4 style="margin-top: 50px;">Group 2</h4>
					<div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Email --">
		            </div>
		            <div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Name --">
		            </div>
	        	</div>
	          	<div class="form-group">
					<div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Email --">
		            </div>
		            <div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Name --">
		            </div>
	        	</div>
	        	<div class="form-group">
					<div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Email --">
		            </div>
		            <div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Name --">
		            </div>
	        	</div>
	        	<br>
	        	<h4 style="margin-top: 80px;">Group 3</h4>
	          	<div class="form-group">
					<div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Email --">
		            </div>
		            <div class="col-lg-6" style="">
		                <input class="form-control" placeholder="-- Name --">
		            </div>
	        	</div>
	      	</fieldset>
	      </div>
	      <div class="modal-footer" style="">
	        <button class="btn btn-material-blue-700" data-dismiss="modal" style="">Save Draft</button>
	        <button class="btn btn-material-blue-700" data-dismiss="modal" style="">Send</button>
	      </div>
	    </div>
	  </div>
	</div>
<!-- ----------------------------------add-popup------------------------------------------------------------- -->
<div id="add-popup" class="modal fade" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
      <form class="form-horizontal">
		<fieldset>
          	<div class="form-group">
          		<br>
	            <label class="col-lg-3 col-md-offset-1 control-label">Assessment :</label>
				 <div class="col-lg-7">
	                 <select class="form-control">
					     <option value="1">-- Series --</option>
					     <option value="2">Series1</option>
					     <option value="3">Series2</option>
				  	 </select>
	            </div>
        	</div>
        	<div class="form-group">
        		<br>
	            <label class="col-lg-3 col-md-offset-1 control-label">Employee :</label>
				 <div class="col-lg-7">
	                <input class="form-control">
	            </div>
        	</div>
      	</fieldset>
      	</form>
      </div>
      <div class="modal-footer">
        <button class="btn btn-material-blue-700" data-dismiss="modal">Add</button>
      </div>
    </div>
  </div>
</div>
<!-- --------------------------------------------------------------------------- -->
<jsp:include page="../footer.jsp" />
<script>
    $(document).ready(function() {
        $.material.init();
    });
</script>
<style>
body { 
	margin-top: 100px; 
	}
.btn {
    padding-left: 14px;
    padding-right: 14px;
    margin: 0px;
  }
.tb {
	margin:0px;padding:0px;
	width:100%;
	border:1px solid #0475e5;
	
	-moz-border-radius-bottomleft:7px;
	-webkit-border-bottom-left-radius:7px;
	border-bottom-left-radius:7px;
	
	-moz-border-radius-bottomright:7px;
	-webkit-border-bottom-right-radius:7px;
	border-bottom-right-radius:7px;
	
	-moz-border-radius-topright:7px;
	-webkit-border-top-right-radius:7px;
	border-top-right-radius:7px;
	
	-moz-border-radius-topleft:7px;
	-webkit-border-top-left-radius:7px;
	border-top-left-radius:7px;
}.tb table{
    border-collapse: collapse;
    border-spacing: 0;
	width:100%;
	height:100%;
	margin:0px;
	padding:0px;
}.tb tr:last-child td:last-child {
	-moz-border-radius-bottomright:7px;
	-webkit-border-bottom-right-radius:7px;
	border-bottom-right-radius:7px;
}
.tb table tr:first-child td:first-child {
	-moz-border-radius-topleft:7px;
	-webkit-border-top-left-radius:7px;
	border-top-left-radius:7px;
}
.tb table tr:first-child td:last-child {
	-moz-border-radius-topright:7px;
	-webkit-border-top-right-radius:7px;
	border-top-right-radius:7px;
}.tb tr:last-child td:first-child{
	-moz-border-radius-bottomleft:7px;
	-webkit-border-bottom-left-radius:7px;
	border-bottom-left-radius:7px;
}.tb tr:hover td{
	
}
.tb tr:nth-child(odd){ background-color:#fcfcfc; }
.tb tr:nth-child(even){ background-color:#ffffff; }.tb td{
	vertical-align:middle;
	border:1px solid #0475e5;
	border-width:0px 1px 1px 0px;
	padding:7px;
	font-weight:normal;
	color:#000000;
}.tb tr:last-child td{
	border-width:0px 1px 0px 0px;
}.tb tr td:last-child{
	border-width:0px 0px 1px 0px;
}.tb tr:last-child td:last-child{
	border-width:0px 0px 0px 0px;
}
.tb tr:first-child td{
	background:-o-linear-gradient(bottom, #0475e5 5%, #046dd6 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #0475e5), color-stop(1, #046dd6) );
	background:-moz-linear-gradient( center top, #0475e5 5%, #046dd6 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#0475e5", endColorstr="#046dd6");	background: -o-linear-gradient(top,#0475e5,046dd6);

	background-color:#0475e5;
	border:0px solid #0475e5;
	text-align:center;
	border-width:0px 0px 1px 1px;
	font-weight:bold;
	color:#ffffff;
}
.tb tr:first-child:hover td{
	background:-o-linear-gradient(bottom, #0475e5 5%, #046dd6 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #0475e5), color-stop(1, #046dd6) );
	background:-moz-linear-gradient( center top, #0475e5 5%, #046dd6 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#0475e5", endColorstr="#046dd6");	background: -o-linear-gradient(top,#0475e5,046dd6);

	background-color:#0475e5;
}
.tb tr:first-child td:first-child{
	border-width:0px 0px 1px 0px;
}
.tb tr:first-child td:last-child{
	border-width:0px 0px 1px 1px;
}
</style>

</body>
</html>