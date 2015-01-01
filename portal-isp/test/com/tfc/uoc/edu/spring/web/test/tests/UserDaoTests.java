package com.tfc.uoc.edu.spring.web.test.tests;

import static org.junit.Assert.*;
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
		"classpath:com/tfc/uoc/edu/spring/web/config/security-context.xml",
		"classpath:com/tfc/uoc/edu/spring/web/test/config/datasource.xml" })

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;
	
	private User user1 = new User("johnwpurcell", "John Purcell", "hellothere",
			"john@caveofprogramming.com", true, "ROLE_USER");
	private User user2 = new User("richardhannay", "Richard Hannay", "the39steps",
			"richard@caveofprogramming.com", true, "ROLE_ADMIN");
	private User user3 = new User("suetheviolinist", "Sue Black", "iloveviolins",
			"sue@caveofprogramming.com", true, "ROLE_USER");
	private User user4 = new User("rogerblake", "Rog Blake", "liberator",
			"rog@caveofprogramming.com", false, "user");

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from users");
	}

	@Test
	public void testCrearExtreure() {
		usersDao.create(user1);
		
		List<User> users1 = usersDao.getAllUsers();
		
		assertEquals("1 usuari ha de ser creat i extret",1,users1.size());		
		assertEquals("L'usuari insertat ha de coincidir amb l'usuari extret", user1, users1.get(0));
		
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		
		List<User> users2 = usersDao.getAllUsers();
		assertEquals("Hauria d'extreure 4 usuaris.", 4, users2.size());
	}
	
	@Test
	public void testExists() {
		usersDao.create(user2);
		usersDao.create(user3);		
		
		assertTrue("Ha d'existir.", usersDao.exists(user2.getUsername()));
		assertTrue("Ha d'existir.", usersDao.exists(user3.getUsername()));
		assertFalse("No ha d'existir.", usersDao.exists(user4.getUsername()));
		
		
	}
	
	
	@Test
	public void testUsers() {
		User user = new User("johnwpurcell", "John Purcell", "hellothere",
				"john@caveofprogramming.com", true, "user");

		usersDao.create(user);

		List<User> users = usersDao.getAllUsers();

		assertEquals("Number of users should be 1.", 1, users.size());

		assertTrue("Ha d'existir.", usersDao.exists(user.getUsername()));
		assertFalse("No ha d'existir.", usersDao.exists("asdalsdajsldkjasldkajlskd"));

		assertEquals("Created user should be identical to retrieved user",
				user, users.get(0));

	}

}
