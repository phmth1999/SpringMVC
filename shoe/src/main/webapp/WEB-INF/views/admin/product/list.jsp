<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
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
									<ul class="pagination" id="pagination"></ul>	
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="limit" name="limit"/>	
								</div>
							</div>
						</div>
				<div class="paginationRight" >
					<div class="pagination">
						<c:if test="${categoryORbrand == null }">
  							<!-- first -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/quan-tri/product?page=1"/>'>First</a>
							</c:if>
							<!-- previous -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/quan-tri/product?page=${previous }"/>'>&laquo;</a>
							</c:if>
							<!-- index -->
							<c:if test="${currentPage == 1 && totalPages == 1 }">
								<a class="active" href='<c:url value="/quan-tri/product?page=1"/>'>1</a>
							</c:if>
							<c:if test="${currentPage == 1 && totalPages == 2 }">
								<c:forEach var = "i" begin = "1" end = "2">
									<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/quan-tri/product?page=${i }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/quan-tri/product?page=${i }"/>'>${i }</a>
									 </c:if>
								</c:forEach>
							</c:if>
							<c:if test="${currentPage <= totalPages-2 && totalPages != 0 }">
								<c:if test="${currentPage <= 2 && totalPages != 0 }">
									 <c:forEach var = "i" begin = "1" end = "3">
									 	<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/quan-tri/product?page=${i }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/quan-tri/product?page=${i }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 	<c:if test="${currentPage > 2 && totalPages != 0 }">
							 	 	<c:forEach var = "i" begin = "${currentPage-2 }" end = "${currentPage+2 }">
							 			<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/quan-tri/product?page=${i }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/quan-tri/product?page=${i }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 </c:if>
							 <c:if test="${currentPage > totalPages - 2 && totalPages != 0 }">
							 	<c:forEach var = "i" begin = "${totalPages-4 }" end = "${totalPage }">
							 		<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/quan-tri/product?page=${i }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/quan-tri/product?page=${i }"/>'>${i }</a>
									 </c:if>
							 	</c:forEach>
							 </c:if>
  							<!-- next -->
  							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/quan-tri/product?page=${next }"/>'>&raquo;</a>
  							</c:if>
  							<!-- last -->
  							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/quan-tri/product?page=${totalPages }"/>'>Last</a>
  							</c:if>
  						</c:if>
  					</div>
  				</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>