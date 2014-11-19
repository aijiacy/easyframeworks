<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String base = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>主页</title>
<link title="bootstrap3" rel="stylesheet" type="text/css" href="<%=base%>/resources/plugins/bootstrap/3.1.1/css/bootstrap.min.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="<%=base%>/resources/plugins/bootstrap/3.1.1/css/font-awesome.min.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="<%=base%>/resources/plugins/bootstrap/3.1.1/css/bootstrap-theme.min.css" />
<link title="bootstrap3" rel="stylesheet" type="text/css" href="<%=base%>/resources/css/common/main.css" />
<script type="text/javascript" language="javascript" src="<%=base%>/resources/plugins/jquery/2.1.1/jquery-2.1.1.min.js"></script>
<script type="text/javascript" language="javascript" src="<%=base%>/resources/plugins/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" language="javascript" src="<%=base%>/resources/js/components/e.panel.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#leftMenus').panel({
			url : 'left',
			method : 'get',
			async : false,
			onBefore : function(){
				$('#leftMenus').after('<div id="loading">正在加载...</div>');
			},
			onComplete : function(obj,data){
				$('#loading').remove();
				obj.after(data);
			}
		});
	});
</script>
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
							<li><a href="#">个人信息</a></li>
							<li><a href="#">修改密码</a></li>
							<li class="divider"></li>
							<li><a href="#">退出系统</a></li>
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
						<div class="panel-footer">
							<h6>Copy &copy; right 2014-2016</h6>
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
								<li class="active">菜单管理</li>
							</ol>
						</div>
					</div>
				</div>
				<div class="main-divbar"></div>
				<div class="row-fluid">
					<div class="col-sm-12 main-padding">
						<div class="panel panel-default">
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="row-fluid">
			<div class="span12"></div>
		</div>
	</div>
</body>
</html>