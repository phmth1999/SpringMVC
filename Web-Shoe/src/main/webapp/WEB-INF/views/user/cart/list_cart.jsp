<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>

	<section class="shopping-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="cart-table">
						<table>
							<thead>
								<tr>
									<th>Image</th>
									<th class="p-name">Product Name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
									<th>Edit</th>
									<th><i class="ti-close"></i></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${Cart }">
									<tr>
										<td class="cart-pic first-row"><img
											src='<c:url value="/template/user/img/products/${item.value.product.img }" />'
											alt=""></td>
										<td class="cart-title first-row">
											<h5>${item.value.product.name }</h5>
										</td>
										<td class="p-price first-row"><fmt:formatNumber pattern="#,##0 vnđ" value="${item.value.product.price}" />
											</td>
										<td class="qua-col first-row">
											<div class="quantity">
												<div class="pro-qty">
													<input id="quanty-cart-${item.key }" type="text"
														value="${item.value.quanty }">
												</div>
											</div>
										</td>
										<td class="total-price first-row"><fmt:formatNumber pattern="#,##0 vnđ" value="${item.value.totalPrice}" />
											</td>
										<td class="close-td first-row"><button
												data-id="${item.key }" class="primary-btn up-cart edit-cart"
												type="button">edit</button></td>
										<td class="close-td first-row"><a
											href='<c:url value="/deletecart/${item.key }" />'><i
												class="ti-close"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="row">
						<div class="col-lg-4">
						</div>
						<div class="col-lg-4 offset-lg-4">
							<div class="proceed-checkout">
								<ul>
									<li class="subtotal">Subtotal <span>
											</span></li>
									<li class="cart-total">Total <span><fmt:formatNumber pattern="#,##0vnđ" value="${TotalPriceCart}" />
											</span></li>
								</ul>
								<a href='<c:url value="/checkout" />' class="proceed-btn">PROCEED
									TO CHECK OUT</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<content tag="script"> <script>
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quanty-cart-" + id).val();
			window.location = "editcart/" + id + "/" + quanty;
		});
	</script></content>

</body>
</html>