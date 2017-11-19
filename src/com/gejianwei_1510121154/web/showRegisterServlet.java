package com.gejianwei_1510121154.web;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gejianwei_1510121154.util.UserUtil;

/**
 * @author Akria
 * @time 2017年11月12日  11:02:49
 * @description
 */
@WebServlet("/servlet/showRegisterServlet")
public class showRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置防重复提交的token
		String token = TokenProcessor.getInstance().generateToken();
		request.getSession().setAttribute("token", token);
		request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

class TokenProcessor {
	private static final TokenProcessor instance = new TokenProcessor();
	private TokenProcessor() {}
	
	public static TokenProcessor getInstance() {
		return instance;
	}
	
	//生成Token
	public String generateToken(){
		Random r = new Random();
		long str = r.nextInt()+System.currentTimeMillis();		
		return UserUtil.md5(str+"");
	}
}