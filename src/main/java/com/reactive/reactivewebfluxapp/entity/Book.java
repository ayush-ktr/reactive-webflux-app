package com.reactive.reactivewebfluxapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {

	@Id
	@Column("book_id")
	private int bookId;

	@Column("name")
	private String name;

	@Column("book_desc")
	private String description;

	@Column("publisher")
	private String publisher;

	@Column("author")
	private String author;

	public int getBookId() {
		return bookId;
	}

	public Book setBookId(int bookId) {
		this.bookId = bookId;
		return this;
	}

	public String getName() {
		return name;
	}

	public Book setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Book setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getPublisher() {
		return publisher;
	}

	public Book setPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public Book setAuthor(String author) {
		this.author = author;
		return this;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", description=" + description + ", publisher=" + publisher
				+ ", author=" + author + "]";
	}

}
