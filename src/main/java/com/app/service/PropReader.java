package com.app.service;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class PropReader {
	protected final Logger logger = LoggerFactory.getLogger(PropReader.class);
	
	@Autowired
	protected ResourceLoader resourceLoader;
	
	@Autowired
	private Environment environment;
	
	
	public String getPropValue(String key) throws IOException {
		Properties props = new Properties();
		try {
			String[] profile = environment.getActiveProfiles();
			Resource resource = resourceLoader.getResource("classpath:application-"+profile[0]+".properties");
			props.load(resource.getInputStream());
			return props.getProperty(key);
		}catch(IOException ie) {
			throw ie;
		}
	}
}
