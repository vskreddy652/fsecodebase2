package com.hackfse.agiveawayapp.login_register.util;

import com.hackfse.agiveawayapp.login_register.models.UserResponseBean;
import com.hackfse.agiveawayapp.login_register.models.UsersBean;

public class CommonUtil {
	public static Boolean isNullOrEmpty(Object obj) {
		if (null == obj || obj.equals("")) {
			return true;
		}
		return false;
	}
	
	public static UserResponseBean prepareUserResponseBean(final UsersBean userBean) {
		if (isNullOrEmpty(userBean)) {
			return null;
		}
		final UserResponseBean userResponseBean = new UserResponseBean(userBean.getId(), userBean.getUserFirstName(),
				userBean.getUserLastName(), userBean.getUserName(), userBean.getUserEmail(), userBean.getUserRole(),
				userBean.getUserMobile(), userBean.getUserAddress(), userBean.getUserCity(),
				userBean.getUserCityPincode(), userBean.getUserApproved());
		return userResponseBean;
	}
}
