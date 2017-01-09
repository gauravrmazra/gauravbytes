package com.gauravbytes.java8.filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.gauravbytes.java8.filtering.Employee.Sex;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class EmployeeStub {
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

	public static Map<Long, Employee> getEmployeeAsMap() {
		return getEmployees().stream().collect(Collectors.toMap(Employee::getId, e -> e));
	}
}
