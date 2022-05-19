package com.nagarro.entity;
/**
 * @author shubhamgoyal04
 * This is Book Entity class
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@Column(name = "bookid")
	private int bookId;

	@Column(name = "bookname")
	private String bookName;

	private String author;
	// knfkaejfla


	@Column(name = "modifieddate")
	private String currentDate;

	public int getBookCode() {
		return bookId;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return currentDate;
	}

	public void setDate(String currentDate) { 
		this.currentDate=currentDate;
	}
}
