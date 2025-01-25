package com.stdproject.api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stdproject.api.Repository.StudentRepository;
import com.stdproject.api.entity.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	// Get all students data
	//localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students = repo.findAll();
		
		return students;
	}
	
	//localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
		
	}
	
	// create data
	
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody Student student){
		repo.save(student);
	}

	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		  Student student = repo.findById(id).get();
		  student.setName("Niki");
		  student.setPercentage(94);
		  repo.save(student);
		  return student;
		  
		
	}
	@DeleteMapping("/student/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		  Student student = repo.findById(id).get();
		  repo.delete(student);

	}
	

}
