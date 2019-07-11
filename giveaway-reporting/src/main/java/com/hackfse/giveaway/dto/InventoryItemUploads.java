package com.hackfse.giveaway.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "inventoryItemUploads")
@Table(name = "INVENTORY_ITEM_UPLOADS")
public class InventoryItemUploads {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "USER_ID")
	private Long userId;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INVENTORY_ITEM_ID")
	private Long inventoryItemId;
	@Column(name = "ITEM_FILE_PATH")
	private String inventoryItemFilePath;
	@Column(name = "ITEM_UPLOAD_DATE")
	private Date uploadDate;
	@Column(name = "USER_REQUEST_TOKEN")
	private String userRequestToken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUserRequestToken() {
		return userRequestToken;
	}

	public void setUserRequestToken(String userRequestToken) {
		this.userRequestToken = userRequestToken;
	}

	public InventoryItemUploads(Long id, Long userId, Long inventoryItemId, String inventoryItemFilePath,
			Date uploadDate, String userRequestToken) {
		this.id = id;
		this.userId = userId;
		this.inventoryItemId = inventoryItemId;
		this.inventoryItemFilePath = inventoryItemFilePath;
		this.uploadDate = uploadDate;
		this.userRequestToken = userRequestToken;
	}

	public InventoryItemUploads() {

	}

}
