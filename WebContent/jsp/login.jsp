<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录页面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/html/login.css">
</head>
<body>	
	<%@ include file="header.jsp"%>
	<div id="content">
		<%@ include file="aside.jsp"%>
		<div id="right">
			<span style="color: red;">${tip}</span><br /><br />
			<form method="post"
				action="${pageContext.request.contextPath}/servlet/loginServlet">
				用户名：<input type="text" name="username" /><br/><br/> 
				密 &nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /><br/><br/> 
				<input style="padding: 5px;" type="submit" value="登录" /> 
				<input style="padding: 5px; margin-left: 20px;" type="reset" value="重置" />
			</form>
		</div>
	</div>
</body>
</html>