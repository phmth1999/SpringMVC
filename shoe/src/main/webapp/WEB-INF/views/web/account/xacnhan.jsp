<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Xác nhận</title>
<meta charset="UTF-8">
</head>
<body>
	<div class="register-login-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="login-form">
						<form  id="form-xacnhan" action="xac-nhan" method="post">
							<h2><spring:message code="confirm" /></h2>
							<div class="group-input">
								<input  id="xacnhan" class="input100" type="text" name="maxacnhan" placeholder="Mã xác nhận" /> 
								<span id="msg" class="form-message" style="color: red"></span>
								<h6 style="color: red">${erro}</h6>
							</div>
							<button type="submit" class="site-btn login-btn" value="Xác nhận"><spring:message code="confirm" /></button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>