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
<script type="text/javascript" src="resources/js/sys/module/viewModule.js"></script>
<title>模块管理</title>
</head>
<body>
	<div id="moduleGrid">
	
	</div>
	<div class="modal fade" id="moduleView" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</div>
</body>
</html>