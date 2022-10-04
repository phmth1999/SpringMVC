<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<div class="register-login-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="register-form">
						<h2>
							<spring:message code="register" />
						</h2>
						<form:form id="form" action="dang-ky" method="post"
							modelAttribute="user">
							<div class="group-input">
								<label for=username><spring:message code="email" /> *</label>
								<form:input id="username" onblur="checkUsernameExsist()"  type="text" placeholder="VD: a@gmail.com"
									path="username" />
								<div id="nameMsg" class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="password"><spring:message code="pass" /> *</label>
								<form:input id="password" type="password"
									placeholder="VD: 123456" path="password" />
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="password_confirmation"><spring:message code="repass" />
									*</label> <input id="password_confirmation" type="password"
									placeholder="Mời bạn nhập lại mật khẩu" /> <div
									class="form-message" style="color: red"></div>
							</div>

							<div class="group-input">
								<label for="fullname"><spring:message code="fullname" /> *</label>
								<form:input id="fullname" type="text"
									placeholder="VD: Phạm Minh Thiện" path="fullname" />
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="address"><spring:message code="address" /> *</label>
								<form:input id="address" type="text"
									placeholder="VD: Cai Lậy, Tiền Giang, Tp.HCM" path="address" />
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="phone"><spring:message code="phone" /> *</label>
								<form:input id="phone" type="text" placeholder="VD: 0378348419"
									path="phone" />
								<div class="form-message" style="color: red"></div>
							</div>
							<button type="submit" class="site-btn register-btn">
								<spring:message code="register" />
							</button>
						</form:form>
						<div class="switch-login">
							<a href='<c:url value="/dang-nhap" />' class="or-login">Or <spring:message
									code="login" /></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script>
	 function checkUsernameExsist() {
		$("#username").blur(function(){
			var name=$("#username").val();
			var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			$.ajax({
				url: "${pageContext.request.contextPath}/checkUsername",
				type: "post",
				data:"username="+name,
				dataType: "text",
				success:function(result){
					if(name==""){
						$("#nameMsg").html("Vui lòng nhập email");
					}else if(!regex.test(name)){
						$("#nameMsg").html("Trường này phải là email");
				    }else if(result==true){
						$("#nameMsg").html("Email đã tồn tại");
					}else{
						$("#nameMsg").html("");
					}
				}
			});
		});
		} 

		document
				.addEventListener(
						'DOMContentLoaded',
						function() {
							// Mong muốn của chúng ta
							Validator({
								form : '#form',
								formGroupSelector : '.group-input',
								errorSelector : '.form-message',
								rules : [
										Validator
												.isRequired('#username',
														'Vui lòng nhập đầy đủ'),
										Validator
												.isRequired('#fullname',
														'Vui lòng nhập tên đầy đủ của bạn'),
										Validator
												.isRequired('#address',
														'Vui lòng nhập địa chỉ đầy đủ của bạn'),
										Validator
												.isRequired('#phone',
														'Vui lòng nhập số điện thoại của bạn'),
										Validator.minLength('#password', 3),
										Validator
												.isRequired('#password_confirmation'),
										Validator
												.isConfirmed(
														'#password_confirmation',
														function() {
															return document
																	.querySelector('#form #password').value;
														},
														'Mật khẩu nhập lại không chính xác') ],
							});

						});
		
		
		
	</script>
</body>
</html>