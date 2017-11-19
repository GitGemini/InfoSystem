<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>查看当前用户</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="content">
		<%@ include file="aside.jsp"%>
		<div id="right">
			<table id="register_table">
				<tr>
				<td colspan="2"><span style="font-size:20px;">${user.username}</span>登录成功</td>
				</tr>
				<tr>
					<td class="col1">头像:</td>
					<td><img class="headicon" id="img_icon" src="${user.usericon}" /></td>
				</tr>
				<tr>
					<td class="col1">性别：</td>
					<td>${user.gender}</td>
				</tr>
				<tr>
					<td class="col1">联系电话：</td>
					<td>${user.phone}</td>
				</tr>
				<tr>
					<td class="col1">电子邮件：</td>
					<td>${user.email}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>