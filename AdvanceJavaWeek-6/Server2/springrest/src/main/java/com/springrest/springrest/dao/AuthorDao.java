package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Author;

public interface AuthorDao extends JpaRepository<Author,Long>{

}
