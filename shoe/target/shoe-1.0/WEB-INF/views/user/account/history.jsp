<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lich su mua hang</title>
</head>
<body>
<div class="register-login-section spad">
		<div class="container">
			<h2 class="titileHistory">History</h2>
			<div class="row">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>STT</th>
							<th>User</th>
							<th>Phone</th>
							<th>Full name</th>
							<th>Address</th>
							<th>Total</th>
							<th>Quanty</th>
							<th>sign</th>
							<th>data</th>
							<th>Note</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${bill }" varStatus = "index"> 
						<tr>
							<td class="count">${index.count}</td>
							<td class="user">${item.user}</td>
							<td class="phone">${item.phone}</td>
							<td class="fullname">${item.fullname}</td>
							<td class="address">${item.address}</td>
							<td class="total">${item.total}</td>
							<td class="quanty"><a href='<c:url value="/history-detail?idBill=${item.id }" />'>${item.quanty}</a></td>
							<td class="sign">${item.sign}</td>
							<td class="data">${item.data}</td>
							<td class="note">${item.note}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="paginationRight" >
						<div class="pagination">
							<%int current = Integer.parseInt(request.getAttribute("currentPage").toString()); %>
							<%int totalPage = Integer.parseInt(request.getAttribute("totalPages").toString()); %>
							<!-- previous -->
							<%if(current>1){ %>
							<a href='<c:url value="/history?page=${previous }"/>'>&laquo;</a>
							<%}else{%>
							<a href='<c:url value="/history?page=${currentPage } "/>'>&laquo;</a>
							<%} %>
							<!-- index -->
  							<%for (int i = 1; i <= Integer.parseInt(request.getAttribute("totalPages").toString()); i++) {%>
							<a <%if(current==i){ %>class="active"<%} %>
							 href="./history?page=<%=i%>"><%=i %></a><%} %>
  							<!-- next -->
							 <%if(current<totalPage){ %>
  							<a href='<c:url value="/history?page=${next }"/>'>&raquo;</a>
  							<%}else{%>
  							<a href='<c:url value="/history?page=${currentPage }"/>'>&raquo;</a>
  							<%} %>
						</div>
					</div>
		</div>
	</div>
</body>
</html>