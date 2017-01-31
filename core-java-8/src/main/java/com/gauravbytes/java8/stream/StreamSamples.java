package com.gauravbytes.java8.stream;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class StreamSamples {
	public static enum Sex {
		MALE, FEMALE;
	}

	public static class Person {
		private String firstName;
		private String lastName;
		private Sex sex;
		private int age;
		private int salary;

		public Person(String firstName, String lastName, Sex sex, int age, int salary) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.sex = sex;
			this.age = age;
			this.salary = salary;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public int getAge() {
			return this.age;
		}

		public Sex getSex() {
			return sex;
		}

		public int getSalary() {
			return salary;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + salary;
			result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
			if (salary != other.salary)
				return false;
			if (sex != other.sex)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex
			    + ", age=" + age + ", salary=" + salary + "]";
		}
	}

	public static class Address {
		private String streetAddress;
		private String city;
		private String state;

		public Address(String streetAddress, String city, String state) {
			super();
			this.streetAddress = streetAddress;
			this.city = city;
			this.state = state;
		}

		public String getStreetAddress() {
			return streetAddress;
		}

		public String getCity() {
			return city;
		}

		public String getState() {
			return state;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
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
			Address other = (Address) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (state == null) {
				if (other.state != null)
					return false;
			} else if (!state.equals(other.state))
				return false;
			if (streetAddress == null) {
				if (other.streetAddress != null)
					return false;
			} else if (!streetAddress.equals(other.streetAddress))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Address [streetAddress=" + streetAddress + ", city=" + city + ", state="
			    + state + "]";
		}

	}

	public static Collection<Person> getPersons() {
		return Arrays.asList(new Person("Gaurav", "Mazra", Sex.MALE, 28, 10000),
		    new Person("Gaurav", "Mazra", Sex.MALE, 28, 10000),
		    new Person("Sandeep", "Shukla", Sex.MALE, 24, 5000),
		    new Person("Rami", "Aggarwal", Sex.FEMALE, 32, 12000),
		    new Person("Jiya", "Khan", Sex.FEMALE, 22, 4500),
		    new Person("Rajesh", "Kumar", Sex.MALE, 45, 55000),
		    new Person("Rampal", "Yadav", Sex.MALE, 35, 12000),
		    new Person("Nisha", "Sharma", Sex.FEMALE, 26, 10000),
		    new Person("Neha", "Kapoor", Sex.FEMALE, 21, 5500),
		    new Person("Ramesh", "Chander", Sex.MALE, 22, 2500),
		    new Person("Parul", "Mehta", Sex.FEMALE, 25, 8500),
		    new Person("Sunil", "Kumar", Sex.MALE, 27, 6875),
		    new Person("Prekha", "Verma", Sex.FEMALE, 20, 3600),
		    new Person("Neeraj", "Shah", Sex.MALE, 25, 33000));
	}
}
