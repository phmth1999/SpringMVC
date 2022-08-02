<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<jsp:useBean id="pagedListHolder" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/quan-tri/user" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
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
										<%-- <a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm tài khoản' href="<c:url value='/dang-ky'/>">Thêm tài khoản
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
											<c:forEach var="item" items="${pagedListHolder.pageList }">
												<tr>
													<td>${item.username}</td>
													<td>${item.fullname}</td>
													<td>${item.address}</td>
													<td>${item.phone}</td>
													<td>${item.role}</td>
													<td>${item.enabled}</td>
													<td><a class="btn btn-sm btn-primary btn-edit"
														data-toggle="tooltip" title="Khóa tài khoản" href="#"><i
															class="glyphicon glyphicon-trash" aria-hidden="true"></i>
													</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="pull-right tableTools-container">
							<tg:paging pagedListHolder="${pagedListHolder}"
								pagedLink="${pagedLink}" />
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