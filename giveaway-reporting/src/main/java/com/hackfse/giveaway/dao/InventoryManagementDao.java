package com.hackfse.giveaway.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackfse.giveaway.dto.InventoryBean;

@Repository
@Transactional
public interface InventoryManagementDao extends JpaRepository<InventoryBean, Long> {
	public List<InventoryBean> getInventoryBeanByUserId(final Long userId);
	public InventoryBean getInventoryBeanByUserRequestToken(final String userRequestToken);
	public List<InventoryBean> getInventoryBeanByDonationStatusId(final Long donationStatusId);
	public List<InventoryBean> getInventoryBeanByItemRequestedByUser(final Long userId);
	@Query("SELECT "+
			"dm1.typeCode,  "+
			"inv.inventoryItemName, "+
			"inv.donatedItemCount, "+
			"dm2.typeCode, "+
			"inv.submissionDate, "+
			"MONTHNAME(inv.submissionDate), "+
			"QUARTER(inv.submissionDate), "+
			"YEAR(inv.submissionDate), "+
			"DAYOFMONTH(inv.submissionDate), "+
			"concat(COALESCE(usr.userFirstName, ''), ' ', COALESCE(usr.userLastName, '')) "+
			"FROM "+
			"inventoryBean inv, "+
			"domainBean dm1, "+
			"domainBean dm2, "+
			"usersBean usr "+
			""+
			"WHERE inv.itemCategoryId = dm1.id "+
			"AND dm1.typeName = 'ItemCategory' "+
			"AND inv.donationStatusId = dm2.id "+
			"AND dm2.typeName = 'ItemStatus' "+
			"AND inv.userId = usr.id "+
			"AND COALESCE(dm1.typeCode, '') = COALESCE(:itemCat,COALESCE(dm1.typeCode, '')) "+
			"AND COALESCE(dm2.typeCode, '') = COALESCE(:itemStat,COALESCE(dm2.typeCode, '')) "+
			"AND COALESCE(QUARTER(inv.submissionDate), 0) = COALESCE(:qtrVal, COALESCE(QUARTER(inv.submissionDate), 0)) "+
			"AND COALESCE(YEAR(inv.submissionDate),0) = COALESCE(:qtrYr, COALESCE(YEAR(inv.submissionDate),0)) "+
			"AND COALESCE(MONTHNAME(inv.submissionDate),'') = COALESCE(:mntname, COALESCE(MONTHNAME(inv.submissionDate),'')) "+
			"AND COALESCE(usr.userName, '') = COALESCE(:qtrUser,COALESCE(usr.userName, ''))")
	public List<Object[]> getInventoryReport(@Param("itemCat") String itemCategory, @Param("itemStat") String itemStatus, @Param("qtrVal") Long qtrVal, @Param("qtrYr") Long qtrYr, @Param("mntname") String mntname, @Param("qtrUser") String qtrUser);
}
