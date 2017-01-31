package com.gauravbytes.java8.stream;

import java.util.List;

import com.gauravbytes.java8.stream.StreamSamples.Person;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamReductionExample {
	public static void main(String[] args) {
		findLongestLine();

	}

	private static void findLongestLine() {
		List<String> lines = DataStub.getLines();
		lines.stream().reduce((a, b) -> a.length() > b.length() ? a : b)
		    .ifPresent(System.out::println);

		Integer value = StreamSamples.getPersons().stream().map(Person::getAge).reduce(0,
		    Integer::sum);
		System.out.println(value);
	}
}
