<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách hóa đơn</title>
</head>

<body>

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="	glyphicon glyphicon-home"></i> <a href="#">Trang
							chủ</a></li>
				</ul>
			</div>
			<h1>${err }</h1>
			<div align="center" style="margin-top: 10px;"></div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<div class="widget-box table-filter">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<%-- <a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='#' href="<c:url value='#'/>">
												</a> --%>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>STT</th>
												<th>User</th>
												<th>Email</th>
												<th>Phone</th>
												<th>Full name</th>
												<th>Address</th>
												<th>Total</th>
												<th>Quanty</th>
												<th>Sign</th>
												<th>PubKey</th>
												<th>Data</th>
												<th>File</th>
												<th>Note</th>
												<th>Status</th>
												<th>Verify</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${listPageBills }" varStatus = "index">
												<tr>
													<td class="count">${index.count + ((currentPage-1)*6)}</td>
													<td class="user">${item.id_user}</td>
													<td class="user">${item.email}</td>
													<td class="phone">${item.phone}</td>
													<td class="fullname">${item.fullname}</td>
													<td class="address">${item.address}</td>
													<td class="total"><span><fmt:formatNumber pattern="#,##0 vnđ" value="${item.total}" /></span></td>
													<td class="quanty"><a href='<c:url value="/quan-tri/bill-detail/${item.id }" />'>${item.quanty}</a></td>
													<td class="sign">${item.sign}</td>
													<td class="sign">${item.pubkey}</td>
													<td class="data">${item.data}</td>
													<td class="data">${item.file}</td>
													<td class="note">${item.note}</td>
													<td class="note">${item.status}</td>
													<td class="edit"><a class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="#" href='<c:url value="/quan-tri/verify/${item.id }" />'><i
															class="glyphicon glyphicon-ok" aria-hidden="true"></i>
													</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
				<div class="paginationRight" >
					<div class="pagination">
						<c:if test="${categoryORbrand == null }">
  							<!-- first -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/quan-tri/bill?page=1"/>'>First</a>
							</c:if>
							<!-- previous -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/quan-tri/bill?page=${previous }"/>'>&laquo;</a>
							</c:if>
							<!-- index -->
							<c:if test="${currentPage == 1 && totalPages == 1 }">
								<a class="active" href='<c:url value="/quan-tri/bill?page=1"/>'>1</a>
							</c:if>
							<c:if test="${currentPage == 1 && totalPages == 2 }">
								<c:forEach var = "i" begin = "1" end = "2">
									<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/quan-tri/bill?page=${i }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/quan-tri/bill?page=${i }"/>'>${i }</a>
									 </c:if>
								</c:forEach>
							</c:if>
							<c:if test="${currentPage <= totalPages-2 && totalPages > 2 }">
								<c:if test="${currentPage <= 2 && totalPages != 0 }">
									 <c:forEach var = "i" begin = "1" end = "3">
									 	<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/quan-tri/bill?page=${i }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/quan-tri/bill?page=${i }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 	<c:if test="${currentPage > 2 && totalPages > 2 }">
							 	 	<c:forEach var = "i" begin = "${currentPage-2 }" end = "${currentPage+2 }">
							 			<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/quan-tri/bill?page=${i }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/quan-tri/bill?page=${i }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 </c:if>
							 <c:if test="${currentPage > totalPages - 2 && totalPages > 2 }">
							 	<c:forEach var = "i" begin = "${totalPages-4 }" end = "${totalPages }">
							 		<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/quan-tri/bill?page=${i }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/quan-tri/bill?page=${i }"/>'>${i }</a>
									 </c:if>
							 	</c:forEach>
							 </c:if>
  							<!-- next -->
  							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/quan-tri/bill?page=${next }"/>'>&raquo;</a>
  							</c:if>
  							<!-- last -->
  							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/quan-tri/bill?page=${totalPages }"/>'>Last</a>
  							</c:if>
  						</c:if>
  					</div>
  				</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
	<script type="text/javascript">
		
	</script>
</body>
</html>