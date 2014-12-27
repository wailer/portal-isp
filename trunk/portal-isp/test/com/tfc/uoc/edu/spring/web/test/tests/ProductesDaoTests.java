package com.tfc.uoc.edu.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.ProductesDao;
import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/tfc/uoc/edu/spring/web/config/dao-context.xml",
		"classpath:com/tfc/uoc/edu/spring/web/config/security-context.xml",
		"classpath:com/tfc/uoc/edu/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductesDaoTests {

	@Autowired
	private ProductesDao ProductesDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	private User user1 = new User("mgarcia", "Manel Garcia", "1234567890",
			"manel@tfc.uoc", true, "ROLE_USER");
	private User user2 = new User("jribas", "Jordi Ribas", "1234567890",
			"jribas@tfc.uoc", true, "ROLE_ADMIN");
	private User user3 = new User("jramon", "Joan Ramon", "1234567890", "jramon@tfc.uoc", true, "ROLE_USER");
	private User user4 = new User("ablasco", "Anna Blasco", "1234567890",
			"ablasco@tfc.uoc", false, "user");

	private Producte offer1 = new Producte(user1, "This is a test offer.");
	private Producte offer2 = new Producte(user1, "This is another test offer.");
	private Producte offer3 = new Producte(user2, "This is yet another test offer.");
	private Producte offer4 = new Producte(user3, "This is a test offer once again.");
	private Producte offer5 = new Producte(user3,
			"Here is an interesting offer of some kind.");
	private Producte offer6 = new Producte(user3, "This is just a test offer.");
	private Producte offer7 = new Producte(user4,
			"This is a test offer for a user that is not enabled.");

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testDelete() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		ProductesDao.saveOrUpdate(offer2);
		ProductesDao.saveOrUpdate(offer3);
		ProductesDao.saveOrUpdate(offer4);
		ProductesDao.saveOrUpdate(offer5);
		ProductesDao.saveOrUpdate(offer6);
		ProductesDao.saveOrUpdate(offer7);
		
		Producte retrieved1 = ProductesDao.getProducte(offer2.getId());
		assertNotNull("Producte with ID " + retrieved1.getId() + " should not be null (deleted, actual)", retrieved1);
		
		ProductesDao.delete(offer2.getId());
		
		Producte retrieved2 = ProductesDao.getProducte(offer2.getId());
		assertNull("Producte with ID " + retrieved1.getId() + " should be null (deleted, actual)", retrieved2);
	}
	
	@Test
	public void testGetById() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		ProductesDao.saveOrUpdate(offer1);
		ProductesDao.saveOrUpdate(offer2);
		ProductesDao.saveOrUpdate(offer3);
		ProductesDao.saveOrUpdate(offer4);
		ProductesDao.saveOrUpdate(offer5);
		ProductesDao.saveOrUpdate(offer6);
		ProductesDao.saveOrUpdate(offer7);
		
		Producte retrieved1 = ProductesDao.getProducte(offer1.getId());
		assertEquals("Productes should match", offer1, retrieved1);
		
		Producte retrieved2 = ProductesDao.getProducte(offer7.getId());
		assertNull("Should not retrieve offer for disabled user.", retrieved2);
	}

	@Test
	public void testCreateRetrieve() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		
		ProductesDao.saveOrUpdate(offer1);

		List<Producte> offers1 = ProductesDao.getProductes();
		assertEquals("Should be one offer.", 1, offers1.size());

		assertEquals("Retrieved offer should equal inserted offer.", offer1,
				offers1.get(0));

		ProductesDao.saveOrUpdate(offer2);
		ProductesDao.saveOrUpdate(offer3);
		ProductesDao.saveOrUpdate(offer4);
		ProductesDao.saveOrUpdate(offer5);
		ProductesDao.saveOrUpdate(offer6);
		ProductesDao.saveOrUpdate(offer7);

		List<Producte> offers2 = ProductesDao.getProductes();
		assertEquals("Should be six offers for enabled users.", 6,
				offers2.size());

	}
	
	@Test
	public void testUpdate() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		ProductesDao.saveOrUpdate(offer2);
		ProductesDao.saveOrUpdate(offer3);
		ProductesDao.saveOrUpdate(offer4);
		ProductesDao.saveOrUpdate(offer5);
		ProductesDao.saveOrUpdate(offer6);
		ProductesDao.saveOrUpdate(offer7);
		
		offer3.setText("This offer has updated text.");
		ProductesDao.saveOrUpdate(offer3);
		
		Producte retrieved = ProductesDao.getProducte(offer3.getId());
		assertEquals("Retrieved offer should be updated.", offer3, retrieved);
	}

	@Test
	public void testGetUsername() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);

		ProductesDao.saveOrUpdate(offer1);
		ProductesDao.saveOrUpdate(offer2);
		ProductesDao.saveOrUpdate(offer3);
		ProductesDao.saveOrUpdate(offer4);
		ProductesDao.saveOrUpdate(offer5);
		ProductesDao.saveOrUpdate(offer6);
		ProductesDao.saveOrUpdate(offer7);

		List<Producte> offers1 = ProductesDao.getProductes(user3.getUsername());
		assertEquals("Should be three offers for this user.", 3, offers1.size());

		List<Producte> offers2 = ProductesDao.getProductes("sdfsfd");
		assertEquals("Should be zero offers for this user.", 0, offers2.size());

		List<Producte> offers3 = ProductesDao.getProductes(user2.getUsername());
		assertEquals("Should be 1 offer for this user.", 1, offers3.size());
	}
}

	
