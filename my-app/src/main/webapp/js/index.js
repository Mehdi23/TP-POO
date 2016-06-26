var rootURL = "http://localhost:8080/rest"
//var rootURL = "http://mehdiappk.appspot.com/rest"
var datyp = "json";
var index = 0;
var crud = 0;

//Find
$(document.body).on('click', '#r-crud' ,function(){
	crud=0;
	$("#c-crud").prop('disabled', true);$("#r-crud").prop('disabled', true);$("#u-crud").prop('disabled', false);$("#d-crud").prop('disabled', false); 
    $('#page-content').find('input, textarea, button, select').attr('disabled', true);	
	Search();
});

//Add
$(document.body).on('click', '#c-crud' ,function(){
	crud=1;
	$("#c-crud").prop('disabled', true);$("#r-crud").prop('disabled', true);$("#u-crud").prop('disabled', true);$("#d-crud").prop('disabled', true); 
	$('#page-content').find('input, textarea, button, select').attr('disabled', false);
    $('#page-content').find('input, textarea, button, select').val("");
});

//Update
$(document.body).on('click', '#u-crud' ,function(){
	crud=2;
	$("#c-crud").prop('disabled', true);$("#r-crud").prop('disabled', true);$("#u-crud").prop('disabled', true);$("#d-crud").prop('disabled', true);  
	$('#page-content').find('input, textarea, button, select').attr('disabled', false);
});

//Delete
$(document.body).on('click', '#d-crud' ,function(){
	crud=3;
	$("#c-crud").prop('disabled', true);$("#r-crud").prop('disabled', true);$("#u-crud").prop('disabled', true);$("#d-crud").prop('disabled', true);
    $('#page-content').find('input, textarea, button, select').attr('disabled', true);	
	Delete();
	echape();
});

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

});

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

});

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

});

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

});
	
//Enter/Escape
$(document).keyup(function(e) {
  if (e.keyCode === 13) { // enter
    switch(crud) {
		case 0:
		   
		break;
		case 1:
		   Create();
		   echape();
		break;
		case 2:
		   Update();
		   echape();
		break;
		case 3:
		   
		break;		
	}
  }     
  if (e.keyCode === 27) echape(); // esc  
});

function echape() {
	$("#c-crud").prop('disabled', false);$("#r-crud").prop('disabled', false);$("#u-crud").prop('disabled', true);$("#d-crud").prop('disabled', true);
	$('#page-content').find('input, textarea, button, select').attr('disabled', true);
    $('#page-content').find('input, textarea, button, select').val("");
	$(".btn-crud").prop('disabled', true);
    $("#current").text(".");
    $("#total").text(".");	
};

function Create(){

  $.ajax({
		type : 'POST',
		url : rootURL + '/' + $('#entity').text(),
		contentType: 'application/json',
		dataType : datyp,
		data : $('#entityform').serializeJSON(),
		success : function(data) {
			alert('Saved ...');
			$('#entityform')[0].reset();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Add error');
		}
	});
	
};

function Search(){
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
	$('#page-content').find('input, textarea, button, select').attr('disabled', true);
};

function Update(){
    if (confirm('Vous confirmez la modification?')) { 
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: rootURL + '/' + $('#entity').text(),
        dataType: datyp,
        data: $('#entityform').serializeJSON(),
        success: function(textStatus, jqXHR){
            alert('updated successfully');
            $('#entityform')[0].reset();
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('update error: ');
        }
    });
    }
    
    else {
        $('#entityform')[0].reset();
        Search();
    }
};

function Delete(){ 
    if (confirm('Vous confirmez la suppression?')) { 
        $.ajax({
            type: 'DELETE',
            contentType: 'application/json',
		    dataType : datyp,
            url: rootURL + '/' + $('#entity').text() + '/' + $("#id").val(),
            success: function(textStatus, jqXHR){
                alert('enregistrement supprimé ');
            },
            error: function(jqXHR, textStatus, errorThrown){
                alert('delete error ');
            }
        });
    }    
};
//Chargement de la page du CRUD
$( ".treeview-menu-entity" ).click(function() {

     $("#content-header-text").html("Référenciel");         
     $("#page-header").load("pages/crud.html");
     $("#page-content" ).load( "entite/"+$(this).attr('name')+".html" );
     $("#entity" ).text($(this).attr('name'));
     $( ".sidebar-toggle" ).trigger( "click" );
	 $(".btn-crud").prop('disabled', true);

})