package com.project1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class RequestHelper {
	private final static Logger logger = Logger.getLogger(RequestHelper.class);

	public static void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String url = req.getRequestURI();
		HttpSession session = req.getSession(false);
		switch(url) {
			case "/ExpenseReimbursement/api":
				logger.debug("Landing page endpoint request received");
				DefaultController.landing(req, resp);	
				break;
			case "/ExpenseReimbursement/api/login":
				logger.debug("Login endpoint request received");
				LoginController.login(req, resp);
				break;
			case "/ExpenseReimbursement/api/logout":
				logger.debug("Logout endpoint request received");
				DefaultController.logout(req, resp);
				break;
			case "/ExpenseReimbursement/api/employee":
				logger.debug("Employee endpoint request received");
				if(session != null && session.getAttribute("employee_id") != null) {
					EmployeeController.employee(req, resp);	
				}else {
					System.out.println("DEFAULT REDIRECT");
					logger.debug("DEFAULT REDIRECT");
					resp.sendRedirect("/ExpenseReimbursement/api");
//					DefaultController.landing(req, resp);
					//resp.setStatus(401);
				}
				break;
			case "/ExpenseReimbursement/api/employee/tickets":
				logger.debug("Employee tickets endpoint request received");
				if(session != null && session.getAttribute("employee_id") != null) {
					switch(req.getMethod()) {
						case "GET":
							EmployeeController.getEmployeeTickets(req, resp);
							break;
						case "POST":
							EmployeeController.createEmployeeTicket(req, resp);
							break;
					}	
				}else {
//					resp.setStatus(401);
				}
				break;
			case "/ExpenseReimbursement/api/manager":
				logger.debug("Manager endpoint request received");
				if(session != null && session.getAttribute("employee_id") != null) {
					ManagerController.manager(req, resp);
				}else {
					System.out.println("DEFAULT REDIRECT");
					logger.debug("DEFAULT REDIRECT");
					resp.sendRedirect("/ExpenseReimbursement/api");
					//DefaultController.landing(req, resp);
					//resp.setStatus(401);
				}
				break;
			case "/ExpenseReimbursement/api/manager/tickets":
				logger.debug("Manager tickets endpoint request received");
				if(session != null && session.getAttribute("employee_id") != null) {
					switch(req.getMethod()) {
						case "GET":
							ManagerController.getAllTickets(req, resp);
							break;
						case "POST":
							ManagerController.updateTicket(req, resp);
							break;
					}
				}else {
					resp.setStatus(401);
				}
				break;
			default:
				logger.debug("Default endpoint request received");
				//resp.sendRedirect("http://localhost:8080/ExpenseReimbursement/api");
				break;
		}
	}
}
