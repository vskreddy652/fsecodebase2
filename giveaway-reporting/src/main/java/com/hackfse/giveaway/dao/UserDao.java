package com.hackfse.giveaway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackfse.giveaway.dto.UsersBean;

@Repository
public interface UserDao extends JpaRepository<UsersBean, Long> {
	public UsersBean findByUserName(final String userName);
}
