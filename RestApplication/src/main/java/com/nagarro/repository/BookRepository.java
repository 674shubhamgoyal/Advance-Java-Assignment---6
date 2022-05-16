package com.nagarro.repository;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Book;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
