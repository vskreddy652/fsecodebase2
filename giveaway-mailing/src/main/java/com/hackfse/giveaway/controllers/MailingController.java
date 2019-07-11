package com.hackfse.giveaway.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hackfse.giveaway.bean.ErrorResponse;
import com.hackfse.giveaway.bean.MailInboxBean;
import com.hackfse.giveaway.exception.ReportException;
import com.hackfse.giveaway.services.EmailServiceImpl;
import com.hackfse.giveaway.services.MailingService;
import com.hackfse.giveaway.util.Constants;

@RestController
@RequestMapping(value="/mailer")
public class MailingController {	
	

	@Autowired
	MailingService objMailingService;
	
	@Autowired
	EmailServiceImpl objEmailMailingService;
	
	@RequestMapping(value = "/getinbox" , method = {RequestMethod.GET})
	public List<MailInboxBean> getInbox(@RequestParam String email){
		return objMailingService.getUserInbox(email);
	}
	
	@RequestMapping(value = "/readMail" , method = {RequestMethod.PUT})
	public String readEmail(@RequestParam String mailid){
		return objMailingService.updateReadStatus(mailid);
	}
	
	@RequestMapping(value = "/sendMail" , method = {RequestMethod.POST})
	public MailInboxBean sendEmail(@RequestBody MailInboxBean email) throws Exception{
		return objMailingService.sendMail(email);
	}
		
	@RequestMapping(value = "/sendmailwithattachment" , method = {RequestMethod.POST})
	public String sendEmailWithAttachment(@RequestParam String userId, @RequestParam String subject, @RequestParam String message, @RequestParam("files") MultipartFile[] uploadfiles) throws Exception{
		
		
		// Get file name
        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

        if (StringUtils.isEmpty(uploadedFileName)) {
            return "please select a file!";
        }

        try {
        	List<MultipartFile> lstAllFiles = Arrays.asList(uploadfiles);
        	List<String> lstFilePaths = new ArrayList<String>();
        	objEmailMailingService.saveUploadedFiles(Arrays.asList(uploadfiles));
        	
        	for (MultipartFile file : lstAllFiles) {

                 if (file.isEmpty()) {
                     continue; //next pls
                 }
                 
                 lstFilePaths.add(Constants.FILE_UPLOAD_PATH + file.getOriginalFilename());
        	}
        	objEmailMailingService.sendMessageWithAttachment(userId, subject, message, lstFilePaths);
    		return "Successfully uploaded - " + uploadedFileName;   		

        } catch (IOException e) {
            return "Internal error while sending the notification.";
        }       
		
	}
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
