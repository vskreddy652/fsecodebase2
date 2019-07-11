package com.hackfse.giveaway.component;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.giveaway.bean.ErrorResponse;
import com.hackfse.giveaway.exception.ReportException;
import com.hackfse.giveaway.service.ReportingService;
import com.hackfse.giveaway.util.CommonUtil;



@RestController
@RequestMapping(value="/report")
public class GenerateReport {

	@Autowired
	ReportingService reportingService;
	
	
	CommonUtil commonUtil;
	
	private static String[] columns = {"Item Category", "Item Name", "Item Count", "Item Status", "Date of submition", "Month of Submition", "Quarter of Submition", "Year of Submition", "Month Date of Submition", "Submited By"};
	
	@RequestMapping(value="/inventry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public String[] generateReportForInventry(@RequestParam String itemCategory, @RequestParam String itemStatus, @RequestParam Long qutrValue, @RequestParam Long yrValue, @RequestParam String mntName, @RequestParam String userId){
		
		String[] responseData = new String[2];
		try{
			commonUtil = new CommonUtil();
		List<Object[]> lstReportData;
		lstReportData = reportingService.getReportForInventry(itemCategory, itemStatus.trim(), qutrValue, yrValue, mntName, userId);
		String strFileData = reportingService.generateReportExcel(columns, lstReportData, "Inventry_Report_"+System.currentTimeMillis());
		String strReportData = commonUtil.writeListToJsonArray(lstReportData);
		responseData[0] = strReportData;
		responseData[1] = strFileData;
		}catch(Exception e){
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
		
			
		return responseData;
	}
	
	@RequestMapping(value="/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUserDetails() throws IOException {
		return reportingService.getUserList();	
	}
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
