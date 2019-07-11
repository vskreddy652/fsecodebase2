package com.hackfse.giveaway.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "usersBean")
@Table(name = "USERS")
public class UsersBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "USER_FIRST_NAME")
	private String userFirstName;
	@Column(name = "USER_LAST_NAME")
	private String userLastName;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	@Column(name = "USER_EMAIL")
	private String userEmail;
	@Column(name = "USER_ROLE")
	private String userRole;
	@Column(name = "USER_MOBILE")
	private String userMobile;
	@Column(name = "USER_ADDRESS")
	private String userAddress;
	@Column(name = "USER_CITY")
	private String userCity;
	@Column(name = "USER_CITY_PINCODE")
	private String userCityPincode;
	@Column(name = "USER_AGGMT_ACCEPTED")
	private Boolean userAgreementAccepted;
	@Column(name = "USER_REQUEST_MESSAGE")
	private String userRequestMessage;
	@Column(name = "USER_APPROVED_STATUS")
	private Boolean userApproved;	
	
	@OneToMany(mappedBy = "usersBean", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Event> event = new HashSet<>();

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(final String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(final String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(final String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(final String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(final String userRole) {
		this.userRole = userRole;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(final String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(final String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(final String userCity) {
		this.userCity = userCity;
	}

	public String getUserCityPincode() {
		return userCityPincode;
	}

	public void setUserCityPincode(final String userCityPincode) {
		this.userCityPincode = userCityPincode;
	}

	public Boolean getUserAgreementAccepted() {
		return userAgreementAccepted;
	}

	public void setUserAgreementAccepted(final Boolean userAgreementAccepted) {
		this.userAgreementAccepted = userAgreementAccepted;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserRequestMessage() {
		return userRequestMessage;
	}

	public void setUserRequestMessage(String userRequestMessage) {
		this.userRequestMessage = userRequestMessage;
	}

	public Boolean getUserApproved() {
		return userApproved;
	}

	public void setUserApproved(Boolean userApproved) {
		this.userApproved = userApproved;
	}
	
	
	public Set<Event> getEvent() {
		return event;
	}

	public void setEvent(Set<Event> event) {
		this.event = event;
	}

	public UsersBean() {
		// no-args constructor
	}

	public UsersBean(String userFirstName, String userLastName, String userName, String userPassword, String userEmail,
			String userRole, String userMobile, String userAddress, String userCity, String userCityPincode,
			Boolean userAgreementAccepted, String userRequestMessage, Boolean userApproved, Set<Event> event) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.userMobile = userMobile;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userCityPincode = userCityPincode;
		this.userAgreementAccepted = userAgreementAccepted;
		this.userRequestMessage = userRequestMessage;
		this.userApproved = userApproved;
		this.event = event;
	}
	
	
	
	

}
