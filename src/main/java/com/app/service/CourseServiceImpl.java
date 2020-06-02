package com.app.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.entity.dto.DirectoryNode;
import com.app.util.WebAppConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CourseServiceImpl {
	
	@Autowired
	private APICallService apiCallService;
	@Autowired
	protected PropReader propReader;
	
	public ResponseEntity<String> courseHomePage(String courseName) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		try {
			UriComponents uriComponents = UriComponentsBuilder.fromPath(WebAppConstants.CMS_BUCKET_FILE_URI).queryParam(WebAppConstants.PATH, courseName+"/"+WebAppConstants.COURSE_HOME_PAGE).build();
			responseEntity = apiCallService.exchange(uriComponents);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseEntity;
		
	}
	public DirectoryNode listCourseContent(String courseName) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		DirectoryNode directoryNode = new DirectoryNode();
		try {
			UriComponents uriComponents = UriComponentsBuilder.fromPath(WebAppConstants.CMS_BUCKET_METADATA_URI).queryParam(WebAppConstants.PATH, courseName).build();
			responseEntity = apiCallService.exchange(uriComponents);
			ObjectMapper mapper = new ObjectMapper();
			directoryNode =  mapper.readValue(responseEntity.getBody(), DirectoryNode.class);
		} catch (RestClientException | IOException e) {
			e.printStackTrace();
		}
		return directoryNode;
	}
	public ResponseEntity<String> getFileContent(String fileUri) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		try {
			String encPath = UriComponentsBuilder.newInstance().path(fileUri.concat(WebAppConstants.COURSE_FILE_EXT)).toUriString();
			UriComponents uriComponent = UriComponentsBuilder.fromPath(WebAppConstants.CMS_BUCKET_FILE_URI).queryParam(WebAppConstants.PATH, encPath).build();
			responseEntity= apiCallService.exchange(uriComponent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseEntity;		
	}

}
