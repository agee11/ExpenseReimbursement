package com.project1.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.project1.dao.EmployeeDaoImp;
import com.project1.models.Employee;

public class EmployeeServiceTest {
	
	private EmployeeService eService;
	
	@Mock
	private static EmployeeDaoImp eDao;
	
	@Before
	public void setup() {
		eDao = Mockito.mock(EmployeeDaoImp.class);
		eService = new EmployeeService(eDao);
		
		Mockito.when(eDao.getEmployeeByCred("test1","testPass")).thenReturn(new Employee());
		Mockito.when(eDao.getEmployeeByCred("bad", "bad")).thenReturn(null);
	}

	@Test
	public void testCredentials() {
		assertTrue(eService.validCredentials("test1", "testPass"));
		assertFalse(eService.validCredentials("bad", "bad"));
	}
	
	@Test
	public void testGetEmployee() {
		assertNotNull(eService.getEmployeeByCred("test1", "testPass"));
		assertNull(eService.getEmployeeByCred("bad", "bad"));
	}

}
