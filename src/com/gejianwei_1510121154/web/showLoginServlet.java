package com.gejianwei_1510121154.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gejianwei_1510121154.domain.Message;
import com.gejianwei_1510121154.domain.User;

/**
 * @author Akria
 * @time 2017年11月17日  上午2:28:30
 * @description
 */
@WebServlet("/servlet/showLoginServlet")
public class showLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
			Message message = new Message();
			message.setPage("注销登录");
			message.setInfo("请先退出已登录用户!!");
			String url  = request.getContextPath()+"/servlet/showExitServlet";
			message.setUrl(url);
			request.setAttribute("message", message);
			response.setHeader("refresh", "3;"+url);
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}