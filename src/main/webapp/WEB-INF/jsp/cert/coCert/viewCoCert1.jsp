<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>图片预览测试</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<!-- Bootstrap -->

<link rel="stylesheet" href="./resources/css/common/blueimp-gallery.min.css">
<link rel="stylesheet" href="./resources/plugins/bootstrap/3.1.1/css/bootstrap-image-gallery.min.css">

<script src="./resources/plugins/jquery/2.1.1/jquery.blueimp-gallery.min.js"></script>
<script src="./resources/js/cocert/jquery.blueimp-gallery.min.js"></script>
<script src="./resources/js/cocert/ajaxfileupload.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $('.dropdown-toggle').dropdown();
});

function ajaxFileUpload()
{
    
    $("#loading")
    .ajaxStart(function(){
        $(this).show();
    })//开始上传文件时显示一个图片
    .ajaxComplete(function(){
        $(this).hide();
    });//文件上传完成将图片隐藏起来
    
    $.ajaxFileUpload
    (
        {
            url:'./cert/cocert/upload?name=company',//用于文件上传的服务器端请求地址
            secureuri:false,//一般设置为false
            fileElementId:'upload',//文件上传空间的id属性  <input type="file" id="file" name="file" />
            dataType: 'json',//返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
            	
            	
                if(data.status=="OK"){
                	Messenger().post({
    				    message: "上传成功！" + '.',
    				    type: 'info',
    				    showCloseButton: true
    				});
                	$("#image_url").value=data.message;
                }else{
                	Messenger().post({
    				    message: data.message + '.',
    				    type: 'error',
    				    showCloseButton: true
    				});
                }
                
               
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert("sssss");
            }
        }
    )
    
    return false;

}

</script>
</head>
<body>
<div class="container">
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">企业资质信息</div>

  <!-- Table -->
  <form class="form-signin" name="form" method="post" enctype="multipart/form-data">  
   <input type="hidden" id="image_url" name="image_url" value=""/>
  <table class="table">
  <tr>

 <td><div class="input-group"><span class="input-group-addon">资质名称</span><input type="text" name="co_cret_name" class="form-control" placeholder="资质名称" required /></div></td>
    <td><div class="input-group"><span class="input-group-addon">证书编号</span><input type="text" name="qc_cret_code"  class="form-control" placeholder="证书编号" required autofocus /></div></td>
  </tr>
  <tr>
    <td><div class="input-group"><span class="input-group-addon">证书序号</span><input type="text" name="qc_ser_no" class="form-control" placeholder="证书序号" required autofocus /></div></td>
    <td><div class="input-group"><span class="input-group-addon">资质类型</span><input type="text" name="qc_cret_type"  class="form-control" placeholder="资质类型" required autofocus /></div></td>
  </tr>
  <tr>
    <td><div class="input-group"><span class="input-group-addon">资质等级</span><input type="text" class="form-control" name="qc_cret_grade"  placeholder="资质类型" required autofocus />
</div></td>
    <td><div class="input-group"><span class="input-group-addon">发证机关</span><input type="text" class="form-control" name="qc_award_dept"  placeholder="发证机关" required autofocus />
</div></td>
    
  </tr>
  <tr>
    
    <td><div class="input-group"><span class="input-group-addon">资质状态</span><select class="form-control" name="qci_status" >

<option>待审</option>

<option>失效</option>

<option>有效</option>

<option>失效</option>


</select></div></td>
    <td><div class="input-group"><span class="input-group-addon">发证日期</span><input type="date" name="qc_award_date" class="form-control" placeholder="发证日期" required autofocus></div></td>
  </tr>
  <tr>
    <td><div class="input-group"><span class="input-group-addon">有效期始</span><input type="date" name="qc_begin_date" class="form-control" placeholder="有效期始" required autofocus></div></td>
    <td><div class="input-group"><span class="input-group-addon">有效期止</span><input type="date" class="form-control" name="qc_end_date"  placeholder="有效期止" required autofocus></div></td>
  </tr>
    <tr>
    <td colspan="2"><div class="input-group" style="width:100%"><span class="input-group-addon">&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;</span><input type="text" name="qc_remark"  class="form-control" placeholder="备注" required></div></td>
    </tr>
       <tr>
    <td colspan="2"><div class="input-group" style="width:100%"><span class="input-group-addon">图片上传</span> <input type="file" id="upload" name="upload" class="form-control" placeholder="图片上传" required /><input type="button" value="上传" onclick="return ajaxFileUpload();"></div></td>
    </tr>
</table>
<div class="btn-group pull-right">
  <button type="submit" class="btn btn-primary">保存</button>
  
  <button type="button" class="btn btn-primary" style="margin-left:10px;">取消</button>
  </div> 
</form>
</div>
</div>
<HR style="BORDER-RIGHT: #00686b 1px dotted; BORDER-TOP: #00686b 1px dotted; BORDER-LEFT: #00686b 1px dotted; BORDER-BOTTOM: #00686b 1px dotted" noShade SIZE=1>
<div class="container" style="margin-top:20px; border:2px;">
<div id="blueimp-gallery" class="blueimp-gallery">
    <!-- The container for the modal slides -->
    <div class="slides"></div>
    <!-- Controls for the borderless lightbox -->
    <h3 class="title"></h3>
    <a class="prev">‹</a>
    <a class="next">›</a>
    <a class="close">×</a>
    <a class="play-pause"></a>
    <ol class="indicator"></ol>
    <!-- The modal dialog, which will be used to wrap the lightbox content -->
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body next"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left prev">
                        <i class="glyphicon glyphicon-arrow-left"></i>
                        上一张
                    </button>
                    <button type="button" class="btn btn-primary next">
                        下一张
                        <i class="glyphicon glyphicon-arrow-right"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>


<div id="links">
<c:if test="${list_images !=null}">
<c:forEach var="coinfo" items="${list_images }">
	<div class="col-sm-4 col-md-3">
    <div class="thumbnail">
    <a href="${cocert.image_ulr }" title="第一张" data-gallery>
        <img src="${cocert.image_ulr }" width="300" height="200" alt="Banana">
    </a>
    
    <div class="caption">
        <h5>${cocert.co_cret_name }</h5>
        <p>${cocert.qc_cret_code }</p>
         <p>${cocert.qc_ser_no }</p>
         <p>${cocert.qc_cret_type }</p>
         <p>${cocert.qc_cret_grade }</p>
          <p>${cocert.qc_award_dept }</p>
           <p>${cocert.qc_award_date }</p>
             <p>${cocert.qc_begin_date }--${cocert.qc_end_date }</p>
                <p>${cocert.qci_status }</p>
      </div>
    </div>
    </div>
   </c:forEach>
   </c:if>
   
   <c:if test="${list_images ==null}">
    <div class="col-sm-4 col-md-3">
    <div class="thumbnail">
    <a href="images/201008271200068199.jpg" title="第二张" data-gallery>
        <img src="images/201008271200068199.jpg" width="300" height="200" alt="Banana">
    </a>
    
    <div class="caption">
        <h5>没有查询到相关的图片</h5>
        
      </div>
    </div>
    </div>
    </c:if>
 

</div>
</div>
</body>
</html>