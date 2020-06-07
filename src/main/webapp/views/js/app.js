if (!jQuery) {throw new TypeError("jQuery is required.");};
(function ($, window, document, undefined) {
	'use strict';

	$('#logginRegModalGenerator').click(function(e){
		e.preventDefault();
		$.ajax({
			url:$(this).attr('href'),
		}).done(function(response){
			$('.modal-container').html(response);
			$('.loginRegModal').modal('show');
		}).fail(function(data){
			console.log(data);
		});
	});

/*	$('#navbarCollapse').collapse({
		toggle: false
	});*/
	$('img').addClass("img-fluid");
})(jQuery, window, document);

$(window, document, undefined).ready(function() {

	  $('.input').blur(function() {
	    var $this = $(this);
	    if ($this.val())
	      $this.addClass('used');
	    else
	      $this.removeClass('used');
	  });
	  
	});
/*$('#login').on('click' , function(){
    $('#tab1').addClass('login-shadow');
   $('#tab2').removeClass('signup-shadow');
});

$('#tab2').on('click' , function(){
    $('#tab2').addClass('signup-shadow');
   $('#tab1').removeClass('login-shadow');


});
*/

$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

});

$(document).ready(function(){
	   $('.button-left').click(function(){
	       $('.sidebar').toggleClass('fliph');
	   });
	});