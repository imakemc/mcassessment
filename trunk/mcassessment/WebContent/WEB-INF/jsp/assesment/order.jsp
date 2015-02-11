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
				     				<td class="col-md-2">ID</td>
				     				<td class="col-md-6">Customer Name</td>
				     				<td class="col-md-4">Assessment</td>
				     			</tr>
				     			<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;">00001</td>
				     				<td class="col-md-6" style="padding-left: 30px; vertical-align: middle;">Neptune Food and Beverage Co.,Ltd</td>
				     				<td class="col-md-4" style="text-align: center;">
					     					<span>Series [ <span>1</span> ] &nbsp;&nbsp;&nbsp;</span>
				     						<button class="btn btn-success btn-flat btn-lg" data-tooltip="Approve"><i class="mdi-action-assignment-turned-in"></i></button>
										  	<button class="btn btn-danger btn-flat btn-lg" data-tooltip="Reject"><i class="mdi-content-reply-all"></i></button>
				     				</td>
			     				</tr>
			     				<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;">00002</td>
				     				<td class="col-md-6" style="padding-left: 30px; vertical-align: middle;">gooooooooogle cooperation</td>
				     				<td class="col-md-4" style="text-align: center;">
					     					<span>Series [ <span>1</span> ] &nbsp;&nbsp;&nbsp;</span>
				     						<button class="btn btn-success btn-flat btn-lg" data-tooltip="Approve"><i class="mdi-action-assignment-turned-in"></i></button>
										  	<button class="btn btn-danger btn-flat btn-lg" data-tooltip="Reject"><i class="mdi-content-reply-all"></i></button>
				     				</td>
			     				</tr>
			     				<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;">00003</td>
				     				<td class="col-md-6" style="padding-left: 30px; vertical-align: middle;">Albatross Consulting Co.,Ltd</td>
				     				<td class="col-md-4" style="text-align: center;">
					     					<span>Series [ <span>1</span> ] &nbsp;&nbsp;&nbsp;</span>
				     						<button class="btn btn-success btn-flat btn-lg" data-tooltip="Approve" style="float: ri"><i class="mdi-action-assignment-turned-in"></i></button>
										  	<button class="btn btn-danger btn-flat btn-lg" data-tooltip="Reject"><i class="mdi-content-reply-all"></i></button>
				     				</td>
			     				</tr>
			     				<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;">00004</td>
				     				<td class="col-md-6" style="padding-left: 30px; vertical-align: middle;">Robinson store & Market</td>
				     				<td class="col-md-4" style="text-align: center;">
					     					<span>Series [ <span>1</span> ] &nbsp;&nbsp;&nbsp;</span>
				     						<button class="btn btn-success btn-flat btn-lg" data-tooltip="Approve"><i class="mdi-action-assignment-turned-in"></i></button>
										  	<button class="btn btn-danger btn-flat btn-lg" data-tooltip="Reject"><i class="mdi-content-reply-all"></i></button>
				     				</td>
			     				</tr>
			     				<tr>
				     				<td class="col-md-2" style="text-align: center; vertical-align: middle;">00005</td>
				     				<td class="col-md-6" style="padding-left: 30px; vertical-align: middle;">Microsoft coop</td>
				     				<td class="col-md-4" style="text-align: center;">
					     					<span>Series [ <span>1</span> ] &nbsp;&nbsp;&nbsp;</span>
				     						<button class="btn btn-success btn-flat btn-lg" data-tooltip="Approve"><i class="mdi-action-assignment-turned-in"></i></button>
										  	<button class="btn btn-danger btn-flat btn-lg" data-tooltip="Reject"><i class="mdi-content-reply-all"></i></button>
				     				</td>
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
  [data-tooltip] {
	position: relative;
	z-index: 2;
	cursor: pointer;
}

[data-tooltip]:before,
[data-tooltip]:after {
  visibility: hidden;
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
	filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);
	opacity: 0;
	pointer-events: none;
}

[data-tooltip]:before {
	position: absolute;
	bottom:170%;
	left: 50%;
	margin-bottom: -20px;
	margin-left: -50px;
	padding: 5px;
	width: 100px;
	-webkit-border-radius: 3px;
	-moz-border-radius:    3px;
	border-radius:         3px;
	background-color: #000;
	background-color: hsla(0, 0%, 20%, 0.9);
	color: #fff;
	content: attr(data-tooltip);
	text-align: center;
	font-size: 10px;
	line-height: 1.2;
}

[data-tooltip]:after {
	position: absolute;
	bottom: 105%;
	left: 50%;
	margin-left: -5px;
	width: 0;
	border-top: 5px solid #000;
	border-top: 5px solid hsla(0, 0%, 20%, 0.9);
	border-right: 5px solid transparent;
	border-left: 5px solid transparent;
	content: " ";
	font-size: 0;
	line-height: 0;
}

[data-tooltip]:hover:before,
[data-tooltip]:hover:after {
	visibility: visible;
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
	filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=100);
	opacity: 1;
}
</style>

</body>
</html>