package com.reactive.reactivewebfluxapp.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.reactivewebfluxapp.entity.Book;

import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Integer>  {

	@Query(value = "SELECT * from book_details WHERE name LIKE :name")
	public Flux<Book> searchBooks(@Param(value = "name") String bookName);
	
}
