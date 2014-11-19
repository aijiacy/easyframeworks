/**
 * 登陆请求
 */
$(document).ready(function(){
	$('#frmLogin').ajaxForm({
		dataType:'json',
		success : function(retMsg){
			if(retMsg.status == 'ERROR'){				
				$.UIkit.notify(retMsg.message + '.', {status:'warning',timeout : 2000});
			}
			if(retMsg.status === 'OK'){
				$.UIkit.notify(retMsg.message + '.', {status:'info', timeout : 2000});
				window.location.href= $('base').attr('href') + 'index/';
			}
		}
	});
});