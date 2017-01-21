package com.gauravbytes.java8.methodref;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class MethodReferenceExample {
	static class Job {
		private String jobName;

		public Job (String jobName) {
			this.jobName = jobName;
		}
		
		@Override
		public String toString() {
			return "[job: " + jobName + "]";
		}
	}
	
	static class Employee {
		private String firstName;
		private String lastName;
		private int age;
		
		Employee(String firstName, String lastName, int age) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
			Employee other = (Employee) obj;
			if (age != other.age)
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
		}
	}
	
	public static int compareByAge(Employee first, Employee second) {
		return Integer.compare(first.age, second.age);
	}
	public static void main(String[] args) {
		instanceMethodReference();
		staticMethodReference();
		constructorReference();
		
	}
	
	private static void staticMethodReference() {
		Comparator<Employee> ageComparator = MethodReferenceExample::compareByAge;

		//above is equivalent to below one
		//Comparator<Employee> ageComparator2 = (first, second) -> MethodReferenceExample.compareByAge(first, second);
		List<Employee> employees = Arrays.asList(new Employee("Gaurav", "Mazra", 27), new Employee("Mohan", "Sharma", 29), new Employee("Gurpreet", "Singh", 24));
		System.out.println(employees);
		
		Collections.sort(employees, ageComparator);
		System.out.println(employees);
		
	}
	
	private static void constructorReference() {
		Function<String, Job> jobCreator = Job::new;
		// this is equivalent to 
		//Function<String, Job> jobCreator2 = (jobName) -> new Job(jobName);
		
		System.out.println(jobCreator.apply("Create a new task"));
	}

	private static void instanceMethodReference() {
		Comparator<String> stringIgnoreCase = String::compareToIgnoreCase;
		// this is equivalent to below
		//Comparator<String> stringIgnoreCase2 = (first, second) -> first.compareToIgnoreCase(second);
		List<String> values = Arrays.asList("Gaurav", "Sunil", "Anil", "Rajesh", "sajjad");
		System.out.println(values);
		
		
		Collections.sort(values, stringIgnoreCase);
		System.out.println(values);
	}
}
