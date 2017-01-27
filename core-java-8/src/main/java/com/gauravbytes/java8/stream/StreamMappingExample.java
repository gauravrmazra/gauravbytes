package com.gauravbytes.java8.stream;

import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamMappingExample {
	public static void main(String[] args) {
		List<String> lines = DataStub.getLines();
		lines.stream().mapToInt(String::length).max().ifPresent(System.out::println);
	}
}
