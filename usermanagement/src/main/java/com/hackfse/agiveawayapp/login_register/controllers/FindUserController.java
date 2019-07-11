package com.hackfse.agiveawayapp.login_register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.agiveawayapp.login_register.models.UserResponseBean;
import com.hackfse.agiveawayapp.login_register.models.UsersBean;
import com.hackfse.agiveawayapp.login_register.services.FindUserService;

@RestController
@RequestMapping("/users")
public class FindUserController {
	
	@Autowired
	FindUserService findUserService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserResponseBean findUserById(@PathVariable("id") Long userId) {
		return findUserService.findUserById(userId);
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public UserResponseBean findUserByUserName(@PathVariable("username") String userName) {
		return findUserService.findUserByUserName(userName);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<UserResponseBean> findAllUsers() {
		return findUserService.findAllUsers();
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public void approveRejectUser(@RequestBody UsersBean userObj) {
		findUserService.approveRejectUserApprovalStatus(userObj);
	}
}
