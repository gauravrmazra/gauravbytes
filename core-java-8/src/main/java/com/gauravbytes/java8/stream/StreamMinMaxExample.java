package com.gauravbytes.java8.stream;

import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamMinMaxExample {
	public static void main(String[] args) {
		List<String> lines = DataStub.getLines();
		// max line
		lines.stream().max(Comparator.comparingInt(String::length))
		    .ifPresent(System.out::println);

		// min line
		lines.stream().min(Comparator.comparingInt(String::length))
		    .ifPresent(System.out::println);
	}
}
