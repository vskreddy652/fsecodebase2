package com.hackfse.giveaway.bean;

import java.sql.Date;

import org.springframework.stereotype.Controller;

@Controller
public class MailInboxBean {
	private Long id;
	private String recipentEmailId;
	private String senderEmailId;
	private String mailSubject;
	private String mailMessage;
	private Long readStatus;
	private String userName;
	private Date sendDate;
	
	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the recipentEmailId
	 */
	public String getRecipentEmailId() {
		return recipentEmailId;
	}
	/**
	 * @param recipentEmailId the recipentEmailId to set
	 */
	public void setRecipentEmailId(String recipentEmailId) {
		this.recipentEmailId = recipentEmailId;
	}
	/**
	 * @return the senderEmailId
	 */
	public String getSenderEmailId() {
		return senderEmailId;
	}
	/**
	 * @param senderEmailId the senderEmailId to set
	 */
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	/**
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return mailSubject;
	}
	/**
	 * @param mailSubject the mailSubject to set
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	/**
	 * @return the mailMessage
	 */
	public String getMailMessage() {
		return mailMessage;
	}
	/**
	 * @param mailMessage the mailMessage to set
	 */
	public void setMailMessage(String mailMessage) {
		this.mailMessage = mailMessage;
	}
	/**
	 * @return the readStatus
	 */
	public Long getReadStatus() {
		return readStatus;
	}
	/**
	 * @param readStatus the readStatus to set
	 */
	public void setReadStatus(Long readStatus) {
		this.readStatus = readStatus;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public MailInboxBean() {
		
	}
	public MailInboxBean(String recipentEmailId, String senderEmailId, String mailSubject, String mailMessage,
			Long readStatus, String userName, Date sendDate) {
		this.recipentEmailId = recipentEmailId;
		this.senderEmailId = senderEmailId;
		this.mailSubject = mailSubject;
		this.mailMessage = mailMessage;
		this.readStatus = readStatus;
		this.userName = userName;
		this.sendDate = sendDate;
	}
	
	
	
}
