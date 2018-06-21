package com.gauravbytes.hellogb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import com.gauravbytes.hellogb.filter.CustomSecurityHeaderFilter;


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
	DigestAuthenticationFilter digestFilter(DigestAuthenticationEntryPoint digestAuthenticationEntryPoint, UserCache digestUserCache, UserDetailsService userDetailsService) {
		DigestAuthenticationFilter filter = new DigestAuthenticationFilter();
		filter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint);
		filter.setUserDetailsService(userDetailsService);
		filter.setUserCache(digestUserCache);
		return filter;
	}
	
	@Bean
	UserCache digestUserCache() throws Exception {
		return new SpringCacheBasedUserCache(new ConcurrentMapCache("digestUserCache"));
	}
	
	@Bean
	DigestAuthenticationEntryPoint digestAuthenticationEntry() {
		DigestAuthenticationEntryPoint digestAuthenticationEntry = new DigestAuthenticationEntryPoint();
		digestAuthenticationEntry.setRealmName("GAURAVBYTES.COM");
		digestAuthenticationEntry.setKey("GRM");
		digestAuthenticationEntry.setNonceValiditySeconds(60);
		return digestAuthenticationEntry;
	}
	
	@Bean
	FilterRegistrationBean customSecurityHeaderFilterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new CustomSecurityHeaderFilter());
		filterRegistration.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filterRegistration;
	}
	
}
