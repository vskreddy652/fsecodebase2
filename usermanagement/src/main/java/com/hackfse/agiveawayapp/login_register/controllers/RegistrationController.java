package com.hackfse.agiveawayapp.login_register.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.agiveawayapp.login_register.models.UserResponseBean;
import com.hackfse.agiveawayapp.login_register.models.UsersBean;
import com.hackfse.agiveawayapp.login_register.services.FindUserService;
import com.hackfse.agiveawayapp.login_register.services.RegisterService;

@RestController
@RequestMapping(value = "/register")
public class RegistrationController {

	@Autowired
	RegisterService registerService;

	@Autowired
	FindUserService findUserService;

	@RequestMapping(method = RequestMethod.POST, value = "/validate/username")
	public Boolean validateUserName(@RequestBody UsersBean userRegistrationRequest) {
		final String userName = userRegistrationRequest.getUserName();
		return registerService.validateIfUserNameExists(userName);
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserResponseBean registerUser(@RequestBody UsersBean userRegistrationRequest) {
		return registerService.registerUser(userRegistrationRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public UserResponseBean updateUser(@RequestBody UsersBean userUpdateRequestObj) {
		return registerService.updateUser(userUpdateRequestObj);
	}
}
