package com.hackfse.agiveawayapp.inventory_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.agiveawayapp.inventory_management.models.BooksBean;
import com.hackfse.agiveawayapp.inventory_management.request.beans.InventoryRequestBean;
import com.hackfse.agiveawayapp.inventory_management.response.beans.InventoryResponseBean;
import com.hackfse.agiveawayapp.inventory_management.services.BooksManagementService;

@RestController
@RequestMapping("/books")
public class BooksManagementController {
	
	@Autowired
	BooksManagementService booksManagementService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/submit")
	public InventoryResponseBean submitBookFromUser(@RequestBody InventoryRequestBean donationRequest) {
		return booksManagementService.submitDonationFromUser(donationRequest);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public BooksBean getBook(@PathVariable("id") Long bookId) {
		return booksManagementService.getBook(bookId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<BooksBean> getAllBooks() {
		return booksManagementService.getBooks();
	}
}
