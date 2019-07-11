package com.hackfse.agiveawayapp.inventory_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackfse.agiveawayapp.inventory_management.models.ItemRecipientBean;

public interface ItemRecipientDao extends JpaRepository<ItemRecipientBean, Long> {

}