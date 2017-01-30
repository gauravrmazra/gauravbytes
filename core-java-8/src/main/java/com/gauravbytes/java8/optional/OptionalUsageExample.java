package com.gauravbytes.java8.optional;

import java.util.Optional;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class OptionalUsageExample {

	static class Person {
		private String firstName;
		private String lastName;
		private Address address;

		public Person(String firstName, String lastName, Address address) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public Address getAddress() {
			return address;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
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
			Person other = (Person) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
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
			return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address="
			    + address + "]";
		}

	}

	static class Address {
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

	public static void main(String[] args) {
		Optional<String> value = Optional.of("Gaurav");
		value.ifPresent(System.out::println);
		
		// bad
		if (value.isPresent()) {
			System.out.println(value.get());
		}
		else {
			System.err.println("Not found");
		}

		Person gaurav = new Person("Gaurav", "Mazra", new Address("Line 1", null, "Punjab"));
		String city = Optional.of(gaurav).map(Person::getAddress).map(Address::getCity)
		    .orElse("City Not Found");
		System.out.println(city);
		
		Person gauravWithCity = new Person("Gaurav", "Mazra", new Address("Mahilpur", "Hoshiarpur", "Punjab"));
		Optional.of(gauravWithCity).map(Person::getAddress).map(Address::getCity)
		    .ifPresent(System.out::println);

	}
}
