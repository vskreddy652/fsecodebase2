package com.hackfse.agiveawayapp.login_register.models;

import org.springframework.stereotype.Component;

@Component
public class UserLoginBean {
	private String userName;
	private String userPassword;
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
	
}
