package com.nagarro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.dto.BookData;
import com.nagarro.entity.Author;
import com.nagarro.entity.Book;
import com.nagarro.exception.BookNotFoundException;

@Service
public interface BookService {
	public List<BookData> getAllData();
	public void delete(int id) throws BookNotFoundException;
	public void update(Book book,int id) throws BookNotFoundException;
	public void insertBook(BookData bookData);
}
