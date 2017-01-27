package com.gauravbytes.java8.stream;

import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamMaxExample {
	public static void main(String[] args) {
		List<String> lines = DataStub.getLines();
		lines.stream().max(Comparator.comparingInt(String::length))
		    .ifPresent(System.out::println);
	}
}
