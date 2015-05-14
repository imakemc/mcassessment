//var contextPath ="";

//var degreeId = "";
//var degreeGroupId = "";
var evalId = null;
var deleteVal =null;
var idVal =null;
$(document).ready(function() {
	loadEvaluation();
	init();
//  //called when key is pressed in textbox
  $("#input-number1").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
//        $("#errmsg").html("Digits Only").show().fadeOut("slow");
               return false;
    }
   });
	
});
		// alert("xx");
		// $.material.init();

function init(){
	
	$('#choiceTable').dataTable({
		"bsort":false,
		"bInfo":false,
		"bPaginate":false,
		"bFilter":false
	});
	
}

function loadEvaluation(){
    $('#evaluationTable').dataTable({
		'iDisplayLength': 10,
		'bPaginate': true,
		"bProcessing": false,
		"bInfo": true,
		"destroy": true,
		"bFilter":false,
        "sAjaxSource": contextPath+"/evaluation/ajaxGetEvaluationAll",
                "fnServerData": function ( sSource, aoData, fnCallback ) {
            $.ajax( {
                "dataType": 'json',
                'contentType': "application/json; charset=utf-8",
                "type": "GET",
                "url": sSource,
                "async" : true,
                "data": {organizationId : 'xxx'},
                "success": function(data){
                	console.log(data);
                	if(data!=null && data.length!=0){
                		setEvaluationTable(data);
                	}else{
                		 $('#evaluationTable').dataTable().fnClearTable();
                	}
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

function setEvaluationTable(data){
		console.log("into set Data table");
		var table =$('#evaluationTable').dataTable();
		
		for(var i=0 ;i<data.length;i++){
			table.fnAddData( [
            data[i].meId,
            data[i].meName,
//            getDegreeGroup(data[i].meName),
				" <table class='nonBorder' > " +
				 " 	<tr> " +
				 " 		<td> " +
				 " 		<button class='btn btn-success btn-flat btn' data-toggle='modal' data-target='#add-edit-popup' onClick='editEvaluation("+"&#39;"+data[i].meId+"&#39; ,"+"&#39;"+data[i].meName+"&#39;,"+"&#39;edit&#39;);'><i class='glyphicon glyphicon-edit'></i></button> " +
				 " 		</td> " +
				 "		<td> " +
				 " 		<button class='btn btn-danger btn-flat btn' data-toggle='modal' data-target='#delete-popup' onClick='onDeleteEQ("+"&#39;"+data[i].meId+"&#39;,&#39;evaluation&#39;);'><i class='glyphicon glyphicon-trash'></i> </button> " +
				 " 		</td> " +
				 " 	</tr> " +
				 " 	</table>" 
//            "<button class='btn btn-success btn-flat btn-xs' style='float: right;' data-toggle='modal' data-target='#degree-popup'onClick='editDegree("+"&#39;"+data[i].meName+"&#39; ,"+"&#39;"+data[i].meName+"&#39;"+");' ><i class='glyphicon glyphicon-edit'></i></button>"
//            "<button class='btn btn-success btn-flat btn-xs' style='float: right;' data-toggle='modal' data-target='#degree-popup'onClick='editDegree("+"&#39;"+data[i].meName+"&#39; ,"+"&#39;"+data[i].meName+"&#39;"+");' ><i class='glyphicon glyphicon-edit'></i></button>"
            ] );
		}
		
//		table.fnSettings().bProcessing = false;
	}

function loadQuestion(meId){
    $('#QuestionTable').dataTable({
		'iDisplayLength': 10,
		'bPaginate': true,
		"bProcessing": false,
		"bInfo": true,
		"destroy": true,
		"bFilter":false,
        "sAjaxSource": contextPath+"/evaluation/ajaxGetQuestionAll",
                "fnServerData": function ( sSource, aoData, fnCallback ) {
            $.ajax( {
            	'contentType': "application/json; charset=utf-8",
                "dataType": 'json',
                "type": "GET",
                "url": sSource,
                "async" : true,
                "data": {meid : meId},
                "success": function(data){
                	console.log(data);
                	if(data!=null && data.length!=0){
                		setQuestionTable(data);
                		console.log("data x : "+data[0].mcEvaluation.mcIntro);
                	}else{
                		 $('#QuestionTable').dataTable().fnClearTable();
                	}
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

function  setQuestionTable(data){
	var table =$('#QuestionTable').dataTable();
	
	for(var i=0 ;i<data.length;i++){
		table.fnAddData( [
		                  data[i].mqId,
		                  data[i].mqNameThai+"</br>"+data[i].maNameEng,
		  				 " <table class='nonBorder' > " +
						 " 	<tr> " +
						 " 		<td> " +
						 " 		<button class='btn btn-success btn-flat btn' data-toggle='modal' data-target='#add-edit-question-popup' onClick='onEditQ("+"&#39;"+data[i].mqId+"&#39;"+",&#39;edit&#39;);'><i class='glyphicon glyphicon-edit'></i></button> " +
						 " 		</td> " +
						 "		<td> " +
						 " 		<button class='btn btn-danger btn-flat btn' data-toggle='modal' data-target='#delete-popup' onClick='onDeleteEQ("+"&#39;"+data[i].mqId+"&#39;"+",&#39;Question&#39;);'><i class='glyphicon glyphicon-trash'></i> </button> " +
						 " 		</td> " +
						 " 	</tr> " +
						 " 	</table>" 
		                  ])
 }
}
function saveEvaluationTable(){
	console.log('saveEvaluationTable');
	var path = contextPath+"/evaluation/ajaxSaveAndGetIdEvaluation";
	var evalNameP = $("#evalName").val();
	var evalIntroP = $("#introduction").val();
	$.ajax({
		url : path,
		contentType: "application/json; charset=utf-8",
		data : {
			 evalName : evalNameP
			,evalIntro : evalIntroP
			},
		cache : false,
		dataType : "json",
		async : false,
	  "success": function(data){
		console.log(data);
		if(data!=null && data[0].id>=0){
			evalId = data[0].id;
			loadEvaluation();
			$('#t2').show();
			
		}
	},
	"error" : function(xhr, status, error) {
		  console.log(arguments);	
		  
//	    	$("#input-assessor").val("");
//	    	$("#input-groupName").val("");
//	    	$("#btnSummitDegreeGroup").text('Add');
		  
		  alert(error);
		  alert(xhr.responseText);
		}
	});
	
}

function onEditQ(mqId,type){
	idVal = mqId;
	$("#btnSummitAddQuestion").text('Edit');
	console.log("Question id : "+idVal);
	console.log("Eval id : "+evalId);
	
}

function loadEvaluationValue(evalId){
	console.log('loadEvaluationValue');
	var path = contextPath+"/evaluation/ajaxGetEvaluationByEvalId";
	var evalNameP = $("#evalName").val();
	var evalIntroP = $("#introduction").val();
	$.ajax({
		url : path,
		data : {
			evalId : evalId
			},
		cache : false,
		contentType: "application/json; charset=utf-8",
		dataType : "json",
		async : true,
	  "success": function(data){
		console.log(data);
		if(data!=null && data.length>0){
			$("#evalName").val(data[0].meName);
			$("#introduction").val(data[0].mcIntro);
		}
	},
	"error" : function(xhr, status, error) {
		  console.log(arguments);	
		  
//	    	$("#input-assessor").val("");
//	    	$("#input-groupName").val("");
//	    	$("#btnSummitDegreeGroup").text('Add');
		  
		  alert(error);
		  alert(xhr.responseText);
		}
	});
	
}

//$('#myTab a').click(function (e) {
//    if($(this).parent('li').hasClass('active')){
//        $( $(this).attr('href') ).hide();
//    }
//    else {
//        e.preventDefault();
//        $(this).tab('show');
//    }
//});

function onAddEvalClick(){
//	console.log("");
	$('#t2').hide();
	evalId =null;
	$("#evalName").val("");
	$("#introduction").val("");
	$('#QuestionTable').dataTable().fnClearTable();
	generateTbChoices();
}

function editEvaluation(meID,meName,type){
	console.log("meID,meName,type : "+meID+"  "+meName+"   "+type);
	$('#t2').show();
	evalId=meID;
	generateTbChoices()
	if("edit"==type){
			loadEvaluationValue(meID);
		 	loadQuestion(meID);
			$("#evalName").val(meName);
//			$("#introduction").val("");
	}else{
		///delete
	}
	
}

function onDeleteEQ(id,type){
	deleteVal = type;
	idVal=id
//	deleteAjax(id);
}

function onYesDelete(){
	deleteAjax(idVal);
}

function deleteAjax(id){
	console.log('deleteAjax');
	console.log('deleteVal : '+deleteVal);
	console.log('id : '+id);
	var path = contextPath;
	if(deleteVal=="evaluation"){
		path+="/evaluation/ajaxDeleteEvaluation";
	}else{
		path+="/evaluation/ajaxDeleteQuestion";
	}
	console.log('path : '+path);
	$.ajax({
		url : path,
		data : {
			id : id
			},
		cache : false,
		dataType : "json",
		contentType: "application/json; charset=utf-8",
		async : true,
	  "success": function(data){
		console.log(data);
		if(data!=null && data.length>0 && data[0].record>0){
//			$("#evalName").val(data[0].meName);
//			$("#introduction").val(data[0].mcIntro);
			if(deleteVal=="evaluation"){
				loadEvaluation();
			}else{
//				loadQuestion(evalId);
			}
		}
	},
	"error" : function(xhr, status, error) {
		  console.log(arguments);	
		  
//	    	$("#input-assessor").val("");
//	    	$("#input-groupName").val("");
//	    	$("#btnSummitDegreeGroup").text('Add');
		  
		  alert(error);
		  alert(xhr.responseText);
		}
	});
}

function generateTbChoices(){
	var table = $('#choiceTable').dataTable();
//	var table = $('#choiceTable').dataTable({
//		"bInfo":false,
//		"bPaginate":false,
//		"bFilter":false
//	});
	table.fnClearTable();
	for(var i=0;i<4;i++){
		addChoices();
	}
}
function addChoices(){
	var table = $('#choiceTable').dataTable();
	var length = table.fnGetData().length;
	table.fnAddData([
	                 (length+1),
	                 "<input id='input-number"+length+"' name='input-number1' value='"+length+"' type='number' class='form-control numeric-x' data-bind='value:replyNumber'>"
	                 ]);
}

function onSummitAddQuestion(){
	saveQuetion();
	
}

function onAddQuetionClick(){
	$("#btnSummitAddQuestion").text('Add');
	idVal = null;
	console.log("Question id : "+idVal);
	console.log("Eval id : "+evalId);
}

function saveQuetion(){
	var QThai = $("#QThai");
	var QEng = $("#QEng");
	
	var path = contextPath;
	var id =null;
	var idType = $("#btnSummitAddQuestion").text();
	
	path+="/evaluation/ajaxAddEditQuestion";
	
	if(idType=="Add"){
//		path+="/evaluation/ajaxAddEvaluation";
	}else{
//		path+="/evaluation/ajaxEditQuestion";
		id = idVal;
	}
	
//	var evalId = evalId;
	
	
	console.log('path : '+path);
	$.ajax({
		url : path,
		data : {
			id : id,
			evalId : evalId,
			qthai : decodeURI(QThai.val()),
			qeng : QEng.val(),
			type: idType
			},
		cache : false,
//		contentType: "application/json; charset=utf-8",
		contentType: "application/x-www-form-urlencoded",
		dataType : "json",
		async : true,
	    "success": function(data){
		console.log(data);
		if(data!=null && data.length>0 && data[0].id>-1){
			idVal=data[0].id;
			console.log("save Question id : "+idVal);
		}else{
			alert("save faile!!!");
		}
	},
	"error" : function(xhr, status, error) {
		  console.log(arguments);	
		  
//	    	$("#input-assessor").val("");
//	    	$("#input-groupName").val("");
//	    	$("#btnSummitDegreeGroup").text('Add');
		  
		  alert(error);
		  alert(xhr.responseText);
		}
	});
	
}

//called when key is pressed in textbox
//$("#input-number1").keypress(function (e) {
//   //if the letter is not digit then display error and don't type anything
//   if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
//      //display error message
////      $("#errmsg").html("Digits Only").show().fadeOut("slow");
//             return false;
//  }
// });
	  
//function getIndexTableOnclick(tableId){
//	var table = $('#'+tableId).DataTable();
//	 
//	$('#'+tableId+' tbody').on( 'click', 'tr', function () {
//	    alert( 'Row index: '+table.row( this ).index() );
//	} );
//	
//}
//function getDegreeGroup(data){
//	var result = "";
//	if(data==null)
//		return result;
//	for(var i=0 ;i<data.length;i++){
//		result +=data[i].mdgName+"("+data[i].mdgAssessor+") ";
////		result +=data[i].mdgName+"("+(data[i].mdgAssessor==null)?0:data[i].mdgAssessor+") ";
//	}
//	console.log("getDegreeGroup : "+result);
//	return result;
//}
//
//function setDegreeGuopTable(data){
//	console.log("into set Data table");
//	var table =$('#groupTable').dataTable();
//	if(data == null || data.length==0){
//		table.fnClearTable();
//		return;
//	}
//	for(var i=0 ;i<data.length;i++){
//		table.fnAddData( [
//		                  data[i].mdgId,
//		                  data[i].mdgName,
//		                  data[i].mdgAssessor,
//		     				" <table class='nonBorder' > " +
//		     				 " 	<tr> " +
//		     				 " 		<td> " +
//		     				 " 		<button class='btn btn-success btn-flat btn' onClick='editDegreeGroub("+"&#39;"+data[i].mdgId+"&#39; ,"+"&#39;"+data[i].mdgName+"&#39; ,"+"&#39;"+data[i].mdgAssessor+"&#39;"+",&#39;edit&#39;);'><i class='glyphicon glyphicon-edit'></i></button> " +
//		     				 " 		</td> " +
//		     				 "		<td> " +
//		     				 " 		<button class='btn btn-danger btn-flat btn' data-toggle='modal' data-target='#delete-popup' onClick='editDegreeGroub("+"&#39;"+data[i].mdgId+"&#39; ,"+"&#39;"+data[i].mdgName+"&#39; ,"+"&#39;"+data[i].mdgAssessor+"&#39;"+",&#39;delete&#39;);'><i class='glyphicon glyphicon-trash'></i> </button> " +
//		     				 " 		</td> " +
//		     				 " 	</tr> " +
//		     				 " 	</table>" 
//		                  ] );
//	}
//	
////		table.fnSettings().bProcessing = false;
//}
//
//function editDegree(id,def){
//	console.log(id +"  "+def);
//	var title = $("#degree-popup-title");
//	degreeId = id;
//	console.log(title.text());
//	console.log("title.text :"+title.text()+"  def : "+def);
//	if(title.text()!=def){
//		console.log("title.text!=def  : "+(title.text()!=def));
//		title.text(def);
//		onLoadDataTableGroup(id);
//	}
////	var table =$('#groupTable').dataTable();
////	table.fnClearTable();
////	$("#groupTable").DataTable();
////	var tableGroup = 
////	$("#groupTable").DataTable();
//	
//}
//
//function editDegreeGroub(mdgId,mdgNamemdg,assessor,type){
//	console.log("##  "+mdgId + "  "+mdgNamemdg+"  "+assessor);
//	var path = contextPath+"/degree/ajaxEditDegreeGroup";
//	if(type=='edit'){
//		degreeGroupId = mdgId;
//		$("#input-assessor").val(assessor);
//		$("#input-groupName").val(mdgNamemdg);
//		$("#btnSummitDegreeGroup").text('Edit');
//		return;
//	}else if(type=='delete'){
//		console.log('delete');
//		path = contextPath+"/degree/ajaxDeleteDegreeGroup";
////		alert("xx");
//		if(mdgId!=""){
//			degreeGroupId = mdgId;
//			return;
//		}
//		mdgId=degreeGroupId;
//		
//	}else{
//		 mdgId = degreeGroupId;
//		 assessor = $("#input-assessor").val();
//		 mdgNamemdg = $("#input-groupName").val();
//	}
//	
//
//	$.ajax({
//		url : path,
//		data : {
//			 mdgId : mdgId
//    		,groupName : mdgNamemdg
//    		,assessor : assessor
//    		},
//		cache : false,
//		dataType : "json",
//		async : false,
//      "success": function(data){
//    	console.log(data);
//    	$("#input-assessor").val("");
//    	$("#input-groupName").val("");
//    	onLoadDataTableGroup(degreeId);
//    	$("#btnSummitDegreeGroup").text('Add');
//    },
//	"error" : function(xhr, status, error) {
//		  console.log(arguments);	
//		  
//	    	$("#input-assessor").val("");
//	    	$("#input-groupName").val("");
//	    	$("#btnSummitDegreeGroup").text('Add');
//		  
//		  alert(error);
//		  alert(xhr.responseText);
//		}
//	});
//	
//}
//
//function onDeleteDegreeGroup(){
//	editDegreeGroub("","","","delete");
//	
//};
//
//function onLoadDataTableGroup(degreeId){
//    $('#groupTable').dataTable({
//		'iDisplayLength': 50,
//		'bPaginate': true,
//		"bProcessing": false,
//		"destroy": true,
////		"searching": false,
//		"bInfo": true,
//		"bFilter":false,
////		"jQueryUI": true,
////		"scrollY": (screen.height/2)+"px",
////        "scrollCollapse": true,
////        "scrollX":false,
//        "sAjaxSource": contextPath+"/degree/ajaxGetDegreeGroup",
//                "fnServerData": function ( sSource, aoData, fnCallback ) {
//            $.ajax( {
//                "dataType": 'json',
//                "type": "GET",
//                "url": sSource,
//                "data": {degreeId : degreeId},
//                "async":true,
//                "success": function(data){
//                	console.log(data);
//                	setDegreeGuopTable(data);
//                },
//    			"error" : function(xhr, status, error) {
//  				  console.log(arguments);	
//  				  alert(error);
//  				  alert(xhr.responseText);
//  				}
//            } );
//        }
////,
////'aoColumns' : [{'mData' : 'mdId'},
////{ 'mData': 'mdName' }]
////		   ,"sPaginationType" : "full_numbers",
////		   "aLengthMenu" : [ [ 4, 10, 20, -1 ], [ 4, 10, 20, "All" ] ]
//    } );
//	
//}
//
//function onAddDegreeGroup(){
//	var assessor = $("#input-assessor").val();
//	var groupName = $("#input-groupName").val();
//	var path = contextPath+"/degree/ajaxAddDegreeGroup";
//	var type = $("#btnSummitDegreeGroup").text();
//	if("EDIT"==type || "Edit"==type){
//		editDegreeGroub("","","","");
//		return;
//	}
//	
//	$.ajax({
//		url : path,
//		data : {degreeId : degreeId
//    		,groupName : groupName
//    		,assessor : assessor
//    		},
//		cache : false,
//		dataType : "json",
//		async : false,
//      "success": function(data){
//    	console.log(data);
//    	$("#input-assessor").val("");
//    	$("#input-groupName").val("");
//    	onLoadDataTableGroup(degreeId);
//    },
//	"error" : function(xhr, status, error) {
//		  console.log(arguments);	
//		  alert(error);
//		  alert(xhr.responseText);
//		}
//	});
//	
//}
