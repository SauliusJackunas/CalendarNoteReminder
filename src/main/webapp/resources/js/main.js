$(function(){
	var input = document.getElementById('input');
	var picker = new Picker(input, {
	  format: 'YYYY-MM-DD HH:mm',
	  container: '.js-mini-picker-container',
	  inline: true,
	  rows: 3,
	});

	$(".remove").click(function(){

		console.log($(this).attr('id'));

		$.post("/rr",
			{
				reminderId: $(this).attr('id')
			}
		);

		$(this).parent().remove();
		$(this).remove();

	});

})