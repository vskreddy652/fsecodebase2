package com.hackfse.giveaway.MailingSystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hackfse.giveaway.bean.MailInboxBean;
import com.hackfse.giveaway.controllers.MailingController;
import com.hackfse.giveaway.dao.MailDao;
import com.hackfse.giveaway.dao.UserDao;
import com.hackfse.giveaway.services.DomainService;
import com.hackfse.giveaway.services.EmailServiceImpl;
import com.hackfse.giveaway.services.MailingService;
import com.hackfse.giveaway.util.EmailUtility;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailingSystemApplicationTests {

	@InjectMocks
	MailingController mailingController;	
	
	@InjectMocks
	MailingService objMailingService;
	
	@InjectMocks
	EmailServiceImpl objEmailMailingService;
	
	@Autowired
	public JavaMailSender emailSender;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MailDao mailDao;
	
	@Autowired
	DomainService domainService;
	
	@Autowired
	MailInboxBean objMailInboxBean;
	
	@Autowired
	EmailUtility mailUtil;
	
	@Autowired
	EmailServiceImpl emailSrvs;	
	
	private MockMvc mockMvc;
		
	@Before
	public void setUpForTest() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mailingController).build();
	}
	
	@Test
	public void testLoginController() throws Exception {
		ReflectionTestUtils.setField(mailingController, "objMailingService", objMailingService);
		ReflectionTestUtils.setField(mailingController, "objEmailMailingService", objEmailMailingService);
		
		
		ReflectionTestUtils.setField(objMailingService, "objMailInboxBean", objMailInboxBean);
		ReflectionTestUtils.setField(objMailingService, "mailDao", mailDao);	
		ReflectionTestUtils.setField(objMailingService, "userDao", userDao);
		ReflectionTestUtils.setField(objMailingService, "mailUtil", mailUtil);
		ReflectionTestUtils.setField(objMailingService, "emailSrvs", objEmailMailingService);
		ReflectionTestUtils.setField(objMailingService, "domainService", domainService);
		
		ReflectionTestUtils.setField(objEmailMailingService, "emailSender", emailSender);	
		ReflectionTestUtils.setField(objEmailMailingService, "userDao", userDao);
		ReflectionTestUtils.setField(objEmailMailingService, "mailDao", mailDao);
		ReflectionTestUtils.setField(objEmailMailingService, "domainService", domainService);
		
		
		
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString("bhaskar.koley@gmail.com");
		
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/mailer/getinbox?email=bhaskar.koley@gmail.com").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}

