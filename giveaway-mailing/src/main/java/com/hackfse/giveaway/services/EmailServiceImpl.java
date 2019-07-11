package com.hackfse.giveaway.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hackfse.giveaway.dao.MailDao;
import com.hackfse.giveaway.dao.UserDao;
import com.hackfse.giveaway.dto.Email;
import com.hackfse.giveaway.dto.UsersBean;
import com.hackfse.giveaway.util.Constants;
import com.hackfse.giveaway.util.DomainUtil;

@Service
public class EmailServiceImpl{
	
	@Autowired
	public JavaMailSender emailSender;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MailDao mailDao;
	
	@Autowired
	DomainService domainService;
	
	

	public void sendSimpleMessage(String to, String subject, String text) {
		if(Constants.MAIL_DELIVERY_FLAG) {
			SimpleMailMessage message = new SimpleMailMessage(); 
			message.setTo(to); 
			message.setFrom("no-reply@crecent.com");
			message.setSubject(subject); 
			message.setText(text);
			emailSender.send(message);
		}
	}
	
	
	public void sendMessageWithAttachment(String to, String subject, String text, List<String> pathToAttachment) throws MessagingException {	  
		UsersBean objUserBean = userDao.findByUserName(to);
		final DomainUtil domainUtilInstance = domainService.getDomainUtilInstance();
		MimeMessage message = emailSender.createMimeMessage();
	    StringBuffer sbfrFileNames = new StringBuffer();  
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	     
	    helper.setTo(objUserBean.getUserEmail());
	    helper.setSubject(subject);
	    helper.setText(text);
	    helper.setFrom("no-reply@crecent.com");
	    int intFileCount = 0;     
	    for(String strFileName : pathToAttachment) {
	    	intFileCount++;
		    FileSystemResource file = new FileSystemResource(new File(strFileName));
		    helper.addAttachment("Attachment"+intFileCount, file);
		    if(sbfrFileNames.length() > 0 ) {
           	 sbfrFileNames.append(";"+Constants.FILE_UPLOAD_PATH + strFileName);
            }else {
           	 sbfrFileNames.append(Constants.FILE_UPLOAD_PATH + strFileName);
            }
	    }
	    
	   
	    Email email = new Email();		
		email.setSenderemail("admin@crecent.com");
		email.setReciverEmail(objUserBean.getUserEmail());
		email.setSubject(subject);
		email.setMessage(text);
		email.setReadStatus(domainUtilInstance.getDomainByDomainTypeCode(Constants.MAIL_READ_STATUS_UNREAD).getId());
		email.setDeliveryStatus(domainUtilInstance.getDomainByDomainTypeCode(Constants.MAIL_DELIVERY_STATUS_UNDELIVERED).getId());
		email.setUsersBean(objUserBean);
		email.setSendDate(new Date(System.currentTimeMillis()));
		Email svEmail = mailDao.save(email);
		
		if(Constants.MAIL_DELIVERY_FLAG) {
			emailSender.send(message);
		}
	    // ...
	}
	
	//save file
    public void saveUploadedFiles(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(Constants.FILE_UPLOAD_PATH + file.getOriginalFilename());
            Files.write(path, bytes);

        }

    }
}