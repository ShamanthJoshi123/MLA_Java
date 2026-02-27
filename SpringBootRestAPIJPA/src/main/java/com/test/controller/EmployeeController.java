package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
