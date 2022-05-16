package com.nagarro.dao;

public interface UserDao {
	public boolean doesCredentialsMatch(String userName, String password);
}
