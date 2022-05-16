package com.nagarro.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.model.Book;
import com.nagarro.service.BookService;
import com.nagarro.service.GetAuthorService;
import com.nagarro.service.UserService;
@Controller
public class MainController {
	private String username;
	@Autowired
	private UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	private GetAuthorService getAuthorService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model model) throws IOException {
		if (userService.doesCredentialsMatch(username, password)) {
			model.addAttribute("uname",username);
			this.username = username;
		     Book[] book=bookService.getBook();
			model.addAttribute("bookArray",book);
			System.out.println("User logged in");
		
			return "libraryPage.jsp";
		} else {
			System.out.println("User not authorized");
			
			model.addAttribute("alert", "true");
			return "Welcome.jsp";
		}
		
	}
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logout() {
		return "Welcome.jsp";
	}
	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	public String addBook(@RequestParam(value="bookId") int bookId,@RequestParam(value="bookName") String bookName
				,Model model,@RequestParam(value="author") String author,@RequestParam("date") String date) {
		Book book=new Book(bookId,bookName,author,date);
		bookService.addBook(book);
		System.out.println(author);
		model.addAttribute("uname",this.username);
		Book[] b=bookService.getBook();
		model.addAttribute("bookArray",b);
		return "libraryPage.jsp";
	}
	@RequestMapping(value="/addBook",method=RequestMethod.GET)
	public String addBook(Model m) {
		m.addAttribute("authorList", getAuthorService.getAuthor());
		return "addBook.jsp";
	}
	@RequestMapping(value="/editBook",method=RequestMethod.POST)
	public String editBook( Model model,@RequestParam("bookname") String bookName,@RequestParam("author") String authorName,
			 @RequestParam("id") int bookId,@RequestParam("date") String date) {
		Book book=new Book(bookId,bookName,authorName,date);
		bookService.updateBook(book, bookId);
		model.addAttribute("uname",username);
		Book[] b=bookService.getBook();
		model.addAttribute("bookArray",b);
		return "libraryPage.jsp";
	}
	@RequestMapping("/deleteBook")
	public String deleteBook(Model model,@RequestParam("bookCode") int bookCode) {
		bookService.deleteBook(bookCode);
		model.addAttribute("uname",username);
		Book[] book=bookService.getBook();
		model.addAttribute("bookArray",book);
		return "libraryPage.jsp";
	}
	
}
