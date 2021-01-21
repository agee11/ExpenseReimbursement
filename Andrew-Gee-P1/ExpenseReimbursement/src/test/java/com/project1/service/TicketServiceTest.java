package com.project1.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.project1.dao.ExpTicketDaoImp;
import com.project1.models.ExpTicket;

public class TicketServiceTest {
	
	private static TicketService tService;
	
	private static ArrayList<ExpTicket> db;
	private static ExpTicket p;
	
	@Mock
	static ExpTicketDaoImp eDao;
	
	@Before
	public void setUp() {
		
		p = new ExpTicket();
		db = new ArrayList<>();
		
		eDao = Mockito.mock(ExpTicketDaoImp.class);
		
		tService = new TicketService(eDao);
		
		Mockito.when(eDao.getAllTickets()).thenReturn(new ArrayList<ExpTicket>());
		Mockito.when(eDao.getAllTicketsByEmployeeId(1)).thenReturn(new ArrayList<ExpTicket>());
		Mockito.doNothing().when(eDao).createTicket(p);
		Mockito.doNothing().when(eDao).approveTicketById(3);
		Mockito.doNothing().when(eDao).denyTicketById(3);
	}

	@Test
	public void testInsert() {
		tService.insertTicket(p);
		
		Mockito.verify(eDao).createTicket(p);
	}
	
	@Test
	public void testGetTicketByEmployeeId() {
		assertTrue(tService.getTicketByEmployee(1) != null);
	}

	@Test
	public void testGetAllTickets() {
		assertTrue(tService.getAllTickets() != null);
	}
	
	@Test
	public void testApprove() {
		tService.approveTicketById(3);
		
		Mockito.verify(eDao).approveTicketById(3);
	}
	
	@Test
	public void testDeny() {
		tService.denyTicketById(3);
		
		Mockito.verify(eDao).denyTicketById(3);
	}
	

}
