package com.nagarro.service.impl;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Book;
import com.nagarro.service.BookService;

@Component
public class BookServiceImpl implements BookService {

	private RestTemplate restTemplate=new RestTemplate();
	private String url="http://localhost:8082/books/";
	
	@Override
	public Book[] getBook() {
		ResponseEntity<Book[]> bookArray=restTemplate.getForEntity(url,Book[].class);
		Book[] book=bookArray.getBody();
		return book;
	}

	@Override
	public void addBook(Book book) {
		restTemplate.postForEntity(url, book, Book.class);
	}

	@Override
	public void updateBook(Book book, int id) {
		restTemplate.put(url+id,book);
	}

	@Override
	public void deleteBook(int id) {
		restTemplate.delete(url+id);
	}

}
