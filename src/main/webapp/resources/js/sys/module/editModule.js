$(document).ready(function(){
	$("#frmModEdit").validation();
	var options = {
		dataType : "json",
		contentType : "application/x-www-form-urlencoded;charset=utf-8;",
		beforeSubmit : function() {
			// 2.最后要调用 valid()方法。
			if ($("#frmModEdit").valid() == false) {
				$("#error-text").text("error!");
				return false;
			}
		},
		success : function(retMsg) {
			if(retMsg.status === 'OK'){
				Messenger().post({
				    message: retMsg.message + '.',
				    type: 'info',
				    showCloseButton: true
				});
				$("#frmModEdit").resetForm();
				$('#moduleView').modal('hide');
				$('#moduleGrid').getGrid().refresh();
			}else{
				Messenger().post({
				    message: retMsg.message + '.',
				    type: 'error',
				    showCloseButton: true
				});
			}
		}
	};
	$('#frmModEdit').ajaxForm(options);
});