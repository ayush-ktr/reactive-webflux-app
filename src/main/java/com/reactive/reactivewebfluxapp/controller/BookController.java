package com.reactive.reactivewebfluxapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.reactivewebfluxapp.entity.Book;
import com.reactive.reactivewebfluxapp.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/book")
public class BookController {

	@Autowired
	BookService bookservice;

	@PostMapping
	public Mono<String> createBook(@RequestBody Book book) {
		return bookservice.createBook(book);
	}

	@GetMapping
	public Flux<Book> getAllBooks() {
		return bookservice.getAllBooks();
	}

	@GetMapping(path = "/{id}")
	public Mono<Book> getBookById(@PathVariable(name = "id") Integer id) {
		return bookservice.getBookById(id);
	}

	@PutMapping(path = "/{id}")
	public Mono<Book> updateBookById(@RequestBody Book book, @PathVariable(name = "id") Integer id) {
		return bookservice.updateBookById(book, id);
	}

	@DeleteMapping(path = "/{id}")
	public Mono<Void> deleteBookById(@PathVariable(name = "id") Integer id) {
		return bookservice.deleteBookById(id);
	}

	@GetMapping(path = "/search")
	public Flux<Book> searchBook(@RequestParam String query) {
		return bookservice.searchBooks(query);
	}

}
