package com.gauravbytes.java8.stream;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ParallelStreamPerformanceTest {
	static class Person {
		private int age;
		private String name;

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	public static void main(String[] args) {
		Random random = new Random(0);
		String[] names = new String[] { "Gaurav", "Sumit", "Rajesh", "Punit", "Brijesh" };
		List<Person> persons = new ArrayList<>(20000000);
		for (int i = 0; i < 20000000; i++) {
			persons.add(new Person(random.nextInt(55), names[random.nextInt(4)]));
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
