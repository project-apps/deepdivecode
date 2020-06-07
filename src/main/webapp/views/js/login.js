/**
 * File for only login helpers.
 */
if (!jQuery) {throw new TypeError("jQuery is required.");};
(function ($, window, document, undefined) {
	'use strict';

var popupWindow;
$('.ssoLogin').click(function(e){
	e.preventDefault();
	var _this = $(this);
	$.ajax({
		url:$(this).attr('href'),
	}).done(function(response){
		if(response){
			popupWindow = window.open(response, "popupWindow", "width=600,height=600,scrollbars=yes");
		}
		
	}).fail(function(data){
		alert(data);
		_this.closest('form').find('.errorSpan').empty().append(data).css('visibility','visible');
	});
	
});
$('#loginForm').submit(function(e){
	e.preventDefault();
	var _this = $(this);
	var formData = {}
	$.each(this, function(i, v){
		var input = $(v);
		formData[input.attr("name")] = input.val();
	});
	$.ajax({
		url: $(this).attr('action'),
		type: $(this).attr('method'),
		contentType: "application/json; charset=utf-8",
		dataType: 'json',
		data: JSON.stringify(formData),
	}).done(function(data) {
		if(data.status=="CREATED"){
			loginSuccess(data);
			$('#loginRegModal').modal('hide');
		}else{
			_this.closest('form').find('.errorSpan').empty().append(data.value).css('visibility','visible');
		}
	}).fail(function(data){
		_this.closest('form').find('.errorSpan').empty().append(JSON.stringify(data)).css('visibility','visible');
	});
});
$('#signupForm').submit(function(e){
	e.preventDefault();
	var _this =$(this);
	var formData = {}
	$.each(this, function(i, v){
		var input = $(v);
		formData[input.attr("name")] = input.val();
	});
	$.ajax({
		url: $(this).attr('action'),
		type: $(this).attr('method'),
		contentType: "application/json; charset=utf-8",
		dataType: 'json',
		data: JSON.stringify(formData),
	}).done(function(data) {
		if(data.status=="OK"){
			loginSuccess(data);
			$('#loginRegModal').modal('hide');
		}else{
			_this.closest('form').find('.errorSpan').empty().append(data.value).css('visibility','visible');
		}
	}).fail(function(data){
		_this.closest('form').find('.errorSpan').empty().append(JSON.stringify(data)).css('visibility','visible');
	});
});

})(jQuery, window, document);

function loginSuccess(authUserFirstLastName, source){
	if(source.toUpperCase()==='SOCIAL'){
		var opener = window.opener;
		if(opener){
			opener.$('.loginRegModal').modal('toggle');
			opener.$('#logginRegModalGenerator').parent('div').addClass('hide');
			opener.$('div.user-toogle > a.dropdown-toggle').html(authUserFirstLastName);
			opener.$('.user-toogle').removeClass('hide');
		}
	}else{
		$('.loginRegModal').modal('toggle');
		('#logginRegModalGenerator').addClass('hide');
		$('div.user-toogle > a.dropdown-toggle').html(authUserFirstLastName);		
		$('.user-toogle').removeClass('hide');
	}
	
}

