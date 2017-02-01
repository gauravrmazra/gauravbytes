package com.gauravbytes.java8.stream;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.gauravbytes.java8.stream.StreamSamples.Person;
import com.gauravbytes.java8.stream.StreamSamples.Gender;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ParallelStreamPerformanceTest {
	public static void main(String[] args) {
		Random random = new Random(0);
		List<Person> persons = new ArrayList<>(20000000);
		for (int i = 0; i < 20000000; i++) {
			persons.add(
			    new Person("G" + i, "M" + i, Gender.MALE, random.nextInt(60),
			        random.nextInt(50000)));
		}

		parallelStream(persons);
		sequentialStream(persons);

	}

	private static void sequentialStream(List<Person> persons) {
		LocalDateTime now = LocalDateTime.now();
		Map<Integer, List<Person>> results = persons.stream()
		    .collect(Collectors.groupingBy(Person::getAge));
		System.out.println(Duration.between(now, LocalDateTime.now()).getSeconds());
		consume(results);
	}

	private static void parallelStream(List<Person> persons) {
		LocalDateTime now = LocalDateTime.now();
		Map<Integer, List<Person>> results = persons.parallelStream()
		    .collect(Collectors.groupingBy(Person::getAge));
		System.out.println(Duration.between(now, LocalDateTime.now()).getSeconds());
		consume(results);
	}

	private static void consume(Map<Integer, List<Person>> results) {
		System.out.println(results.size());
	}
}
