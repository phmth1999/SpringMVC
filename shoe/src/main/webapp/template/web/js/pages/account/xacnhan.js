document.addEventListener('DOMContentLoaded',function() {
	Validator({
		form : "#form-xacnhan",
		formGroupSelector : ".group-input",
		errorSelector : ".form-message",
		rules : [
				Validator.isRequired('#xacnhan')
				]
	});
});