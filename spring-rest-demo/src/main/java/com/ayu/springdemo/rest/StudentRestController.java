package com.ayu.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayu.springdemo.entity.Student;
import javax.annotation.PostConstruct;
@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStu ;
	
	//define @PostContruct to load the student data .. only once 
	
	
	@PostConstruct
	public void loadData() {
        theStu = new ArrayList<>();
		
		theStu.add(new Student("Ayush" , "Rastogi"));
		theStu.add(new Student("Suyash" , "Rastogi"));
		theStu.add(new Student("Amesh" , "Rastogi"));
	}
	
   
	// define endpoint for "/student" - return list of all student 
	
	@GetMapping("/students")
	public List<Student> getStudents(){
	
		
		return theStu ;
	}
	
	//define endpoint for "/students/{studentyId}" - return student at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// just index into the list -- keep it simple as of now 
		
		
		//check the studentId against the lit size
		
		if((studentId>= theStu.size())|| (studentId<0 )) {
			
			throw new StudentNotFoundException("Student id not found - " + studentId);
		
		}
		return theStu.get(studentId);
		
		
	}
	

}
