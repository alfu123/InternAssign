package com.springrest.springrest.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Author {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	private long id;
	private String author;
	private String book;
	public Author() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setTitle(String author) {
		this.author = author;
	}
	public String getBook() {
		return book;
	}
	public void setDescription(String book) {
		this.book = book;
	}
	public Author(long id, String author, String book) {
		super();
		this.id = id;
		this.author = author;
		this.book = book;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" +author + ", description=" +book + "]";
	}

}
