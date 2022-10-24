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

<!-- Css Library -->
<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
<link href="<c:url value="/template/web/css/bootstrap.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/template/web/css/themify-icons.css"/>" rel="stylesheet" />
<link href="<c:url value="/template/web/css/elegant-icons.css"/>" rel="stylesheet">
<link href="<c:url value="/template/web/css/owl.carousel.min.css"/>" rel="stylesheet">
<link href="<c:url value="/template/web/css/nice-select.css"/>" rel="stylesheet">
<link href="<c:url value="/template/web/css/jquery-ui.min.css"/>" rel="stylesheet">
<link href="<c:url value="/template/web/css/slicknav.min.css"/>" rel="stylesheet">

<!-- Css -->
<link href="<c:url value="/template/web/style.css"/>" rel="stylesheet">
<link href="<c:url value="/template/validator/form.css"/>" rel="stylesheet" />
<link href="<c:url value="/template/web/css/pagination.css"/>" rel="stylesheet" />

<decorator:head />

</head>
<body>
	<%@include file="/WEB-INF/views/layouts/web/header.jsp"%>

	<decorator:body />
	
	<%@include file="/WEB-INF/views/layouts/web/footer.jsp"%>

	<!-- Js Library -->
	<script src="<c:url value="/template/web/js/jquery-3.3.1.min.js" />"></script>
	<script src="<c:url value="/template/web/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/template/web/js/jquery-ui.min.js" />"></script>
	<script src="<c:url value="/template/web/js/jquery.countdown.min.js" />"></script>
	<script src="<c:url value="/template/web/js/jquery.nice-select.min.js"/>"></script>
	<script src="<c:url value="/template/web/js/jquery.zoom.min.js"/>"></script>
	<script src="<c:url value="/template/web/js/jquery.dd.min.js"/>"></script>
	<script src="<c:url value="/template/web/js/jquery.slicknav.js"/>"></script>
	<script src="<c:url value="/template/web/js/owl.carousel.min.js"/>"></script>
	
	<!-- Js -->
	<script src="<c:url value="/template/validator/Validator.js"/>"></script>
	<script src="<c:url value="/template/web/main.js"/>"></script>

</body>
</html>