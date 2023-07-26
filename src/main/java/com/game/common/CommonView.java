package com.game.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonView {
	private static final String PREFIX = "/WEB-INF/views";
	private static final String SUEFIX = ".jsp";

	public static void forward(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = PREFIX + req.getRequestURI() + SUEFIX;
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, res);
	}

	public static String getCmd(HttpServletRequest req) {
		String uri = req.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		return uri.substring(idx);
	}
}
