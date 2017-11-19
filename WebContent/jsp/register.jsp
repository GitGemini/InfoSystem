<%@ page import="com.gejianwei_1510121154.domain.IconList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.gejianwei_1510121154.domain.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册页面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/html/register.css">
<script src="${pageContext.request.contextPath}/html/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/html/register.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="content">
		<%@ include file="aside.jsp"%>
		<div id="right">
			<span style="color: red;text-align: center;">${errors.code}${errors.token}${errors.user} </span>
			<form onsubmit="return checkAll()" action="${pageContext.request.contextPath}/servlet/registerServlet" method="POST">
				<table id="register_table">
					<tr>
						<td class="col1"><span class="tips_star">*</span>用户名：</td>
						<td><input name="username" value="${form.username}" onblur="return checkUserName()"
							type="text"></input> <span id="tips_username">用户名由3-5个字符组成</span></td>
					</tr>
					<tr>
						<td class="col1"><span class="tips_star">*</span>密码：</td>
						<td><input name="password" value="${form.password}"  onblur="checkPassword()"
							type="password"></input> <span id="tips_password">请输入8-12位密码</span></td>
					</tr>
					<tr>
						<td class="col1"><span class="tips_star">*</span>确定密码：</td>
						<td><input name="pwdrepeat" onblur="checkPwdRepeat()"
							type="password"></input> <span id="tips_pwdrepeat">两次密码不一致</span></td>
					</tr>
					<tr>
						<td class="col1"><span class="tips_star">*</span>性别：</td>
						<td><input name="gender" value="男" checked type="radio" />男
						<input name="gender" value="女" type="radio" /> 女</td>
					</tr>

					<tr>
						<td class="col1"><span class="tips_star">*</span>头像:</td>
						<td><select name="usericon" onchange="changeIcon(this)">
								<%
									IconList iconlist = new IconList();
									List<String> icons = iconlist.getIconList();
									for (int i = 0; i < icons.size(); i++) {
										String na = String.format("头像%d", i+1);
										String value = icons.get(i);
								%>
								<option value="<%= value %>"><%= na %></option>
								<%
									}
								%>
						</select><img class="headicon" id="img_icon" src="<%=icons.get(0)%>" /></td>
					</tr>
					<tr>
						<td class="col1"><span class="tips_star">*</span>联系电话：</td>
						<td><input name="phone" value="${form.phone}" onblur="checkPhone()" type="text"></input>
							<span id="tips_phone">格式示例:13803780000</span></td>
					</tr>

					<tr>
						<td class="col1"><span class="tips_star">*</span>电子邮件：</td>
						<td><input name="email" value="${form.email}" onblur="checkEmail()" type="email"></input>
							<span id="tips_email">格式示例:xxxxxxxxx@163.com</span></td>
					</tr>
					<tr>
						<td class="col1"><span class="tips_star">*</span>验证码：</td>
						<td><input name="code" type="text"></input> 
						<img src="${pageContext.request.contextPath}/servlet/checkCode" onclick="changeCode(this)" /></td>
					</tr>
					<tr>
						<td><input name="token" type="hidden" value="${token}"></input></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<button style="padding: 5px;" type="submit">注册</button>
						<button style="padding: 5px; margin-left: 20px;" type="reset">重置</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>