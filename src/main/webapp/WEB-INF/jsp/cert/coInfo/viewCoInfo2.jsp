<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<link rel="stylesheet" type="text/css"
	href="../resources/plugins/bootstrap/3.1.1/css/bootstrap.css" />
	<link href="../resources/css/common/grid.css" rel="stylesheet">
	<link href="../resources/css/common/checker.css" rel="stylesheet">
<script src="../resources/plugins/jquery/2.1.1/jquery-2.1.1.js"></script>
<script src="../resources/plugins/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="../resources/js/components/e.grid.js"></script>
<script src="../resources/js/components/e.select.js"></script>
<script>
	$(document)
			.ready(
					function() {

						var ajaxReq = $.ajax({
							type : "get",
							url : "../coinfo/jpage",
							async : false,
							dataType:'json'
						});
                     
						var ajaxData =eval("("+ajaxReq.responseText+")");
						var columns = [ {title : "企业名称",name : "co_name",width : 150}, 
						                {title : "组织机构代码",name : "co_org_name",width : 150}, 
						                {title : "注册地址",name : "co_reg_addr",width : 150}, 
						                {title : "营业执照号",name : "co_lic_code",width : 150}, 
						                {title : "法人代表",name : "co_corp",width : 150}, 
						                {title : "企业联系电话",name : "co_phone",width : 150}, 
						                {title : "企业在疆地址",name : "co_xj_addr",width : 150} ];
						var buttons = [
								{
									content : '<button  class="btn btn-primary" onclick="addr()" type="button"><span class="glyphicon glyphicon-plus"><span>创建</button>',
									action : ''
								},
								{
									content : '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;修改</button>',
									action : 'modify'
								},
								{
									content : '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</button>',
									action : 'delete'
								} ];

						$("#myGrid").grid({
							identity : 'id',
							columns : columns,
							buttons : buttons,
							querys : [ {title : '企业名称',value : 'co_name'}, 
							           {title : '营业执照号',value : 'co_lic_code'} 
							],
							isUserLocalData : true, //如果为false，则发送ajax请求到url端，获取数据，否则，则视为获取静态数据
							url : "",
							localData :ajaxData.content,
							isShowIndexCol : true
						//,lockWidth: true
						}).on({

							'add' : function() {
								alert("add action");
							},
							'modify' : function(event, data) {
								alert("modify action");
							},
							'delete' : function(event, data) {
								alert('delete action');
							}
						});

					});
	function addr(){
		window.open("../coinfo/add", "add", 'height=600,width800,top=200,left=200,toolbar=no,location=no,titlebar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
</head>
<body>
	<div id="myGrid"></div>
</body>
</html>
