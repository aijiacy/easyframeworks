<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//获得项目完全路径
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn" dir="ltr" class="uk-notouch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<base href="<%=base%>" />
<title>新疆建设厅证书管理系统</title>
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/uikit.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/addons/uikit.addons.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/uikit.gradient.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/addons/uikit.gradient.addons.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/uikit/2.6.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="resources/plugins/button/css/buttons.css" />
<link rel="stylesheet" type="text/css" href="resources/css/common/checker.css" />
<link rel="stylesheet" type="text/css" href="resources/css/common/main.css" />
<script type="text/javascript" language="javascript" src="resources/plugins/jquery/2.1.1/jquery-2.1.1.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/uikit/2.6.0/js/uikit.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/uikit/2.6.0/js/addons/sticky.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/uikit/2.6.0/js/addons/notify.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/uikit/2.6.0/js/addons/datepicker.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/button/js/buttons.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/components/e.panel.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/components/e.grid.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/components/e.select.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/main/index.js"></script>
</head>
<body>
	<nav class="uk-navbar uk-navbar-attached main-top logo-bg" data-uk-sticky="{top:0}">
		<div class="uk-grid uk-grid-margin logo-left" data-uk-grid-match>
			<div class="uk-width-1-1">
				<div class="uk-navbar-flip">
					<div class="uk-navbar">
						<div class="uk-button-group">
							<button class="uk-button uk-button-small uk-button-primary">欢迎 xx 用户，您已登录系统。个人控制台：</button>
							<div data-uk-dropdown="{mode:'click'}" class="">
								<a href="#" class="uk-button uk-button-small uk-button-primary"><i class="uk-icon-caret-down"></i></a>
								<div class="uk-dropdown uk-dropdown-small uk-dropdown-flip">
									<ul class="uk-nav uk-nav-dropdown">
										<li><a href="javascript:void(0)">个人信息</a></li>
										<li><a href="javascript:void(0)">修改密码</a></li>
										<li class="uk-nav-divider"></li>
										<li><a href="javascript:void(0)">退出系统</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<div class="main-wrapper">
		<div class="uk-panel uk-panel-box" id="contentframe">
		</div>
	</div>
	<div class="main-sidebar" id="leftMenus">
	</div>
</body>
</html>