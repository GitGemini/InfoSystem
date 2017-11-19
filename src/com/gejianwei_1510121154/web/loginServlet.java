package com.gejianwei_1510121154.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gejianwei_1510121154.domain.User;
import com.gejianwei_1510121154.exception.UserNotExistException;
import com.gejianwei_1510121154.service.UserServiceImpl;

/**
 * @author Akria
 * @time 2017年11月12日  11:03:30
 * @description
 */
@WebServlet("/servlet/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String tip = null;
		User user = null;
		if (username == null || username.isEmpty()) {// 检查用户名是否为空
			tip = "用户名不能为空！！！";
		} else if (password == null || password.isEmpty()) {// 检查密码是否为空
			tip = "密码不能为空！！！";
		} else { // 用户名与密码不为空，提交service层登录
			UserServiceImpl userService = new UserServiceImpl();
			try {
				user = userService.login(username, password);
			} catch (UserNotExistException e) {
				tip = "用户名或密码错误！！！";
			} catch (Exception e) {
				request.setAttribute("message", e.getMessage());
				request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
				return;
			}
		}
		if (tip != null) {
			request.setAttribute("tip", tip);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		} else if(user != null){
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/jsp/userinfo.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}