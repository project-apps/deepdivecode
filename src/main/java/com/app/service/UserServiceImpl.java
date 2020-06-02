package com.app.service;

import java.io.IOException;

import org.parser.model.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.util.WebAppConstants;

@Service
public class UserServiceImpl {
	
	@Autowired
	private APICallService apiCallService;
	@Autowired
	protected PropReader propReader;
	
	public ResponseEntity<AuthUser> addUser(AuthUser user) throws IOException {
		UriComponents uriComponents = UriComponentsBuilder.fromPath(propReader.getPropValue(WebAppConstants.CMS_BUCKET_FILE_URI))
				.path("/userservice/user").build();
		ResponseEntity<AuthUser> responseEntity = apiCallService.postForEntity(uriComponents, user, AuthUser.class);
		return responseEntity;
	}
	
}
