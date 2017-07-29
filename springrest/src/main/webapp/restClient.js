function doGet(){
	$.ajax({
    	type: "GET",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/restdemo/services/personservice/persons/"+$('#personID').val()
    }).then(function(data) {
       $('#personID').val(data.id);
       $('#personName').val(data.name);
    });
}
	
function doPost(){
$.ajax({
	type: "POST",
	 contentType: "application/json; charset=utf-8",
     dataType: "json",
     data: JSON.stringify({name:$('#personName').val()}),
    url: "http://localhost:8080/restdemo/services/personservice/persons"
    	
	}).then(function(data) {
		$('#personID').val(data.id);
		$('#personName').val(data.name);
		alert('Person Created');
	});
    
}

function doPut(){
	$.ajax({
		type: "PUT",
		 contentType: "application/json; charset=utf-8",
	     dataType: "json",
	     data: JSON.stringify({name:$('#personName').val()}),
	    url: "http://localhost:8080/restdemo/services/personservice/persons"
	    	
		}).then(function(data) {
			$('#personID').val(data.id);
			$('#personName').val(data.name);
			alert('Person Updated');
		});
	    
}
	
function doDelete(){
	$.ajax({
    	type: "DELETE",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/restdemo/services/personservice/persons/"+$('#personID').val()
    }).then(function(data) {
       alert('Person Deleted');
    });
}