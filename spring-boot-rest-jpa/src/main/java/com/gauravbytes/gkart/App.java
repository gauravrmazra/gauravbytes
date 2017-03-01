package com.gauravbytes.gkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 */
@SpringBootApplication
@EnableJpaRepositories
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
