package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CourseService {
//public List<Course> getCourses();
//
//public Course getCourse(long courseId);
//public Course addCourse(Course course);
//public Course updateCourse(Course course);
//public void deleteCourse(long parseLong);
	public List<Author> getCourses();

	public Author getCourse(long courseId);
	public Author addCourse(Author course);
	public Author updateCourse(Author course);
	public void deleteCourse(long parseLong);


		
}
