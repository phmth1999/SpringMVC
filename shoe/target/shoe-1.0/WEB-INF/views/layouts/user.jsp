<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><decorator:title default="Master-layout" /></title>
<meta charset="UTF-8">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
<!-- Css Styles -->
<link href="<c:url value="/template/validator/form.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/template/user/css/pagination.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/template/user/css/bootstrap.min.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/template/user/css/themify-icons.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/template/user/css/elegant-icons.css"/>"
	rel="stylesheet">
<link href="<c:url value="/template/user/css/owl.carousel.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/template/user/css/nice-select.css"/>"
	rel="stylesheet">
<link href="<c:url value="/template/user/css/jquery-ui.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/template/user/css/slicknav.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/template/user/css/style.css"/>"
	rel="stylesheet">
<decorator:head />
</head>
<body>
	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>

	<decorator:body />

	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>

	<!-- Js Plugins -->
	<script src="<c:url value="/template/user/js/jquery-3.3.1.min.js" />"></script>
	<script src="<c:url value="/template/user/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/template/user/js/jquery-ui.min.js" />"></script>
	<script
		src="<c:url value="/template/user/js/jquery.countdown.min.js" />"></script>
	<script
		src="<c:url value="/template/user/js/jquery.nice-select.min.js"/>"></script>
	<script src="<c:url value="/template/user/js/jquery.zoom.min.js"/>"></script>
	<script src="<c:url value="/template/user/js/jquery.dd.min.js"/>"></script>
	<script src="<c:url value="/template/user/js/jquery.slicknav.js"/>"></script>
	<script src="<c:url value="/template/user/js/owl.carousel.min.js"/>"></script>
	<script src="<c:url value="/template/user/js/main.js"/>"></script>
	<script src="<c:url value="/template/validator/Validator.js"/>"></script>

	<decorator:getProperty property="page.script"></decorator:getProperty> 

</body>
</html>