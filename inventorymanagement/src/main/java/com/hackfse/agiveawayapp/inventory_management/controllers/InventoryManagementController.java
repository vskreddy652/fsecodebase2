package com.hackfse.agiveawayapp.inventory_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.agiveawayapp.inventory_management.models.InventoryBean;
import com.hackfse.agiveawayapp.inventory_management.request.beans.InventoryRequestBean;
import com.hackfse.agiveawayapp.inventory_management.response.beans.InventoryResponseBean;
import com.hackfse.agiveawayapp.inventory_management.services.InventoryManangementService;

@RestController
@RequestMapping("/inventory")
public class InventoryManagementController {

	@Autowired
	InventoryManangementService inventoryManangementService;

	@RequestMapping(method = RequestMethod.POST, value = "/submit")
	public InventoryResponseBean submitDonationFromUser(@RequestBody InventoryRequestBean donationRequest) {
		return inventoryManangementService.submitDonationFromUser(donationRequest);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
	public InventoryBean getInventoryItem(@PathVariable("id") Long inventoryId) {
		return inventoryManangementService.getInventoryItem(inventoryId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/userid/{id}")
	public List<InventoryResponseBean> getInventoryItemByUserId(@PathVariable("id") Long userId) {
		return inventoryManangementService.getInventoryItemByUserId(userId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all/{role}")
	public List<InventoryResponseBean> getAllInventoryItems(@PathVariable("role") String userRole) {
		return inventoryManangementService.getAllInventoryItems(userRole);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/approve/{userToken}/{status}/{requestor}/{itemcount}")
	public InventoryBean updateInventoryItem(@PathVariable("status") String status,
			@PathVariable("userToken") String userToken, @PathVariable("requestor") Long requestorUserId,
			@PathVariable("itemcount") Long requestedCountOfItem) {
		return inventoryManangementService.approveRejectInventoryItem(status, userToken, requestorUserId,
				requestedCountOfItem);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
	public void deleteInventoryItem(@PathVariable("id") Long inventoryId) {
		inventoryManangementService.deleteInventoryItem(inventoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/requested/{userid}")
	public List<InventoryResponseBean> getRequestedInventoryItems(@PathVariable("userid") Long userId) {
		return inventoryManangementService.getRequestedInventoryItems(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/delivered")
	public InventoryResponseBean deliverItemsToRecipient(@RequestBody InventoryRequestBean invRequestBean) {
		return inventoryManangementService.deliverItemsToRecipient(invRequestBean);
	}
}
