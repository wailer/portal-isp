package com.tfc.uoc.edu.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {
	
	private UsersDao usersDao;
	

	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public void create(User user) {
		usersDao.create(user);
		
	}

	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	public List<User> getUsers() {
		return usersDao.getAllUsers();
	}


}
