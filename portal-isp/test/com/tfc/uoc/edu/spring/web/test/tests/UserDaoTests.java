package com.tfc.uoc.edu.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/tfc/uoc/edu/spring/web/config/dao-context.xml",
		"classpath:com/tfc/uoc/edu/spring/web/config/datasource.xml",
		"classpath:com/tfc/uoc/edu/spring/web/config/security-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);		
		jdbc.execute("delete from users");
		jdbc.execute("delete from authorities");
	}

	@Test
	public void testUsers() {
		User user = new User("Eduard", "12345", true, "user", "eduardgubert@hotmail.com");

		assertTrue("User creation should return true", usersDao.create(user));

		List<User> users = usersDao.getAllUsers();

		assertEquals("Number of users should be 1.", 1, users.size());

		assertTrue("User should exist.", usersDao.exists(user.getUsername()));

		assertEquals("Created user should be identical to retrieved user",
				user, users.get(0));

	}

}

