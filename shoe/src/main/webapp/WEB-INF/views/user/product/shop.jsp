<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cửa hàng</title>
</head>
<body>
	<section class="product-shop spad">
		<div class="container">
			<div class="row">
				<div
					class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
					<div class="filter-widget">
						<h4 class="fw-title">Categories</h4>
						<c:forEach var="item" items="${listAllCategory }">
							<ul class="filter-catagories">
								<li><a href='<c:url value="/category/${item.id }"/>'>${item.name }</a></li>
							</ul>
						</c:forEach>
					</div>
				</div>
				<div class="col-lg-9 order-1 order-lg-2">
					<div class="product-show-option">
						<div class="row">
							<div class="col-lg-7 col-md-7">
								<div class="select-option">
									<select class="sorting">
										<option value="">Default Sorting</option>
									</select> <select class="p-show">
										<option value="">Show:</option>
									</select>
								</div>
							</div>
							<div class="col-lg-5 col-md-5 text-right">
								<p>Show 01- 09 Of 36 Product</p>
							</div>
						</div>
					</div>
					<div class="product-list">
						<div class="row">
							<c:forEach var="item" items="${listPageProducts }">
								<div class="col-lg-4 col-sm-6">
									<div class="product-item">
										<div class="pi-pic">
											<img
												src='<c:url value="/template/user/img/products/${item.img }" />'
												alt="">
											<ul>
												<li class="w-icon active"><a
													href='<c:url value="/addcart/${item.id }" />'><i
														class="icon_bag_alt"></i></a></li>
												<li class="quick-view"><a
													href='<c:url value="/product/${item.id }"/>'>+ Quick
														View</a></li>
												<li class="w-icon"><a href="#"><i
														class="fa fa-random"></i></a></li>
											</ul>
										</div>
										<div class="pi-text">
											<h5>${item.name }</h5>
											<div class="product-price"><fmt:formatNumber pattern="#,##0 vnđ" value="${item.price }" /></div>
										</div>
										<div class="pi-text">
											<h5>Sold: ${item.quantity_sold }<i> | </i>Quantity: ${item.quantity }</h5>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="paginationRight" >
						<div class="pagination">
							<%int current = Integer.parseInt(request.getAttribute("currentPage").toString()); %>
							<%int totalPage = Integer.parseInt(request.getAttribute("totalPages").toString()); %>
							<!-- previous -->
							<%if(current>1){ %>
							<a href='<c:url value="/shop?page=${previous }"/>'>&laquo;</a>
							<%}else{%>
							<a href='<c:url value="/shop?page=${currentPage } "/>'>&laquo;</a>
							<%} %>
							<!-- index -->
  							<%for (int i = 1; i <= Integer.parseInt(request.getAttribute("totalPages").toString()); i++) {%>
							<a <%if(current==i){ %>class="active"<%} %>
							 href="./shop?page=<%=i%>"><%=i %></a><%} %>
  							<!-- next -->
							 <%if(current<totalPage){ %>
  							<a href='<c:url value="/shop?page=${next }"/>'>&raquo;</a>
  							<%}else{%>
  							<a href='<c:url value="/shop?page=${currentPage }"/>'>&raquo;</a>
  							<%} %>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>