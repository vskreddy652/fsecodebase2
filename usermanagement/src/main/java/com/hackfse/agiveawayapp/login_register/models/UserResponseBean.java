package com.hackfse.agiveawayapp.login_register.models;

import org.springframework.stereotype.Component;

@Component
public class UserResponseBean {
	private Long userId;
	private String userFirstName;
	private String userLastName;
	private String userName;
	private String userEmail;
	private String userRole;
	private String userMobile;
	private String userAddress;
	private String userCity;
	private String userCityPincode;
	private Boolean userAgreementAccepted;
	private String userRequestMessage;
	private Boolean userApproved;
	private Boolean errorOccured;
	private String errorMessage;

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

	public String getUserRequestMessage() {
		return userRequestMessage;
	}

	public void setUserRequestMessage(final String userRequestMessage) {
		this.userRequestMessage = userRequestMessage;
	}

	public Boolean getUserApproved() {
		return userApproved;
	}

	public void setUserApproved(final Boolean userApproved) {
		this.userApproved = userApproved;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Boolean getErrorOccured() {
		return errorOccured;
	}

	public void setErrorOccured(Boolean errorOccured) {
		this.errorOccured = errorOccured;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public UserResponseBean(Long userId, String userFirstName, String userLastName, String userName, String userEmail,
			String userRole, String userMobile, String userAddress, String userCity, String userCityPincode,
			Boolean userApproved) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.userMobile = userMobile;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userCityPincode = userCityPincode;
		this.userApproved = userApproved;
	}
	
	public UserResponseBean() {
		// no-args constructor.
	}
	
}
