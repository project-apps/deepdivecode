package com.app.service;

import java.io.IOException;

import org.parser.model.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.util.WebAppConstants;

@Service
public class AuthServiceImpl {
	protected final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	@Autowired
	private APICallService apiCallService;
	@Autowired
	protected PropReader propReader;
	
	public ResponseEntity<AuthUser> authenticateUser(AuthUser user) throws IOException {
		UriComponents uriComponents = UriComponentsBuilder.fromPath(propReader.getPropValue(WebAppConstants.AUTH_USER_URI)).build();
		ResponseEntity<AuthUser> responseEntity = apiCallService.postForEntity(uriComponents, user, AuthUser.class);
		logger.debug("Ressponse from user-authentication:\n \t ResponseEntity:\n\t\t StatsCode: "
				+ responseEntity.getStatusCodeValue());
		return responseEntity;
	}
	public void requestLogout() {
	
	}
}
