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
	
	public void saveOrUpdate(User user, boolean updatePassword) {
		usersDao.saveOrUpdate(user, updatePassword);		
	}

	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	public List<User> getUsers() {
		return usersDao.getAllUsers();
	}

	public User getUser(String username) {
		return usersDao.getUser(username);
		
	}

	public void save(User user) {
		usersDao.save(user);
		
	}

	public void update(User user) {
		usersDao.update(user,false);		
	}

	public void updatePassword(User user) {
		usersDao.update(user,true);
	}

	public User getUser(int id) {
		return usersDao.getUser(id);		
	}

	public void delete(int id) {
		usersDao.delete(id);		
	}


}
