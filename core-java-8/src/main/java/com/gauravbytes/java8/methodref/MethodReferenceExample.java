package com.gauravbytes.java8.methodref;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class MethodReferenceExample {
	public static void main(String[] args) {
		instanceMethodReference();
	}

	private static void instanceMethodReference() {
		List<String> values = Arrays.asList("Gaurav", "Rasham", "Aashi", "Leo", "aashi");
		System.out.println(values);
		Collections.sort(values, String::compareToIgnoreCase);
		System.out.println(values);
	}
}
