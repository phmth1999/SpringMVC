<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<h2><spring:message code="register" /></h2>
						<form:form id="form-register"  action="dang-ky" method="post" modelAttribute="user">
							<div class="group-input">
								<label for=username><spring:message code="email" /> *</label>
								<form:input id="username" placeholder="VD: ...@gmail.com" path="username" maxlength="50"/>
								<div id="nameMsg" class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="password"><spring:message code="pass" /> *</label>
								<form:password id="password" placeholder="VD: 'A-Z'+'a-z'+'0-9'" path="password" maxlength="16"/>
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="password_confirmation"><spring:message code="repass" />*</label> 
								<input id="password_confirmation" type="password" placeholder="Mời bạn nhập lại mật khẩu" maxlength="16"/> 
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="fullname"><spring:message code="fullname" /> *</label>
								<form:input id="fullname" placeholder="VD: Phạm Minh Thiện" path="fullname" maxlength="50"/>
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="address"><spring:message code="address" /> *</label>
								<form:input id="address" placeholder="VD: Cai Lậy, Tiền Giang, Tp.HCM" path="address" maxlength="255"/>
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="phone"><spring:message code="phone" /> *</label>
								<form:input id="phone" placeholder="VD: 0378348419" path="phone" maxlength="10"/>
								<div class="form-message" style="color: red"></div>
							</div>
							<button type="submit" class="site-btn register-btn"><spring:message code="register" /></button>
						</form:form>
						<div class="switch-login">
							<a href='<c:url value="/dang-nhap" />' class="or-login">Or <spring:message code="login" /></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>