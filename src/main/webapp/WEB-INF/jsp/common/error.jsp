<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//获得项目完全路径
	String base = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=base%>" />
<title>访问已过期</title>
<style type="text/css">
body {
	background-color: #eee;
}
.my-btn {
	color: #fff;
	background-color: #428bca;
	border-color: #357ebd;
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.428571429;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	cursor: pointer;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	-o-user-select: none;
	user-select: none;
	font-family: '微软雅黑';
}
</style>
<script type="text/javascript">
	var c = 5;
	var t;
	function timedCount() {
		document.getElementById('txt').innerText = c
		c = c - 1;
		t = setTimeout("timedCount()", 1000);
		if (c < 0) {
			stopCount();
		}
	}
	function stopCount() {
		parent.window.location.href = document.getElementsByTagName('base')[0].href + "index/login";
	}
</script>
</head>
<body onLoad="timedCount()">
	<div tyle="text-align:center; margin-top:50px;">
		<div style="height: 350px; background: url(resources/images/common/timeout.jpg) center"></div>
		<div style="text-align: center; margin-top: 10px;">
			<div style="font-size: 24px; color: #F00; font-weight: bolder; margin-top: 10px;">
				<span id="txt"></span>秒后，系统将会自动引导您到登录页面，您也可点击<button type="button" class="my-btn" onclick="stopCount();">重新登录</button>按钮，获得帮助!
			</div>
		</div>
	</div>
</body>
</html>
