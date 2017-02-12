package com.gauravbytes.hellogb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
@Configuration
@Import(value = { DBConfig.class, WelcomeGbConfig.class })
public class HelloGbAppConfig {

}
