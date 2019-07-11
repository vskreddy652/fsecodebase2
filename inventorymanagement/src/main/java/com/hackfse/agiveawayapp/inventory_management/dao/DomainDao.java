package com.hackfse.agiveawayapp.inventory_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackfse.agiveawayapp.inventory_management.models.DomainBean;

@Repository
public interface DomainDao extends JpaRepository<DomainBean, Long> {

}
