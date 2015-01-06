package com.tfc.uoc.edu.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@Transactional
@Component("usersDao")
public class UsersDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(User user, boolean updatePassword) {
		if(updatePassword) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		} else {
			user.setPassword(user.getPassword());
		}
		session().saveOrUpdate(user);
	}

	public boolean exists(String username) {
		Criteria criteria = session().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user  = (User)criteria.uniqueResult();
		return user != null;		
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return session().createQuery("from User").list();
	}

	public User getUser(String username) {
		Criteria criteria = session().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user  = (User)criteria.uniqueResult();
		return user;			
	}

	public void save(User user) {
		session().save(user);
		
	}

	public void update(User user, boolean updatePassword) {
		if(updatePassword) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		} else {
			user.setPassword(user.getPassword());
		}
		session().update(user);
	}

	public User getUser(int id) {
		Criteria criteria = session().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		User user  = (User)criteria.uniqueResult();
		return user;
	}

	public void delete(int id) {
		Query query = session()
				.createQuery("delete from User where id=:id");
		query.setLong("id", id);
		query.executeUpdate();
		
	}



}
