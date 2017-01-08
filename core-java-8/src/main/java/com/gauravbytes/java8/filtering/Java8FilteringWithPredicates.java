package com.gauravbytes.java8.filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Java8FilteringWithPredicates {
	static enum Sex {
		MALE, FEMALE;
	}

	static class Employee {
		private long id;
		private String firstName;
		private String lastName;
		private int age;
		private Sex sex;
		private int salary;

		public Employee(long id, String firstName, String lastName, int age, Sex sex, int salary) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.sex = sex;
			this.salary = salary;
		}

		public long getId() {
			return id;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public int getAge() {
			return age;
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
			result = prime * result + (int) (id ^ (id >>> 32));
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
			Employee other = (Employee) obj;
			if (age != other.age)
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id != other.id)
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
			return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", sex="
			    + sex + ", salary=" + salary + "]";
		}
	}

	public static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Gaurav", "Mazra", 29, Sex.MALE, 10000));
		employees.add(new Employee(2, "Rajesh", "Sundre", 32, Sex.MALE, 15000));
		employees.add(new Employee(3, "Kunal", "Kundra", 22, Sex.MALE, 33000));
		employees.add(new Employee(4, "Pankaj", "Kumar", 21, Sex.MALE, 25000));
		employees.add(new Employee(5, "Ramesh", "Singh", 33, Sex.MALE, 22000));
		employees.add(new Employee(6, "Suresh", "Mehra", 31, Sex.MALE, 8000));
		employees.add(new Employee(7, "Pinki", "Panchauty", 22, Sex.FEMALE, 45000));
		employees.add(new Employee(8, "Sweety", "Rehan", 45, Sex.FEMALE, 25500));
		employees.add(new Employee(9, "Jisha", "Rajput", 27, Sex.FEMALE, 22000));
		employees.add(new Employee(10, "Parul", "Verma", 26, Sex.FEMALE, 16000));
		employees.add(new Employee(11, "Sohna", "Sharma", 25, Sex.FEMALE, 26000));
		return employees;
	}

	public static void main(String[] args) {
		Predicate<Employee> male = e -> e.getSex() == Sex.MALE;
		Predicate<Employee> female = e -> e.getSex() == Sex.FEMALE;
		Predicate<Employee> ageLessThan30 = e -> e.getAge() < 30;
		Predicate<Employee> salaryLessThan20 = e -> e.getSalary() < 20000;
		Predicate<Employee> salaryGreaterThan25 = e -> e.getSalary() > 25000;
		Predicate<Employee> salaryLessThan20OrGreateThan25 = salaryLessThan20.or(salaryGreaterThan25);

		Predicate<Employee> allMaleSalaryLessThan20 = male.and(salaryLessThan20);
		Predicate<Employee> allMaleAgeLessThan30 = male.and(ageLessThan30);
		Predicate<Employee> allFemaleSalaryGreaterThan25 = female.and(salaryGreaterThan25);

		Predicate<Employee> allMaleSalaryLessThan20OrGreateThan25 = male.and(salaryLessThan20OrGreateThan25);

		List<Employee> employees = getEmployees();
		System.out.println("All employees");
		System.out.println(employees);
		System.out.println("\n\n");
		
		System.out.println("All Male Salary less than 20");
		System.out.println(employees.stream().filter(allMaleSalaryLessThan20).collect(Collectors.toList()));
		System.out.println("All male Age less than 30");
		System.out.println(employees.stream().filter(allMaleAgeLessThan30).collect(Collectors.toList()));
		System.out.println("All females salary greater than 25");
		System.out.println(employees.stream().filter(allFemaleSalaryGreaterThan25).collect(Collectors.toList()));
		
		System.out.println("All males salary either less than 20 or greater than 25");
		System.out.println(employees.stream().filter(allMaleSalaryLessThan20OrGreateThan25).collect(Collectors.toList()));
	}
}
