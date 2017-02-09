package com.gauravbytes.hellogb.service;

import java.util.logging.Logger;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class GreetingService {
	private static final Logger logger = Logger.getLogger(GreetingService.class.getName());

	public GreetingService() {

	}

	public void greet() {
		logger.info("Gaurav Bytes: Your first tutorial on Spring!!!");
	}
}
