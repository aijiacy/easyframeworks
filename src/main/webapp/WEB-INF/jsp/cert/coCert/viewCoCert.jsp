<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	//获得项目完全路径
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn" dir="ltr">
<head>
<base href="<%=base%>" />
<title>图片预览测试</title>
<script type="text/javascript" src="resources/js/cocert/ajaxfileupload.js"></script>
<meta charset="utf-8">
<script type="text/javascript">
	function ajaxFileUpload() {
		$("#loading").ajaxStart(function() {
			$(this).show();
		}).ajaxComplete(function() {//开始上传文件时显示一个图片 
			$(this).hide();
		});//文件上传完成将图片隐藏起来

		$.ajaxFileUpload({
			url : './cert/cocert/upload?name=company',//用于文件上传的服务器端请求地址
			secureuri : false,//一般设置为false
			fileElementId : 'upload',//文件上传空间的id属性  <input type="file" id="file" name="file" />
			dataType : 'json',//返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{

				if (data.status == "OK") {
					$.UIkit.notify('上传成功' + '.', {
						status : 'info',
						timeout : 2000
					});
					$("#image_url").value = data.message;
				} else {
					$.UIkit.notify('上传失败' + '.', {
						status : 'error',
						timeout : 2000
					});
				}
			},
			error : function(data, status, e) {//服务器响应失败处理函数
				$.UIkit.notify('服务器链接发生错误' + '.', {
					status : 'error',
					timeout : 2000
				});
			}
		});

		return false;

	}
	function open(elm) {
		var src = $('#' + elm).attr("src");
		$('#imgModal').find('#showimage').attr('src', src);
		new $.UIkit.modal.Modal("#imgModal").show();
	}
</script>
</head>
<body>
	<form class="uk-panel uk-panel-box uk-form box" id="frmLogin" action="" method="post" enctype="multipart/form-data" role="form">
		<input type="hidden" id="image_url" name="image_url" value="" />
		<div class="uk-form-row">
			<label class="uk-width-2-10 uk-form-label">资质名称:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="co_cret_name" placeholder="资质名称" />
		    <label class="uk-width-2-10 uk-form-label">证书编号:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="qc_cret_code" placeholder="证书编号" />
		</div>
		<div class="uk-form-row">
			<label class="uk-width-2-10 uk-form-label">证书序号:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="qc_ser_no" placeholder="证书序号" />
		    <label class="uk-width-2-10 uk-form-label">资质类型:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="qc_cret_type" placeholder="资质类型" />
		</div>
		<div class="uk-form-row">
			<label class="uk-width-2-10 uk-form-label">资质等级:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="qc_cret_grade" placeholder="资质等级" />
		    <label class="uk-width-2-10 uk-form-label">发证机关:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="qc_award_dept" placeholder="发证机关" />
		</div>
		<div class="uk-form-row">
			<label class="uk-width-2-10 uk-form-label">资质状态:</label>
		    <select class="uk-width-3-10 uk-form-medium" name="qci_status">
						<option>待审</option>
						<option>失效</option>
						<option>有效</option>
						<option>失效</option>
			</select>
		    <label class="uk-width-2-10 uk-form-label">发证日期:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="qc_award_date" placeholder="yyyy-mm-dd" data-uk-datepicker="{format:'YYYY-MM-DD',i18n:{ months:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'], weekdays:['周日','周一','周二','周三','周四','周五','周六']}}" />
		</div>
		<div class="uk-form-row">
			<label class="uk-width-2-10 uk-form-label">有效期始:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="qc_begin_date" placeholder="yyyy-mm-dd" data-uk-datepicker="{format:'YYYY-MM-DD',i18n:{ months:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'], weekdays:['周日','周一','周二','周三','周四','周五','周六']}}" />
		    <label class="uk-width-2-10 uk-form-label">有效期止:</label>
		    <input class="uk-width-3-10 uk-form-medium" type="text" name="qc_end_date" placeholder="yyyy-mm-dd" data-uk-datepicker="{format:'YYYY-MM-DD',i18n:{ months:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'], weekdays:['周日','周一','周二','周三','周四','周五','周六']}}" />
		</div>
		<div class="uk-form-row">
			<label class="uk-width-2-10 uk-form-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label>
		    <textarea class="uk-width-8-10 uk-form-small" rows="5" cols="15" name="qc_remark" placeholder="..."></textarea>
		</div>
		<div class="uk-form-row" data-uk-form-file>
			<label class="uk-width-2-10 uk-form-label">上传资质:</label>
		    <div class="uk-form-file">
		        <button class="uk-button">选择文件</button>
		        <input class="uk-button" id="upload" name="upload" type="file" onchange="$('#showfile').val(this.value);" />
		    </div>
		    <input id="showfile" type="text" disabled />
    		<button class="uk-button uk-button-success" onclick="return ajaxFileUpload();">开始上传</button>
		</div>
		<div class="uk-form-row">
			<button class="uk-width-1-10 uk-button uk-button-medium uk-button-primary" type="submit">保存</button>
			<button class="uk-width-1-10 uk-button uk-button-medium uk-button-primary" type="button">取消</button>
		</div>
		</from>
		<hr class="uk-article-divider">
		<div class="uk-margin">

			<a href="javascript:open('imgView');" class="uk-thumbnail uk-thumbnail-medium"> <img id="imgView" alt="" src="">
				<div class="uk-thumbnail-caption">Caption</div>
				<div class="uk-thumbnail-caption">
					Caption
					<code>&lt;a&gt;</code>
				</div>
				<div class="uk-thumbnail-caption">
					Caption
					<code>&lt;a&gt;</code>
				</div>
			</a>
		</div>
		<div class="uk-modal" id="imgModal" style="display: none; padding-right: 17px;" data-uk-modal="{target:'#imgModal',bgclose:false}">
			<div class="uk-modal-dialog uk-modal-dialog-frameless">
				<a class="uk-modal-close uk-close uk-close-alt" href=""></a> <img id="showimage" width="600" height="400" alt="" src="">
			</div>
		</div>
</body>
</html>