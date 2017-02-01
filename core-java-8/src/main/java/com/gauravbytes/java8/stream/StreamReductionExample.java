package com.gauravbytes.java8.stream;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
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

		// reduction
		Collection<Person> persons = StreamSamples.getPersons();
		Integer value = persons.stream().map(Person::getAge).reduce(0,
		    Integer::sum);
		System.out.println("Sum of persons age: " + value);

		IntStream.range(1, 10).reduce(Integer::sum)
		    .ifPresent(sum -> System.out.println("Sum of 1 to 10: " + sum));

		// average age
		persons.stream().mapToInt(Person::getAge).average()
		    .ifPresent(System.out::println);

		// max age from stream
		persons.stream().mapToInt(Person::getAge).max()
		    .ifPresent(System.out::println);

		// min age from stream
		persons.stream().mapToInt(Person::getAge).min()
		    .ifPresent(System.out::println);

		// better way
		IntSummaryStatistics summaryStats = persons.stream()
		    .map(Person::getAge).collect(Collectors.summarizingInt(t -> t));
		System.out.println(summaryStats);

		int sumOfFirst10 = IntStream.range(1, 10).reduce(0, Integer::sum);
		System.out.println(sumOfFirst10);

		int sumOfFirst10Parallel = IntStream.range(1, 10).parallel().reduce(0, Integer::sum);
		System.out.println(sumOfFirst10Parallel);

		/*
		 * List<String> names = Arrays.asList("Mohan", "Sohan", "Ramesh"); String
		 * result = names.stream().reduce("-", (s1, s2) -> {
		 * System.out.println("First func:  " + s1 + " :: " + s2); return s1 + s2;
		 * }, (p, q) -> { System.out.println("second func:  " + p + " :: " + q);
		 * return p + q; }); System.out.println(result);
		 */
	}

	private static void findLongestLine() {
		List<String> lines = DataStub.getLines();
		lines.stream().reduce((a, b) -> a.length() > b.length() ? a : b)
		    .ifPresent(System.out::println);
	}
}
