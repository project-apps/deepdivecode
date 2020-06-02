package com.app.service;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.parser.model.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.util.WebAppConstants;

@Service
public class APICallService {
	protected final Logger logger = LoggerFactory.getLogger(APICallService.class);
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	protected PropReader propReader;
	
	//private  List<HttpMessageConverter<?>> httpMessageConverter;
	
	private HttpHeaders headers;
	
	public APICallService() {
		/*
		 * HttpMessageConverter stringHttpMessageConverter = new
		 * StringHttpMessageConverter(Charset.forName("UTF-8")); httpMessageConverter =
		 * new ArrayList<HttpMessageConverter<?>>();
		 * httpMessageConverter.add(stringHttpMessageConverter);
		 */
		headers = new HttpHeaders();
		MediaType mediaType = new MediaType(MediaType.TEXT_HTML, StandardCharsets.UTF_8);
		headers.setContentType(mediaType);
	}
	
	public ResponseEntity<String> exchange(UriComponents uriComponents) throws RestClientException, IOException {
		//restTemplate.setMessageConverters(httpMessageConverter);
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(appendGatewayUri(uriComponents), HttpMethod.GET, entity, String.class);
		return responseEntity;
	}
	public <T extends Serializable> ResponseEntity<T> postForEntity(UriComponents uriComponents, T entity, Class<T> clazz) throws IOException {
		ResponseEntity<T> responseEntity = restTemplate.postForEntity(appendGatewayUri(uriComponents), entity, clazz);
		return responseEntity;
	}
	
	private String appendGatewayUri(UriComponents uriComponents) throws IOException {
		String targetUri = UriComponentsBuilder.fromUriString(propReader.getPropValue(WebAppConstants.API_GATEWAY_HOST)).uriComponents(uriComponents).build().toString();
		logger.info("Invoking restTemplate with targetUrl: "+targetUri);
		return targetUri; 
	}
}
