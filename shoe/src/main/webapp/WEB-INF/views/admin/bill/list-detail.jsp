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
												<th>Img</th>
												<th>Name</th>
												<th>Price</th>
												<th>Total</th>
												<th>Quanty</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${billDetail }" varStatus = "index">
												<tr>
													<td class="count">${index.count}</td>
													<td class="img"><img src='<c:url value="/template/user/img/products/${item.img }" />' alt=""></td>
													<td class="name">${item.name}</td>
													<td class="price">${item.price}</td>
													<td class="total">${item.total}</td>
													<td class="quanty">${item.quanty}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<h2 class="linkGoBack"><a href='<c:url value="/quan-tri/bill?page=${page }" />'>Go Back</a></h2>
							</div>
						</div>
						<div class="paginationRight" >
							<div class="pagination">
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