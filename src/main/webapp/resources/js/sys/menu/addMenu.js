$(document).ready(function() {
	$("#menuView").on("hidden.bs.modal", function(e) {
	    $(this).removeData("bs.modal");
	});
	var contents = [];
	$.ajax({
		url : 'admin/module/jlist',
		method : 'get',
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded;charset=utf-8;",
		success : function(retData) {
			if(retData.length > 0){
				for(var i = 0; i < retData.length; i++){
					var module = {};
					module.value = retData[i].id;
					module.title = retData[i].name;
					module.selected = false;
					contents[i] = module;
				}
				if(contents.length > 0){
					contents[0].selected = true;
				}
			}
			$("div[data-role='select']").select({
				selectName: 'moduleId.id',
				contents: contents
			});
		}
	});
	
	
});