document.addEventListener('DOMContentLoaded',function() {
	Validator({
		form : '#form-checkout',
		formGroupSelector : '.col-lg-12',
		errorSelector : '.form-message',
		rules : [
				Validator.isRequired('#address'),
				
				Validator.isRequired('#note'),
				
				Validator.isRequired('#phone')
				]
	});
});