package com.hackfse.agiveawayapp.inventory_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hackfse.agiveawayapp.inventory_management.response.beans.FileUploadResponse;
import com.hackfse.agiveawayapp.inventory_management.services.FileUploadService;

@RestController
@RequestMapping("/files")
public class FileUploadController {

	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping(method = RequestMethod.POST, value = "/upload", consumes = { "multipart/form-data" })
	public FileUploadResponse uploadFiles(@RequestParam("file") MultipartFile fileToUpload,
			@RequestParam("userId") String userId, @RequestParam("inventoryId") String inventoryId,
			@RequestParam("userRequestToken") String userRequestToken) {
		return fileUploadService.uploadFiles(fileToUpload, Long.valueOf(userId), inventoryId, userRequestToken);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public List<FileUploadResponse> getFiles(@PathVariable("id") Long inventoryId) {
		return fileUploadService.getFiles(inventoryId);
	}
}
