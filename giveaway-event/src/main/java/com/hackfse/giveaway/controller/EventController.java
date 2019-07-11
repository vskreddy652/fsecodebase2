package com.hackfse.giveaway.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.hackfse.giveaway.bean.ErrorResponse;
import com.hackfse.giveaway.bean.EventBean;
import com.hackfse.giveaway.exception.ReportException;
import com.hackfse.giveaway.services.EventService;
import com.hackfse.giveaway.services.FileUploadService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/event")
//@FeignClient(name = "eventmanagementservice")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	FileUploadService objFileUploadService;
	
	List<String> files = new ArrayList<String>();
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public EventBean create(@RequestBody EventBean eventBean) {		
		return eventService.createEvent(eventBean);
	}
	
	@RequestMapping(value="/uploadimage", method = RequestMethod.POST)
	public EventBean uploadimage(@RequestParam("file") MultipartFile file) {		
		return eventService.uploadEventImage(file);
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public List<EventBean> getEvent() throws Exception {			
		return eventService.getEvent();
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public void deleteEvent(@RequestParam String eventId) {		
		eventService.deleteEvent(eventId);
	}
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = objFileUploadService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	@GetMapping("/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		List<String> fileNames = files.stream().map(fileName -> MvcUriComponentsBuilder.fromMethodName(EventController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());
 
		return ResponseEntity.ok().body(fileNames);
	}
	
	@RequestMapping(value ="/image", method = RequestMethod.GET)
	public @ResponseBody byte[] getImage(HttpServletRequest request) throws IOException{
		String uri = request.getRequestURI();
		String Path = request.getContextPath();
		System.out.println("uri ::::: " +uri + "  || Path ::::: "+Path);
		InputStream in = getClass().getResourceAsStream("/upload-dir/party.png");
		return IOUtils.toByteArray(in);
	}

	@ExceptionHandler(ReportException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
