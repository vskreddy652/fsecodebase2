package com.hackfse.giveaway.GiveAwayReportingService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hackfse.giveaway.component.GenerateReport;
import com.hackfse.giveaway.dao.InventoryManagementDao;
import com.hackfse.giveaway.dao.UserDao;
import com.hackfse.giveaway.dto.UsersBean;
import com.hackfse.giveaway.service.ReportingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GiveAwayReportingServiceApplicationTests {

	@InjectMocks
	GenerateReport generateReport;
	
	@InjectMocks
	ReportingService reportingService;
	
	@Autowired
	UserDao userDao;

	private MockMvc mockMvc;
	
	@Autowired
	InventoryManagementDao inventoryManagementDao;
		
	
	@Before
	public void setUpForTest() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(generateReport).build();
	}
	
	@Test
	public void testLoginController() throws Exception {
		ReflectionTestUtils.setField(generateReport, "reportingService", reportingService);
		ReflectionTestUtils.setField(reportingService, "userDao", userDao);
		ReflectionTestUtils.setField(reportingService, "inventoryManagementDao", inventoryManagementDao);		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/report/getUsers").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
