package com.gauravbytes.di;

import java.io.File;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gauravbytes.di.parser.config.SetterBasedDIConfig;
import com.gauravbytes.di.parser.setter.SetterBasedFileParser;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
public class SetterBasedApp {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SetterBasedDIConfig.class);) {
			SetterBasedFileParser parser = context.getBean(SetterBasedFileParser.class);
			parser.parseFile(new File("text.json"));
		}
	}
}
