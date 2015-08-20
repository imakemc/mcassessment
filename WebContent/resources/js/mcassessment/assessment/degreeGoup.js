//var contextPath ="";

var degreeId = "";
var degreeGroupId = "";
$(document).ready(function() {
	loadTableFirst();
//    	contextPath = "<%= request.getContextPath() %>";
//    	console.log("contextPath : "+contextPath);
		// ----------
//		    	    $('#degreeGuop').dataTable({
//		    		'iDisplayLength': 10,
//		    		'bPaginate': true,
//		    		"bProcessing": false,
//		    		"bInfo": true,
//		    		"destroy": true,
//		    		"bFilter":false,
//		            "sAjaxSource": contextPath+"/degree/ajaxGetDegreeGroupAll",
//		                    "fnServerData": function ( sSource, aoData, fnCallback ) {
//		                $.ajax( {
//		                    "dataType": 'json',
//		                    "type": "GET",
//		                    "url": sSource,
//		                    "data": {organizationId : 'sdsdsd'},
//		                    "success": function(data){
//		                    	console.log(data);
//		                    	setDegreeTable(data);
//		                    },
//		        			"error" : function(xhr, status, error) {
//		      				  console.log(arguments);	
//		      				  alert(error);
//		      				  alert(xhr.responseText);
//		      				}
//		                } );
//		            }
//   	    		   ,"sPaginationType" : "full_numbers",
//   	    		   "aLengthMenu" : [ [ 4, 10, 20, -1 ], [ 4, 10, 20, "All" ] ]
//		        } );

});
		// alert("xx");
		// $.material.init();

function loadTableFirst(){
	
//	console.log("contextPath : "+contextPath);
	// ----------
	    	    $('#degreeGuop').dataTable({
	    		'iDisplayLength': 10,
	    		'bPaginate': true,
	    		"bProcessing": false,
	    		"bInfo": true,
	    		"destroy": true,
	    		"bFilter":false,
	            "sAjaxSource": contextPath+"/degree/ajaxGetDegreeGroupAll",
	                    "fnServerData": function ( sSource, aoData, fnCallback ) {
	                $.ajax( {
	                    "dataType": 'json',
	                    "type": "GET",
	                    "url": sSource,
	                    "async":true,
	                    "data": {organizationId : 'sdsdsd'},
	                    "success": function(data){
	                    	console.log(data);
	                    	setDegreeTable(data);
	                    },
	        			"error" : function(xhr, status, error) {
	      				  console.log(arguments);	
	      				  alert(error);
	      				  alert(xhr.responseText);
	      				}
	                } );
	            }
//,
//'aoColumns' : [{'mData' : 'mdId'},
//{ 'mData': 'mdName' }]
	    		   ,"sPaginationType" : "full_numbers",
	    		   "aLengthMenu" : [ [ 4, 10, 20, -1 ], [ 4, 10, 20, "All" ] ]
	        } );
	
}

function setDegreeTable(data){
		console.log("into set Data table");
		var table =$('#degreeGuop').dataTable();
		
		for(var i=0 ;i<data.length;i++){
			table.fnAddData( [
            data[i].mdId,
//            data[i].mdName,
            getDegreeGroup(data[i].mcDegreeGroups),
            "<button class='btn btn-success btn-flat btn-xs' style='float: right;' data-toggle='modal' data-target='#degree-popup'onClick='editDegree("+"&#39;"+data[i].mdId+"&#39; ,"+"&#39;"+data[i].mdName+"&#39;"+");' ><i class='glyphicon glyphicon-edit'></i></button>"
            ] );
		}
		
//		table.fnSettings().bProcessing = false;
	}
function getDegreeGroup(data){
	var result = "";
	if(data==null)
		return result;
	for(var i=0 ;i<data.length;i++){
		result +=data[i].mdgName+"("+data[i].mdgAssessor+") ,";
//		result +=data[i].mdgName+"("+(data[i].mdgAssessor==null)?0:data[i].mdgAssessor+") ";
	}
	result = result.substring(0,result.length-1)
	console.log("getDegreeGroup : "+result);
	return result;
}

function setDegreeGuopTable(data){
	console.log("into set Data table");
	var table =$('#groupTable').dataTable();
	if(data == null || data.length==0){
		table.fnClearTable();
		return;
	}
	for(var i=0 ;i<data.length;i++){
		table.fnAddData( [
		                  data[i].mdgId,
		                  data[i].mdgName,
		                  data[i].mdgAssessor,
		     				" <table class='nonBorder' > " +
		     				 " 	<tr> " +
		     				 " 		<td> " +
		     				 " 		<button class='btn btn-success btn-flat btn' onClick='editDegreeGroub("+"&#39;"+data[i].mdgId+"&#39; ,"+"&#39;"+data[i].mdgName+"&#39; ,"+"&#39;"+data[i].mdgAssessor+"&#39;"+",&#39;edit&#39;);'><i class='glyphicon glyphicon-edit'></i></button> " +
		     				 " 		</td> " +
		     				 "		<td> " +
		     				 " 		<button class='btn btn-danger btn-flat btn' data-toggle='modal' data-target='#delete-popup' onClick='editDegreeGroub("+"&#39;"+data[i].mdgId+"&#39; ,"+"&#39;"+data[i].mdgName+"&#39; ,"+"&#39;"+data[i].mdgAssessor+"&#39;"+",&#39;delete&#39;);'><i class='glyphicon glyphicon-trash'></i> </button> " +
		     				 " 		</td> " +
		     				 " 	</tr> " +
		     				 " 	</table>" 
		                  ] );
	}
	
//		table.fnSettings().bProcessing = false;
}

