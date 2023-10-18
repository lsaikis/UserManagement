package com.backend.main.service.impl;

import org.springframework.stereotype.Service;

import com.backend.main.model.Employee;
import com.backend.main.repository.EmployeeRepo;
import com.backend.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo empRepo ;
	
	public EmployeeServiceImpl(EmployeeRepo empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	
}
