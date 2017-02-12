package com.gauravbytes.di.parser.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Configuration
@Import(value = ParserConfig.class)
@ComponentScan(basePackages = "com.gauravbytes.di.parser.setter")
public class SetterBasedDIConfig {

}
