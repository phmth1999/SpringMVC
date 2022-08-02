<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>

	<!-- Register Section Begin -->
	<div class="register-login-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="login-form">
						<h2>
							<spring:message code="login" />
						</h2>
						<c:if test="${param.incorrectAccount != null }">
							<div class="alert alert-danger">Username or password
								incorrect</div>
						</c:if>
						<c:if test="${param.accessDenied != null }">
							<div class="alert alert-danger">You not authorize</div>
						</c:if>
						<form:form id="form-login" action="j_spring_security_check"
							method="post" modelAttribute="user">
							<div class="group-input">
								<label for="username"><spring:message code="email" /> *</label>
								<form:input id="email" type="email"
									placeholder="Mời bạn nhập email" path="username" />
								<span class="form-message" style="color: red"></span>
							</div>
							<div class="group-input">
								<label for="password"><spring:message code="pass" /> *</label>
								<form:input id="password" type="password"
									placeholder="Mời bạn nhập mật khẩu" path="password" />
								<span class="form-message" style="color: red"></span>
							</div>
							<button type="submit" class="site-btn login-btn">
								<spring:message code="login" />
							</button>
						</form:form>
						<div class="switch-login">
							<a href='<c:url value="/dang-ky" />' class="or-login">Or <spring:message
									code="register" /></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Register Form Section End -->


</body>
</html>