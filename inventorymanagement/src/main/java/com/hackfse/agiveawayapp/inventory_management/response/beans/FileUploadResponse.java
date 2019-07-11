package com.hackfse.agiveawayapp.inventory_management.response.beans;

public class FileUploadResponse {
	private Long userId;
	private Long inventoryItemId;
	private String inventoryItemFilePath;
	private String userRequestToken;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public String getInventoryItemFilePath() {
		return inventoryItemFilePath;
	}

	public void setInventoryItemFilePath(String inventoryItemFilePath) {
		this.inventoryItemFilePath = inventoryItemFilePath;
	}

	public String getUserRequestToken() {
		return userRequestToken;
	}

	public void setUserRequestToken(String userRequestToken) {
		this.userRequestToken = userRequestToken;
	}

	public FileUploadResponse(Long userId, Long inventoryItemId, String inventoryItemFilePath,
			String userRequestToken) {
		super();
		this.userId = userId;
		this.inventoryItemId = inventoryItemId;
		this.inventoryItemFilePath = inventoryItemFilePath;
		this.userRequestToken = userRequestToken;
	}

	public FileUploadResponse() {

	}
}
