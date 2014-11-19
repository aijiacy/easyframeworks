$(document).ready(function() {
	/**
	 * 调用加载
	 */
	loadModule({page:1,size:10});
});

/**
 * 加载分页效果
 * @param condtions
 */
function loadModule(condtions){
	 $('#moduleGrid').panel({
			url : 'admin/module/page',
			method : 'get',
			params : condtions,
			async : false,
			onBefore : function(obj){
				obj.html('');
			},
			onComplete : function(obj,data){
				obj.html(data);
			}
		});
}