package com.gauravbytes.java8.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import com.gauravbytes.java8.stream.StreamSamples.Person;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamMappingExample {
	public static void main(String[] args) {
		StreamSamples.getPersons().stream().mapToInt(Person::getAge)
		    .average().ifPresent(System.out::println);

		StreamSamples.getPersons().stream().mapToInt(Person::getAge).max()
		    .ifPresent(System.out::println);

		StreamSamples.getPersons().stream().mapToInt(Person::getAge).min()
		    .ifPresent(System.out::println);
		
		//better way
		IntSummaryStatistics summaryStats = StreamSamples.getPersons().stream()
		    .map(Person::getAge)
		    .collect(Collectors.summarizingInt(t -> t));

		System.out.println(summaryStats);

	}
}
