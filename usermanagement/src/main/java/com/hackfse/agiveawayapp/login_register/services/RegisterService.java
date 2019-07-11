package com.hackfse.agiveawayapp.login_register.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackfse.agiveawayapp.login_register.dao.UserDao;
import com.hackfse.agiveawayapp.login_register.models.UserResponseBean;
import com.hackfse.agiveawayapp.login_register.models.UsersBean;
import com.hackfse.agiveawayapp.login_register.util.CommonUtil;

@Service
public class RegisterService {

	@Autowired
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ConsumeRestApplication consumeRestApplication;

	public Boolean validateIfUserNameExists(final String userName) {
		final UsersBean user = userDao.findByUserName(userName);
		if (CommonUtil.isNullOrEmpty(user)) {
			return true;
		}
		return false;
	}

	public UserResponseBean registerUser(final UsersBean userObj) {
		final UsersBean userToBeRegistered;
		if (userObj.getUserRole().equals("gwUser")) {
			userToBeRegistered = new UsersBean(userObj.getUserFirstName(), userObj.getUserLastName(),
					userObj.getUserName(), passwordEncoder.encode(userObj.getUserPassword()), userObj.getUserEmail(),
					userObj.getUserRole(), userObj.getUserMobile(), userObj.getUserAddress(), userObj.getUserCity(),
					userObj.getUserCityPincode(), userObj.getUserAgreementAccepted(), userObj.getUserRequestMessage(),
					true);
		} else {
			userToBeRegistered = new UsersBean(userObj.getUserFirstName(), userObj.getUserLastName(),
					userObj.getUserName(), passwordEncoder.encode(userObj.getUserPassword()), userObj.getUserEmail(),
					userObj.getUserRole(), userObj.getUserMobile(), userObj.getUserAddress(), userObj.getUserCity(),
					userObj.getUserCityPincode(), userObj.getUserAgreementAccepted(), userObj.getUserRequestMessage(),
					false);
		}
		UsersBean registeredUser = userDao.save(userToBeRegistered);
		sendEmailToUser(registeredUser);
		return CommonUtil.prepareUserResponseBean(registeredUser);
	}

	public UserResponseBean updateUser(final UsersBean userUpdateRequestObj) {
		final UsersBean existingUser = userDao.findByUserName(userUpdateRequestObj.getUserName());
		if (!CommonUtil.isNullOrEmpty(existingUser)) {
			existingUser.setUserAddress(userUpdateRequestObj.getUserAddress());
			// TODO do for rest of the fields as well.
			final UsersBean updatedUser = userDao.save(existingUser);
			if (!CommonUtil.isNullOrEmpty(updatedUser)) {
				return CommonUtil.prepareUserResponseBean(updatedUser);
			}
		}
		return null;
	}
	
	public void sendEmailToUser(final UsersBean registeredUser) {
		StringBuffer sbMessage = new StringBuffer();
		sbMessage.append("Hi " + registeredUser.getUserFirstName() + ", \n");
		sbMessage.append("\t Your registration to the Crecent Application is successful." + " \n");
		sbMessage.append("regards,\n");
		sbMessage.append("Crecent Team \n");
		consumeRestApplication.postForObjectOperation("Crecent Regestration Successful!", sbMessage.toString(),
				registeredUser.getUserEmail(), registeredUser.getUserName());
	}

}
