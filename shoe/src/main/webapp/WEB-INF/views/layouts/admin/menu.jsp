<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<div id="sidebar"
	class="sidebar                  responsive                    ace-save-state">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle"> <span
				class="menu-text"></span> Quản lý hóa đơn
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="<c:url value='/quan-tri/bill'/>"> DS hóa đơn </a></li>
			</ul></li>
	</ul>
	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle"> <span
				class="menu-text"></span> Quản lý tài khoản
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="<c:url value='/quan-tri/user'/>"> DS tài khoản </a></li>
			</ul></li>
	</ul>
	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle"> <span
				class="menu-text"></span> Quản lý sản phẩm
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="<c:url value='/quan-tri/product'/>"> DS sản phẩm </a></li>
			</ul></li>
	</ul>
	<div class="sidebar-toggle sidebar-collapse">
		<i class="	glyphicon glyphicon-th-list"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>