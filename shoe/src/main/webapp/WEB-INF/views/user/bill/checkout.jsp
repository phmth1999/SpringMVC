<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="checkout-section spad">
		<div class="container">
			<form:form onSubmit="return checkSubmit()" action="checkout"
				method="post" modelAttribute="bill" class="checkout-form">
				<div class="row">
					<div class="col-lg-6">
						<h4 class="titileBillDetail">
							<spring:message code="billing-details" />
						</h4>
						<div class="row">
							<div class="col-lg-12">
								<label><spring:message code="fullname" /></label>
								<form:input id="fullname" path="fullname" readonly="true"/>
							</div>
							<div class="col-lg-12">
								<label><spring:message code="addressdelivery" /><span>*</span></label>
								<form:input onkeyup="return checkAddress()" id="address" path="address" />
								<span id="msgAddress" class="form-message" style="color: red"></span>
							</div>
							<div class="col-lg-6">
								<label><spring:message code="email" /></label>
								<form:input id="email" type="email" path="user" readonly="true"/>
								<span id="msgEmail" class="form-message" style="color: red"></span>
							</div>
							<div class="col-lg-6">
								<label><spring:message code="phone" /><span>*</span></label>
								<form:input onkeyup="return checkPhone()" id="phone" path="phone" />
								<span id="msgPhone" class="form-message" style="color: red"></span>
							</div>
							<div class="col-lg-12">
								<label><spring:message code="note" /><span>*</span></label>
								<br>
								<form:select id="note" onkeyup="return checkNote()" path="note">
  									<form:option id="op" value="" hidden="true"></form:option>
  									<form:option id="op" value="Direct payment"></form:option>
  									<form:option id="op" value="Online payment"></form:option>
								</form:select>
								<span id="msgNote" class="form-message" style="color: red"></span>
							</div>
							
							<div class="col-lg-12">
								<label style="color: "> Lưu ý: Bạn cần nhập thông tin thật chính xác.</label>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="place-order">
							<h4 class="titileOrder">
								<spring:message code="your-order" />
							</h4>
							<div class="order-total">
								<ul class="order-table">
									<c:forEach var="item" items="${Cart }">
										<li><spring:message code="product" /> <span><spring:message code="price" /></span></li>
										<li class="fw-normal">${item.value.product.name} &emsp;&emsp; x${item.value.quanty}<span><fmt:formatNumber
												pattern="#,##0 vnđ" value="${item.value.totalPrice}" /></span></li>
									</c:forEach>
									<li class="total-price"><spring:message code="total" /> <span><fmt:formatNumber
												pattern="#,##0 vnđ" value="${TotalPriceCart}" /></span></li>

								</ul>
								<!-- <div class="payment-check">
									<div class="pc-item">
										<label for="pc-check"> Cheque Payment <input
											type="checkbox" id="pc-check"> <span
											class="checkmark"></span>
										</label>
									</div>
									<div class="pc-item">
										<label for="pc-paypal"> Paypal <input type="checkbox"
											id="pc-paypal"> <span class="checkmark"></span>
										</label>
									</div>
								</div> -->
								<div class="order-btn">
									<button id="submit" type="submit" class="site-btn place-btn">
										<spring:message code="checkout" />
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</section>

	<script>
		function checkFullName() {
			var ok = false;
			var fullname = document.getElementById("fullname").value;
			if (fullname == "") {
				document.getElementById("msgFullName").innerHTML = "Bạn không thể để trống dữ liệu này";
			} else {
				document.getElementById("msgFullName").innerHTML = "";
				ok = true;
			}
			return ok;
		}
		function checkAddress() {
			var ok = false;
			var address = document.getElementById("address").value;
			if (address == "") {
				document.getElementById("msgAddress").innerHTML = "Bạn không thể để trống dữ liệu này";
			} else {
				document.getElementById("msgAddress").innerHTML = "";
				ok = true;
			}
			return ok;
		}
		function checkEmail() {
			var ok = false;
			var email = document.getElementById("email").value;
			var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			if (email == "") {
				document.getElementById("msgEmail").innerHTML = "Bạn không thể để trống dữ liệu này";
			} else if (!regex.test(email)) {
				document.getElementById("msgEmail").innerHTML = "Trường này phải là email";
			} else {
				document.getElementById("msgEmail").innerHTML = "";
				ok = true;
			}
			return ok;
		}
		function checkPhone() {
			var ok = false;
			var phone = document.getElementById("phone").value;
			if (phone == "") {
				document.getElementById("msgPhone").innerHTML = "Bạn không thể để trống dữ liệu này";
			} else {
				document.getElementById("msgPhone").innerHTML = "";
				ok = true;
			}
			return ok;
		}
		function checkNote() {
			var ok = false;
			var note = document.getElementById("note").value;
			if (note == "") {
				document.getElementById("msgNote").innerHTML = "Bạn không thể để trống dữ liệu này";
			} else {
				document.getElementById("msgNote").innerHTML = "";
				ok = true;
			}
			return ok;
		}
		function checkSubmit() {
			return checkFullName() && checkAddress() && checkEmail()
					&& checkPhone() && checkNote();
		}
	</script>
</body>
</html>