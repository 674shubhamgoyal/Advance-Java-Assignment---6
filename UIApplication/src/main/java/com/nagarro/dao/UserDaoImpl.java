package com.nagarro.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.entity.User;




@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("deprecation")
	public boolean doesCredentialsMatch(String userName , String password) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from User WHERE userName =:uname ");
		q.setParameter("uname",userName);
		List<User> list = q.list();
		
		return matchEncryptedPassword(list.get(0).getPassword(), password);
	}
	private  boolean matchEncryptedPassword(String password1, String password2) { 
	        String encryptedpassword = null;  
	        try   
	        {   
	            MessageDigest m = MessageDigest.getInstance("MD5");       
	            m.update(password2.getBytes()); 
	            byte[] bytes = m.digest();   
	            StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }   
	            encryptedpassword = s.toString();  
	        }   
	        
	        catch (NoSuchAlgorithmException e)   
	        {  
	            e.printStackTrace();  
	        }  
		return encryptedpassword.equals(password1);
		
	}
	
}
