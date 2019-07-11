package com.hackfse.agiveawayapp.inventory_management.response.beans;

public class InventoryResponseBean {
	private String donationStatus;
	private String inventoryItemName;
	private Long itemCategoryId;
	private Long donatedItemCount;
	private String itemWareHouseAddress;
	private String itemDescription;
	private Long userId;
	private Long inventoryId;
	private String userRequestToken;
	private String itemUploadedFilePath;
	private String itemCategory;
	private Long itemRequestedByUser;
	private Long requestedItemCount;

	public Long getItemRequestedByUser() {
		return itemRequestedByUser;
	}

	public void setItemRequestedByUser(Long itemRequestedByUser) {
		this.itemRequestedByUser = itemRequestedByUser;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getDonationStatus() {
		return donationStatus;
	}

	public void setDonationStatus(String donationStatus) {
		this.donationStatus = donationStatus;
	}

	public String getInventoryItemName() {
		return inventoryItemName;
	}

	public void setInventoryItemName(String inventoryItemName) {
		this.inventoryItemName = inventoryItemName;
	}

	public Long getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(Long itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public Long getDonatedItemCount() {
		return donatedItemCount;
	}

	public void setDonatedItemCount(Long donatedItemCount) {
		this.donatedItemCount = donatedItemCount;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
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
	
	public Long getRequestedItemCount() {
		return requestedItemCount;
	}

	public void setRequestedItemCount(Long requestedItemCount) {
		this.requestedItemCount = requestedItemCount;
	}

	public InventoryResponseBean(String donationStatus, String inventoryItemName, Long itemCategoryId,
			Long donatedItemCount, String itemWareHouseAddress, String itemDescription, Long userId, Long inventoryId,
			String userRequestToken, String itemUploadedFilePath, String itemCategory, Long itemRequestedByUser, Long requestedItemCount) {
		this.donationStatus = donationStatus;
		this.inventoryItemName = inventoryItemName;
		this.itemCategoryId = itemCategoryId;
		this.donatedItemCount = donatedItemCount;
		this.itemWareHouseAddress = itemWareHouseAddress;
		this.itemDescription = itemDescription;
		this.userId = userId;
		this.inventoryId = inventoryId;
		this.userRequestToken = userRequestToken;
		this.itemUploadedFilePath = itemUploadedFilePath;
		this.itemCategory = itemCategory;
		this.itemRequestedByUser = itemRequestedByUser;
		this.requestedItemCount = requestedItemCount;
	}

	public InventoryResponseBean() {

	}
}
