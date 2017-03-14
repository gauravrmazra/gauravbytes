package com.gauravbytes.hellogb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	
	@Bean
	BasicAuthenticationFilter basicAuthFilter(AuthenticationManager authenticationManager,
			BasicAuthenticationEntryPoint basicAuthEntryPoint) {
		return new BasicAuthenticationFilter(authenticationManager, basicAuthEntryPoint());
	}
	
	@Bean
	BasicAuthenticationEntryPoint basicAuthEntryPoint() {
		BasicAuthenticationEntryPoint bauth = new BasicAuthenticationEntryPoint();
		bauth.setRealmName("GAURAVBYTES");
		return bauth;
	}
}
