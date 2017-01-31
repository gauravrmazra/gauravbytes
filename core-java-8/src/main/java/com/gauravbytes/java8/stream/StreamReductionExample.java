package com.gauravbytes.java8.stream;

import java.util.List;
import java.util.stream.IntStream;

import com.gauravbytes.java8.stream.StreamSamples.Person;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamReductionExample {
	public static void main(String[] args) {
		findLongestLine();

		Integer value = StreamSamples.getPersons().stream().map(Person::getAge).reduce(0,
		    Integer::sum);
		System.out.println("Sum of persons age: " + value);
		IntStream.range(1, 10).reduce(Integer::sum)
		    .ifPresent(sum -> System.out.println("Sum of 1 to 10: " + sum));
	}

	private static void findLongestLine() {
		List<String> lines = DataStub.getLines();
		lines.stream().reduce((a, b) -> a.length() > b.length() ? a : b)
		    .ifPresent(System.out::println);


	}
}
