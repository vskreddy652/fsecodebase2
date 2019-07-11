package com.hackfse.agiveawayapp.inventory_management.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackfse.agiveawayapp.inventory_management.models.InventoryBean;

@Repository
@Transactional
public interface InventoryManagementDao extends JpaRepository<InventoryBean, Long> {
	public List<InventoryBean> getInventoryBeanByUserId(final Long userId);
	public InventoryBean getInventoryBeanByUserRequestToken(final String userRequestToken);
	public List<InventoryBean> getInventoryBeanByDonationStatusId(final Long donationStatusId);
	public List<InventoryBean> getInventoryBeanByItemRequestedByUser(final Long userId);
	public InventoryBean getInventoryBeanById(final Long id);
}
