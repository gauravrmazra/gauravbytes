package com.gauravbytes.hellogb.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Component
public class AppStartupRunner implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Your application started with non-option args : {}", args.getNonOptionArgs());
	}

}
