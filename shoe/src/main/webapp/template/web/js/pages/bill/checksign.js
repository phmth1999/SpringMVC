document.addEventListener('DOMContentLoaded',function() {
	Validator({
		form : "#form-checksign",
		formGroupSelector : ".group-input",
		errorSelector : ".form-message",
		rules : [
				Validator.isRequired('#sign'),
				Validator.isRequired('#pubkey')
				]
	});
});