package com.gauravbytes.di;

import java.io.File;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gauravbytes.di.parser.config.ConstructorBasedDIConfig;
import com.gauravbytes.di.parser.constructor.ConstructorBasedFileParser;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
public class ConstructorBasedApp {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ConstructorBasedDIConfig.class);) {
			ConstructorBasedFileParser parser = context.getBean(ConstructorBasedFileParser.class);
			parser.parseFile(new File("text.json"));
		}
	}
}
