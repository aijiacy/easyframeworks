<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//获得项目完全路径
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=base%>" />
<title>出错了，访问的页面不存在</title>
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
function goLogin(){
	parent.window.location.href=  document.getElementsByTagName('base')[0].href + 'index/login';
}
</script>
</head>
<body>
	<div class="jumbotron" style="text-align: center; margin-top: 50px;">
		<div class="alert alert-warning" style="height: 350px; background: url(resources/images/common/404.jpg) top center"></div>
		<p>
			<h3>对不起，您访问的页面不存在!</h3>
			<button type="button" onclick="javascript:goLogin();" class="my-btn">返回首页</button>
		</p>
	</div>
</body>
</html>