package com.backend.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.main.exception.ResourceNotFoundException;
import com.backend.main.model.Student;
import com.backend.main.repository.StudentRepo;
import com.backend.main.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepo studentRepo;
	
	
	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}


	@Override
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}


	@Override
	public Student getStudentById(int id) {
		return studentRepo.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Student","Id",id));
	}


	@Override
	public Student updateStudent(int id, Student student) {
		
		Student existingStudent = studentRepo.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Student","Id",id));
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setCourse(student.getCourse());
		
		studentRepo.save(existingStudent);
		return existingStudent;
	}


	@Override
	public String deleteStudent(int id) {
		
		if(studentRepo.existsById(id)){
			studentRepo.deleteById(id);
			return "Student deleted by id : " +id;
		}else {
			return "Student doen't exits with given Id : "+id;
		}
		
		
	}

}
