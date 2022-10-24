<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
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
								<li><a href='<c:url value="/category/${item.id }?page=${currentPage }&&sort=${sortSession }"/>' >${item.name }</a></li>
							</ul>
						</c:forEach>
					</div>
					<div class="filter-widget">
						<h4 class="fw-title">Brand</h4>
						<c:forEach var="item" items="${listAllBrand }">
							<ul class="filter-catagories">
								<li><a href='<c:url value="/brand/${item.id }?page=${currentPage }&&sort=${sortSession }"/>'>${item.name }</a></li>
							</ul>
						</c:forEach>
					</div>
					<!-- <div class="filter-widget">
						<h4 class="fw-title">Price</h4>
						<div class="filter-range-wrap">
							<div class="range-slider">
								<div class="price-input">
									<input type="text" id="minamount"> <input type="text"
										id="maxamount">
								</div>
							</div>
							<div
								class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
								data-min="33" data-max="98">
								<div class="ui-slider-range ui-corner-all ui-widget-header"></div>
								<span tabindex="0"
									class="ui-slider-handle ui-corner-all ui-state-default"></span>
								<span tabindex="0"
									class="ui-slider-handle ui-corner-all ui-state-default"></span>
							</div>
						</div>
						<a href="#" class="filter-btn">Filter</a>
					</div> -->
					<!-- <div class="filter-widget">
						<h4 class="fw-title">Color</h4>
						<div class="fw-color-choose">
							<div class="cs-item">
								<input type="radio" id="cs-black"> <label
									class="cs-black" for="cs-black">Black</label>
							</div>
							<div class="cs-item">
								<input type="radio" id="cs-violet"> <label
									class="cs-violet" for="cs-violet">Violet</label>
							</div>
							<div class="cs-item">
								<input type="radio" id="cs-blue"> <label class="cs-blue"
									for="cs-blue">Blue</label>
							</div>
							<div class="cs-item">
								<input type="radio" id="cs-yellow"> <label
									class="cs-yellow" for="cs-yellow">Yellow</label>
							</div>
							<div class="cs-item">
								<input type="radio" id="cs-red"> <label class="cs-red"
									for="cs-red">Red</label>
							</div>
							<div class="cs-item">
								<input type="radio" id="cs-green"> <label
									class="cs-green" for="cs-green">Green</label>
							</div>
						</div>
					</div> -->
					<!-- <div class="filter-widget">
						<h4 class="fw-title">Size</h4>
						<div class="fw-size-choose">
							<div class="sc-item">
								<input type="radio" id="s-size"> <label for="s-size">s</label>
							</div>
							<div class="sc-item">
								<input type="radio" id="m-size"> <label for="m-size">m</label>
							</div>
							<div class="sc-item">
								<input type="radio" id="l-size"> <label for="l-size">l</label>
							</div>
							<div class="sc-item">
								<input type="radio" id="xs-size"> <label for="xs-size">xs</label>
							</div>
						</div>
					</div> -->
					<!-- <div class="filter-widget">
						<h4 class="fw-title">Tags</h4>
						<div class="fw-tags">
							<a href="#">Towel</a> <a href="#">Shoes</a> <a href="#">Coat</a>
							<a href="#">Dresses</a> <a href="#">Trousers</a> <a href="#">Men's
								hats</a> <a href="#">Backpack</a>
						</div>
					</div> -->
				</div>
				<div class="col-lg-9 order-1 order-lg-2">
					<div class="product-show-option">
						<div class="row">
							<div class="col-lg-7 col-md-7">
								<div class="select-option">
									<select  data-id="${sortSession }" id="sorting" class="sorting" onchange="location = this.value;" >
										<c:if test="${categoryORbrand == null }">
											<option value='<c:url value="/shop?page=${currentPage }&&sort=low-high" />'>Low to High Price</option>
											<option value='<c:url value="/shop?page=${currentPage }&&sort=high-low" />'>High to Low Price</option>
											<option value='<c:url value="/shop?page=${currentPage }&&sort=a-z"/>'>Name: A - Z</option>
											<option value='<c:url value="/shop?page=${currentPage }&&sort=z-a"/>'>Name: Z - A</option>
										</c:if>
										<c:if test="${categoryORbrand != null }">
											<option value='<c:url value="/${categoryORbrand }/${id }?page=${currentPage }&&sort=low-high"/>'>Low to High Price</option>
											<option value='<c:url value="/${categoryORbrand }/${id }?page=${currentPage }&&sort=high-low"/>'>High to Low Price</option>
											<option value='<c:url value="/${categoryORbrand }/${id }?page=${currentPage }&&sort=a-z"/>'>Name: A - Z</option>
											<option value='<c:url value="/${categoryORbrand }/${id }?page=${currentPage }&&sort=z-a"/>'>Name: Z - A</option>
										</c:if>
									</select> 
								</div>
							</div>
							<div class="col-lg-5 col-md-5 text-right">
								<c:if test="${currentPage == 1 }">
									<p>Show ${currentPage } - ${currentPage*9 } Of ${totalItems } Product</p>
								</c:if>
								<c:if test="${currentPage != 1 }">
									<p>Show ${(currentPage-1)*9 } - ${currentPage*9 } Of ${totalItems } Product</p>
								</c:if>
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
												src='<c:url value="/template/web/img/products/${item.img }" />'
												alt="">
											<ul>
												<li class="w-icon active"><a
													href='<c:url value="/addcart/${item.id }" />'><i
														class="icon_bag_alt"></i></a></li>
												<li class="quick-view"><a
													href='<c:url value="/product/${item.id }"/>'>+ Quick
														View</a></li>
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
						<!-- pagination categoryORbrand -->
						<c:if test="${categoryORbrand != null }">
							<!-- first -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/${categoryORbrand }/${id }?page=1&&sort=${sortSession }"/>'>First</a>
							</c:if>
							<!-- previous -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/${categoryORbrand }/${id }?page=${previous }&&sort=${sortSession }"/>'>&laquo;</a>
							</c:if>
							<!-- index -->
							<c:if test="${currentPage == 1 && totalPages == 1 }">
								<a class="active" href="./${id }?page=1&&sort=${sortSession }">1</a>
							</c:if>
							<c:if test="${currentPage == 1 && totalPages == 2 }">
							 	<c:forEach var = "i" begin = "1" end = "2">
									<c:if test="${i == currentPage }">
										<a class="active" href="./${id }?page=${i }&&sort=${sortSession }">${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href="./${id }?page=${i }&&sort=${sortSession }">${i }</a>
									 </c:if>
								</c:forEach>
							</c:if>
							<c:if test="${currentPage <= totalPages-2 && totalPages !=0 }">
								<c:if test="${currentPage <= 2 && totalPages !=0 }">
							 		<c:forEach var = "i" begin = "1" end = "3">
									 	<c:if test="${i == currentPage }">
											<a class="active" href="./${id }?page=${i }&&sort=${sortSession }">${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href="./${id }?page=${i }&&sort=${sortSession }">${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 	<c:if test="${currentPage > 2 && totalPages !=0 }">
							 		<c:forEach var = "i" begin = "${currentPage-2 }" end = "${currentPage+2 }">
							 			<c:if test="${i == currentPage }">
											<a class="active" href="./${id }?page=${i }&&sort=${sortSession }">${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href="./${id }?page=${i }&&sort=${sortSession }">${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							</c:if>
							<c:if test="${currentPage > totalPages-2 && totalPages !=0 }">
							 	<c:forEach var = "i" begin = "${totalPages-4 }" end = "${totalPages }">
							 		<c:if test="${i == currentPage }">
										<a class="active" href="./${id }?page=${i }&&sort=${sortSession }">${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href="./${id }?page=${i }&&sort=${sortSession }">${i }</a>
									 </c:if>
							 	</c:forEach>
							</c:if>
							<!-- next -->
							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/${categoryORbrand }/${id }?page=${next }&&sort=${sortSession }"/>'>&raquo;</a>
  							</c:if>
  							<!-- last -->
							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/${categoryORbrand }/${id }?page=${totalPages }&&sort=${sortSession }"/>'>Last</a>
  							</c:if>
  						</c:if>
  						
  						<!-- pagination shop -->
  						<c:if test="${categoryORbrand == null }">
  							<!-- first -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/shop?page=1&&sort=${sortSession }"/>'>First</a>
							</c:if>
  							<!-- previous -->
							<c:if test="${currentPage > 1 }">
								<a href='<c:url value="/shop?page=${previous }&&sort=${sortSession }"/>'>&laquo;</a>
							</c:if>
							<!-- index -->
							<c:if test="${currentPage == 1 && totalPages == 1 }">
								<a class="active" href='<c:url value="/shop?page=1&&sort=${sortSession }"/>'>1</a>
							</c:if>
							<c:if test="${currentPage == 1 && totalPages == 2 }">
								<c:forEach var = "i" begin = "1" end = "2">
									<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/shop?page=${i }&&sort=${sortSession }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/shop?page=${i }&&sort=${sortSession }"/>'>${i }</a>
									 </c:if>
								</c:forEach>
							</c:if>
							<c:if test="${currentPage <= totalPages-2 && totalPages != 0 }">
								<c:if test="${currentPage <= 2 && totalPages != 0 }">
									 <c:forEach var = "i" begin = "1" end = "3">
									 	<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/shop?page=${i }&&sort=${sortSession }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/shop?page=${i }&&sort=${sortSession }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 	<c:if test="${currentPage > 2 && totalPages != 0 }">
							 	 	<c:forEach var = "i" begin = "${currentPage-2 }" end = "${currentPage+2 }">
							 			<c:if test="${i == currentPage }">
											<a class="active" href='<c:url value="/shop?page=${i }&&sort=${sortSession }"/>'>${i }</a>
									 	</c:if>
									 	<c:if test="${i != currentPage }">
											<a href='<c:url value="/shop?page=${i }&&sort=${sortSession }"/>'>${i }</a>
									 	</c:if>
							 		</c:forEach>
							 	</c:if>
							 </c:if>
							 <c:if test="${currentPage > totalPages-2 && totalPages != 0 }">
							 	<c:forEach var = "i" begin = "${totalPages-4 }" end = "${totalPages }">
							 		<c:if test="${i == currentPage }">
										<a class="active" href='<c:url value="/shop?page=${i }&&sort=${sortSession }"/>'>${i }</a>
									 </c:if>
									 <c:if test="${i != currentPage }">
										<a href='<c:url value="/shop?page=${i }&&sort=${sortSession }"/>'>${i }</a>
									 </c:if>
							 	</c:forEach>
							 </c:if>
  							<!-- next -->
  							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/shop?page=${next }&&sort=${sortSession }"/>'>&raquo;</a>
  							</c:if>
  							<!-- last -->
  							<c:if test="${currentPage < totalPages }">
  								<a href='<c:url value="/shop?page=${totalPages }&&sort=${sortSession }"/>'>Last</a>
  							</c:if>
  						</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>