package com.project1.service;

import org.apache.log4j.Logger;

import com.project1.dao.EmployeeDaoImp;
import com.project1.models.Employee;

public class EmployeeService {
	private final static Logger logger = Logger.getLogger(EmployeeService.class);

	private EmployeeDaoImp empDao;
	
	public EmployeeService() {
		this.empDao = new EmployeeDaoImp();
	}
	
	public EmployeeService(EmployeeDaoImp e) {
		this.empDao = e;
	}
	
	public boolean validCredentials(String username, String password) {
		if(empDao.getEmployeeByCred(username, password) != null) {
			logger.debug("Credentials valid");
			return true;
		}
		logger.debug("Credentials invalid");
		return false;
	}
	
	public Employee getEmployeeByCred(String username, String password) {
		return empDao.getEmployeeByCred(username, password);
	}
	
}
