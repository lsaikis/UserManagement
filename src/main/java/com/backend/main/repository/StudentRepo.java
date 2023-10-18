package com.backend.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.main.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	
}
