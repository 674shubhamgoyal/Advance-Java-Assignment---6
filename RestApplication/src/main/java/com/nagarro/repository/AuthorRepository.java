package com.nagarro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Author;




@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
