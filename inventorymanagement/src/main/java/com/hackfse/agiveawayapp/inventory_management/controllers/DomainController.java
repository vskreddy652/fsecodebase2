package com.hackfse.agiveawayapp.inventory_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.agiveawayapp.inventory_management.models.DomainBean;
import com.hackfse.agiveawayapp.inventory_management.services.DomainService;

@RestController
@RequestMapping("/domain")
public class DomainController {
	@Autowired
	DomainService domainService;
	
	@RequestMapping(method = RequestMethod.GET, value = "{typeName}")
	public List<DomainBean> getDomainByDomainTypeName(@PathVariable("typeName") String typeName) {
		return domainService.getDomainByDomainTypeName(typeName);
	}
}
