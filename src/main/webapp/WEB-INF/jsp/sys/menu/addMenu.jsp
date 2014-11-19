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
<script type="text/javascript" src="resources/js/sys/menu/addMenu.js"></script>
<title>创建菜单</title>
</head>
<body>
	<form class="form-horizontal" id="frmMenuAdd" action="admin/menu/jsave" method="post" role="form">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" aria-labelledby="createMenu">创建菜单</h4>
		</div>
		<div class="modal-body">
			<div class="form-group">
				<!-- Text input-->
				<label class="col-sm-3 control-label" for="name">菜单名称：</label>
				<div class="col-sm-6">
					<input type="text" placeholder="填写菜单名称" class="form-control" id="name" name="name" check-type="required" required-message="请输入模块名称!" />
				</div>
			</div>
			<div class="form-group">
				<!-- Text input-->
				<label class="col-sm-3 control-label" for="code">菜单编码：</label>
				<div class="col-sm-6">
					<input type="text" placeholder="填写菜单编码" class="form-control" id="code" name="code" check-type="required" required-message="请输入模块编码!" />
				</div>
			</div>
			<div class="form-group">
				<!-- Text input-->
				<label class="col-sm-3 control-label" for="sort">菜单排序：</label>
				<div class="col-sm-6">
					<input type="text" placeholder="填写菜单排序" class="form-control" id="sort" name="sort" check-type="required" required-message="请输入模块排序!">
				</div>
			</div>
			<div class="form-group">
				<!-- Text input-->
				<label class="col-sm-3 control-label" for="sort">所属模块：</label>
				<div class="col-sm-6">
					<div class="btn-group select" data-role="select"></div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">创建</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		</div>
	</form>
</body>
</html>