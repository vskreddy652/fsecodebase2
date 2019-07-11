package com.hackfse.agiveawayapp.inventory_management.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.agiveawayapp.inventory_management.dao.FileUploadDao;
import com.hackfse.agiveawayapp.inventory_management.dao.InventoryManagementDao;
import com.hackfse.agiveawayapp.inventory_management.dao.ItemRequestDao;
import com.hackfse.agiveawayapp.inventory_management.models.InventoryBean;
import com.hackfse.agiveawayapp.inventory_management.models.InventoryItemUploads;
import com.hackfse.agiveawayapp.inventory_management.models.ItemRequestBean;
import com.hackfse.agiveawayapp.inventory_management.request.beans.InventoryRequestBean;
import com.hackfse.agiveawayapp.inventory_management.response.beans.InventoryResponseBean;
import com.hackfse.agiveawayapp.inventory_management.util.CommonUtil;
import com.hackfse.agiveawayapp.inventory_management.util.Constants;
import com.hackfse.agiveawayapp.inventory_management.util.DomainUtil;

@Service
public class InventoryManangementService {

	@Autowired
	InventoryManagementDao inventoryManagementDao;

	@Autowired
	BooksManagementService booksManagementService;

	@Autowired
	DomainService domainService;

	@Autowired
	FileUploadDao fileUploadDao;

	@Autowired
	ItemRequestDao itemRequestDao;

