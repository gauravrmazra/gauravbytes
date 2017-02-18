package com.gauravbytes.hellogb;

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
		register(BookController.class);
		register(GenericExceptionMapper.class);
	}
}
