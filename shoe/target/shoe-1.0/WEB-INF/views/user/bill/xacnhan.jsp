<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
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
						<form onSubmit="return checkSubmit()" id="form-xacnhan" action="xacnhan-publickey" method="post">
							<h2>
								<spring:message code="confirm" />
							</h2>
							<div class="group-input">
								<input onkeyup="return checkNull()" id="xacnhan" class="input100" type="text"
									name="maxacnhan" placeholder="Mã xác nhận" /> 
									<span id="msg" class="form-message" style="color: red"></span>
								<h6 style="color: red">${erro}</h6>
							</div>
							<button type="submit" class="site-btn login-btn" value="Xác nhận">
								<spring:message code="confirm" />
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>

	function checkNull() {
		var ok = false;
		var xacnhan = document.getElementById("xacnhan").value;
		if (xacnhan == "") {
			document.getElementById("msg").innerHTML = "Bạn không thể để trống dữ liệu này";
		} else {
			document.getElementById("msg").innerHTML = "";
			ok = true;
		}
		return ok;
	}
	function checkSubmit() {
		return checkNull;
	}
    </script>
</body>
</html>