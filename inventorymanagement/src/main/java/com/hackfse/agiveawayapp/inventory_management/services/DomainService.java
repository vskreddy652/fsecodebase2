package com.hackfse.agiveawayapp.inventory_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.agiveawayapp.inventory_management.dao.DomainDao;
import com.hackfse.agiveawayapp.inventory_management.models.DomainBean;
import com.hackfse.agiveawayapp.inventory_management.util.DomainUtil;

@Service
public class DomainService {
	
	@Autowired
	DomainDao domainDao;
	
	public List<DomainBean> getDomainByDomainTypeName(final String typeName) {
		final DomainUtil domainUtilInstance = getDomainUtilInstance();
		return domainUtilInstance.getDomainObjByDomainTypeName(typeName);
	}
	
	public DomainUtil getDomainUtilInstance() {
		return DomainUtil.getInstance(domainDao);
	}
}
