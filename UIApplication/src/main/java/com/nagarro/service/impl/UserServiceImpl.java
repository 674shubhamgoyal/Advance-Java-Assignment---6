package com.nagarro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.dao.UserDao;
import com.nagarro.service.UserService;

@Component
public class UserServiceImpl implements UserService  {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean doesCredentialsMatch(String userName, String password) {
		return userDao.doesCredentialsMatch(userName, password);
	}
	
}
