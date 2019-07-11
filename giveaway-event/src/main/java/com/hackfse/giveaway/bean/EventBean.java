package com.hackfse.giveaway.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;


public class EventBean {
	
	private Long id;
	private String eveName;
	private String eveDescription;
	private Date startDate;
	private Date endDate;
	private String address;
	private String city;
	private String contactno;
	private String contactName;
	private String pic_url_1;
	private String pic_url_2;
	private String pic_url_3;
	private String pic_url_4;
	private Long status;
	private Date effStartDate;
	private Date effEndDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getPic_url_1() {
		return pic_url_1;
	}
	public void setPic_url_1(String pic_url_1) {
		this.pic_url_1 = pic_url_1;
	}
	public String getPic_url_2() {
		return pic_url_2;
	}
	public void setPic_url_2(String pic_url_2) {
		this.pic_url_2 = pic_url_2;
	}
	public String getPic_url_3() {
		return pic_url_3;
	}
	public void setPic_url_3(String pic_url_3) {
		this.pic_url_3 = pic_url_3;
	}
	public String getPic_url_4() {
		return pic_url_4;
	}
	public void setPic_url_4(String pic_url_4) {
		this.pic_url_4 = pic_url_4;
	}
	
	
	/**
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * @return the effStartDate
	 */
	public Date getEffStartDate() {
		return effStartDate;
	}
	/**
	 * @param effStartDate the effStartDate to set
	 */
	public void setEffStartDate(Date effStartDate) {
		this.effStartDate = effStartDate;
	}
	/**
	 * @return the effEndDate
	 */
	public Date getEffEndDate() {
		return effEndDate;
	}
	/**
	 * @param effEndDate the effEndDate to set
	 */
	public void setEffEndDate(Date effEndDate) {
		this.effEndDate = effEndDate;
	}
	public String getEveName() {
		return eveName;
	}
	public void setEveName(String eveName) {
		this.eveName = eveName;
	}
	public String getEveDescription() {
		return eveDescription;
	}
	public void setEveDescription(String eveDescription) {
		this.eveDescription = eveDescription;
	}
	public EventBean(Long id, String eveName, String eveDescription, Date startDate, Date endDate, String address,
			String city, String contactno, String contactName, String pic_url_1, String pic_url_2, String pic_url_3,
			String pic_url_4, Long status, Date effStartDate, Date effEndDate) {
		
		this.id = id;
		this.eveName = eveName;
		this.eveDescription = eveDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.city = city;
		this.contactno = contactno;
		this.contactName = contactName;
		this.pic_url_1 = pic_url_1;
		this.pic_url_2 = pic_url_2;
		this.pic_url_3 = pic_url_3;
		this.pic_url_4 = pic_url_4;
		this.status = status;
		this.effStartDate = effStartDate;
		this.effEndDate = effEndDate;
	}
	public EventBean() {
		
	}
	
	
	
	
}
