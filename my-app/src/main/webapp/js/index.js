var rootURL = "http://localhost:8080/rest"
//var rootURL = "http://mehdiappk.appspot.com/rest"
var datyp = "json"
var index = 0

$( ".treeview-menu-entity" ).click(function() {

     $("#content-header-text").html("Référenciel");         
     $("#page-header").load("pages/crud.html");
     $("#page-content" ).load( "entite/"+$(this).attr('name')+".html" );
     $("#entity" ).text($(this).attr('name'));
     $( ".sidebar-toggle" ).trigger( "click" );
})

$(document.body).on('click', '#create' ,function(){

  $.ajax({
		type : 'POST',
		url : rootURL + '/' + $('#entity').text(),
		contentType: 'application/json',
		dataType : datyp,
		data : $('#entityform').serializeJSON(),
		success : function(data) {
			alert('Saved ...');
			$('#entityform')[0].reset();
			$( "#search" ).trigger( "click" );
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Error : ' + textStatus);
		}
	});
	
})

$(document.body).on('click', '#search' ,function(){

  index = 0;
  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('#entity').text(),
		dataType : datyp,
		success : function(data) {
		    $(".btn-crud").prop('disabled', true);
		    if(data.length>1) $(".btn-crud").prop('disabled', false);   
		    $("#current").text(1);
		    $("#total").text(data.length);
			$('#entityform').loadJSON(data[index]);
		},
		error: function(){
            alert('search error ');
        }
	});

})

$(document.body).on('click', '#update' ,function(){
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: rootURL + '/' + $('#entity').text(),
        dataType: datyp,
        data: $('#entityform').serializeJSON(),
        success: function(textStatus, jqXHR){
            alert('updated successfully');
            $('#entityform')[0].reset();
			$( "#search" ).trigger( "click" );
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('update error: ' + textStatus);
        }
    });
})

$(document.body).on('click', '#delete' ,function(){
    console.log('delete !');
    $.ajax({
        type: 'DELETE',
        contentType: 'application/json',
		dataType : datyp,
        url: rootURL + '/' + $('#entity').text() + '/' + $("#id").val(),
        success: function(textStatus, jqXHR){
            alert('deleted successfully ');
            $( "#search" ).trigger( "click" );
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('delete error ');
        }
    });
})

$(document.body).on('click', '#next' ,function(){

  index = parseInt($("#current").text());
  index++;
  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('#entity').text(),
		dataType : datyp,
		success : function(data) {
		    $("#current").text(index);
		    $("#total").text(data.length);
		    if(index == data.length) $("#next").prop('disabled', true); 
		    if(index == 2) $("#prev").prop('disabled', false); 
			$('#entityform').loadJSON(data[index-1]);
		}
	});

})

$(document.body).on('click', '#prev' ,function(){

  index = parseInt($("#current").text());
  index--;
  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('#entity').text(),
		dataType : datyp,
		success : function(data) {
		    $("#current").text(index);
		    $("#total").text(data.length);
		    if(index == data.length-1) $("#next").prop('disabled', false); 
		    if(index == 1) $("#prev").prop('disabled', true); 
			$('#entityform').loadJSON(data[index-1]);
		}
	});

})

$(document.body).on('click', '#first' ,function(){

  index = 0;
  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('#entity').text(),
		dataType : datyp,
		success : function(data) {
		    $("#current").text(1);
		    $("#total").text(data.length);
		    $("#prev").prop('disabled', true);
		    $("#next").prop('disabled', false);
			$('#entityform').loadJSON(data[0]);
		}
	});

})

$(document.body).on('click', '#last' ,function(){

  $.ajax({
		type : 'GET',
		url : rootURL + '/' + $('#entity').text(),
		dataType : datyp,
		success : function(data) {
		    $("#current").text(data.length);
		    $("#total").text(data.length);
		    $("#next").prop('disabled', true);
		    $("#prev").prop('disabled', false);
			$('#entityform').loadJSON(data[data.length-1]);
		}
	});

})