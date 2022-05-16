package com.nagarro.model;
/**
 * 
 * @author shubhamgoyal04
 *  This is Book model
 */
public class Book {

	private int bookId;

	private String bookName;

	private String authorName;

	private String currentDate;

	public int getBookCode() {
		return bookId;
	}

	public Book(int bookId, String bookName, String authorName, String currentDate) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.currentDate = currentDate;
	}

	public Book() {

	}

	public void setBookCode(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDate() {
		return currentDate;
	}

	public void setDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}