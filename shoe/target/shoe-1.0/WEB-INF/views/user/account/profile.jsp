<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ho so khach hang</title>
</head>
<body>
<div class="register-login-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="register-form">
						<h2>Profile</h2>
						<form:form id="form" action="profile" method="post" modelAttribute="user">
							<div class="group-input">
								<label><spring:message code="email" /></label>
								<form:input id="username" path="username" readonly="true"/>
							</div>
							<div class="group-input">
								<label><spring:message code="fullname" /></label>
								<form:input id="fullname" path="fullname"/>
							</div>
							<div class="group-input">
								<label><spring:message code="address" /></label>
								<form:input id="address" path="address"/>
							</div>
							<div class="group-input">
								<label><spring:message code="phone" /></label>
								<form:input id="phone" path="phone"/>
							</div>
							<div class="group-input">
								<label>Publickey</label>
								<form:textarea  id="publickey" rows="5" path="publickey"/>
							</div>
							<button type="submit" class="site-btn register-btn">
								Edit
							</button> 
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>