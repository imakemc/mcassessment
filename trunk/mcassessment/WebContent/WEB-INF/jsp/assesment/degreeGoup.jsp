<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<jsp:include page="../header.jsp" />
	<div style="min-height: 645px;">
		<jsp:include page="../headerNavi.jsp" />
		<div class="container" style="background-color:#fff; box-shadow: 0px 5px 10px #3e4545; margin-bottom: 20px;">
			<div class="row">
	  			<div class="col-md-8 col-md-offset-2" style=" background: #ffffff; margin-top: 30px; min-height: 400px;">
		     		<div class="table-responsive">	
		     			<table class="table tb table-hover">
			     			<tbody>
			     				<tr>
				     				<td class="col-md-2">Degree</td>
				     				<td class="col-md-8">Group</td>
				     				<td class="col-md-2"></td>
				     			</tr>
				     			<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;">180</td>
				     				<td class="col-md-8" style="padding-left: 30px; vertical-align: middle;">Group 1 (2) | Group 2 (3)</td>
				     				<td class="col-md-2" style="text-align: center;">
			     						<button class="btn btn-success btn-flat" data-toggle="modal" data-target="#degree-popup"><i class="glyphicon glyphicon-edit"></i></button>
				     				</td>
			     				</tr>
			     				<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;">360</td>
				     				<td class="col-md-8" style="padding-left: 30px; vertical-align: middle;">Group 1 (2) | Group 2 (3) | Group 3 (2) | Group 4 (3)</td>
				     				<td class="col-md-2" style="text-align: center;">
			     						<button class="btn btn-success btn-flat" data-toggle="modal" data-target="#degree-popup"><i class="glyphicon glyphicon-edit"></i></button>
				     				</td>
			     				</tr>
			     				<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;"></td>
				     				<td class="col-md-8" style="padding-left: 30px; vertical-align: middle;"></td>
				     				<td class="col-md-2" style="text-align: center;">
			     						<button class="btn btn-success btn-flat" data-toggle="modal" data-target="#degree-popup"><i class="glyphicon glyphicon-edit"></i></button>
				     				</td>
			     				</tr>
			     				<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;"></td>
				     				<td class="col-md-8" style="padding-left: 30px; vertical-align: middle;"></td>
				     				<td class="col-md-2" style="text-align: center;">
			     						<button class="btn btn-success btn-flat" data-toggle="modal" data-target="#degree-popup"><i class="glyphicon glyphicon-edit"></i></button>
				     				</td>
			     				</tr>
			     				<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;"></td>
				     				<td class="col-md-8" style="padding-left: 30px; vertical-align: middle;"></td>
				     				<td class="col-md-2" style="text-align: center;">
			     						<button class="btn btn-success btn-flat" data-toggle="modal" data-target="#degree-popup"><i class="glyphicon glyphicon-edit"></i></button>
				     				</td>
			     				</tr>
		     				</tbody>
		     			</table>
		     		</div>
		     		<ul class="pagination pagination-sm" style="float: right;">
					    <li class="disabled"><a href="javascript:void(0)">x</a></li>
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
<!-- --------------------------------------degree-popup--------------------------------------------------- -->
	<div id="degree-popup" class="modal fade" tabindex="-1">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
	        <h4 class="modal-title"><span>180 Degree</span></h4>
	      </div>
	      <div class="modal-body">
        	<button type="button" class="btn btn-info btn-xs" style="margin-bottom: 5px;" data-toggle="modal" data-target="#group-popup"><span class="glyphicon glyphicon-plus"></span> Add </button>
           		<div class="table-responsive">	
	     			<table class="table tb table-hover" style="margin-bottom: 15px;">
		     			<tbody>
		     				<tr>
			     				<td class="col-md-2">ID</td>
			     				<td class="col-md-4">Group</td>
			     				<td class="col-md-1">Assessor</td>
			     				<td class="col-md-3"></td>
			     			</tr>
			     			<tr>
			     				<td class="col-md-2" style="text-align:center; vertical-align: middle;">00001</td>
			     				<td class="col-md-4" style="vertical-align: middle;">Group 1</td>
			     				<td class="col-md-1" style="text-align:center; vertical-align: middle;">2</td>
			     				<td class="col-md-3" style="text-align: center;">
		     						<button class="btn btn-success btn-flat btn" data-toggle="modal" data-target="#group-popup"><i class="glyphicon glyphicon-edit"></i></button>
								  	<button class="btn btn-danger btn-flat btn" data-toggle="modal" data-target="#delete-popup"><i class="glyphicon glyphicon-trash"></i> </button>
			     				</td>
		     				</tr>
		     				<tr>
			     				<td class="col-md-2" style="text-align:center; vertical-align: middle;">00002</td>
			     				<td class="col-md-4" style="vertical-align: middle;">Group 2</td>
			     				<td class="col-md-1" style="text-align:center; vertical-align: middle;">3</td>
			     				<td class="col-md-3" style="text-align: center;">
		     						<button class="btn btn-success btn-flat btn" data-toggle="modal" data-target="#group-popup"><i class="glyphicon glyphicon-edit"></i></button>
								  	<button class="btn btn-danger btn-flat btn" data-toggle="modal" data-target="#delete-popup"><i class="glyphicon glyphicon-trash"></i> </button>
			     				</td>
		     				</tr>
		     				<tr>
			     				<td class="col-md-2" style="text-align:center; vertical-align: middle;"></td>
			     				<td class="col-md-4" style="vertical-align: middle;"></td>
			     				<td class="col-md-1" style="text-align:center; vertical-align: middle;"></td>
			     				<td class="col-md-3" style="text-align: center;">
		     						<button class="btn btn-success btn-flat btn" data-toggle="modal" data-target="#group-popup"><i class="glyphicon glyphicon-edit"></i></button>
								  	<button class="btn btn-danger btn-flat btn" data-toggle="modal" data-target="#delete-popup"><i class="glyphicon glyphicon-trash"></i> </button>
			     				</td>
		     				</tr>
		     				<tr>
			     				<td class="col-md-2" style="text-align:center; vertical-align: middle;"></td>
			     				<td class="col-md-4" style="vertical-align: middle;"></td>
			     				<td class="col-md-1" style="text-align:center; vertical-align: middle;"></td>
			     				<td class="col-md-3" style="text-align: center;">
		     						<button class="btn btn-success btn-flat btn" data-toggle="modal" data-target="#group-popup"><i class="glyphicon glyphicon-edit"></i></button>
								  	<button class="btn btn-danger btn-flat btn" data-toggle="modal" data-target="#delete-popup"><i class="glyphicon glyphicon-trash"></i> </button>
			     				</td>
		     				</tr>
		     				<tr>
			     				<td class="col-md-2" style="text-align:center; vertical-align: middle;"></td>
			     				<td class="col-md-4" style="vertical-align: middle;"></td>
			     				<td class="col-md-1" style="text-align:center; vertical-align: middle;"></td>
			     				<td class="col-md-3" style="text-align: center;">
		     						<button class="btn btn-success btn-flat btn" data-toggle="modal" data-target="#group-popup"><i class="glyphicon glyphicon-edit"></i></button>
								  	<button class="btn btn-danger btn-flat btn" data-toggle="modal" data-target="#delete-popup"><i class="glyphicon glyphicon-trash"></i> </button>
			     				</td>
		     				</tr>
	     				</tbody>
	     			</table>
				</div>
				<ul class="pagination pagination-sm" style="margin-top: -10px;">
				    <li class="disabled"><a href="javascript:void(0)">Â«</a></li>
				    <li class="active"><a href="javascript:void(0)">1</a></li>
				    <li><a href="javascript:void(0)">2</a></li>
				    <li><a href="javascript:void(0)">3</a></li>
				    <li><a href="javascript:void(0)">4</a></li>
				    <li><a href="javascript:void(0)">5</a></li>
				    <li><a href="javascript:void(0)">Â»</a></li>
				</ul>
	      </div>
	      <div class="modal-footer" style="margin-top: -30px;">
	        <button class="btn btn-material-blue-700" data-dismiss="modal" style="">Submit</button>
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
		            <label class="col-lg-3 col-md-offset-1 control-label">Employee :</label>
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