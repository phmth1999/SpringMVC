<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>

<div class="backtop">
    	<i class='glyphicon glyphicon-chevron-up'></i>
</div>
<footer class="footer-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="footer-left">
					<div class="footer-logo">
						<a href="#"><img src='<c:url value="/template/web/img/footer-logo.png" />'
							alt=""></a>
					</div>
					<ul>
						<li>Address: Cai Lay, Tien Giang, HCM</li>
						<li>Phone: 0378348419</li>
						<li>Email: phmth1999@gmail.com</li>
					</ul>
					<br>
					<div class="payment-pic">
						<img src='<c:url value="/template/web/img/payment-method.png" />' alt="">
					</div>
				</div>
			</div>
			<div class="col-lg-2 offset-lg-1">
				<div class="footer-widget">
					<h5>Information</h5>
					<ul>
						<li><a href="#">About Us</a></li>
						<li><a href="#">Checkout</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Serivius</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-2">
				<div class="footer-widget">
					<h5>My Account</h5>
					<ul>
						<li><a href="#">My Account</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Shopping Cart</a></li>
						<li><a href="#">Shop</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="newslatter-item">
					<h5>Join Our Newsletter Now</h5>
					<p>Get E-mail updates about our latest shop and special offers.</p>
					<form action="#" class="subscribe-form">
						<input type="text" placeholder="Enter Your Mail">
						<button type="button">Subscribe</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</footer>
