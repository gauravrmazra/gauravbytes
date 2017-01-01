package com.gauravbytes.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class StreamFilteringExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Gaurav", "Sumit", "Raman", "Gagan");
		names.stream().filter((name) -> names.equals("Gaurav")).findFirst();
	}
}
