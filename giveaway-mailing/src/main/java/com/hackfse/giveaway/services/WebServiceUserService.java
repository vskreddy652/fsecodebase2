package com.hackfse.giveaway.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackfse.giveaway.dao.WebServiceUserDao;
import com.hackfse.giveaway.dto.WebServiceUserCredential;
import com.hackfse.giveaway.util.CommonUtil;
import com.hackfse.giveaway.util.Constants;

@Service
public class WebServiceUserService implements UserDetailsService {
	@Autowired
	WebServiceUserDao wsUserDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		final WebServiceUserCredential wsUserCredsFromDb = wsUserDao.findByUserName(userName);
		if (CommonUtil.isNullOrEmpty(wsUserCredsFromDb)) {
			throw new UsernameNotFoundException("WS userName/password not valid...");
		} else {
			final List<SimpleGrantedAuthority> authorities = Arrays
					.asList(new SimpleGrantedAuthority(Constants.WS_USER_AUTHORITY));
			return new User(wsUserCredsFromDb.getUserName(), wsUserCredsFromDb.getUserPassword(), authorities);
		}
	}
}
