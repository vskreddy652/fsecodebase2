package com.hackfse.giveaway.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "itemRequestBean")
@Table(name = "ITEM_REQUEST_DETAILS")
public class ItemRequestBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "REQUESTOR_ID")
	private Long requestorId;
	@Column(name = "USER_TOKEN")
	private String userToken;
	@Column(name = "ITEM_STATUS")
	private Long itemStatus;
	@Column(name = "ITEM_COUNT")
	private Long itemCount;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFF_START_DATE")
	private Date effectiveStartDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFF_END_DATE")
	private Date effectiveEndDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRequestorId() {
		return requestorId;
	}
	public void setRequestorId(Long requestorId) {
		this.requestorId = requestorId;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public Long getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(Long itemStatus) {
		this.itemStatus = itemStatus;
	}
	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}
	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}
	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}
	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}
	public Long getItemCount() {
		return itemCount;
	}
	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}
	public ItemRequestBean(Long requestorId, String userToken, Long itemStatus, Date effectiveStartDate,
			Date effectiveEndDate, Long itemCount) {
		this.itemCount = itemCount;
		this.requestorId = requestorId;
		this.userToken = userToken;
		this.itemStatus = itemStatus;
		this.effectiveStartDate = effectiveStartDate;
		this.effectiveEndDate = effectiveEndDate;
	}
	public ItemRequestBean() {
		
	}
}
