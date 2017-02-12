package com.gauravbytes.hellogb.dao;

import java.util.logging.Logger;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class FunnyDao {
	private static final Logger logger = Logger.getLogger(FunnyDao.class.getName());

	public FunnyDao() {

	}

	public void save(String message) {
		logger.info(String.format("I log funny on console in a funny mode: %s", message));
	}
}
