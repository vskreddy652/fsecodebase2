package com.hackfse.agiveawayapp.login_register.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackfse.agiveawayapp.login_register.dao.UserDao;
import com.hackfse.agiveawayapp.login_register.models.UserResponseBean;
import com.hackfse.agiveawayapp.login_register.models.UsersBean;
import com.hackfse.agiveawayapp.login_register.util.CommonUtil;

@Service
public class FindUserService {

	@Autowired
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	public UserResponseBean findUserById(final Long userId) {
		final UsersBean existingUser = (userDao.findById(userId)).get();
		return CommonUtil.prepareUserResponseBean(existingUser);
	}

	public UserResponseBean findUserByUserName(final UsersBean userLoginObj) throws Exception {
		final UsersBean existingUser = userDao.findByUserName(userLoginObj.getUserName());
		if (!CommonUtil.isNullOrEmpty(existingUser)
				&& passwordEncoder.matches(userLoginObj.getUserPassword(), existingUser.getUserPassword())) {
			return CommonUtil.prepareUserResponseBean(existingUser);
		} else {
			return null;
			//throw new Exception("User not found");
		}
	}

	public UserResponseBean findUserByUserName(final String userName) {
		return CommonUtil.prepareUserResponseBean(userDao.findByUserName(userName));
	}
	
	public List<UserResponseBean> findAllUsers() {
		final List<UserResponseBean> usersResponseList = new ArrayList<UserResponseBean>();
		final List<UsersBean> usersList = userDao.findAll();
		for(UsersBean userBean : usersList) {
			usersResponseList.add(CommonUtil.prepareUserResponseBean(userBean));
		}
		return usersResponseList;
	}
	
	public void approveRejectUserApprovalStatus(final UsersBean userObj) {
		final UsersBean existingUser = (userDao.findById(userObj.getId())).get();
		existingUser.setUserApproved(userObj.getUserApproved());
		userDao.save(existingUser);
	}

}
