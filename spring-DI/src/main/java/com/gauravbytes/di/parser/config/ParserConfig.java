package com.gauravbytes.di.parser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gauravbytes.di.parser.JsonFileParser;
import com.gauravbytes.di.parser.Parser;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Configuration
public class ParserConfig {
	@Bean
	Parser jsonFileParser() {
		return new JsonFileParser();
	}
}
