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
	
	private User user1 = new User("test1", "test1", true, "ROLE_USER", "test1@tfc.uoc", "usuari1", "de test1", "12345678K", "972000001", "C/ test nº1", "17241", "Quart", "Testing1 S.L.");
	private User user2 = new User("test2", "test2", true, "ROLE_USER", "test2@tfc.uoc", "usuari2", "de test2", "22345678K", "972000002", "C/ test nº2", "17242", "Quart", "Testing2 S.L.");
	private User user3 = new User("test3", "test3", true, "ROLE_USER", "test3@tfc.uoc", "usuari3", "de test3", "32345678K", "972000003", "C/ test nº3", "17243", "Quart", "Testing3 S.L.");
	private User user4 = new User("test4", "test4", true, "ROLE_USER", "test4@tfc.uoc", "usuari4", "de test4", "42345678K", "972000004", "C/ test nº4", "17244", "Quart", "Testing4 S.L.");
	private User user5 = new User("test5", "test5", true, "ROLE_ADMIN", "test5@tfc.uoc", "usuari5", "de test4", "52345678K", "972000005", "C/ test nº5", "17245", "Quart", "Testing5 S.L.");
	
	

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from users");
	}

	@Test
	public void testCrearExtreure() {
		usersDao.saveOrUpdate(user1,true);
		
		List<User> users1 = usersDao.getAllUsers();
		
		assertEquals("1 usuari ha de ser creat i extret",1,users1.size());		
		assertEquals("L'usuari insertat ha de coincidir amb l'usuari extret", user1, users1.get(0));
		
		usersDao.saveOrUpdate(user2,true);
		usersDao.saveOrUpdate(user3,true);
		usersDao.saveOrUpdate(user4,true);
		
		List<User> users2 = usersDao.getAllUsers();
		assertEquals("Hauria d'extreure 4 usuaris.", 4, users2.size());
	}
	
	@Test
	public void testExists() {
		usersDao.saveOrUpdate(user2,true);
		usersDao.saveOrUpdate(user3,true);		
		
		assertTrue("Ha d'existir.", usersDao.exists(user2.getUsername()));
		assertTrue("Ha d'existir.", usersDao.exists(user3.getUsername()));
		assertFalse("No ha d'existir.", usersDao.exists(user4.getUsername()));
		
		
	}	
	
	@Test
	public void testUsers() {	
		User user = new User("test5", "test5", true, "ROLE_ADMIN", "test5@tfc.uoc", "usuari5", "de test4", "52345678K", "972000005", "C/ test nº5", "17245", "Quart", "Testing5 S.L.");
		
		usersDao.saveOrUpdate(user,true);

		List<User> users = usersDao.getAllUsers();

		assertEquals("Number of users should be 1.", 1, users.size());

		assertTrue("Ha d'existir.", usersDao.exists(user.getUsername()));
		assertFalse("No ha d'existir.", usersDao.exists("asdalsdajsldkjasldkajlskd"));

		assertEquals("Created user should be identical to retrieved user",
				user, users.get(0));
	}
	
	@Test
	public void getUser() {	
		User user = new User("test5", "test5", true, "ROLE_ADMIN", "test5@tfc.uoc", "usuari5", "de test4", "52345678K", "972000005", "C/ test nº5", "17245", "Quart", "Testing5 S.L.");
		
		usersDao.saveOrUpdate(user,true);

		User usuari1 = usersDao.getUser("test5");
		
		assertEquals("El username hauria de ser test5", "test5", usuari1.getUsername());
		assertEquals("El nom hauria de ser test5", "usuari5", usuari1.getNom());
		assertEquals("El mail hauria de ser test5@tfc.uoc", "test5@tfc.uoc", usuari1.getEmail());


	}

}
