package com.backend.main.service;

import java.util.List;

import com.backend.main.model.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	
	List<Student> getStudents();
	
	Student getStudentById(int id);
	
	Student updateStudent(int id, Student student);
	
	String deleteStudent(int id);

}