	public InventoryResponseBean submitDonationFromUser(final InventoryRequestBean donationRequest) {
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		donationRequest.setDonationStatusId(
				domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_STATUS_WAITING_FOR_APPROVAL).getId());
		// final Long typeId = donationRequest.getItemCategoryId();
		final InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setDonatedItemCount(donationRequest.getItemCount());
		inventoryBean.setDonationStatusId(donationRequest.getDonationStatusId());
		inventoryBean.setInventoryItemName(donationRequest.getInventoryItemName());
		inventoryBean.setItemCategoryId(donationRequest.getItemCategoryId());
		inventoryBean.setItemDescription(donationRequest.getItemDescription());
		inventoryBean.setUserId(donationRequest.getUserId());
		inventoryBean.setItemRequestedByUser(null);
		inventoryBean.setItemWareHouseAddress(donationRequest.getItemWareHouseAddress());
		inventoryBean.setSubmissionDate(new Date(System.currentTimeMillis()));
		final String userRequestToken = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
		inventoryBean.setUserRequestToken(userRequestToken);
		inventoryManagementDao.save(inventoryBean);
		// if donation is for Book, then update the Book table also.
		/*
		 * if (typeId.longValue() ==
		 * domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_CATEGORY_BOOK).
		 * getId()) { return
		 * booksManagementService.submitDonationFromUser(donationRequest); }
		 */
		return CommonUtil.prepareInventoryResponseBean(inventoryBean, domainUtilInstance, 0L);
	}

	public InventoryBean getInventoryItem(final Long inventoryId) {
		return inventoryManagementDao.getInventoryBeanById(inventoryId);
	}

	public List<InventoryResponseBean> getAllInventoryItems(final String userRole) {
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		final List<InventoryBean> inventoryList = inventoryManagementDao.findAll();
		final List<InventoryResponseBean> inventoryResponseList = new ArrayList<InventoryResponseBean>();
		for (InventoryBean invBean : inventoryList) {
			final List<InventoryItemUploads> invItemuploaded = fileUploadDao
					.getInventoryItemUploadsByInventoryItemId(invBean.getId());
			if (!CommonUtil.isNullOrEmpty(invItemuploaded) && (invItemuploaded.size() > 0) && !CommonUtil.isNullOrEmpty(invItemuploaded)) {
				invBean.setItemUploadedFilePath(readFromFileInBase64(invItemuploaded.get(0).getInventoryItemFilePath()));
			} else {
				invBean.setItemUploadedFilePath("");
			}
			inventoryResponseList.add(CommonUtil.prepareInventoryResponseBean(invBean, domainUtilInstance, 0L));
		}
		return inventoryResponseList;
	}

	public List<InventoryResponseBean> getRequestedInventoryItems(final Long userId) {
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		final List<InventoryResponseBean> inventoryResponseList = new ArrayList<InventoryResponseBean>();

		if (!CommonUtil.isNullOrEmpty(userId) && userId.longValue() == 0) {
			final List<ItemRequestBean> itemRequestBeanList = itemRequestDao.findAll();
			for (ItemRequestBean itemReqBean : itemRequestBeanList) {
				final InventoryBean invBean = inventoryManagementDao
						.getInventoryBeanByUserRequestToken(itemReqBean.getUserToken());
				final List<InventoryItemUploads> invItemuploaded = fileUploadDao
						.getInventoryItemUploadsByInventoryItemId(invBean.getId());
				if (!CommonUtil.isNullOrEmpty(invItemuploaded) && (invItemuploaded.size() > 0) && !CommonUtil.isNullOrEmpty(invItemuploaded)) {
					invBean.setItemUploadedFilePath(readFromFileInBase64(invItemuploaded.get(0).getInventoryItemFilePath()));
				} else {
					invBean.setItemUploadedFilePath("");
				}
				invBean.setDonationStatusId(itemReqBean.getItemStatus());
				invBean.setItemRequestedByUser(itemReqBean.getRequestorId());
				inventoryResponseList.add(CommonUtil.prepareInventoryResponseBean(invBean, domainUtilInstance,
						itemReqBean.getItemCount()));

			}

		} else if (!CommonUtil.isNullOrEmpty(userId) && userId.longValue() != 0) {
			final List<ItemRequestBean> itemRequestBeanList = itemRequestDao.getItemRequestBeanByRequestorId(userId);
			for (ItemRequestBean itemReqBean : itemRequestBeanList) {
				final InventoryBean invBean = inventoryManagementDao
						.getInventoryBeanByUserRequestToken(itemReqBean.getUserToken());
				final List<InventoryItemUploads> invItemuploaded = fileUploadDao
						.getInventoryItemUploadsByInventoryItemId(invBean.getId());
				if (!CommonUtil.isNullOrEmpty(invItemuploaded) && (invItemuploaded.size() > 0) && !CommonUtil.isNullOrEmpty(invItemuploaded)) {
					invBean.setItemUploadedFilePath(readFromFileInBase64(invItemuploaded.get(0).getInventoryItemFilePath()));
				} else {
					invBean.setItemUploadedFilePath("");
				}
				invBean.setDonationStatusId(itemReqBean.getItemStatus());
				invBean.setItemRequestedByUser(itemReqBean.getRequestorId());
				inventoryResponseList.add(CommonUtil.prepareInventoryResponseBean(invBean, domainUtilInstance, 0L));

			}
		}

		return inventoryResponseList;
	}

	public InventoryBean approveRejectInventoryItem(final String status, final String userToken,
			final Long requestorUserId, final Long requestedCountOfItem) {
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		final InventoryBean inventoryItemToUpdate = inventoryManagementDao
				.getInventoryBeanByUserRequestToken(userToken);
		if (!CommonUtil.isNullOrEmpty(inventoryItemToUpdate)) {
			if (status.equals(Constants.APPROVE_INVENTORY_ITEM)) {
				inventoryItemToUpdate.setDonationStatusId(
						domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_STATUS_IN_WAITING).getId());
			} else if (status.equals(Constants.REJECT_INVENTORY_ITEM)) {
				inventoryItemToUpdate.setDonationStatusId(
						domainUtilInstance.getDomainByDomainTypeCode(Constants.STATUS_REJECTED).getId());
			} else if (status.equals(Constants.COLLECTED_INVENTORY_ITEM)) {
				inventoryItemToUpdate.setDonationStatusId(
						domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_STATUS_COLLECTED).getId());
			} else if (status.equals(Constants.REQUEST_INVENTORY_ITEM) && !CommonUtil.isNullOrEmpty(requestorUserId)) {
				inventoryItemToUpdate.setDonationStatusId(
						domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_STATUS_COLLECTED).getId());
				inventoryItemToUpdate.setItemRequestedByUser(requestorUserId);
				final ItemRequestBean itemRequestObj = new ItemRequestBean(requestorUserId, userToken,
						domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_STATUS_VOLUNTEER_REQUESTED).getId(),
						new Date(System.currentTimeMillis()), null, requestedCountOfItem);
				itemRequestDao.save(itemRequestObj);
			} else if (status.equals(Constants.APPROVE_REQUESTED_INVENTORY_ITEM)) {
				final ItemRequestBean itemRequestObj = itemRequestDao
						.getItemRequestBeanByRequestorIdAndUserToken(requestorUserId, userToken);
				remainingInventoryCountCalculation(inventoryItemToUpdate, itemRequestObj.getItemCount());
				itemRequestObj.setEffectiveEndDate(new Date(System.currentTimeMillis()));
				itemRequestObj.setItemStatus(domainUtilInstance
						.getDomainByDomainTypeCode(Constants.ITEM_STATUS_ACQUIRED_BY_VOLUNTEER).getId());
				itemRequestDao.save(itemRequestObj);
			}
			return inventoryManagementDao.save(inventoryItemToUpdate);
		}
		return null;
	}

	public void deleteInventoryItem(final Long inventoryId) {
		final InventoryBean inventoryItemToUpdate = inventoryManagementDao.getOne(inventoryId);
		inventoryManagementDao.delete(inventoryItemToUpdate);
	}

	public List<InventoryResponseBean> getInventoryItemByUserId(Long userId) {
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		final List<InventoryResponseBean> responseBeanListForUser = new ArrayList<InventoryResponseBean>();
		final List<InventoryBean> inventoryListForUser = inventoryManagementDao.getInventoryBeanByUserId(userId);
		for (InventoryBean inventoryBean : inventoryListForUser) {
			final InventoryResponseBean response = new InventoryResponseBean();
			response.setDonatedItemCount(inventoryBean.getDonatedItemCount());
			response.setDonationStatus(
					domainUtilInstance.getDomainByDomainId(inventoryBean.getDonationStatusId()).getTypeCode());
			response.setInventoryId(inventoryBean.getId());
			response.setInventoryItemName(inventoryBean.getInventoryItemName());
			response.setItemDescription(inventoryBean.getItemDescription());
			response.setItemWareHouseAddress(inventoryBean.getItemWareHouseAddress());
			final List<InventoryItemUploads> invItemuploaded = fileUploadDao
					.getInventoryItemUploadsByInventoryItemId(inventoryBean.getId());
			if (!CommonUtil.isNullOrEmpty(invItemuploaded) && (invItemuploaded.size() > 0) && !CommonUtil.isNullOrEmpty(invItemuploaded)) {
				response.setItemUploadedFilePath(readFromFileInBase64(invItemuploaded.get(0).getInventoryItemFilePath()));
			} else {
				response.setItemUploadedFilePath("");
			}
			response.setUserRequestToken(inventoryBean.getUserRequestToken());
			responseBeanListForUser.add(response);
		}
		return responseBeanListForUser;
	}

	public InventoryResponseBean deliverItemsToRecipient(final InventoryRequestBean invRequestBean) {
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		final InventoryBean existingInvBean = inventoryManagementDao
				.getInventoryBeanByUserRequestToken(invRequestBean.getUserRequestToken());
		final InventoryBean newInvRecord = new InventoryBean();
		newInvRecord.setDeliveredToAddress(invRequestBean.getRecipientAddress());
		newInvRecord.setDeliveryDate(new Date(System.currentTimeMillis()));
		newInvRecord.setDonatedItemCount(invRequestBean.getItemCount());
		newInvRecord.setDonationStatusId(
				domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_STATUS_DONATED).getId());
		newInvRecord.setInventoryItemName(existingInvBean.getInventoryItemName());
		newInvRecord.setItemAttributesJson(existingInvBean.getItemAttributesJson());
		newInvRecord.setItemCategoryId(existingInvBean.getItemCategoryId());
		newInvRecord.setItemDescription(existingInvBean.getItemDescription());
		newInvRecord.setItemRequestedByUser(invRequestBean.getItemRequestorId());
		newInvRecord.setItemUploadedFilePath("");
		newInvRecord.setItemWareHouseAddress(existingInvBean.getItemWareHouseAddress());
		newInvRecord.setSubmissionDate(existingInvBean.getSubmissionDate());
		newInvRecord.setUserId(existingInvBean.getUserId());
		newInvRecord.setUserRequestToken(invRequestBean.getUserRequestToken());
		//inventoryManagementDao.save(newInvRecord);

		final ItemRequestBean itemRequestBean = itemRequestDao.getItemRequestBeanByRequestorIdAndUserToken(
				invRequestBean.getItemRequestorId(), invRequestBean.getUserRequestToken());
		itemRequestBean.setEffectiveEndDate(new Date(System.currentTimeMillis()));
		itemRequestBean
				.setItemStatus(domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_STATUS_DONATED).getId());
		itemRequestDao.save(itemRequestBean);
		return CommonUtil.prepareInventoryResponseBean(newInvRecord, domainUtilInstance, invRequestBean.getItemCount());
	}

	private InventoryBean remainingInventoryCountCalculation(final InventoryBean invBean,
			final Long requestedItemCount) {
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		final Long currentItemCount = invBean.getDonatedItemCount();
		if (currentItemCount > requestedItemCount) {
			invBean.setDonatedItemCount(currentItemCount - requestedItemCount);
		} else if (currentItemCount == requestedItemCount) {
			invBean.setDonatedItemCount(currentItemCount - requestedItemCount);
			invBean.setDonationStatusId(
					domainUtilInstance.getDomainByDomainTypeCode(Constants.ITEM_STATUS_ACQUIRED_BY_VOLUNTEER).getId());
		}
		return invBean;
	}

	private String readFromFileInBase64(final String filePath) {
		final File file = new File(filePath);
		if (file.exists()) {
			byte[] encoded;
			try {
				encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
				return new String(encoded, StandardCharsets.US_ASCII);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
