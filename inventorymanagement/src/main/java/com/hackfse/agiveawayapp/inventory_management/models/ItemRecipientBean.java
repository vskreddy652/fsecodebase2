package com.hackfse.agiveawayapp.inventory_management.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "itemRecipientBean")
@Table(name = "ITEM_RECIPIENT_DETAILS")
public class ItemRecipientBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "USER_TOKEN")
	private String userToken;
	@Column(name = "VOLUNTEER_USER_ID")
	private Long volunteerUserId;
	@Column(name = "RECIPIENT_ADDRESS")
	private String recipientAddress;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public Long getVolunteerUserId() {
		return volunteerUserId;
	}
	public void setVolunteerUserId(Long volunteerUserId) {
		this.volunteerUserId = volunteerUserId;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public ItemRecipientBean(String userToken, Long volunteerUserId, String recipientAddress) {
		this.userToken = userToken;
		this.volunteerUserId = volunteerUserId;
		this.recipientAddress = recipientAddress;
	}

	public ItemRecipientBean() {
		
	}
}
