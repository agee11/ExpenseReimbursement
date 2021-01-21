package com.project1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.project1.service.EmployeeService;

public class DefaultController {
	
	private final static Logger logger = Logger.getLogger(DefaultController.class);

	
	public static void landing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("Landing page sent");
		RequestDispatcher redis = req.getRequestDispatcher("/index.html");
		redis.forward(req, resp);
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			logger.debug("Logout fired, session invalidated");
			session.invalidate();
		}
//		RequestDispatcher redis = req.getRequestDispatcher(req.getContextPath() + "/api");
//		redis.forward(req, resp);
		
		
//		return;
	}
}
