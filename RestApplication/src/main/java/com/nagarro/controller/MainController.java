package com.nagarro.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dto.BookData;
import com.nagarro.entity.Author;
import com.nagarro.entity.Book;
import com.nagarro.exception.BookNotFoundException;
import com.nagarro.services.AuthorService;
import com.nagarro.services.BookService;


@RestController
public class MainController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookData>> getBooks() { 
		List<BookData> allData = bookService.getAllData();
		
		if (allData != null && allData.size() > 0) {
			return new ResponseEntity<>(allData,HttpStatus.OK);
		}else {
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/books")
	public void postHome(@RequestBody BookData bookData) {
		bookService.insertBook(bookData);
		System.out.println(bookData.getAuthorName());
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity delete(@PathVariable("id") int id) {
		try {
			bookService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (BookNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>("No book Found with given id", HttpStatus.BAD_REQUEST);

		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Object> update(@RequestBody BookData bookData,@PathVariable("id") int id) {
		try {
			Book book = new Book();
			book.setBookCode(bookData.getBookCode());
			book.setBookName(bookData.getBookName());
			book.setDate(bookData.getDate());
			book.setAuthor(bookData.getAuthorName());
			bookService.update(book,id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			 return new ResponseEntity<>("No book Found with given id",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/author")
	public List<Author> getAuthor() {
		return authorService.getAuthor();
	}
}
