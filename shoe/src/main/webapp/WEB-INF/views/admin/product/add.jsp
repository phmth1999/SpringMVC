<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
		<div class="register-login-section">
			<div class="row" style="display:flex; justify-content:center; align-items:center; ">
				<div class="col-lg-6 offset-lg-3">
					<div class="register-form">
						<h2>Add</h2>
						<form:form id="form" action="add" method="post" modelAttribute="product" enctype="multipart/form-data">
							<div class="group-input">
								<label for=username>Name *</label>
								<form:input id="name" path="name" />
								<div id="nameMsg" class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for=username>Category *</label>
								<form:input id="category" path="nameCategory" />
								<div id="nameMsg" class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label for=username>Brand *</label>
								<form:input id="brand" path="nameBrand" />
								<div id="nameMsg" class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label>IMG *</label>
								<input type="file" id="img" name="image" />
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label>Price *</label>
								<form:input id="price" path="price" />
								<div class="form-message" style="color: red"></div>
							</div>
							<div class="group-input">
								<label>Quantity *</label>
								<form:input id="quantity" path="quantity" />
								<div class="form-message" style="color: red"></div>
							</div>
							 <button type="submit" class="site-btn register-btn">
								Add
							</button> 
						</form:form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>