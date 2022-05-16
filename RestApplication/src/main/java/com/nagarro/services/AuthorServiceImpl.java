package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.entity.Author;
import com.nagarro.repository.AuthorRepository;


@Component
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public List<Author> getAuthor() {
		return (List<Author>) authorRepository.findAll();
	}

}
