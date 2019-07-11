package com.hackfse.agiveawayapp.inventory_management.util;

import com.hackfse.agiveawayapp.inventory_management.models.InventoryBean;
import com.hackfse.agiveawayapp.inventory_management.response.beans.InventoryResponseBean;

public class CommonUtil {
	public static Boolean isNullOrEmpty(final Object obj) {
		return (null == obj) || (Constants.EMPTY_STRING.equals(obj));
	}

	public static InventoryResponseBean prepareInventoryResponseBean(final InventoryBean savedInventoryRequest,
			final DomainUtil domainUtilInstance, final Long requestedItemCount) {
		final InventoryResponseBean inventoryResponseBean = new InventoryResponseBean();
		inventoryResponseBean.setDonatedItemCount(savedInventoryRequest.getDonatedItemCount());
		if (!CommonUtil.isNullOrEmpty(savedInventoryRequest.getDonationStatusId())) {
			inventoryResponseBean.setDonationStatus(
					domainUtilInstance.getDomainByDomainId(savedInventoryRequest.getDonationStatusId()).getTypeCode());
		}
		if (!CommonUtil.isNullOrEmpty(savedInventoryRequest.getItemCategoryId())) {
			inventoryResponseBean.setItemCategory(
					domainUtilInstance.getDomainByDomainId(savedInventoryRequest.getItemCategoryId()).getTypeCode());
		}
		if(!CommonUtil.isNullOrEmpty(savedInventoryRequest.getItemRequestedByUser())) {
			inventoryResponseBean.setItemRequestedByUser(savedInventoryRequest.getItemRequestedByUser());
		}
		// inventoryResponseBean.setDonationStatusId(savedInventoryRequest.getDonationStatusId());
		inventoryResponseBean.setInventoryItemName(savedInventoryRequest.getInventoryItemName());
		inventoryResponseBean.setItemCategoryId(savedInventoryRequest.getItemCategoryId());
		inventoryResponseBean.setItemDescription(savedInventoryRequest.getItemDescription());
		inventoryResponseBean.setItemWareHouseAddress(savedInventoryRequest.getItemWareHouseAddress());
		inventoryResponseBean.setUserId(savedInventoryRequest.getUserId());
		inventoryResponseBean.setInventoryId(savedInventoryRequest.getId());
		inventoryResponseBean.setUserRequestToken(savedInventoryRequest.getUserRequestToken());
		if(!CommonUtil.isNullOrEmpty(savedInventoryRequest.getItemUploadedFilePath())) {
			inventoryResponseBean.setItemUploadedFilePath(savedInventoryRequest.getItemUploadedFilePath());
		}
		if(!CommonUtil.isNullOrEmpty(requestedItemCount) && requestedItemCount != 0) {
			inventoryResponseBean.setRequestedItemCount(requestedItemCount);
		}
		return inventoryResponseBean;
	}
}
