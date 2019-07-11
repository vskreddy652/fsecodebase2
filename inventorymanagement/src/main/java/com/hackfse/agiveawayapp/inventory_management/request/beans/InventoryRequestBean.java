package com.hackfse.agiveawayapp.inventory_management.request.beans;

public class InventoryRequestBean {
	private Long itemCategoryId;
	private Long donationStatusId;
	private Long userId;
	private String inventoryItemName;
	private String itemWareHouseAddress;
	private String itemDescription;
	private Long itemCount;
	private String bookIsbnNumber;
	private String bookCategory;
	private String bookAuthor;
	private String bookName;
	private String dressSize;
	private String itemCategory;
	private String recipientAddress;
    private String userRequestToken;
    private Long itemRequestorId;

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getDressSize() {
		return dressSize;
	}

	public void setDressSize(String dressSize) {
		this.dressSize = dressSize;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookIsbnNumber() {
		return bookIsbnNumber;
	}

	public void setBookIsbnNumber(final String bookIsbnNumber) {
		this.bookIsbnNumber = bookIsbnNumber;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(final String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(final String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public InventoryRequestBean() {

	}

	public Long getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(final Long itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public String getInventoryItemName() {
		return inventoryItemName;
	}

	public void setInventoryItemName(final String inventoryItemName) {
		this.inventoryItemName = inventoryItemName;
	}

	public String getItemWareHouseAddress() {
		return itemWareHouseAddress;
	}

	public void setItemWareHouseAddress(final String itemWareHouseAddress) {
		this.itemWareHouseAddress = itemWareHouseAddress;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(final String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Long getItemCount() {
		return itemCount;
	}

	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}

	public Long getDonationStatusId() {
		return donationStatusId;
	}

	public void setDonationStatusId(Long donationStatusId) {
		this.donationStatusId = donationStatusId;
	}
	
	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getUserRequestToken() {
		return userRequestToken;
	}

	public void setUserRequestToken(String userRequestToken) {
		this.userRequestToken = userRequestToken;
	}

	public Long getItemRequestorId() {
		return itemRequestorId;
	}

	public void setItemRequestorId(Long itemRequestorId) {
		this.itemRequestorId = itemRequestorId;
	}

	public InventoryRequestBean(Long itemCategoryId, Long donationStatusId, Long userId, String inventoryItemName,
			String itemWareHouseAddress, String itemDescription, Long itemCount, String bookIsbnNumber,
			String bookCategory, String bookAuthor, String bookName, String dressSize, String itemCategory,
			String recipientAddress, String userRequestToken, Long itemRequestorId) {
		this.itemCategoryId = itemCategoryId;
		this.donationStatusId = donationStatusId;
		this.userId = userId;
		this.inventoryItemName = inventoryItemName;
		this.itemWareHouseAddress = itemWareHouseAddress;
		this.itemDescription = itemDescription;
		this.itemCount = itemCount;
		this.bookIsbnNumber = bookIsbnNumber;
		this.bookCategory = bookCategory;
		this.bookAuthor = bookAuthor;
		this.bookName = bookName;
		this.dressSize = dressSize;
		this.itemCategory = itemCategory;
		this.recipientAddress = recipientAddress;
		this.userRequestToken = userRequestToken;
		this.itemRequestorId = itemRequestorId;
	}

}