/**
 * 面板页面
 */

+function($){
	"e.panel";
	
	
	/*定义构造*/
	var Panel = function(element, options){
		this.$element = $(element);
		this.options = $.extend({}, $.fn.panel.defaults, options);
	};
	
	//原型定义，定义构造函数和其他方法
	Panel.prototype = {
		constructor:Panel,
		loadData : function(){
			var $el = this.$element;
			this.options.onBefore($el);
			var ajaxObj = $.ajax({
				url:this.options.url,
				method:this.options.method,
				async:false,
				dataType:this.options.dataType,
				data:this.options.params
			});
			this.options.onComplete($el,ajaxObj.responseText);
		}
	};
	var old = $.fn.panel;
	$.fn.panel = function(options) {
		return this.each(function() {
		    // call our load function
			var $this = $(this);
			var panel = new Panel($this,options);
			panel.loadData();
		  });    
	};

	$.fn.panel.defaults = {
		loadText: '正在为您加载数据...',
		url 	: '',
		method	: 'get',
		useAjax	: true,
		data	: {},
		dataType: '*',
		onBefore:function(){},
		onComplete:function(obj,data){}
	};
	
	//插件的构造对象赋值
	$.fn.panel.Constructor = Panel;
	/* BUTTON NO CONFLICT * ================== */
	$.fn.panel.noConflict = function () {
	   $.fn.panel = old;
	   return this;
	};
}(window.jQuery);