<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
.tds {
	text-align: right
}

input {
	width: 100%
}
</style>
<link rel="stylesheet" type="text/css"
	href="../resources/plugins/bootstrap/3.1.1/css/bootstrap.css" />

<script type="text/javascript">
	function save() {

		document.getElementById("add_company").s;

	}
</script>
</head>
		<form id="add_company" name="form1" method="post"
			action="save" class="form-signin" role="form">
<div class="container">
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">企业基本信息</div>

		<!-- Table -->

			<table class="table">
				<tr>
					<td><div class="input-group">
							<span class="input-group-addon">企业名称</span><input name="co_name"
								type="text" class="form-control" placeholder="企业名称" required
								autofocus>
						</div></td>
					<td><div class="input-group">
							<span class="input-group-addon">组织机构代码</span><input
								name="co_org_name" type="text" class="form-control"
								placeholder="组织机构代码" required autofocus>
						</div></td>
				</tr>
				<tr>
					<td><div class="input-group">
							<span class="input-group-addon">注册地址</span><input
								name="co_reg_addr" type="text" class="form-control"
								placeholder="注册地址" required autofocus>
						</div></td>
					<td><div class="input-group">
							<span class="input-group-addon">营业执照号</span><input
								name="co_lic_code" type="text" class="form-control"
								placeholder="营业执照号" required autofocus>
						</div></td>
				</tr>
				<tr>
					<td><div class="input-group">
							<span class="input-group-addon">法人代表</span><input name="co_corp"
								type="text" class="form-control" placeholder="法人代表" required
								autofocus>
						</div></td>
					<td><div class="input-group">
							<span class="input-group-addon">企业联系电话</span><input
								name="co_phone" type="text" class="form-control"
								placeholder="企业联系电话" required autofocus>
						</div></td>
				</tr>
				<tr>
					<td colspan="2"><div class="input-group" style="width: 100%">
							<span class="input-group-addon">企业在疆地址</span><input
								name="co_xj_addr" type="text" class="form-control"
								placeholder="企业在疆地址" required>
						</div></td>
				</tr>
			</table>
		
	</div>
</div>
<div class="btn-group" style="float: right; margin-right: 150px">
	<button type="submit" class="btn btn-primary">保存</button>
	<button type="button" class="btn btn-primary"
		style="margin-left: 10px;">取消</button>
</div>

</form>

<body>
</body>
</html>
