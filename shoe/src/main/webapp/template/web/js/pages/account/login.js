document.addEventListener('DOMContentLoaded',function() {
	Validator({
		form : "#form-login",
		formGroupSelector : ".group-input",
		errorSelector : ".form-message",
		rules : [
				Validator.isRequired('#username'),
						
				Validator.isRequired('#password')
				]
	});
});