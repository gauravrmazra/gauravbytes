package com.gauravbytes.java8.stream;

import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamSortingExample {
	public static void main(String[] args) {
		List<String> lines = DataStub.getLines();
		lines.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst()
		    .ifPresent(System.out::println);
	}
}
