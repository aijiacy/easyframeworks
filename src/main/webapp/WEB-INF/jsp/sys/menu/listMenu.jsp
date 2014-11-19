<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<script type="text/javascript">
$(function(){
	
	var buttons = [
			{content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"></span>&nbsp;创建</button>', action: 'add'},
            {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;修改</button>', action: 'modify'},
            {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</button>', action: 'delete'}
            ];
	var columns = [
	               {title : "菜单名称",name : "name",width : 250}, 
				   {title : "菜单编码",name : "code",width : 250},
				   {title : "菜单链接",name : "url",width : 250},
				   {title : "菜单脚本",name : "jscript",width : 250},
				   {title : "菜单图标",name : "iconData.value",width : 250},
				   {title : "菜单排序",name : "sort",width : 250}
	  		];
	var staticData = [
	                  {id:'1', name:'测试1', roleDesc:''},
	                  {id:'1', name:'测试2', roleDesc:''},
	        ];
	
	$("#menuGrid").grid({
		 identity: 'id',
         columns: columns,
         buttons: buttons,
         querys: [{ title: '角色名称', value: 'name'},{ title: '角色描述', value: 'roleDesc'} ],
         isUserLocalData:true,			//如果为false，则发送ajax请求到url端，获取数据，否则，则视为获取静态数据
         url:"",
         localData:staticData,
         isShowIndexCol:true
         //,lockWidth: true
    }).on({
    	
    	'add': function(){
    		alert("add action");
    	},
    	'modify': function(event, data){
			alert("modify action");
    	},
    	'delete': function(event, data){
            alert(event + ":" + data);
    	}
    });
	
});
</script>
</head>
<body>
<!-- 
	<table id="tMenuList">
		<thead>
			<tr>
				<th><input name="chkAll" type="checkbox" /></th>
				<th>菜单名称</th>
				<th>菜单编码</th>
				<th>菜单图标</th>
				<th>菜单链接</th>
				<th>菜单脚本</th>
				<th>显示顺序</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${PAGE.content }">
				<tr>
					<td><input name="chkId" value="${item.id }" type="checkbox" /></td>
					<td><lable name="name">${item.name }</lable></td>
					<td><lable name="code">${item.code }</lable></td>
					<td><lable name="sort"><i class="${item.iconData.value }"></i></lable></td>
					<td><lable name="sort">${item.url }</lable></td>
					<td><lable name="sort">${item.jscript }</lable></td>
					<td><lable name="sort">${item.sort }</lable></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
 -->
 <div id="menuGrid">
 </div>
</body>
</html>