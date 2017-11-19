<%@ page language="java" pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/html/aside.css">
<div id="left">
	<div class="menu_title">
		<img src= "${pageContext.request.contextPath}/img/gear.png">管理菜单
	</div>
	<ul id="menulist">
		<li class="request"><img src="${pageContext.request.contextPath}/img/right_arrow.png"><a
			href="${pageContext.request.contextPath}/servlet/showRegisterServlet">用户注册</a></li>
		<li class="request"><img src="${pageContext.request.contextPath}/img/right_arrow.png"><a
			href="${pageContext.request.contextPath}/servlet/showLoginServlet">用户登录</a></li>
		<li class="request"><img src="${pageContext.request.contextPath}/img/right_arrow.png"><a
			href="${pageContext.request.contextPath}//servlet/showUserinfoServlet">用户信息</a></li>
		<li class="request"><img src="${pageContext.request.contextPath}/img/right_arrow.png"><a
			href="${pageContext.request.contextPath}//servlet/showExitServlet">用户退出</a></li>
	</ul>
</div>