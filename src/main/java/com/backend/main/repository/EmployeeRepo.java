package com.backend.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.main.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
}
