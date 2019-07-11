package com.hackfse.agiveawayapp.inventory_management.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackfse.agiveawayapp.inventory_management.models.WebServiceUserCredential;

@Repository
@Transactional
public interface WebServiceUserDao extends JpaRepository<WebServiceUserCredential, Long> {
	public WebServiceUserCredential findByUserName(final String userName);
}
