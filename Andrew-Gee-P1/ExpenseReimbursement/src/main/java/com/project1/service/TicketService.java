package com.project1.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project1.dao.ExpTicketDaoImp;
import com.project1.models.ExpTicket;

public class TicketService {
	private final static Logger logger = Logger.getLogger(TicketService.class);

	private ExpTicketDaoImp expDao;
	
	public TicketService() {
		this.expDao = new ExpTicketDaoImp();
	}
	
	public TicketService(ExpTicketDaoImp eDao) {
		this.expDao = eDao;
	}

	public void insertTicket(ExpTicket t) {
		logger.debug("Ticket created");
		expDao.createTicket(t);
	}
	
	public List<ExpTicket> getTicketByEmployee(int id){
		ArrayList<ExpTicket> expList = (ArrayList<ExpTicket>) expDao.getAllTicketsByEmployeeId(id);
		logger.debug("Retrieved all tickets for employee " + id);
		return expList;
	}
	
	public List<ExpTicket> getAllTickets(){
		ArrayList<ExpTicket> expList = (ArrayList<ExpTicket>) expDao.getAllTickets();
		logger.debug("Retrieved all tickets");
		return expList;
	}
	
	public void approveTicketById(int id) {
		logger.debug("Ticket " + id + " approved");
		expDao.approveTicketById(id);
	}
	
	public void denyTicketById(int id) {
		logger.debug("Ticket " + id + " denied");
		expDao.denyTicketById(id);
	}

}
