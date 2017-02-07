package com.gauravbytes.hellogb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gauravbytes.hellogb.service.GreetingService;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class App {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
		    "com.gauravbytes.hellogb.service");) {
			GreetingService greetingService = context.getBean(GreetingService.class);
			greetingService.greet();
		}
	}
}
