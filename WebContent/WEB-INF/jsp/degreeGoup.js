var contextPath ="";
$(document).ready(function() {
    	contextPath = "<%= request.getContextPath() %>";
    	console.log("contextPath : "+contextPath);
		// ----------
		    	    $('#degreeGuop').dataTable({
		    		'iDisplayLength': 10,
		    		'bPaginate': true,
		    		"bProcessing": true,
		            "sAjaxSource": contextPath+"/degree/ajaxtest",
		                    "fnServerData": function ( sSource, aoData, fnCallback ) {
		                $.ajax( {
		                    "dataType": 'json',
		                    "type": "GET",
		                    "url": sSource,
		                    "data": {organizationId : 'sdsdsd'},
		                    "success": function(data){
		                    	console.log(data);
		                    	setdegreeGuopTable(data);
		                    },
		        			"error" : function(xhr, status, error) {
		      				  console.log(arguments);	
		      				  alert(error);
		      				  alert(xhr.responseText);
		      				}
		                } );
		            }
// ,
// 'aoColumns' : [{'mData' : 'mdId'},
// { 'mData': 'mdName' }]
   	    		   ,"sPaginationType" : "full_numbers",
   	    		   "aLengthMenu" : [ [ 4, 10, 20, -1 ], [ 4, 10, 20, "All" ] ]
		        } );

});
		// alert("xx");
		// $.material.init();
function setdegreeGuopTable(data){
		console.log("into set Data table");
		for(var i=0 ;i<data.length;i++){
	 		$('#degreeGuop').dataTable().fnAddData( [
            data[i].mdId,
            data[i].mdName,
            "xxxx"
            ] );
		}
	}