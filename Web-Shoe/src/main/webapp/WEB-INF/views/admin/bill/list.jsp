<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<jsp:useBean id="pagedListHolder" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/quan-tri/bill" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
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
												<th>User</th>
												<th>Phone</th>
												<th>Full name</th>
												<th>Address</th>
												<th>Total</th>
												<th>Quanty</th>
												<th>Note</th>
												<th>sign</th>
												<th>pubkey</th>
												<th>data</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pagedListHolder.pageList }">
												<tr>
													<td>${item.user}</td>
													<td>${item.phone}</td>
													<td>${item.fullname}</td>
													<td>${item.address}</td>
													<td>${item.total}</td>
													<td>${item.quanty}</td>
													<td>${item.note}</td>
													<td style="width: 100px;max-width: 100px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;" class="sign">${item.sign}</td>
													<td style="width: 100px;max-width: 100px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;" class="pubkey">${item.file}</td>
													<td style="width: 100px;max-width: 100px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;" class="data">${item.data}</td>
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