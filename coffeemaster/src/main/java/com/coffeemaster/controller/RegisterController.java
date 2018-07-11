package com.coffeemaster.controller;

import javax.annotation.ManagedBean;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.coffeemaster.dao.UserDao;
import com.coffeemaster.model.User;

/**
 * @author adil
 *
 */
@Named
@ManagedBean
@Scope("request")
public class RegisterController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private User user = new User();
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * @return
	 */
	public String register()
	{
		userDao.save(this.user);
		logger.info("Person will be saved ");
		return "login";
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	

}
