package com.hackfse.agiveawayapp.inventory_management.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "inventoryBean")
@Table(name = "INVENTORY")
public class InventoryBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "ITEM_CAT_ID")
	private Long itemCategoryId;
	@Column(name = "USER_ID")
	private Long userId;
	@Column(name = "ITEM_STATUS_ID")
	private Long donationStatusId;
	@Column(name = "ITEM_COUNT")
	private Long donatedItemCount;
	@Column(name = "ITEM_NAME")
	private String inventoryItemName;
	@Column(name = "ITEM_WAREHOUSE_ADD")
	private String itemWareHouseAddress;
	@Column(name = "ITEM_DESCRIPTION")
	private String itemDescription;
	@Column(name = "ITEM_REQUESTED_BY")
	private Long itemRequestedByUser;
	@Column(name = "ITEM_UPLOAD_DATE")
	private Date submissionDate;
	@Column(name = "ITEM_DELIVERY_DATE")
	private Date deliveryDate;
	@Column(name = "ITEM_DELIVERED_TO")
	private String deliveredToAddress;
	@Column(name = "ITEM_ATTRIBUTES_JSON")
	private String itemAttributesJson;
	@Column(name = "USER_REQUEST_TOKEN")
	private String userRequestToken;
	@Transient
	private String itemUploadedFilePath;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getItemAttributesJson() {
		return itemAttributesJson;
	}

	public void setItemAttributesJson(String itemAttributesJson) {
		this.itemAttributesJson = itemAttributesJson;
	}

	public Long getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(Long itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDonationStatusId() {
		return donationStatusId;
	}

	public void setDonationStatusId(Long donationStatusId) {
		this.donationStatusId = donationStatusId;
	}

	public Long getDonatedItemCount() {
		return donatedItemCount;
	}

	public void setDonatedItemCount(Long donatedItemCount) {
		this.donatedItemCount = donatedItemCount;
	}

	public String getInventoryItemName() {
		return inventoryItemName;
	}

	public void setInventoryItemName(String inventoryItemName) {
		this.inventoryItemName = inventoryItemName;
	}

	public String getItemWareHouseAddress() {
		return itemWareHouseAddress;
	}

	public void setItemWareHouseAddress(String itemWareHouseAddress) {
		this.itemWareHouseAddress = itemWareHouseAddress;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public Long getItemRequestedByUser() {
		return itemRequestedByUser;
	}

	public void setItemRequestedByUser(Long itemRequestedByUser) {
		this.itemRequestedByUser = itemRequestedByUser;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveredToAddress() {
		return deliveredToAddress;
	}

	public void setDeliveredToAddress(String deliveredToAddress) {
		this.deliveredToAddress = deliveredToAddress;
	}
	
	public String getUserRequestToken() {
		return userRequestToken;
	}

	public void setUserRequestToken(String userRequestToken) {
		this.userRequestToken = userRequestToken;
	}
	
	public String getItemUploadedFilePath() {
		return itemUploadedFilePath;
	}

	public void setItemUploadedFilePath(String itemUploadedFilePath) {
		this.itemUploadedFilePath = itemUploadedFilePath;
	}

	public InventoryBean(Long id, Long itemCategoryId, Long userId, Long donationStatusId, Long donatedItemCount,
			String inventoryItemName, String itemWareHouseAddress, String itemDescription,
			Long itemRequestedByUser, Date submissionDate, Date deliveryDate, String deliveredToAddress,
			String itemAttributesJson, String userRequestToken) {
		this.id = id;
		this.itemCategoryId = itemCategoryId;
		this.userId = userId;
		this.donationStatusId = donationStatusId;
		this.donatedItemCount = donatedItemCount;
		this.inventoryItemName = inventoryItemName;
		this.itemWareHouseAddress = itemWareHouseAddress;
		this.itemDescription = itemDescription;
		this.itemRequestedByUser = itemRequestedByUser;
		this.submissionDate = submissionDate;
		this.deliveryDate = deliveryDate;
		this.deliveredToAddress = deliveredToAddress;
		this.itemAttributesJson = itemAttributesJson;
		this.userRequestToken = userRequestToken;
	}

	public InventoryBean() {

	}
}
