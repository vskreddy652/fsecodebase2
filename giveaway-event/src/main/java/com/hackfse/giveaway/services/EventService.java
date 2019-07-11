package com.hackfse.giveaway.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hackfse.giveaway.bean.EventBean;
import com.hackfse.giveaway.dao.EventRepository;
import com.hackfse.giveaway.dto.Event;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepo;
	
	@Autowired
	FileUploadService objFileUploadService;
	
	boolean isFileSaved;
	
	public EventBean uploadEventImage(MultipartFile files) {
		List<String> lnsFilePath = objFileUploadService.uploadFiles(files);
		if(lnsFilePath != null) {
			if(lnsFilePath.size() > 0) {
				Event objEvent = new Event();
				objEvent.setPic_url_1(lnsFilePath.get(0));
				objEvent.setStatus(0L);				
				objEvent = eventRepo.save(objEvent);
				
				EventBean eventBean = new EventBean();
				eventBean.setPic_url_1(objEvent.getPic_url_1());
				eventBean.setId(objEvent.getId());				
				return eventBean;
			}else {
				return null;
			}
		}else {
			return null;
		}	
		
	}

	public List<EventBean> getEvent() throws IOException {
		List<EventBean> lstEventBean = new ArrayList<>();
		List<Event> lstEvent = eventRepo.findAllByOrderByStartDate();
		for(Event event : lstEvent) {
			EventBean objEventBean = new EventBean();
			objEventBean.setAddress(event.getAddress());
			objEventBean.setEveName(event.getEveName());
			objEventBean.setEveDescription(event.getEveDescription());
			objEventBean.setCity(event.getCity());
			objEventBean.setContactName(event.getContactName());
			objEventBean.setContactno(event.getContactno());
			objEventBean.setStartDate(event.getStartDate());
			objEventBean.setEndDate(event.getEndDate());
			if(event.getPic_url_1() != null) {
				if(!event.getPic_url_1().toString().trim().equalsIgnoreCase("")) {
					File imgFile = new File(event.getPic_url_1());
					if(imgFile.exists()) {
						byte[] fileContent = FileUtils.readFileToByteArray(new File(event.getPic_url_1()));
						String encodedString = Base64.getEncoder().encodeToString(fileContent);
						objEventBean.setPic_url_1(encodedString);
					}else {
						objEventBean.setPic_url_1("");
					}
				}else {
					objEventBean.setPic_url_1("");
				}
			}else {
				objEventBean.setPic_url_1("");
			}
			
			objEventBean.setPic_url_2(event.getPic_url_2());
			objEventBean.setPic_url_3(event.getPic_url_3());
			objEventBean.setPic_url_4(event.getPic_url_4());
			lstEventBean.add(objEventBean);
		}
		return lstEventBean;
	}

	public void deleteEvent(String eventId) {		
		eventRepo.deleteById(Long.valueOf(eventId));;
	}

	public EventBean createEvent(EventBean eventBean) {
		Event objEvent = new Event();
		objEvent.setId(eventBean.getId());
		objEvent.setAddress(eventBean.getAddress());
		objEvent.setCity(eventBean.getCity());
		objEvent.setEveName(eventBean.getEveName());
		objEvent.setEveDescription(eventBean.getEveDescription());
		objEvent.setContactName(eventBean.getContactName());
		objEvent.setContactno(eventBean.getContactno());
		objEvent.setStartDate(new Date());
		objEvent.setEndDate(eventBean.getEndDate());
		objEvent.setPic_url_1(eventBean.getPic_url_1());
		objEvent.setPic_url_2(eventBean.getPic_url_2());
		objEvent.setPic_url_3(eventBean.getPic_url_3());
		objEvent.setPic_url_4(eventBean.getPic_url_4());
		objEvent.setStatus(1L);
		eventRepo.save(objEvent);
		return eventBean;
	}

}
