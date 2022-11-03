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
							<td class="total"><span><fmt:formatNumber pattern="#,##0 vnđ" value="${item.total}" /></span></td>
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
							<!-- first -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/history?page=1"/>'>First</a>
							</c:if>
							<!-- previous -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/history?page=${previous }"/>'>&laquo;</a>
							</c:if>
							<!-- index -->
							<c:if test="${currentPage == 1 && totalPages == 1 }">
								<a class="active" href='<c:url value="/history?page=1"/>'>1</a>
							</c:if>
							<c:if test="${currentPage == 1 && totalPages == 2 }">
								<c:forEach var = "i" begin = "1" end = "2">
									<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/history?page=${i }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/history?page=${i }"/>'>${i }</a>
									 </c:if>
								</c:forEach>
							</c:if>
							<c:if test="${currentPage <= totalPages-2 && totalPages > 2 }">
								<c:if test="${currentPage <= 2 && totalPages != 0 }">
									 <c:forEach var = "i" begin = "1" end = "3">
									 	<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/history?page=${i }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/history?page=${i }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 	<c:if test="${currentPage > 2 && totalPages > 2 }">
							 	 	<c:forEach var = "i" begin = "${currentPage-2 }" end = "${currentPage+2 }">
							 			<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/history?page=${i }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/history?page=${i }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 </c:if>
							 <c:if test="${currentPage > totalPages - 2 && totalPages > 2 }">
							 	<c:forEach var = "i" begin = "${totalPages-4 }" end = "${totalPage }">
							 		<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/history?page=${i }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/history?page=${i }"/>'>${i }</a>
									 </c:if>
							 	</c:forEach>
							 </c:if>
  							<!-- next -->
							 <c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/history?page=${next }"/>'>&raquo;</a>
  							</c:if>
  							<!-- last -->
							 <c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/history?page=${totalPages }"/>'>Last</a>
  							</c:if>
						</div>
					</div>
		</div>
	</div>
</body>
</html>