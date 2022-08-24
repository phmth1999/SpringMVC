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
									<table class="table table-bordered">
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
												<tr>
													<td class="count">${index.count + ((currentPage-1)*6)}</td>
													<td class="user">${item.username}</td>
													<td class="fullname">${item.fullname}</td>
													<td class="address">${item.address}</td>
													<td class="phone">${item.phone}</td>
													<td class="role">${item.role}</td>
													<td class="enabled">${item.enabled}</td>
													<td class="edit"><a class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="Khóa tài khoản" href="#"><i
															class="glyphicon glyphicon-lock" aria-hidden="true"></i>
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
								<a href='<c:url value="/quan-tri/user?page=${previous }"/>'>&laquo;</a>
								<%}else{%>
								<a href='<c:url value="/quan-tri/user?page=${currentPage } "/>'>&laquo;</a>
								<%} %>
								<!-- index -->
  								<%for (int i = 1; i <= Integer.parseInt(request.getAttribute("totalPages").toString()); i++) {%>
								<a <%if(current==i){ %>class="active"<%} %>
								href="./user?page=<%=i%>"><%=i %></a><%} %>
  								<!-- next -->
							 	<%if(current<totalPage){ %>
  								<a href='<c:url value="/quan-tri/user?page=${next }"/>'>&raquo;</a>
  								<%}else{%>
  								<a href='<c:url value="/quan-tri/user?page=${currentPage }"/>'>&raquo;</a>
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