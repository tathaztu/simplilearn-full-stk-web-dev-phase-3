package com.simplilearn.workshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.model.FileUploadResponse;
import com.simplilearn.workshop.service.FileStorageService;

@RestController
public class FileSystemController {

	private FileStorageService fileStorageService;

	public FileSystemController(FileStorageService fileStorageService) {
		this.fileStorageService = fileStorageService;
	}

	@PostMapping("single/upload")
	FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);

		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download/")
				.path(fileName)
				.toUriString();

		String contentType = file.getContentType();
		FileUploadResponse fileUploadResponse = new FileUploadResponse(fileName, contentType, url);
		return fileUploadResponse;
	}

	@GetMapping("/download/{fileName}")
	ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		Resource resource = fileStorageService.downloadFile(fileName);

		String mimeType;

		try {
			mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		}catch (IOException e) {
			mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
		}

		if(null == mimeType) {
			mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
		}

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(mimeType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + resource.getFilename())
				.body(resource);
	}


}
