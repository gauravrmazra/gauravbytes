package com.gauravbytes.java8.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.gauravbytes.java8.stream.StreamSamples.Person;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class CreateStreamsExample {
	public static void main(String[] args) {
		Stream.of("This", "is", "how", "you", "create", "stream", "from", "static", "factory",
		    "method").map(s -> s.concat(" ")).forEach(System.out::print);
		System.out.println();

		Arrays.stream(new String[] { "This", "is", "how", "you", "create", "stream", ".",
		    "Above", "function", "use", "this" }).map(s -> s.concat(" "))
		    .forEach(System.out::print);
		System.out.println();

		Collection<Person> persons = StreamSamples.getPersons();
		persons.stream().forEach(System.out::println);

		// parallel stream
		persons.parallelStream().forEach(System.out::println);

		int sumOfFirst10PositiveNumbers = IntStream.range(1, 10).reduce(0, Integer::sum);
		System.out.println(sumOfFirst10PositiveNumbers);

		// iterate return infinite stream... beware of infinite streams
		Stream.iterate(1, i -> i++).limit(10).forEach(System.out::print);
		System.out.println();

		// random.ints for random number
		new Random().ints().limit(20).forEach(System.out::println);
		String myValue = "Gaurav Rocks\n you dope";

		try (BufferedReader br = new BufferedReader(new StringReader(myValue))) {
			br.lines().forEach(System.out::print);
			System.out.println();
		}
		catch (IOException io) {
			System.err.println("Got this:>>>> " + io);
		}
	}
}
