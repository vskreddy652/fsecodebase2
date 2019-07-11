package com.hackfse.agiveawayapp.inventory_management.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.hackfse.agiveawayapp.inventory_management.config.WebServiceConfig;
import com.hackfse.agiveawayapp.inventory_management.dao.InventoryManagementDao;
import com.hackfse.agiveawayapp.inventory_management.services.InventoryManangementService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebServiceConfig.class)
public class InventoryManagementControllerTest {

	@InjectMocks
	private InventoryManagementController inventoryManagementController;

	@InjectMocks
	InventoryManangementService inventoryManangementService;

	@Autowired
	InventoryManagementDao inventoryManagementDao;

	private MockMvc mockMvc;

	@Before
	public void setUpForTest() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(inventoryManagementController).build();
	}

	@Test
	public void testGetInventoryItem() throws Exception {
		ReflectionTestUtils.setField(inventoryManagementController, "inventoryManangementService",
				inventoryManangementService);
		ReflectionTestUtils.setField(inventoryManangementService, "inventoryManagementDao", inventoryManagementDao);
		mockMvc.perform(MockMvcRequestBuilders.get("/inventory/id/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void dummyTestMethod() {
		System.out.println("Ran dummy Test");
	}

}
