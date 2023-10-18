package com.backend.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.main.model.Employee;
import com.backend.main.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		System.out.println(emp);
		return new ResponseEntity<Employee>(empService.saveEmployee(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/test")
	public String test(){
		return "test Ok";
	}
	
}
