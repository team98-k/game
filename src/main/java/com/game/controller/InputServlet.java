package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/input/*")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private static List<Map<String, String>> result = new ArrayList<Map<String,String>>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = null;
		

		while ((str = br.readLine()) != null) {
			sb.append(str);
		}

		Map<String, String> map = gson.fromJson(sb.toString(), Map.class);
		result.add(map);
		System.out.println(result);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(map.get("name"));
		out.print(map.get("id"));
		out.print(map.get("pwd"));
		out.print(map.get("desc"));
		out.print(map.get("trans"));
		out.print(map.get("job"));
	}
	
}
