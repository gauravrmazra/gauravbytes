package com.gauravbytes.java8.defaultmethods;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Java8DefaultMethods {

	static class Employee {
		private String firstName;
		private String lastName;
		private int age;

		public Employee(String firstName, String lastName, int age) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result
			    + ((firstName == null) ? 0 : firstName.hashCode());
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
			return "Employee [firstName=" + firstName + ", lastName=" + lastName
			    + ", age=" + age + "]";
		}
	}

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
		    new Employee("Gaurav", "Mazra", 27),
		    new Employee("Gaurav", "Sharma", 28),
		    new Employee("Gaurav", "Parshad", 26),
		    new Employee("Gautam", "Singh", 26),
		    new Employee("Gaudel", "Sarma", 26));
		Comparator<Employee> comp = Comparator.comparing(Employee::getFirstName)
		    .thenComparing(Employee::getAge);
		System.out.println(employees);
		Collections.sort(employees, comp);
		System.out.println(employees);
	}
}
