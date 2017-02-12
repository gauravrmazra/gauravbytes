package com.gauravbytes.hellogb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gauravbytes.hellogb.service.GreetingService;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
@Configuration
public class WelcomeGbConfig {

	@Bean
	GreetingService greetingService() {
		return new GreetingService();
	}
}
