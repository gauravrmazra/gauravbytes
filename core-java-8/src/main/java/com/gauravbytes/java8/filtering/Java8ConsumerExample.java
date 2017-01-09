package com.gauravbytes.java8.filtering;

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
		// fetch employees from Stub
		List<Employee> employees = EmployeeStub.getEmployees();
		// create a consumer on employee
		Consumer<Employee> employeeConsolePrinter = System.out::println;
		// use List's retrofitted method for iteration on employees and consume it
		employees.forEach(employeeConsolePrinter);

		BiConsumer<Long, Employee> employeeBiConsumer = (id, employee) -> System.out.println(id + " : " + employee);
		Map<Long, Employee> idToEmployeeMap = EmployeeStub.getEmployeeAsMap();
		idToEmployeeMap.forEach(employeeBiConsumer);
	}
}
