$(document).ready(function() {
	var buttons = [ {
				content : '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"></span>&nbsp;创建</button>',
				action : 'add'
			},{
				content : '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;修改</button>',
				action : 'modify'
			},{
				content : '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</button>',
				action : 'delete'
			} ];
	var columns = [ 
			          { title : "菜单名称", name : "name", width : 250 },
			          { title : "菜单编码", name : "code", width : 250 },
			          { title : "隶属模块", name : "moduleId.name", width : 250 },
			          { title : "菜单链接", name : "url", width : 250 },
			          { title : "菜单图标", name : "iconData.value", width : 250 },
			          { title : "菜单排序", name : "sort", width : 250 } 
			      ];

	$("#menuGrid").grid({
		identity : 'id',
		columns : columns,
		buttons : buttons,
		autoLoad: false,
		querys : [ {
			title : '菜单名称', value : 'name'
		}, {
			title : '菜单编码', value : 'code'
		}],
		isUserLocalData : false, // 如果为false，则发送ajax请求到url端，获取数据，否则，则视为获取静态数据
		url : "admin/menu/jpage",
		localData : [],
		isShowIndexCol : true
	// ,lockWidth: true
	}).on({
		'add' : function() {
			$('#menuView').modal({
				backdrop : 'static',
				keyboard: true,
				remote : 'admin/menu/add'
			});
		},
		'modify' : function(event, data) {
			alert("modify action");
		},
		'delete' : function(event, data) {
			alert(data.data);
		}
	});
});