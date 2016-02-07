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


$(document.body).on('change', "#select-crud", function(){ 
    var val = parseInt($(this).val(), 10);
    switch (val) {
        case 1://search
           $('#page-content').find('input, textarea, button, select').attr('disabled', true);
        break;
        case 2: //create
           $('#page-content').find('input, textarea, button, select').attr('disabled', false);
           $('#page-content').find('input, textarea, button, select').val("");
        break;
        case 3: //update
           $('#page-content').find('input, textarea, button, select').attr('disabled', false);
        break;
        case 4: //delete
           $('#page-content').find('input, textarea, button, select').attr('disabled', true);
        break;
    }
})

$(document.body).on('click', '#valid-crud' ,function(){ 
    var val = parseInt($("#select-crud").val(), 10);
    switch (val) {
        case 1:
           Search();
        break;
        case 2:  
           Create();
        break;
        case 3: 
           Update();
        break;
        case 4: 
           Delete();
        break;
    }
})

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
			Search();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Add error');
		}
	});
	
}

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
}

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
			Search();
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
}

function Delete(){ 
    if (confirm('Vous confirmez la suppression?')) { 
        $.ajax({
            type: 'DELETE',
            contentType: 'application/json',
		    dataType : datyp,
            url: rootURL + '/' + $('#entity').text() + '/' + $("#id").val(),
            success: function(textStatus, jqXHR){
                alert('enregistrement supprimé ');
                Search();
            },
            error: function(jqXHR, textStatus, errorThrown){
                alert('delete error ');
            }
        });
    }    
}

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