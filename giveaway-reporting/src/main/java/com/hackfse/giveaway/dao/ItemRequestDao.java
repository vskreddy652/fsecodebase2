package com.hackfse.giveaway.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackfse.giveaway.dto.ItemRequestBean;

public interface ItemRequestDao extends JpaRepository<ItemRequestBean, Long> {
	public List<ItemRequestBean> getItemRequestBeanByRequestorId(final Long requestorId);
	public ItemRequestBean getItemRequestBeanByRequestorIdAndUserToken(final Long requestorId, final String userToken);
}
