package com.hackfse.giveaway.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hackfse.giveaway.dto.Event;

@Transactional
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {	
	public List<Event> findAllByOrderByStartDate();	
}