function editDegree(id,def){
	console.log(id +"  "+def);
	var title = $("#degree-popup-title");
	degreeId = id;
	console.log(title.text());
	console.log("title.text :"+title.text()+"  def : "+def);
	if(title.text()!=def){
		console.log("title.text!=def  : "+(title.text()!=def));
		title.text(def);
		onLoadDataTableGroup(id);
	}
//	var table =$('#groupTable').dataTable();
//	table.fnClearTable();
//	$("#groupTable").DataTable();
//	var tableGroup = 
//	$("#groupTable").DataTable();
	
}

function editDegreeGroub(mdgId,mdgNamemdg,assessor,type){
	console.log("##  "+mdgId + "  "+mdgNamemdg+"  "+assessor);
	var path = contextPath+"/degree/ajaxEditDegreeGroup";
	if(type=='edit'){
		degreeGroupId = mdgId;
		$("#input-assessor").val(assessor);
		$("#input-groupName").val(mdgNamemdg);
		$("#btnSummitDegreeGroup").text('Edit');
		return;
	}else if(type=='delete'){
		console.log('delete');
		path = contextPath+"/degree/ajaxDeleteDegreeGroup";
//		alert("xx");
		if(mdgId!=""){
			degreeGroupId = mdgId;
			return;
		}
		mdgId=degreeGroupId;
		
	}else{
		 mdgId = degreeGroupId;
		 assessor = $("#input-assessor").val();
		 mdgNamemdg = $("#input-groupName").val();
	}
	

	$.ajax({
		url : path,
		data : {
			 mdgId : mdgId
    		,groupName : mdgNamemdg
    		,assessor : assessor
    		},
		cache : false,
		dataType : "json",
		async : false,
      "success": function(data){
    	console.log(data);
    	$("#input-assessor").val("");
    	$("#input-groupName").val("");
    	onLoadDataTableGroup(degreeId);
    	$("#btnSummitDegreeGroup").text('Add');
    },
	"error" : function(xhr, status, error) {
		  console.log(arguments);	
		  
	    	$("#input-assessor").val("");
	    	$("#input-groupName").val("");
	    	$("#btnSummitDegreeGroup").text('Add');
		  
		  alert(error);
		  alert(xhr.responseText);
		}
	});
	
}

function onDeleteDegreeGroup(){
	editDegreeGroub("","","","delete");
	
};

function onLoadDataTableGroup(degreeId){
    $('#groupTable').dataTable({
		'iDisplayLength': 50,
		'bPaginate': true,
		"bProcessing": false,
		"destroy": true,
//		"searching": false,
		"bInfo": true,
		"bFilter":false,
//		"jQueryUI": true,
//		"scrollY": (screen.height/2)+"px",
//        "scrollCollapse": true,
//        "scrollX":false,
        "sAjaxSource": contextPath+"/degree/ajaxGetDegreeGroup",
                "fnServerData": function ( sSource, aoData, fnCallback ) {
            $.ajax( {
                "dataType": 'json',
                "type": "GET",
                "url": sSource,
                "data": {degreeId : degreeId},
                "async":true,
                "success": function(data){
                	console.log(data);
                	setDegreeGuopTable(data);
                },
    			"error" : function(xhr, status, error) {
  				  console.log(arguments);	
  				  alert(error);
  				  alert(xhr.responseText);
  				}
            } );
        }
//,
//'aoColumns' : [{'mData' : 'mdId'},
//{ 'mData': 'mdName' }]
//		   ,"sPaginationType" : "full_numbers",
//		   "aLengthMenu" : [ [ 4, 10, 20, -1 ], [ 4, 10, 20, "All" ] ]
    } );
	
}

function onAddDegreeGroup(){
	var assessor = $("#input-assessor").val();
	var groupName = $("#input-groupName").val();
	var path = contextPath+"/degree/ajaxAddDegreeGroup";
	var type = $("#btnSummitDegreeGroup").text();
	if("EDIT"==type || "Edit"==type){
		editDegreeGroub("","","","");
		return;
	}
	
	$.ajax({
		url : path,
		data : {degreeId : degreeId
    		,groupName : groupName
    		,assessor : assessor
    		},
		cache : false,
		dataType : "json",
		async : false,
      "success": function(data){
    	console.log(data);
    	$("#input-assessor").val("");
    	$("#input-groupName").val("");
    	onLoadDataTableGroup(degreeId);
    	loadTableFirst();
    },
	"error" : function(xhr, status, error) {
		  console.log(arguments);	
		  alert(error);
		  alert(xhr.responseText);
		}
	});
	
}
