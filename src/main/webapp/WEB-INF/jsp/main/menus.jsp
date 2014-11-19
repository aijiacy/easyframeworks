<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
</head>
<body>
	<div class="uk-panel uk-panel-box">
		<h3 class="uk-panel-title">系统导航</h3>
		<ul class="uk-nav uk-nav-navbar uk-nav-parent-icon" data-uk-nav="{multiple:true}">
			<li class="uk-nav-divider"></a></li>
			<c:if test="${!empty MMENUS}">
				<c:forEach var="module" items="${MMENUS}">
					<li class="uk-parent"><a href="#">${module.name }</a>
						<c:if test="${!empty module.menus}">
							<ul class="uk-nav-sub uk-panel">
								<c:forEach var="menu" items="${module.menus}">
									<li><a href="javascript:menuClick('${menu.name}','${menu.url }');">${menu.name}</a></li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</c:forEach>
			</c:if>
			<c:if test="${empty MMENUS}">
				<li class="uk-parent"><a href="javascript:void(0)">请初始化基础菜单</a></li>
			</c:if>
			<li class="uk-nav-divider"></li>
			<li><a href="javascript:void(0)"><i class="uk-icon-rss"></i>帮助</a></li>
		</ul>
	</div>
</body>
</html>