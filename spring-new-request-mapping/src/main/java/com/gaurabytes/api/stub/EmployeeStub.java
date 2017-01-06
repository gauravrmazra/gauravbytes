package com.gaurabytes.api.stub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.gaurabytes.api.domain.Employee;

public class EmployeeStub {
	private static final ConcurrentMap<Long, Employee> employees = new ConcurrentHashMap<>();
	
	public static List<Employee> getAll() {
		return new ArrayList<>(employees.values());
	}
	
	public static Employee findById(Long id) {
		return employees.get(id);
	}
	
	public static Employee addEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
		return employee;
	}
	
	public static Employee updateEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
		return employee;
	}
	
	public static Employee deleteEmployee(Long id) {
		return employees.remove(id);
	}
}
