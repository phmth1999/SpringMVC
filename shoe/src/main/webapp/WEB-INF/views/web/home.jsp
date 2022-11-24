<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div id="preloder">
		<div class="loader"></div>
	</div>
	
	<!-- Slide Quang Cao Begin -->
	<section class="hero-section">
		<div class="hero-items owl-carousel">
			<c:forEach var="items" items="${listAllSlide }">
				<div class="single-hero-items set-bg"
					data-setbg="template/web/img/${items.img }">
					<div  class="container">
						<div class="row">
							<div class="col-lg-5">
								<span>Bag,kids</span>
								<h1>${items.caption }</h1>
								<p>${items.content }</p>
								<a href="#" class="primary-btn">Shop Now</a>
							</div>
						</div>
						<div class="off-card">
							<h2>
								Sale <span>50%</span>
							</h2>
						</div>
				</div>
				</div>
			</c:forEach>
		</div>
	</section>
	<!-- Slide quang cao End -->

	<!-- Banner Section Begin -->
	<div class="banner-section spad">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-4">
					<div class="single-banner">
						<img src="template/web/img/banner-1.jpg" alt="">
						<div class="inner-text">
							<h4>
								<spring:message code="men" />
							</h4>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="single-banner">
						<img src="template/web/img/banner-2.jpg" alt="">
						<div class="inner-text">
							<h4>
								<spring:message code="women" />
							</h4>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="single-banner">
						<img src="template/web/img/banner-3.jpg" alt="">
						<div class="inner-text">
							<h4>
								<spring:message code="kid" />
							</h4>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner Section End -->

	<!-- Women Begin -->
	<section class="women-banner spad">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3">
					<div class="product-large set-bg"
						data-setbg="template/web/img/products/women-large.jpg">
						<h2>
							<spring:message code="women" />
						</h2>
						<a href="#">Discover More</a>
					</div>
				</div>
				<div class="col-lg-8 offset-lg-1">
					<div class="filter-control">
						<ul>
							<li class="active">Clothings</li>
							<li>HandBag</li>
							<li>Shoes</li>
							<li>Accessories</li>
						</ul>
					</div>
					<div class="product-slider owl-carousel">
						<c:forEach var="item" items="${listProductCategoryWomen }">
							<div class="product-item">
								<div class="pi-pic">
									<img
										src='<c:url value="/template/web/img/products/${item.img }" />'
										alt="">
									<div class="sale">Sale</div>
									<div class="icon">
										<i class="icon_heart_alt"></i>
									</div>
									<ul>
										<li class="w-icon active"><a
											href='<c:url value="/addcart/${item.id }" />'><i
												class="icon_bag_alt"></i></a></li>
										<li class="quick-view"><a
											href='<c:url value="/product/${item.id }"/>'>+ Quick View</a></li>
										<li class="w-icon"><a href="#"><i
												class="fa fa-random"></i></a></li>
									</ul>
								</div>
								<div class="pi-text">
									<div class="catagory-name">${item.name }</div>
									<div class="product-price"><fmt:formatNumber pattern="#,##0 vnđ" value="${item.price }" /></div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Women End -->

	<!-- Man Begin -->
	<section class="man-banner spad">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-8">
					<div class="filter-control">
						<ul>
							<li class="active">Clothings</li>
							<li>HandBag</li>
							<li>Shoes</li>
							<li>Accessories</li>
						</ul>
					</div>
					<div class="product-slider owl-carousel">
						<c:forEach var="item" items="${listProductCategoryMen }">
							<div class="product-item">
								<div class="pi-pic">
									<img
										src='<c:url value="/template/web/img/products/${item.img }" />'
										alt="">
									<div class="sale">Sale</div>
									<div class="icon">
										<i class="icon_heart_alt"></i>
									</div>
									<ul>
										<li class="w-icon active"><a
											href='<c:url value="/addcart/${item.id }" />'><i
												class="icon_bag_alt"></i></a></li>
										<li class="quick-view"><a
											href='<c:url value="/product/${item.id }"/>'>+ Quick View</a></li>
										<li class="w-icon"><a href="#"><i
												class="fa fa-random"></i></a></li>
									</ul>
								</div>
								<div class="pi-text">
									<div class="catagory-name">${item.name }</div>
									<div class="product-price"><fmt:formatNumber pattern="#,##0 vnđ" value="${item.price }" /></div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-lg-3 offset-lg-1">
					<div class="product-large set-bg m-large"
						data-setbg="template/web/img/products/man-large.jpg">
						<h2>
							<spring:message code="men" />
						</h2>
						<a href="#">Discover More</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Man End -->

</body>
</html>