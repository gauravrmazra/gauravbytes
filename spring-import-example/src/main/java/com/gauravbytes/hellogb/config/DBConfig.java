package com.gauravbytes.hellogb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gauravbytes.hellogb.dao.FunnyDao;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
@Configuration
public class DBConfig {
	// beans related to various database/ Daos/ Templates etc
	// I am creating funny dao
	@Bean(name = "funny")
	FunnyDao funnyDao() {
		return new FunnyDao();
	}
}
