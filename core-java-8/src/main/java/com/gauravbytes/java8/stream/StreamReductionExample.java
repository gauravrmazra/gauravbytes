package com.gauravbytes.java8.stream;

import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamReductionExample {
	public static void main(String[] args) {
		List<String> lines = DataStub.getLines();
		lines.stream().reduce((a, b) -> a.length() > b.length() ? a : b)
		    .ifPresent(System.out::println);
	}
}
