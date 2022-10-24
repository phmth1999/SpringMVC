<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách tài khoản</title>
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
										 <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
												   title='Thêm tài khoản' href="<c:url value='/dang-ky'/>"><i class="glyphicon glyphicon-plus"></i>  Thêm tài khoản</a> 
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="table" class="table table-bordered">
										<thead>
											<tr>
												<th>STT</th>
												<th>UserName</th>
												<th>Full name</th>
												<th>Address</th>
												<th>Phone</th>
												<th>Role</th>
												<th>Enabled</th>
												<th>Block</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${listPageUsers }" varStatus = "index">
												<tr onload="">
													<td class="count">${index.count + ((currentPage-1)*6)}</td>
													<td class="user">${item.username}</td>
													<td class="fullname">${item.fullname}</td>
													<td class="address">${item.address}</td>
													<td class="phone">${item.phone}</td>
													<td class="role">${item.role}</td>
													<td class="enabled">${item.enabled}</td>
													<c:if test="${item.role == 'ROLE_ADMIN'}">
													<td class="edit"><a id="block" class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="Khóa tài khoản" href='<c:url value="/quan-tri/user/lock?idUser=${item.id }" />'><i
															class="glyphicon glyphicon-lock" aria-hidden="true"></i>
													</a></td>
													</c:if>
													<c:if test="${item.role == 'ROLE_USER'}">
													<td class="edit"><a class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="Khóa tài khoản" href='<c:url value="/quan-tri/user/lock?idUser=${item.id }" />'><i
															class="glyphicon glyphicon-lock" aria-hidden="true"></i>
													</a></td>
													</c:if>
													
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
								<a href='<c:url value="/quan-tri/user?page=1"/>'>First</a>
							</c:if>
							<!-- previous -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/quan-tri/user?page=${previous }"/>'>&laquo;</a>
							</c:if>
							<!-- index -->
							<c:if test="${currentPage == 1 && totalPages == 1 }">
								<a class="active" href='<c:url value="/quan-tri/user?page=1"/>'>1</a>
							</c:if>
							<c:if test="${currentPage == 1 && totalPages == 2 }">
								<c:forEach var = "i" begin = "1" end = "2">
									<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/quan-tri/user?page=${i }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/quan-tri/user?page=${i }"/>'>${i }</a>
									 </c:if>
								</c:forEach>
							</c:if>
							<c:if test="${currentPage <= totalPages-2 && totalPages != 0 }">
								<c:if test="${currentPage <= 2 && totalPages != 0 }">
									 <c:forEach var = "i" begin = "1" end = "3">
									 	<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/quan-tri/user?page=${i }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/quan-tri/user?page=${i }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 	<c:if test="${currentPage > 2 && totalPages != 0 }">
							 	 	<c:forEach var = "i" begin = "${currentPage-2 }" end = "${currentPage+2 }">
							 			<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/quan-tri/user?page=${i }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/quan-tri/user?page=${i }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 </c:if>
							 <c:if test="${currentPage > totalPages - 2 && totalPages != 0 }">
							 	<c:forEach var = "i" begin = "${totalPages-4 }" end = "${totalPage }">
							 		<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/quan-tri/user?page=${i }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/quan-tri/user?page=${i }"/>'>${i }</a>
									 </c:if>
							 	</c:forEach>
							 </c:if>
  							<!-- next -->
  							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/quan-tri/user?page=${next }"/>'>&raquo;</a>
  							</c:if>
  							<!-- last -->
  							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/quan-tri/user?page=${totalPages }"/>'>Last</a>
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
</body>
</html>