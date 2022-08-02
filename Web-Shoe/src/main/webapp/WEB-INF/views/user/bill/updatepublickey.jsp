<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update publickey</title>
</head>
<body>
<div class="register-login-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="login-form">
						<form onSubmit="return checkSubmit()" action="update-publickey" method="post">
							<h2>
								update
							</h2>
							<span> </span>
						
							<div class="group-input">
								<input onkeyup="return checkSign()" id="key" class="input100" type="text"
									name="key" placeholder="update publicKey" /> 
									<span id="msgSign" class="form-message" style="color: red"></span>
								<h6 style="color: red">${erro}</h6>
							</div>
							
							<button type="submit" class="site-btn login-btn" value="update">
								update
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
		var sign = document.getElementById("key").value;
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