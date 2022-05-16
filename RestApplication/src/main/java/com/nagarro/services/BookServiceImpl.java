package com.nagarro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.dto.BookData;
import com.nagarro.entity.Book;
import com.nagarro.exception.BookNotFoundException;
import com.nagarro.repository.BookRepository;

@Component
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorService authorService;
	public List<BookData> getAllData() {
		List<Book> booksFound = (List<Book>) bookRepository.findAll();

		List<BookData> booksDataList = new ArrayList<BookData>();
		for (Book bookEntity : booksFound) {
			BookData bookData = new BookData();
			bookData.setAuthorName(bookEntity.getAuthor());
			bookData.setBookCode(bookEntity.getBookCode());
			bookData.setBookName(bookEntity.getBookName());
			bookData.setDate(bookEntity.getDate());
			booksDataList.add(bookData);
		}
		return booksDataList;
	}

	public void delete(int id) throws BookNotFoundException {

		Optional<Book> book = bookRepository.findById(id);

		if (book == null || !book.isPresent()) {
			throw new BookNotFoundException("Book not found with id " + id);
		}

		bookRepository.deleteById(id);
	}

	public void update(Book book, int id) throws BookNotFoundException {
		Optional<Book> temp = bookRepository.findById(id);

		if (temp == null || !temp.isPresent()) {
			throw new BookNotFoundException("Book not found with id " + id);
		}

		book.setBookCode(id);
		bookRepository.save(book);
	}

	public void insertBook(BookData bookData) {
		Book book = new Book();
		book.setBookCode(bookData.getBookCode());
		book.setBookName(bookData.getBookName());
		book.setDate(bookData.getDate());
		book.setAuthor(bookData.getAuthorName());
		
		
		
		bookRepository.save(book);
	}

}
