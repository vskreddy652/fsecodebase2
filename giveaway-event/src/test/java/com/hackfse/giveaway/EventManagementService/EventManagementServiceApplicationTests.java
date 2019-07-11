package com.hackfse.giveaway.EventManagementService;

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

import com.hackfse.giveaway.controller.EventController;
import com.hackfse.giveaway.dao.EventRepository;
import com.hackfse.giveaway.services.EventService;
import com.hackfse.giveaway.services.FileUploadService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventManagementServiceApplicationTests {

	@InjectMocks
	EventController eventController;
	
	@InjectMocks
	EventService eventService;
	
	@Autowired
	EventRepository eventRepo;
	
	@Autowired
	FileUploadService objFileUploadService;
	
	private MockMvc mockMvc;
		
	@Before
	public void setUpForTest() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
	}
	
	@Test
	public void testLoginController() throws Exception {
		ReflectionTestUtils.setField(eventController, "eventService", eventService);
		ReflectionTestUtils.setField(eventService, "objFileUploadService", objFileUploadService);
		ReflectionTestUtils.setField(eventService, "eventRepo", eventRepo);	
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/event/get").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}

