document.addEventListener('DOMContentLoaded',function() {
	Validator({
		form : "#form-register",
		formGroupSelector : ".group-input",
		errorSelector : ".form-message",
		rules : [
				Validator.isRequired('#username'),
				Validator.checkUsernameExist('#username'),
				
				Validator.isRequired('#fullname'),
				
				Validator.isRequired('#address'),
				
				Validator.isRequired('#phone'),
				Validator.isPhone('#phone'),
				Validator.checkPhoneExist('#phone'),
				
				Validator.isRequired('#email'),
				Validator.isEmail('#email'),
				Validator.checkEmailExist('#email'),
				
				Validator.isRequired('#password'),
				Validator.isRequired('#password_confirmation'),
				Validator.isPassword('#password'),
				Validator.isConfirmed('#password_confirmation', function() {
															 	return document.querySelector('#form #password').value;
																},'Mật khẩu nhập lại không chính xác')
				]
	});
});