package com.hackfse.giveaway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackfse.giveaway.dto.DomainBean;

@Repository
public interface DomainDao extends JpaRepository<DomainBean, Long> {

}
