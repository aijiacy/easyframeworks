<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<script type="text/javascript">
$(function () {
    // chkAll全选事件
    $("#mod_chkAll").bind("click", function () {
    	if(true === this.checked){
	        $("input[name = mod_chkItem]").each(function(){
	        	this.checked = true;
	        });
    	}else{
    		$("input[name = mod_chkItem]").each(function(){
    			this.checked = false;
	        });
    	};
    });
    
    $("input[name = mod_chkItem]").each(function(){
    	$chk = $(this);
    	$chk.bind("click",function(){
    		var isCheck = $("input[name = mod_chkItem]").length === $("input[name = mod_chkItem]").filter(":checked").length;
    		$("#mod_chkAll").attr("checked", isCheck);
    	});
    });
    
});
</script>
</head>
<body>
	<div class="uk-panel uk-panel-box">
		<table class="uk-table uk-table-hover uk-table-striped uk-table-condensed">
			<thead>
				<tr>
					<th width="10%"><input type="checkbox" id="mod_chkAll" value="0" />全选</th>
					<th width="10%">模块名称</th>
					<th width="10%">模块编码</th>
					<th>模块排序</th>
				</tr>
			</thead>
		</table>
		<div style="width: 100%; height: 300px; overflow-y: scroll;">
			<table class="uk-table uk-table-hover uk-table-striped uk-table-condensed">
				<tbody>
					<c:forEach var="item" items="${PAGE.rows }" varStatus="status">
						<tr>
							<td width="10%"><input type="checkbox" id="chk_${status.index }" name="mod_chkItem" value="${item.id }" /></td>
							<td width="10%">${item.name }</td>
							<td width="10%">${item.code }</td>
							<td>${item.sort }</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<input type="hidden" id="mod_pageNo" value="${PAGE.start == 0? PAGE.start + 1 : PAGE.start }"/>
					<input type="hidden" id="mod_pageSize" value="${PAGE.limit}"/>
					<input type="hidden" id="mod_totalPage" value="${PAGE.totalPages }"/>
				</tfoot>
			</table>
		</div>
		<div class="uk-grid uk-grid-preserve">
			<div class="uk-width-1-2">每页 ${PAGE.limit} 条记录,当前 ${PAGE.start == 0? PAGE.start + 1 : PAGE.start } / ${PAGE.totalPages }页，共 ${PAGE.totalPages } 页</div>
			<div class="uk-width-1-2 uk-left">
				<ul class="uk-pagination ">
				<c:if test="${PAGE.hasPreviousPage==true }">
					<li><a href="javascript:prevPage(loadModule,-1,mod_);">首页</a></li>
					<li><a href="javascript:prevPage(loadModule,1,mod_);">上页</a></li>
				</c:if>
				<c:if test="${!PAGE.hasPreviousPage }">
					<li class="uk-disabled"><span>首页</span></li>
					<li class="uk-disabled"><span>上页</span></li>
				</c:if>
				<c:if test="${PAGE.hasNextPage }">
					<li><a href="javascript:nextPage(loadModule,1,mod_);">下页</a></li>
					<li><a href="javascript:nextPage(loadModule,-1,mod_);">末页</a></li>
				</c:if>
				<c:if test="${!PAGE.hasNextPage }">
					<li class="uk-disabled"><span>下页</span></li>
					<li class="uk-disabled"><span>末页</span></li>
				</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>