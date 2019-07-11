package com.hackfse.giveaway.util;

import java.io.IOException;
import javax.mail.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {
	
	@Autowired
	Environment env;

	public void sendmail(String recipentMial, String senderMail, String subject, String message) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
		   props.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
		   props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
		   props.put("mail.smtp.port", env.getProperty("mail.smtp.port"));
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(env.getProperty("mail.smtp.masterEmail"), env.getProperty("mail.smtp.password"));
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(env.getProperty("mail.smtp.masterEmail"), false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipentMial));
		   msg.setSubject(subject);
		   msg.setContent(message, "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent(message, "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   MimeBodyPart attachPart = new MimeBodyPart();

		  // attachPart.attachFile("/var/tmp/image19.png");
		  // multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
}
