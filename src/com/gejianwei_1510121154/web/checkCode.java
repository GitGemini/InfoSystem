package com.gejianwei_1510121154.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Akria
 * @time 2017年11月17日  上午2:28:30
 * @description
 */
@WebServlet("/servlet/checkCode")
public class checkCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 150;
	public static final int HEIGHT = 40;	
	
	private Random r = new Random();
	
	private StringBuffer code = new StringBuffer();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();		
		//2. 设置背景色
		setBackground(g);		
		//3. 设置边框
		setBorder(g);		
		//4. 画线
		drawRandomLine(g);		
		//5. 画上文字
		drawRandomText((Graphics2D) g);		
		//6. 返回图片
		response.setContentType("image/jpeg");
		request.getSession().setAttribute("code", code.toString());
		//清空之前内容
		code = new StringBuffer();		
		ImageIO.write(image, "jpg", response.getOutputStream());		
	}

	private void setBackground(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	private void setBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
	}
	
	private void drawRandomLine(Graphics g) {
		g.setColor(Color.GREEN);
		//
		for (int i = 0; i < 5; i++) {
			int x1 = r.nextInt(WIDTH);
			int x2 = r.nextInt(WIDTH);
			int y1 = r.nextInt(HEIGHT);
			int y2 = r.nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	private void drawRandomText(Graphics2D g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		
		String base = "0123456789";
		int x = 20;
		int y = 25;
		for (int i = 0; i < 4; i++) {
			//
			int degree = r.nextInt()%30;
			String c = base.charAt(r.nextInt(base.length()))+"";
			code.append(c);
			//
			g.rotate(degree*Math.PI/180, x, y);
			g.drawString(c, x, y);
			//
			g.rotate(-degree*Math.PI/180, x, y);
			x += 30;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}