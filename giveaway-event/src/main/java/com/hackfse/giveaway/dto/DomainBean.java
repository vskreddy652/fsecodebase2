package com.hackfse.giveaway.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//TODO This domain table should include DonationStatus, ItemCategories details.

@Component
@Entity(name = "domainBean")
@Table(name = "DOMAIN")
public class DomainBean {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "TYPE_ID")
	private Long typeId;
	@Column(name = "TYPE_CODE")
	private String typeCode;
	@Column(name = "TYPE_NAME")
	private String typeName;
	@Column(name = "TYPE_DESCRIPTION")
	private String typeDescription;

	public DomainBean(Long id, Long typeId, String typeCode, String typeName, String typeDescription) {
		this.id = id;
		this.typeId = typeId;
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.typeDescription = typeDescription;
	}

	public DomainBean() {

	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(final Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(final String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(final String typeName) {
		this.typeName = typeName;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(final String typeDescription) {
		this.typeDescription = typeDescription;
	}

}
