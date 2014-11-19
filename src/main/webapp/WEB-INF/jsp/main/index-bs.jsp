<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//获得项目完全路径
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=base %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>新疆建设厅证书管理系统</title>
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/bootstrap/3.1.1/css/bootstrap.min.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/bootstrap/3.1.1/css/bootstrap-theme.min.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/bootstrap/3.1.1/css/font-awesome.min.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/messager/css/messenger.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/messager/css/messenger-spinner.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/messager/css/messenger-theme-air.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/messager/css/messenger-theme-block.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/messager/css/messenger-theme-flat.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/messager/css/messenger-theme-future.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/plugins/messager/css/messenger-theme-ice.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/css/common/main.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/css/common/grid.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="resources/css/common/checker.css" />
<script type="text/javascript" language="javascript" src="resources/plugins/jquery/2.1.1/jquery-2.1.1.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/bootstrap/3.1.1/js/bootstrap3-validation.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/jquery/plugin/jquery.form.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/messager/js/messenger.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/messager/js/messenger-theme-flat.js"></script>
<script type="text/javascript" language="javascript" src="resources/plugins/messager/js/messenger-theme-future.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/components/e.panel.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/components/e.select.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/components/e.grid.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/main/index.js"></script>
</head>
<body>
	<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner">
	<div class="container-fluid main-top">
		<div class="row-fluid logo-bg" id="mainTop">
			<div class="col-sm-12 logo-left">
				<div class="navbar-text navbar-right logo-user">
					用户：admin 欢迎您，您已登录系统!
					<div class="btn-group logo-button">
						<button type="button" class="btn btn-danger">用户中心</button>
						<button type="button" class="btn btn-danger dropdown-toggle logo-btndown" data-toggle="dropdown">
							<span class="caret"></span> <span class="sr-only">Toggle Dropdown</span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="javascript:void(0);">个人信息</a></li>
							<li><a href="javascript:void(0);">修改密码</a></li>
							<li class="divider"></li>
							<li><a href="index/logout">退出系统</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<div class="main-header"></div>
	<div class="container-fluid" id="main-content">
		<div class="row-fluid">
			<div class="col-sm-2 main-padding">
				<div class="main-sibar affix">
					<div class="panel panel-default fixed">
						<div class="panel-heading" id="leftMenus">
							<span class="headerPos"><i class="icon-desktop icon-1x"></i>导航菜单</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-10 main-padding">
				<div class="row-fluid">
					<div class="col-sm-12 main-padding">
						<div class="navbar navbar-fixed-top affix main-nav" role="banner">
							<ol class="breadcrumb main-index">
								<li>首页</li>
								<li class="active" id="menuIndex"></li>
							</ol>
						</div>
					</div>
				</div>
				<div class="main-divbar"></div>
				<div class="row-fluid">
					<div class="col-sm-12 main-padding">
						<div class="panel panel-default" id="contentframe">
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="row-fluid">
			<div class="col-sm-12 main-padding">
				<%--
				<div class="panel panel-default">
					<h6>Copy &copy; right 2014-2016</h6>
				</div>
				 --%>
			</div>
		</div>
	</div>
</body>
</html>