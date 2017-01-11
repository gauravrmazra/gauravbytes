package com.gauravbytes.java8.filtering;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Java8ConsumerExample {
	public static void main(String[] args) {
		preJava8CollectionIteration();
		postJava8CollectionIteration();
		
		BiConsumer<Long, Employee> employeeBiConsumer = (id, employee) -> System.out.println(id + " : " + employee);
		Map<Long, Employee> idToEmployeeMap = EmployeeStub.getEmployeeAsMap();
		idToEmployeeMap.forEach(employeeBiConsumer);
	}

	public static void preJava8CollectionIteration() {
		List<Employee> employees = EmployeeStub.getEmployees();
		Iterator<Employee> employeeItr = employees.iterator();
		Employee employee;
		while (employeeItr.hasNext()) {
			employee = employeeItr.next();
			System.out.println(employee);
		}
	}

	public static void postJava8CollectionIteration() {
		// fetch employees from Stub
		List<Employee> employees = EmployeeStub.getEmployees();
		// create a consumer on employee
		Consumer<Employee> consolePrinter = System.out::println;
		// use List's retrofitted method for iteration on employees and consume it
		employees.forEach(consolePrinter);
	}
}
