package com.hackfse.giveaway.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "email")
public class Email {

	@Id
	@GeneratedValue
	private Long emailid;
		
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="ID")    
	private UsersBean usersBean;
	
	private String subject;
	private String message;
	private String attFilePath;	
	private Long deliveryStatus;
	private Long readStatus;
	private String senderemail;
	private String reciverEmail;
	private Date sendDate;
	
	
	public Long getEmailid() {
		return emailid;
	}
	public void setEmailid(Long emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	
	public UsersBean getUsersBean() {
		return usersBean;
	}
	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the deliveryStatus
	 */
	public Long getDeliveryStatus() {
		return deliveryStatus;
	}
	/**
	 * @param deliveryStatus the deliveryStatus to set
	 */
	public void setDeliveryStatus(Long deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
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
	/**
	 * @return the senderemail
	 */
	public String getSenderemail() {
		return senderemail;
	}
	/**
	 * @param senderemail the senderemail to set
	 */
	public void setSenderemail(String senderemail) {
		this.senderemail = senderemail;
	}
	/**
	 * @return the reciverEmail
	 */
	public String getReciverEmail() {
		return reciverEmail;
	}
	/**
	 * @param reciverEmail the reciverEmail to set
	 */
	public void setReciverEmail(String reciverEmail) {
		this.reciverEmail = reciverEmail;
	}
	
	public String getAttFilePath() {
		return attFilePath;
	}
	public void setAttFilePath(String attFilePath) {
		this.attFilePath = attFilePath;
	}
	
	
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Email() {
	}
	
	
	public Email(UsersBean usersBean, String subject, String message, String attFilePath, Long deliveryStatus,
			Long readStatus, String senderemail, String reciverEmail, Date sendDate) {
		this.usersBean = usersBean;
		this.subject = subject;
		this.message = message;
		this.attFilePath = attFilePath;
		this.deliveryStatus = deliveryStatus;
		this.readStatus = readStatus;
		this.senderemail = senderemail;
		this.reciverEmail = reciverEmail;
		this.sendDate = sendDate;
	}
	
	
}
