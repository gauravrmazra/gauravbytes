package com.gauravbytes.springbeanscope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gauravbytes.springbeanscope.Dictionary;

@Configuration
public class ScopeConfig {
	@Bean(name = "prototypeDictionary")
	@Scope("prototype")
	Dictionary prototypeDictionary() {
		return new Dictionary();
	}
	
	@Bean(name = "singletonDictionary")
	@Scope("singleton") 
	//you can omit the scope by default it is singleton
	Dictionary singletonDictionary() {
		return new Dictionary();
	}
}
