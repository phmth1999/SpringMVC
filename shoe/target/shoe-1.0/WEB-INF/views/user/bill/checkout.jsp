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
			<form:form id="form"  action="checkout"
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
								<div id="fullname" class="form-message" style="color: red"></div>
							</div>
							<div class="col-lg-12">
								<label><spring:message code="addressdelivery" /><span>*</span></label>
								<form:input  id="address" path="address" />
								<div id="msgAddress" class="form-message" style="color: red"></div>
							</div>
							<div class="col-lg-12">
								<label><spring:message code="email" /></label>
								<form:input id="email" type="email" path="user" readonly="true"/>
								<div id="msgEmail" class="form-message" style="color: red"></div>
							</div>
							<div class="col-lg-12">
								<label><spring:message code="phone" /><span>*</span></label>
								<form:input  id="phone" path="phone" />
								<div id="msgPhone" class="form-message" style="color: red"></div>
							</div>
							<div class="col-lg-12">
								<label><spring:message code="note" /><span>*</span></label>
								<form:select id="note"  path="note">
  									<form:option id="op" value="" hidden="true"></form:option>
  									<form:option id="op" value="Direct payment"></form:option>
  									<form:option id="op" value="Online payment"></form:option>
								</form:select>
								<div id="msgNote" class="form-message" style="color: red"></div>
							</div>
							
							<div class="col-lg-12">
								<label style="color: "> L??u ??: B???n c???n nh???p th??ng tin th???t ch??nh x??c.</label>
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
												pattern="#,##0 vn??" value="${item.value.totalPrice}" /></span></li>
									</c:forEach>
									<li class="total-price"><spring:message code="total" /> <span><fmt:formatNumber
												pattern="#,##0 vn??" value="${TotalPriceCart}" /></span></li>

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
									<button type="submit" class="site-btn place-btn">
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
		document
		.addEventListener(
				'DOMContentLoaded',
				function() {
					// Mong mu???n c???a ch??ng ta
					Validator({
						form : '#form',
						formGroupSelector : '.col-lg-12',
						errorSelector : '.form-message',
						rules : [
								Validator
										.isRequired('#address',
												'Vui l??ng nh???p ?????a ch??? m?? b???n nh???n h??ng'),
								Validator
										.isRequired('#note',
												'Vui l??ng ch???n ph????ng th???c thanh to??n'),
								Validator
										.isRequired('#phone',
												'Vui l??ng cung c???p ????ng s??? ??i???n tho???i ????? vi???c giao h??ng thu???n ti???n h??n')],
					});

				});
	</script>
</body>
</html>