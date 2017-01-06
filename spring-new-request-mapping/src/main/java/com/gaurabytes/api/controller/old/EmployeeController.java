package com.gaurabytes.api.controller.old;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurabytes.api.domain.Employee;
import com.gaurabytes.api.stub.EmployeeStub;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@RequestMapping
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(Collections.emptyList());
	}
	
	@RequestMapping("/{employeeId}")
	public ResponseEntity<Employee> findById(@PathVariable Long employeeId) {
		return ResponseEntity.ok(EmployeeStub.findById(employeeId));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(EmployeeStub.addEmployee(employee));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(EmployeeStub.updateEmployee(employee));
	}
	
	@RequestMapping(path = "/{employeeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long employeeId) {
		return ResponseEntity.ok(EmployeeStub.deleteEmployee(employeeId));
	}
}
