package com.gauravbytes.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class CollectionImprovements {
	public static void main(String[] args) {
		concurrentMapNewFeatures();

		filteringWithStreams();
	}

	private static void filteringWithStreams() {
		List<String> values = Arrays.asList("Gaurav", "Rasham", "Aashi", "Leo", "aashi");
		List<String> filteredResults = values.stream().filter(s -> s.length() > 5).collect(Collectors.toList());
		System.out.println(filteredResults);
	}

	private static void concurrentMapNewFeatures() {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("One", "One");
		map.put("One1", "One");
		map.put("One11", "One");
		map.put("One111", "One");
		map.put("One1111", "One");

		map.forEachKey(2, k -> k.length(), System.out::println);
	}
}
