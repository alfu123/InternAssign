package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.AuthorDao;

import com.springrest.springrest.entities.Author;


@Service
public class CourseServiceimpl implements CourseService {
	
	@Autowired()
	private AuthorDao authorDao;


	public CourseServiceimpl() {

	}

	@Override
	public List<Author> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return authorDao.findAll();
	}



	@SuppressWarnings("deprecation")
	@Override
	public Author getCourse(long courseId) {

		return authorDao.getOne(courseId);
	}

	@Override
	public Author addCourse(Author course) {
		// TODO Auto-generated method stub
	//list.add(course);
		authorDao.save(course);

		return course;
	}

	@Override
	public Author updateCourse(Author course) {
		// TODO Auto-generated method stub

		
		authorDao.save(course);

	return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		//list=this.list.stream().filter (e->e.getId() !=parseLong).collect(Collectors.toList());
		Author entity=authorDao.getOne(parseLong);
		authorDao.delete(entity);
	
	
	}
	
	


}
