<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//获得项目完全路径
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn" dir="ltr">
<head>
<base href="<%=base%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新疆建设厅证书管理系统登陆</title>
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/uikit.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/addons/uikit.addons.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/uikit.gradient.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/button/css/buttons.css" />
<link rel="stylesheet" type="text/css" href="resources/css/common/default.css" />
<link rel="stylesheet" type="text/css" href="resources/css/login/login.css" />
<script type="text/javascript" language="javascript" src="resources/plugins/jquery/2.1.1/jquery-2.1.1.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/uikit/2.6.0/js/uikit.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/uikit/2.6.0/js/addons/notify.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/button/js/buttons.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/jquery/plugin/jquery.form.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/login/login.js"></script>
<body class="uk-height-1-1 login-bg">
	<div class="uk-vertical-align uk-text-center uk-height-1-1">
		<div class="uk-vertical-align-middle login-wrapper">	
			<div class="uk-form-row">
				<img class="uk-width-1-1 uk-margin-bottom" src="resources/images/login/logo.png">
			</div>
			<form class="uk-panel uk-panel-box uk-form box" id="frmLogin" action="index/ajaxLogin" method="post" role="form">
				<div class="uk-form-row">
					<input type="text" class="uk-width-1-1 uk-form-large" name="username" placeholder="请输入用户名" autofocus>
				</div>
				<div class="uk-form-row">
				 	<input type="password" class="uk-width-1-1 uk-form-large" name="password" placeholder="请输入密码">
				</div>	
				<div class="uk-form-row">
					<div class="uk-width-1-1 uk-form-controls">
					 	<input type="text" class="uk-width-3-10 uk-form-large" name="code" placeholder="验证码">
					 	<img class="uk-width-3-10 uk-form-controls uk-form-large" src="index/imgCode" onclick="javascript:this.src='index/imgCode'" />
					 </div>
				</div>
				<div class="uk-form-row uk-form-large">
					<button class="uk-width-1-1 button button-pill button-highlight login-button" type="submit" id="btnSmt">
					<i class="uk-icon-hand-o-right"></i>&nbsp;&nbsp;登&nbsp;&nbsp;陆</button>
				</div>
			</form>
		</div>
	</div>
	<!-- /container -->
</body>
</html>