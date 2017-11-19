<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.gejianwei_1510121154.domain.User"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/html/header.css">
	<%
		User user = (User)session.getAttribute("user");
		String src = null;
		String name = null;
		if(user!=null){
			src = user.getUsericon();
			name = user.getUsername();
		}else{
			src = request.getContextPath()+"/img/default.jpg";
			name = "您还未登录！";
		}
	%>
<header>
	<div id="header_left">
		<a class="url_img" href="${pageContext.request.contextPath}/index.jsp"><img
			src="${pageContext.request.contextPath}/img/appicon.png"></a><span class="text_img">欢迎使用本系统！</span>
	</div>
	<div id="header_right">
		<img src="<%= src %>"><span id="login_info" class="text_img"><%= name %></span>
	</div>
</header>