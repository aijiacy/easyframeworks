<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//获得项目完全路径
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=base%>" />
<script type="text/javascript" src="<%=base%>/resources/js/sys/menu/viewMenu.js"></script>
</head>
<body>
	<!-- 菜单列表 -->
	<div id="menuGrid"></div>
	<div class="modal fade" role="dialog" id="menuView">
		<div class="modal-dialog">
			<div class="modal-content">

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</body>
</html>