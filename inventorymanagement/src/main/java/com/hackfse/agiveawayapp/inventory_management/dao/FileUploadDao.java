package com.hackfse.agiveawayapp.inventory_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hackfse.agiveawayapp.inventory_management.models.InventoryItemUploads;

public interface FileUploadDao extends JpaRepository<InventoryItemUploads, Long> {
	public InventoryItemUploads getInventoryItemUploadsById(final Long id);
	public List<InventoryItemUploads> getInventoryItemUploadsByInventoryItemId(final Long inventoryItemId);

	@Query(value = "SELECT seq_name.nextval FROM dual", nativeQuery = true)
	public Long getNextSeriesId();
}
