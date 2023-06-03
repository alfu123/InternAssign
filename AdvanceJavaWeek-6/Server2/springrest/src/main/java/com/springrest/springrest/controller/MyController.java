package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Author;

import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService cs;
	
	@GetMapping("/home")
	public String home() {
		return "this is my home";
	}
	
	@GetMapping("/authors")
	public List<Author> getCourses(){
		return this.cs.getCourses();
	}
	
	@GetMapping("/author/{authorId}")
	public Author getCourse(@PathVariable String authorId){
		return this.cs.getCourse(Long.parseLong(authorId));
	}
	
	@PostMapping("/authors")
	public Author addCourse(@RequestBody Author course) {
		return this.cs.addCourse(course);
	}
	

	@PutMapping("/authors")
	public Author updateCourse(@RequestBody Author course) {
		return this.cs.updateCourse(course);
	}
	
	@DeleteMapping("/authors/{authorId}")

	public ResponseEntity<HttpStatus> deleteCourse (@PathVariable String authorId) {
	try {

	this.cs.deleteCourse (Long.parseLong (authorId));

	return new ResponseEntity<> (HttpStatus.OK);

	} catch (Exception e) {

	return new ResponseEntity<>(HttpStatus. INTERNAL_SERVER_ERROR);

	}

	}

	
}
