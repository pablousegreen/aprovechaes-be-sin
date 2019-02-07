$(document).ready(function(){
	$('.table .eBtn').on('click', function(event){
		event.preventDefault();
		console.log("<-----New/Update Proccess----->");
		var href = $(this).attr('href');
		var text = $(this).text();
		console.log("text->: ", text);
		console.log("href->: ", href);
		if(text === 'Edit'){
			$.get(href, function(country, status){
				console.log("country->: ", country.id);
				console.log("status->:", status);
				
				$('.myForm #id').val(country.id);
				$('.myForm #name').val(country.name);
				$('.myForm #capital').val(country.capital);
			});
			
			$('.myForm #exampleModal').modal();
		}else if(text === 'New'){
			$('.myForm #id').val('');
			$('.myForm #name').val('');
			$('.myForm #capital').val('');
			$('.myForm #exampleModal').modal();
		}
	});
	
	$('.table .delBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		console.log("Delete href->: ", href);
		$('#exampleModalCenter #delRef').attr('href', href);
		$('#exampleModalCenter').modal();
	});
});