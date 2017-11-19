<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>退出页面</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<div id="content">
		<%@ include file="aside.jsp"%>
		<div id="right">
			${username} 已成功退出！<br/>
			对不起，您还没有登录！			
		</div>
	</div>
</body>
</html>