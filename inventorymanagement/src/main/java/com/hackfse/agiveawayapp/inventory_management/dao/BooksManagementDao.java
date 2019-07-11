package com.hackfse.agiveawayapp.inventory_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackfse.agiveawayapp.inventory_management.models.BooksBean;

public interface BooksManagementDao extends JpaRepository<BooksBean, Long> {
	
}
