package com.gauravbytes.feapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Mazra, Gaurav Rais
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class UserApplication {
	public static void main(String[] args) {
	    SpringApplication.run(UserApplication.class, args);
	  }
}
