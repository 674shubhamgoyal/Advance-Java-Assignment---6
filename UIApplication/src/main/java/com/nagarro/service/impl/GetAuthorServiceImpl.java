package com.nagarro.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Author;
import com.nagarro.service.GetAuthorService;

@Repository
public class GetAuthorServiceImpl implements GetAuthorService{

	@Override
	public Author[] getAuthor() {
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<Author[]> responseEntity=restTemplate.getForEntity("http://localhost:8082/author",Author[].class);
		return responseEntity.getBody();
	}

}
