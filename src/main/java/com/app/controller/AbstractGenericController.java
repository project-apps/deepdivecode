package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
/**
 * @author Rajan Mishra
 */
@Controller
public abstract class AbstractGenericController {
	
	/** Logger available to subclasses. */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
}
