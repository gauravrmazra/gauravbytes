package com.guaravbytes.property.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
@Configuration
public class DBProperties {
	
	@Value("${db.username}")
	private String userName;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${db.url}")
	private String url;
	
	public DBProperties() {}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "DBProperties [userName=" + userName + ", password=" + password + ", url=" + url + "]";
	}
}
