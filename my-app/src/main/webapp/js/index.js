var rootURL = "http://localhost:8080/rest"
var index = 0

$( "#create" ).click(function() {

  $.ajax({
		type : 'POST',
		url : rootURL + '/' + $('title').text(),
		contentType: 'application/json',
		dataType : "jsonp",
		data : $('form').serializeJSON(),
		success : function(data) {
			alert('Saved ...');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Error : ' + textStatus);
		}
	});
	
})

$( "#search" ).click(function() {

  index = 0;
  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('title').text(),
		dataType : "json",
		success : function(data) {
		    $("#current").text(1);
		    $("#total").text(data.length);
			$('form').loadJSON(data[index]);
		}
	});

})

$( "#next" ).click(function() {

  index = parseInt($("#current").text());
  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('title').text(),
		dataType : "json",
		success : function(data) {
		    $("#current").text(index+1);
		    $("#total").text(data.length);
		    if(index == data.length-1) $("#next").prop('disabled', true); 
		    if(index == 2) $("#prev").prop('disabled', false); 
			$('form').loadJSON(data[index]);
		}
	});

})

$( "#prev" ).click(function() {

  index = parseInt($("#current").text());
  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('title').text(),
		dataType : "json",
		success : function(data) {
		    $("#current").text(index-1);
		    $("#total").text(data.length);
		    if(index == data.length-1) $("#next").prop('disabled', false); 
		    if(index == 2) $("#prev").prop('disabled', true); 
			$('form').loadJSON(data[index-2]);
		}
	});

})

$( "#first" ).click(function() {

  index = 0;
  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('title').text(),
		dataType : "json",
		success : function(data) {
		    $("#current").text(1);
		    $("#total").text(data.length);
		    $("#prev").prop('disabled', true);
		    $("#next").prop('disabled', false);
			$('form').loadJSON(data[0]);
		}
	});

})

$( "#last" ).click(function() {

  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('title').text(),
		dataType : "json",
		success : function(data) {
		    $("#current").text(data.length);
		    $("#total").text(data.length);
		    $("#next").prop('disabled', true);
		    $("#prev").prop('disabled', false);
			$('form').loadJSON(data[data.length-1]);
		}
	});

})