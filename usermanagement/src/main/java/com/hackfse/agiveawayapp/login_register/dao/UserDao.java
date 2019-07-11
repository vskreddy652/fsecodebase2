package com.hackfse.agiveawayapp.login_register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackfse.agiveawayapp.login_register.models.UsersBean;

@Repository
public interface UserDao extends JpaRepository<UsersBean, Long> {
	public UsersBean findByUserName(final String userName);
}
