package com.nagarro.service;

import org.springframework.stereotype.Service;

import com.nagarro.model.Book;

public interface BookService {
	public Book[] getBook();
	public void addBook(Book book);
	public void updateBook(Book book,int id);
	public void deleteBook(int id);
}
