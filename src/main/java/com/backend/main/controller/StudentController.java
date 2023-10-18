package com.backend.main.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.main.model.Student;
import com.backend.main.service.StudentService;

@RestController
//@RequestMapping("/api/student/")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping("/Students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student studentdetails =studentService.saveStudent(student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(studentdetails.getStudentId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/Students")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping("/Students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
		return new ResponseEntity<Student>( studentService.getStudentById(id), HttpStatus.OK);
	}
	
	@PutMapping("/Students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
		return new ResponseEntity<Student>( studentService.updateStudent(id, student), HttpStatus.OK);
	}
	
	@DeleteMapping("/Students/{id}")
	public String deleteStudentById(@PathVariable("id") int id){
		return studentService.deleteStudent(id);
	}
}
