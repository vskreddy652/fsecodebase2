package com.hackfse.agiveawayapp.inventory_management.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hackfse.agiveawayapp.inventory_management.dao.FileUploadDao;
import com.hackfse.agiveawayapp.inventory_management.models.InventoryItemUploads;
import com.hackfse.agiveawayapp.inventory_management.response.beans.FileUploadResponse;

@Service
public class FileUploadService {

	@Value("${application.storage.location}")
	private String fileStorageLocation;

	@Autowired
	FileUploadDao fileUploadDao;

	public FileUploadResponse uploadFiles(MultipartFile fileToUpload, Long userId, String inventoryId,
			String userRequestToken) {
		final Path fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
		String newFileName = userRequestToken + StringUtils.cleanPath(fileToUpload.getOriginalFilename());
		Path targetLocation = fileStoragePath.resolve(newFileName);
		try {
			byte[] bytes = fileToUpload.getBytes();
			Files.write(targetLocation, bytes);
			final InventoryItemUploads uploadedItem = new InventoryItemUploads();
			uploadedItem.setUploadDate(new Date(System.currentTimeMillis()));
			uploadedItem.setInventoryItemFilePath(targetLocation.toString());
			uploadedItem.setUserId(userId);
			uploadedItem.setInventoryItemId(Long.valueOf(inventoryId));
			uploadedItem.setUserRequestToken(userRequestToken);
			fileUploadDao.save(uploadedItem);
			final FileUploadResponse response = new FileUploadResponse();
			response.setInventoryItemFilePath(uploadedItem.getInventoryItemFilePath());
			response.setInventoryItemId(uploadedItem.getInventoryItemId());
			response.setUserId(uploadedItem.getUserId());
			response.setUserRequestToken(userRequestToken);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<FileUploadResponse> getFiles(final Long inventoryId) {
		return (List<FileUploadResponse>) fileUploadDao.getInventoryItemUploadsById(inventoryId);
	}
}
