package com.hackfse.agiveawayapp.inventory_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.agiveawayapp.inventory_management.dao.BooksManagementDao;
import com.hackfse.agiveawayapp.inventory_management.models.BooksBean;
import com.hackfse.agiveawayapp.inventory_management.request.beans.InventoryRequestBean;
import com.hackfse.agiveawayapp.inventory_management.response.beans.InventoryResponseBean;
import com.hackfse.agiveawayapp.inventory_management.util.CommonUtil;

@Service
public class BooksManagementService {

	@Autowired
	BooksManagementDao booksManagementDao;

	public InventoryResponseBean submitDonationFromUser(final InventoryRequestBean donationRequest) {
		final BooksBean booksBean = new BooksBean();
		booksBean.setBookAuthor(donationRequest.getBookAuthor());
		booksBean.setBookCategory(donationRequest.getBookCategory());
		booksBean.setBookDescription(donationRequest.getItemDescription());
		booksBean.setBookIsbnNumber(donationRequest.getBookIsbnNumber());
		booksBean.setBookName(donationRequest.getInventoryItemName());
		booksBean.setCount(donationRequest.getItemCount());
		booksManagementDao.save(booksBean);
		return null;
	}

	public BooksBean getBook(Long bookId) {
		return booksManagementDao.getOne(bookId);
	}

	public List<BooksBean> getBooks() {
		return booksManagementDao.findAll();
	}

}
