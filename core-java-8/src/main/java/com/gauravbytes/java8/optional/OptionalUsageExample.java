package com.gauravbytes.java8.optional;

import java.util.Optional;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class OptionalUsageExample {
	public static void main(String[] args) {
		Optional<String> value = Optional.of("Gaurav");
		value.ifPresent(System.out::println);
		
		if (value.isPresent()) {
			System.out.println(value.get());
		}
		else {
			System.err.println("Not found");
		}
	}
}
