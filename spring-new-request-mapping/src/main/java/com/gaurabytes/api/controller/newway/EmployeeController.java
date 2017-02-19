package com.gaurabytes.api.controller.newway;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(EmployeeStub.getAll());
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> findById(@PathVariable Long employeeId) {
		return ResponseEntity.ok(EmployeeStub.findById(employeeId));
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		EmployeeStub.addEmployee(employee);
		return ResponseEntity.created(URI.create("/" + employee.getId())).build();
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		EmployeeStub.updateEmployee(employee);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(path = "/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
		EmployeeStub.deleteEmployee(employeeId);
		return ResponseEntity.ok("DELETED");
	}
}
