package com.hackfse.giveaway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.giveaway.dao.DomainDao;
import com.hackfse.giveaway.dto.DomainBean;
import com.hackfse.giveaway.util.DomainUtil;

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
