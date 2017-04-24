package com.guaravbytes.property;

import java.util.logging.Logger;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guaravbytes.property.config.AppConfig;
import com.guaravbytes.property.config.DBProperties;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, DBProperties.class);) {
			DBProperties dbProperties = context.getBean(DBProperties.class);
			logger.info("This is dbProperties: " + dbProperties.toString());
		}
	}
}
