package com.gejianwei_1510121154.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gejianwei_1510121154.domain.Message;
import com.gejianwei_1510121154.domain.User;
import com.gejianwei_1510121154.exception.UserExistException;
import com.gejianwei_1510121154.service.UserServiceImpl;
import com.gejianwei_1510121154.util.WebUtil;

/**
 * @author Akria
 * @time 2017年11月16日 下午10:22:27
 * @description
 */
@WebServlet("/servlet/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 将提交表单数据封装到bean里面，并进行合法性校验
		User user = WebUtil.request2Bean(request, User.class);
		
		Map<String, String> errors = new HashMap<String, String>();
		// 2. 校验token与验证码，过滤重复及无效请求
		// 客户端用js进行了校验， 此处省去校验值是否有效的步骤
		boolean b = isCodeValid(request);
		if (!b) {
			errors.put("code", "验证码输入错误");
			request.setAttribute("errors", errors);
			request.setAttribute("form", user);
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			return;
		}
		b = isTokenValid(request);
		if (!b) {
			errors.put("token", "请不要重复提交数据！！");
			request.setAttribute("errors", errors);
			request.setAttribute("form", user);
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			return;
		} else {
			//移除校验码
			request.getSession().removeAttribute("token");
		}

		// 3. 如果校验成功，向service层提交注册请求
		UserServiceImpl userService = new UserServiceImpl();
		try {
			userService.register(user);
		} catch (UserExistException e) {
			// 4. 如果service处理不成功，且失败原因是因为注册用户已存在的话，
			// 则跳回注册页面，并显示注册用户已存在的消息
			errors.put("user", "该用户已存在，请登录！");
			request.setAttribute("errors", errors);
			request.setAttribute("form", user);
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			// 5. 如果service处理不成功，且失败原因是因为未知原因，
			// 则跳转到全局错误信息显示页面，给用户提示信息
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
			return;
		}
		// 6. 如果处理成功，则跳转到消息显示页面，提示用户注册成功
		Message message = new Message();
		message.setPage("登录");
		message.setInfo("注册成功,请登录");
		String url  = request.getContextPath()+"/jsp/login.jsp";
		message.setUrl(url);
		request.setAttribute("message", message);
		response.setHeader("refresh", "3;"+url);
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean isCodeValid(HttpServletRequest request) {
		String client_code = request.getParameter("code");
		if (client_code == null) {
			return false;
		}
		String server_code = (String) request.getSession().getAttribute("code");
		if (server_code == null) {
			return false;
		}
		if (!client_code.equals(server_code)) {
			return false;
		}
		return true;
	}

	private boolean isTokenValid(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		if (client_token == null) {
			return false;
		}
		String server_token = (String) request.getSession().getAttribute("token");
		if (server_token == null) {
			return false;
		}
		if (!client_token.equals(server_token)) {
			return false;
		}
		return true;
	}
}