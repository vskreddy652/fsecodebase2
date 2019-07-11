package com.hackfse.giveaway.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.giveaway.bean.MailInboxBean;
import com.hackfse.giveaway.dao.MailDao;
import com.hackfse.giveaway.dao.UserDao;
import com.hackfse.giveaway.dto.Email;
import com.hackfse.giveaway.dto.UsersBean;
import com.hackfse.giveaway.util.Constants;
import com.hackfse.giveaway.util.DomainUtil;
import com.hackfse.giveaway.util.EmailUtility;

@Service
public class MailingService {

	@Autowired
	MailInboxBean objMailInboxBean;
	
	@Autowired
	MailDao mailDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	EmailUtility mailUtil;
	
	@Autowired
	EmailServiceImpl emailSrvs;
	
	@Autowired
	DomainService domainService;
	
	
	
	public List<MailInboxBean> getUserInbox(String strRecipentEmail) {
		List<Email> lstEmail = mailDao.findByReciverEmail(strRecipentEmail);
		List<MailInboxBean> lstMailInboxBeans = new ArrayList<>();
		for(Email email : lstEmail) {
			MailInboxBean mailboxBean = new MailInboxBean();
			mailboxBean.setId(email.getEmailid());
			mailboxBean.setRecipentEmailId(email.getReciverEmail());
			mailboxBean.setSenderEmailId(email.getSenderemail());
			mailboxBean.setMailMessage(email.getMessage());
			mailboxBean.setMailSubject(email.getSubject());
			mailboxBean.setReadStatus(email.getReadStatus());
			mailboxBean.setSendDate(email.getSendDate());
			lstMailInboxBeans.add(mailboxBean);
		}	
		
		return lstMailInboxBeans;
	}
	
	public String updateReadStatus(String strMailId) {
		int count = mailDao.updateReadStatusById(1L, Long.valueOf(strMailId));
		if(count > 0) {
			return "ML_READ";
		}else {
			return "ML_UNDEAR";
		}
	}
	
	public MailInboxBean sendMail(MailInboxBean mailBean) throws Exception {
		Email email = new Email();
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		UsersBean usersBean = userDao.findByUserName(mailBean.getUserName());
		email.setSenderemail(mailBean.getSenderEmailId());
		email.setReciverEmail(mailBean.getRecipentEmailId());
		email.setSubject(mailBean.getMailSubject());
		email.setMessage(mailBean.getMailMessage());
		email.setReadStatus(domainUtilInstance.getDomainByDomainTypeCode(Constants.MAIL_READ_STATUS_UNREAD).getId());
		email.setDeliveryStatus(domainUtilInstance.getDomainByDomainTypeCode(Constants.MAIL_DELIVERY_STATUS_UNDELIVERED).getId());
		email.setUsersBean(usersBean);
		email.setSendDate(new Date(System.currentTimeMillis()));
		Email svEmail = mailDao.save(email);
		if(svEmail != null) {
			if(Constants.MAIL_DELIVERY_FLAG) 
				emailSrvs.sendSimpleMessage(mailBean.getRecipentEmailId(), mailBean.getMailSubject(), mailBean.getMailMessage());
			
			return mailBean;
		}else {
			return null;
		}
	}

	
}
