package com.hackfse.agiveawayapp.login_register.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackfse.agiveawayapp.login_register.models.WebServiceUserCredential;

@Repository
@Transactional
public interface WebServiceUserDao extends JpaRepository<WebServiceUserCredential, Long> {
	public WebServiceUserCredential findByUserName(final String userName);
}
