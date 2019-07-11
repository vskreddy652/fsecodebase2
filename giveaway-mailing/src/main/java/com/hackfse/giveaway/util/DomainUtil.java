package com.hackfse.giveaway.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hackfse.giveaway.dao.DomainDao;
import com.hackfse.giveaway.dto.DomainBean;

public class DomainUtil {
	private Map<String, List<DomainBean>> domainMap = null;

	private static DomainUtil domainUtilInstance = null;

	private DomainDao domainDao;

	private DomainUtil(DomainDao domainDao) {
		this.domainDao = domainDao;
		updateDomainMap();
	}

	public DomainDao getDomainDao() {
		return domainDao;
	}

	public void setDomainDao(DomainDao domainDao) {
		this.domainDao = domainDao;
	}

	public static DomainUtil getInstance(DomainDao domainDao) {
		if (CommonUtil.isNullOrEmpty(domainUtilInstance) && !CommonUtil.isNullOrEmpty(domainDao)) {
			domainUtilInstance = new DomainUtil(domainDao);
		}
		return domainUtilInstance;
	}

	public void updateDomainMap() {
		domainMap = new HashMap<String, List<DomainBean>>();
		final List<DomainBean> domainBeanList = getDomainDao().findAll();
		final Set<String> keySet = new HashSet<String>();
		for (DomainBean domain : domainBeanList) {
			keySet.add(domain.getTypeName());
		}
		for (String key : keySet) {
			final List<DomainBean> tempDomainBeanList = new ArrayList<DomainBean>();
			for (DomainBean domainBean : domainBeanList) {
				if (key.equals(domainBean.getTypeName())) {
					tempDomainBeanList.add(domainBean);
				}
			}
			domainMap.put(key, tempDomainBeanList);
		}
	}

	public List<DomainBean> getDomainObjByDomainTypeName(final String domainTypeName) {
		return domainMap.get(domainTypeName);
	}

	public DomainBean getDomainByDomainTypeCode(final String typeCode) {
		for (String mapKey : domainMap.keySet()) {
			final List<DomainBean> domainBeanList = domainMap.get(mapKey);
			for (DomainBean domainBean : domainBeanList) {
				if (domainBean.getTypeCode().equals(typeCode)) {
					return domainBean;
				}
			}
		}
		return null;
	}
	
	public DomainBean getDomainByDomainId(final Long id) {
		for (String mapKey : domainMap.keySet()) {
			final List<DomainBean> domainBeanList = domainMap.get(mapKey);
			for (DomainBean domainBean : domainBeanList) {
				if (domainBean.getId().longValue() == id) {
					return domainBean;
				}
			}
		}
		return null;
	}
}
