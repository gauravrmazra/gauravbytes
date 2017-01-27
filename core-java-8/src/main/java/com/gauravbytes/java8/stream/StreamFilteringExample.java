package com.gauravbytes.java8.stream;

import java.util.List;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class StreamFilteringExample {
	public static void main(String[] args) {
		List<String> names = DataStub.getNames();
		names.stream().filter((name) -> names.equals("Gaurav")).findFirst();
	}
}
