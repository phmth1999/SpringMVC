<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>
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
										<a
											class="btn btn-sm btn-primary btn-edit"
											data-toggle="tooltip" title='Thêm sản phẩm'
											href="<c:url value='/quan-tri/product/add'/>"><i class="glyphicon glyphicon-plus"></i> Thêm sản phẩm  </a>
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
												<th>Category</th>
												<th>Brand</th>
												<th>Name</th>
												<th>Image</th>
												<th>Price</th>
												<th>Quantity</th>
												<th>Edit</th>
												<th>Cancel</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${listPageProducts }" varStatus = "index">
												<tr>
													<%int current = Integer.parseInt(request.getAttribute("currentPage").toString()); %>
													<%if(current >= 2){%>
													<td class="count">${index.count + ((currentPage-1)*6)}</td>
													<%}else{ %>
													<td class="count">${index.count}</td>
													<%} %>
													<td>${item.nameCategory}</td>
													<td>${item.nameBrand}</td>
													<td>${item.name}</td>
													<td>${item.img}</td>
													<td>${item.price}</td>
													<td>${item.quantity}</td>
													<td class="edit">
													<a class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="Sửa sản phẩm" href='<c:url value="/quan-tri/product/edit?idProduct=${item.id }" />' >
														<i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>
													</a>
													</td>
													<td class="edit">
													<a class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="Hủy sản phẩm" href='<c:url value="/quan-tri/product/delete?idProduct=${item.id }" />'>
														<i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
													</a>
													</td>
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
								<a href='<c:url value="/quan-tri/product?page=${previous }"/>'>&laquo;</a>
								<%}else{%>
								<a href='<c:url value="/quan-tri/product?page=${currentPage } "/>'>&laquo;</a>
								<%} %>
								<!-- index -->
								<%if(current == 1 && totalPage == 1){ %>
									<a class="active" href="./product?page=1">1</a>
								<%}else if(current == 1 && totalPage == 2){ %>
									<%for (int i = 1; i <=2; i++) {%>
										<a <%if(current==i){ %>class="active"<%} %>
							 			href="./product?page=<%=i%>"><%=i %></a>
							 		<%} %>
								<%}else if(current<=totalPage-2 && totalPage!=0){ %>
									<%if(current<=2 && totalPage!=0){ %>
										<%for (int i = 1; i <=3; i++) {%>
										<a <%if(current==i){ %>class="active"<%} %>
							 			href="./product?page=<%=i%>"><%=i %></a>
							 			<%} %>
									<%}else if(current>2 && totalPage!=0){ %>
  										<%for (int i = current-2; i <=current+2; i++) {%>
										<a <%if(current==i){ %>class="active"<%} %>
							 			href="./product?page=<%=i%>"><%=i %></a>
							 			<%} %>
							 		<%} %>
							 	<%}else if(current>totalPage-2 && totalPage!=0){ %>
							 		<%for (int i = totalPage-4; i <=totalPage; i++) {%>
									<a <%if(current==i){ %>class="active"<%} %>
							 		href="./product?page=<%=i%>"><%=i %></a>
							 		<%} %>
							 	<%} %>
  								<!-- next -->
							 	<%if(current<totalPage){ %>
  								<a href='<c:url value="/quan-tri/product?page=${next }"/>'>&raquo;</a>
  								<%}else{%>
  								<a href='<c:url value="/quan-tri/product?page=${currentPage }"/>'>&raquo;</a>
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