<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />
<!-- Standard Meta -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="athor" content="ERMS" />
<title>Table | Semantic UI</title>
<link rel="stylesheet" type="text/css"
	href="../resources/plugins/semantic/0.17.0/css/semantic.min.css">
<link rel="stylesheet" type="text/css"
	href="../resources/css/cert/common.css">
<script src="../resources/plugins/jquery/2.1.1/jquery-2.1.1.min.js"></script>
<script
	src="../resources/plugins/semantic/0.17.0/javascript/semantic.min.js"></script>
<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		$('.ui.dropdown').dropdown();
		$('.ui.checkbox').checkbox();
	});
	function selectAll() {
		var checklist = document.getElementsByName("selected");

		for (var i = 0; i < checklist.length; i++) {
			if (checklist[i].checked == 1) {
				checklist[i].checked = 0;
			} else if (checklist[i].checked == 0) {
				checklist[i].checked = 1;
			}
		}

	}
</script>
</head>
<body>
	<div>
		<div class="ui menu">
			<div class="left menu">
				<div class="item">
					<div class="ui icon input">
						<input type="text" placeholder="查询数据"> <i
							class="search link icon"></i>
					</div>
				</div>
				<div class="ui icon buttons">
					<div class="ui button">
						<i class="add icon"></i>
					</div>
					<div class="ui button">
						<i class="trash icon"></i>
					</div>
				</div>
			</div>
		</div>
		<table class="table" width="100%" border="0" cellspacing="0">
			<thead>
				<tr>
					<th scope="col"><div class="ui small checkbox"><input type="checkbox" id="index" onClick="onChange()"/><label></label></div></th>
					<th scope="col">企业名称</th>
					<th scope="col">组织机构代码</th>
					<th scope="col">注册地址</th>
					<th scope="col">营业执照号</th>
					<th scope="col">法人代表</th>
					<th scope="col">企业联系电话</th>
					<th scope="col">在疆地址</th>
					<th scope="col">创建时间</th>
					<th scope="col">创建者</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="coinfo" items="${PAGE.content }">
					<tr>
						<td>
							<div class="ui small checkbox">
								<input name="selected" type="checkbox"> <label></label>
							</div>
						</td>
						<td>${coinfo.co_name }</td>
						<td>${coinfo.co_org_name }</td>
						<td>${coinfo.co_reg_addr }</td>
						<td>${coinfo.co_lic_code }</td>
					<td>${coinfo.co_corp }</td>
						<td>${coinfo.co_phone }</td>
						<td>${coinfo.co_xj_addr }</td>
						<td>${coinfo.createDate }</td>
						<td>${coinfo.createUser }</td>
						<td><a class="blue">修改</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
							class="red">上传图片</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a class="red">人员管理</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div style="text-align: right">
			<div style="float: left">共1/2页</div>
			<div style="float: right">
				<button type="button">首页</button>
				<button type="button">下一页</button>
				<button type="button">上一页</button>
				<button type="button">尾页</button>
			</div>
		</div>
</body>
</html>
