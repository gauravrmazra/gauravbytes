package com.gauravbytes.java8.filtering;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.gauravbytes.java8.filtering.Employee.Sex;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Java8FilteringWithPredicates {

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

		List<Employee> employees = EmployeeStub.getEmployees();
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
