package com.gauravbytes.java8.stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.gauravbytes.java8.stream.StreamSamples.Person;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamDistinctExample {
	public static void main(String[] args) {
		Collection<Person> persons = StreamSamples.getPersons();
		List<String> uniqueFirstNames = persons.stream().map(Person::getFirstName).distinct()
		    .collect(Collectors.toList());

		System.out.println(uniqueFirstNames);
	}
}
