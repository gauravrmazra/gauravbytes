package com.gauravbytes.igniteexamples;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

/**
 * A simple helloworld example for Apache Ignite
 * @author Gaurav Rai Mazra
 *
 */
public class HelloworldIgniteExample {	
	public static void main(String[] args) {
		try (Ignite ignite =  Ignition.start(IgniteConfigurationHelper.helloworldConfiguration())) {
			
		}
		Ignition.stop(true);
	}
}
