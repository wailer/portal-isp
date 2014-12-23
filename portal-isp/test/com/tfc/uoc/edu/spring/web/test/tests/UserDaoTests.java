package com.tfc.uoc.edu.spring.web.test.tests;

import static org.junit.Assert.*;

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
		"classpath:com/tfc/uoc/edu/spring/web/config/security-context.xml",
		"classpath:com/tfc/uoc/edu/spring/web/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("DELETE FROM users");
		jdbc.execute("DELETE FROM authorities");

	}

	@Test
	public void testCreateUser() {
		assertEquals("Dummy test", 1, 1);
		User user = new User("John", "hello", true, "user", "john@j2ee.com");
		

		assertTrue("User creation shouldreturn true", usersDao.create(user));

	}

}
