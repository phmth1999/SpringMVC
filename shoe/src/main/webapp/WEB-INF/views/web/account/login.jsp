<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
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
								<label for="username">Username *</label>
								<form:input id="username" path="username" placeholder="Mời bạn nhập username" maxlength="50" />
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for="password"><spring:message code="pass" /> *</label>
								<form:password id="password" path="password" placeholder="Mời bạn nhập mật khẩu" maxlength="8" />
								<div class="form-message" style="color: red"></div>
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