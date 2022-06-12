package com.simplilearn.workshop.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	private Path fileStoragePath;
	private String fileStorageLocation;

	public FileStorageService(@Value("${file.storage.location:temp}") String fileStorageLocation) {
		super();
		this.fileStorageLocation = fileStorageLocation;

		fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();

		try {
			Files.createDirectories(fileStoragePath);
		} catch (IOException e) {
			throw new RuntimeException("Issue in creating file directory - " + e.getMessage());
		}
	}

	public String storeFile(MultipartFile file) {
		System.out.println("Before cleanPath() - " + file.getOriginalFilename());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println("After cleanPath() - " + fileName);

		Path filePath = Paths.get(fileStoragePath + "\\" + fileName);

		try {
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("Issue in storing file - " + e.getMessage());
		}

		return fileName;
	}

	public Resource downloadFile(String fileName) {
		Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(fileName);

		Resource resource;

		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e ){
			throw new RuntimeException("Issue in reading file - " + e.getMessage());
		}

		if (resource.exists() && resource.isReadable()) {
			return resource;
		} else {
			throw new RuntimeException("File doesn't exist or is unreadable");
		}
	}
}
