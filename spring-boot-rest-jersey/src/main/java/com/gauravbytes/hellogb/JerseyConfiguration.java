package com.gauravbytes.hellogb;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.gauravbytes.hellogb.controller.BookController;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Configuration
@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration() {
		
	}
	
	@PostConstruct
	public void setUp() {
		register(BookController.class);
		register(GenericExceptionMapper.class);
	}
}
