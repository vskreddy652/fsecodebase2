package com.hackfse.agiveawayapp.login_register.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hackfse.agiveawayapp.login_register.config.WebServiceConfig;
import com.hackfse.agiveawayapp.login_register.controllers.LoginController;
import com.hackfse.agiveawayapp.login_register.dao.UserDao;
import com.hackfse.agiveawayapp.login_register.models.UsersBean;
import com.hackfse.agiveawayapp.login_register.services.FindUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebServiceConfig.class)
public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;

	@InjectMocks
	FindUserService findUserService;

	@InjectMocks
	private UsersBean userBean;
	
	@Autowired
	UserDao userDao;

	private MockMvc mockMvc;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Before
	public void setUpForTest() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	@Test
	public void testLoginController() throws Exception {
		ReflectionTestUtils.setField(loginController, "findUserService", findUserService);
		ReflectionTestUtils.setField(findUserService, "userDao", userDao);
		ReflectionTestUtils.setField(findUserService, "passwordEncoder", passwordEncoder);
		userBean.setUserName("admin");
		userBean.setUserPassword("admin");
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(userBean);
		mockMvc.perform(
				MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON).content(requestJson));
	}
	
	@Test
	public void dummyTestMethod() {
		System.out.println("Ran dummy Test");
	}

}
