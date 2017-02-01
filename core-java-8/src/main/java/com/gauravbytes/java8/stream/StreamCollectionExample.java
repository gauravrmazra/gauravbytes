package com.gauravbytes.java8.stream;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.gauravbytes.java8.stream.StreamSamples.Person;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamCollectionExample {
	public static void main(String[] args) {
		Collection<Person> persons = StreamSamples.getPersons();
		List<String> firstNameOfPersons = persons.stream().map(Person::getFirstName)
		    .collect(Collectors.toList());
		System.out.println(firstNameOfPersons);

		Map<Integer, List<Person>> personByAge = persons.stream()
		    .collect(Collectors.groupingBy(Person::getAge));
		System.out.println(personByAge);

		Double averageAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
		System.out.println(averageAge);

		Long totalPersons = persons.stream().collect(Collectors.counting());
		System.out.println(totalPersons);

		IntSummaryStatistics personsAgeSummary = persons.stream()
		    .collect(Collectors.summarizingInt(Person::getAge));

		System.out.println(personsAgeSummary);

		String allPersonsFirstName = persons.stream()
		    .collect(Collectors.mapping(Person::getFirstName, Collectors.joining("#")));
		System.out.println(allPersonsFirstName);

		// concurrent reduction with parallel stream
		ConcurrentMap<Integer, List<Person>> personByAgeConcurrent = persons.stream()
		    .collect(Collectors.groupingByConcurrent(Person::getAge));
		System.out.println(personByAgeConcurrent);
	}
}
