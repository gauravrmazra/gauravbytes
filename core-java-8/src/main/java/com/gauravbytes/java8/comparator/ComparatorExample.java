package com.gauravbytes.java8.comparator;

import java.util.Comparator;

import com.gauravbytes.java8.stream.StreamSamples.Person;

public class ComparatorExample {
	public static void main(String[] args) {
		Comparator<Person> byAge = (p1, p2) -> {
			return Integer.compare(p1.getAge(), p2.getAge());
		};

		Comparator<Person> byFirstName = (p1, p2) -> {
			return p1.getFirstName().compareTo(p2.getFirstName());
		};

		Comparator<Person> byAgeThenFirstName = byAge.thenComparing(byFirstName);

		Calculator sum = (a, b) -> Integer.sum(a, b);
		Calculator multiply = (a, b) -> a * b;
		Calculator divide = (a, b) -> a / b;

		System.out.println(sum.calculate(10, 20));
		System.out.println(multiply.calculate(10, 2));
		System.out.println(divide.calculate(20, 2));
	}

	@FunctionalInterface
	interface Calculator {
		public int calculate(int a, int b);
	}
}
