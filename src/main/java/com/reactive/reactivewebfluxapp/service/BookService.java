package com.reactive.reactivewebfluxapp.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.reactivewebfluxapp.entity.Book;
import com.reactive.reactivewebfluxapp.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Mono<String> createBook(Book book) {
		return bookRepository.save(book).map(e -> "Book created Successfully..!!, Id: " + e.getBookId());
	}

	public Flux<Book> getAllBooks() {
		return bookRepository.findAll().delayElements(Duration.ofSeconds(3));
	}

	public Mono<Book> getBookById(Integer id) {
		return bookRepository.findById(id);
	}

	public Mono<Book> updateBookById(Book book, Integer id) {
		return bookRepository.save(book.setBookId(id));
	}

	public Mono<Void> deleteBookById(Integer id) {
		return bookRepository.deleteById(id);
	}

	public Flux<Book> searchBooks(String query) {
		return bookRepository.searchBooks("%" + query + "%");
	}

}
