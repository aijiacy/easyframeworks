/*
 * 初始化页面控件
 */
$(document).ready(function() {
	$('#leftMenus').panel({
		url : 'index/left',
		method : 'get',
		async : false,
		onBefore : function(){
			$('#leftMenus').append('<div id="loading">正在加载...</div>');
		},
		onComplete : function(obj,data){
			$('#loading').remove();
			obj.append(data);
		}
	});
});

function menuClick(menuName, menuUrl){
	 $('#contentframe').panel({
		url : menuUrl,
		method : 'get',
		async : false,
		onBefore : function(obj){
			obj.html('');
		},
		onComplete : function(obj,data){
			obj.html(data);
		}
	});
}

/**
 * 分页通用脚本
 * @param num
 */
function nextPage(funcName,num,prefix){
	var condions={};
	if(num == -1){
		condions.page = $('#'+prefix+'totalPage').val();
		condions.size = $('#'+prefix+'pageSize').val();
	}else{
		condions.page = parseInt($('#'+prefix+'pageNo').val()) + 1;
		condions.size = $('#'+prefix+'pageSize').val();
	}
	doExecute(funcName, condions);
}

/**
 * 分页通用脚本
 * @param num
 */
function prevPage(funcName,num){
	var condions={};
	if(num == -1){
		condions.page = 1;
		condions.size = $('#'+prefix+'pageSize').val();
	}else{
		condions.page = parseInt($('#'+prefix+'pageNo').val()) - 1;
		condions.size = $('#'+prefix+'pageSize').val();
	}
	doExecute(funcName, condions);
}

function doExecute(func, params){
    //在这里，通过传过来的方法名，来调用对应的方法
	//var funcStr=funcName + "("+params+")";
    //eval(funcStr);
	//func.apply(this, params);
	func.call(this, params);
}