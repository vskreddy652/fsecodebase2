package com.hackfse.giveaway.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	@Value("${application.storage.location}")
	private String fileStorageLocation;
	

	public List<String> uploadFiles(List<MultipartFile> imagesToUpload) {
		final Path fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
		final List<String> uploadResponses = new ArrayList<String>();
		for (MultipartFile multiPartFile : imagesToUpload) {
			String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename()) + UUID.randomUUID();
			Path targetLocation = fileStoragePath.resolve(fileName);
			try {
				Files.copy(multiPartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);				
				uploadResponses.add(targetLocation.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return uploadResponses;
	}
	
	public List<String> uploadFiles(MultipartFile imagesToUpload) {
		//final Path fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
		final Path fileStoragePath = Paths.get(fileStorageLocation);
		final List<String> uploadResponses = new ArrayList<String>();		
		String fileName = UUID.randomUUID()+StringUtils.cleanPath(imagesToUpload.getOriginalFilename());
		Path targetLocation = fileStoragePath.resolve(fileName);
		try {
			Files.copy(imagesToUpload.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);				
			uploadResponses.add(targetLocation.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return uploadResponses;
	}
	
	public Resource loadFile(String filename) {
		try {
			final Path fileStoragePath = Paths.get("//");
			Path file = fileStoragePath.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
}
