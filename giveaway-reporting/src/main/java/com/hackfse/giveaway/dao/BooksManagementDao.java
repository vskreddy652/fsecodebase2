package com.hackfse.giveaway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackfse.giveaway.dto.BooksBean;

public interface BooksManagementDao extends JpaRepository<BooksBean, Long> {
	
}
