package com.hackfse.agiveawayapp.login_register.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.agiveawayapp.login_register.models.UserResponseBean;
import com.hackfse.agiveawayapp.login_register.models.UsersBean;
import com.hackfse.agiveawayapp.login_register.services.FindUserService;
import com.hackfse.agiveawayapp.login_register.util.CommonUtil;

@RestController
public class LoginController {

	@Autowired
	FindUserService findUserService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<UserResponseBean> login(@RequestBody UsersBean userLoginObj) {
		UserResponseBean responseBean = null;
		try {
			responseBean = findUserService.findUserByUserName(userLoginObj);
			if(CommonUtil.isNullOrEmpty(responseBean)) {
				throw new Exception("Invalid Credentials");
			}
			responseBean.setErrorOccured(false);
			return new ResponseEntity<UserResponseBean>(responseBean, HttpStatus.OK);
		} catch (Exception ex) {
			responseBean = new UserResponseBean();
			responseBean.setErrorOccured(true);
			responseBean.setErrorMessage(ex.getMessage());
			return new ResponseEntity<UserResponseBean>(responseBean, HttpStatus.BAD_REQUEST);
		}

	}
}
