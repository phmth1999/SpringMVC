<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check sign</title>
</head>
<body>
<div class="register-login-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="login-form">
						<form onSubmit="return checkSubmit()" action="sign" method="post">
							<h2>
								<spring:message code="sign" />
							</h2>
							<span> </span>
						
							<div class="group-input">
								<textarea rows="5" onkeyup="return checkSign()" id="sign" name="sign" placeholder="Mã hash chữ ký" ></textarea> 
									<span id="msgSign" class="form-message" style="color: red"></span>
								<h6 style="color: red">${erro}</h6>
							</div>
							<div class="link-publickey">
							<a href='<c:url value="/update-publickey" />'>Update Publickey</a>
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

	function checkSign() {
		var ok = false;
		var sign = document.getElementById("sign").value;
		if (sign == "") {
			document.getElementById("msgSign").innerHTML = "Bạn không thể để trống dữ liệu này";
		} else {
			document.getElementById("msgSign").innerHTML = "";
			ok = true;
		}
		return ok;
	}
	function checkSubmit() {
		return checkSign();
	}
    </script>
</body>
</html>