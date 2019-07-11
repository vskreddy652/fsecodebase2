package com.hackfse.agiveawayapp.login_register.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hackfse.agiveawayapp.login_register.models.MailInboxBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumeRestApplication {
	
	final Logger logger = LoggerFactory.getLogger(ConsumeRestApplication.class);
		
	@Value("${mailerserver.name}")
	private String mailSrvrName;
	
	@Autowired	
    RestTemplate restTemplate;
	
	@Autowired
	MailInboxBean mailInboxBean;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	
	@HystrixCommand(fallbackMethod = "callMailingService_Fallback")
	public void postForObjectOperation(String strSubject, String strMessage, String strRecipientMail, String strUserName) {
		mailInboxBean.setMailSubject(strSubject);
		mailInboxBean.setMailMessage(strMessage);
		mailInboxBean.setRecipentEmailId(strRecipientMail);
		mailInboxBean.setUserName(strUserName);		
		HttpHeaders headers = new HttpHeaders();		
		headers.setBasicAuth("loginUser", "loginPassword");
		String mailServiceURL = serviceUrl();
		mailServiceURL += "/mailer/sendMail";
		System.out.println("The Service URL : "+ mailServiceURL);
		HttpEntity<MailInboxBean> request = new HttpEntity<MailInboxBean>(mailInboxBean, headers);
		restTemplate.postForObject("http://"+mailSrvrName+"/mailer/sendMail", request, MailInboxBean.class);		
	}	
	
	
	@SuppressWarnings("unused")
    private void callMailingService_Fallback(String strSubject, String strMessage, String strRecipientMail, String strUserName) {
		logger.info("Mailing Service is down!!! fallback route enabled...");
        System.out.println("Mailing Service is down!!! fallback route enabled...");
      
    } 
   
    
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances(mailSrvrName);
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

}