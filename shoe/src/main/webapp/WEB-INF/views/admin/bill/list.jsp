<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
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
												<th>Phone</th>
												<th>Full name</th>
												<th>Address</th>
												<th>Total</th>
												<th>Quanty</th>
												<th>sign</th>
												<th>data</th>
												<th>Note</th>
												<th>Check</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${listPageBills }" varStatus = "index">
												<tr>
													<td class="count">${index.count + ((currentPage-1)*6)}</td>
													<td class="user">${item.user}</td>
													<td class="phone">${item.phone}</td>
													<td class="fullname">${item.fullname}</td>
													<td class="address">${item.address}</td>
													<td class="total">${item.total}</td>
													<td class="quanty"><a href='<c:url value="/quan-tri/bill-detail?idBill=${item.id }" />'>${item.quanty}</a></td>
													<td class="sign">${item.sign}</td>
													<td class="data">${item.data}</td>
													<td class="note">${item.note}</td>
													<td class="edit"><a class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="#" href="#"><i
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
								<%int current = Integer.parseInt(request.getAttribute("currentPage").toString()); %>
								<%int totalPage = Integer.parseInt(request.getAttribute("totalPages").toString()); %>
								<!-- previous -->
								<%if(current>1){ %>
								<a href='<c:url value="/quan-tri/bill?page=${previous }"/>'>&laquo;</a>
								<%}else{%>
								<a href='<c:url value="/quan-tri/bill?page=${currentPage } "/>'>&laquo;</a>
								<%} %>
								<!-- index -->
								<%if(current == 1 && totalPage == 1){ %>
									<a class="active" href="./bill?page=1">1</a>
								<%}else if(current == 1 && totalPage == 2){ %>
									<%for (int i = 1; i <=2; i++) {%>
										<a <%if(current==i){ %>class="active"<%} %>
							 			href="./bill?page=<%=i%>"><%=i %></a>
							 		<%} %>
								<%}else if(current<=totalPage-2 && totalPage!=0){ %>
									<%if(current<=2 && totalPage!=0){ %>
										<%for (int i = 1; i <=3; i++) {%>
										<a <%if(current==i){ %>class="active"<%} %>
							 			href="./bill?page=<%=i%>"><%=i %></a>
							 			<%} %>
									<%}else if(current>2 && totalPage!=0){ %>
  										<%for (int i = current-2; i <=current+2; i++) {%>
										<a <%if(current==i){ %>class="active"<%} %>
							 			href="./bill?page=<%=i%>"><%=i %></a>
							 			<%} %>
							 		<%} %>
							 	<%}else if(current>totalPage-2 && totalPage!=0){ %>
							 		<%for (int i = totalPage-4; i <=totalPage; i++) {%>
									<a <%if(current==i){ %>class="active"<%} %>
							 		href="./bill?page=<%=i%>"><%=i %></a>
							 		<%} %>
							 	<%} %>
  								<!-- next -->
							 	<%if(current<totalPage){ %>
  								<a href='<c:url value="/quan-tri/bill?page=${next }"/>'>&raquo;</a>
  								<%}else{%>
  								<a href='<c:url value="/quan-tri/bill?page=${currentPage }"/>'>&raquo;</a>
  								<%} %>
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