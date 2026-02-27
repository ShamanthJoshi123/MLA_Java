package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee/v1/api")
@Tag(name="EMPLOYEE CRUD OPERATIONS")
public class EmployeeController {
	@Autowired 
	private EmployeeService service;
	@PostMapping("/create")
	@Operation(summary = "CREATE EMPLOYEE")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		Employee eobj = service.saveEmployee(emp);
		if(eobj!=null) {
			return new ResponseEntity<>(eobj,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(eobj,HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/list")
	@Operation(summary = "Listing all employees")
	public ResponseEntity<List<Employee>> listAllEmployees(){
		List<Employee> list = service.getAllEmployees();
		if(list.size()>0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id){
		Optional<Employee> emp = service.getEmployeeById(id);
		if(emp != null) {
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(emp, HttpStatus.NO_CONTENT);
		}
	}
	@PutMapping(value="/{id}",consumes="application/json")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee employee){
		employee.setId(id);
		Employee emp = service.updateEmployee(employee);
		if(emp != null) {
			return new ResponseEntity<>(emp,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(emp, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping(value="/{id}",produces="application/json")
	public ResponseEntity<List<Employee>> deleteEmployeeById(@PathVariable int id){
		List<Employee> list = service.deleteEmployeeById(id);
		if(list.size()>0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
		}
	}
	
}
