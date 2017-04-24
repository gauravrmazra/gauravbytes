package com.guaravbytes.property.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource("application-db.properties"));
		//propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
		//propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);
		return propertySourcesPlaceholderConfigurer;
	}
}
