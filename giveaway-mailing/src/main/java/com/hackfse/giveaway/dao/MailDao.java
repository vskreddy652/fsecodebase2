package com.hackfse.giveaway.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackfse.giveaway.dto.Email;

@Repository
@Transactional
public interface MailDao extends JpaRepository<Email, Long> {
	public List<Email> findByReciverEmail(final String reciverEmail);	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Email e SET e.readStatus = :readStatus WHERE e.id = :id")
	public int updateReadStatusById(@Param("readStatus") Long readStatus, @Param("id") Long id);
	
}
