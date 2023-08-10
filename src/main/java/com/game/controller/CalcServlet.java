package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc/*")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = 0;
		String calc = request.getParameter("op");
		
		if("+".equals(calc)) {
			result =  num1 + num2;
		}else if("-".equals(calc)) {
			result =  num1 - num2;
		}else if("*".endsWith(calc)) {
			result = num1 * num2;
		}else if("/".endsWith(calc)) {
			result = num1 / num2;
		}else if("%".endsWith(calc)) {
			result = num1 % num2;
		}
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
