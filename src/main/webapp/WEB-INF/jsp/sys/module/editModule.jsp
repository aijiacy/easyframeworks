<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	//获得项目完全路径
	String base = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=base%>" target="_self"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建模块</title>
<script type="text/javascript" src="resources/js/sys/module/editModule.js"></script>
</head>
<body>
	<form class="form-horizontal" id="frmModEdit" action="admin/module/jupd" method="post" role="form">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" aria-labelledby="modifyMenu">修改模块</h4>
		</div>
		<div class="modal-body">
			<div class="form-group">
				<!-- Text input-->
				<label class="col-sm-3 control-label" for="name">模块名称：</label>
				<div class="col-sm-6">
					<input type="text" placeholder="修改模块名称" class="form-control" id="name" name="name" check-type="required" required-message="请输入模块名称!" value="${MODULE.name }" />
				</div>
			</div>
			<div class="form-group">
				<!-- Text input-->
				<label class="col-sm-3 control-label" for="code">模块编码：</label>
				<div class="col-sm-6">
					<input type="text" placeholder="修改模块编码" class="form-control" id="code" name="code" check-type="required" required-message="请输入模块编码!" value="${MODULE.code }"  />
				</div>
			</div>
			<div class="form-group">
				<!-- Text input-->
				<label class="col-sm-3 control-label" for="sort">模块排序：</label>
				<div class="col-sm-6">
					<input type="text" placeholder="修改模块编码" class="form-control" id="sort" name="sort" check-type="required" required-message="请输入模块排序!" value="${MODULE.sort }" >
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-success">修改</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		</div>
		<input type="hidden" id="id" name="id" value="${MODULE.id }" />
		<input type="hidden" id="version" name="version" value="${MODULE.version }" />
	</form>
</body>
</html>