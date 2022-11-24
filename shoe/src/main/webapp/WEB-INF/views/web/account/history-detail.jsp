<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History Detail</title>
</head>
<body>
<div class="register-login-section spad">
		<div class="container">
		<h2 class="titileHistory">History Detail</h2>
			<div class="row">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>STT</th>
							<th>Img</th>
							<th>Name</th>
							<th>Price</th>
							<th>Total</th>
							<th>Quanty</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${billDetail }" varStatus = "index"> 
						<tr>
							<td class="count">${index.count}</td>
							<td class="img"><img src='<c:url value="/template/web/img/products/${item.img }" />' alt=""></td>
							<td class="name">${item.name}</td>
							<td class="price"><span><fmt:formatNumber pattern="#,##0 vnđ" value="${item.price}" /></span></td>
							<td class="total"><span><fmt:formatNumber pattern="#,##0 vnđ" value="${item.total}" /></span></td>
							<td class="quanty">${item.quanty}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<h2 class="linkGoBack"><a href='<c:url value="/history?page=${pageSessionHistoryWeb }" />'>Go Back</a></h2>
		</div>
	</div>
</body>
</html>