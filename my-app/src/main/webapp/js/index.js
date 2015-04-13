/**
 * 
 */

var rootURL = "http://localhost:8080/rest"

// Update configuration to our liking
$(document).on("pageinit", "#home", function(event) {
	/*
	 * $('#save').click(function() { alert('Button has been clicked'); });
	 */
	$("#save").bind("click", function(event, ui) {
		findByName("home", "Mehdi");
	});
});

function findByName(path, searchKey) {
	$.ajax({
		type : 'GET',
		url : rootURL + '/' + path + '/' + searchKey,
		dataType : "json",
		success : function(data) {
			switch (path) {
			
			/** Home Page */
			case "home":
				$('#name').val(data.nom);
				$('#level').val(data.niveau);
				return data;
				break;

			default:
				alert('Code error : ');
			}

		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Error : ' + textStatus);
		}
	});
}