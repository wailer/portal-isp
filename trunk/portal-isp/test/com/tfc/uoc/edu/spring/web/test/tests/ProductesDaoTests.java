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
	private ProductesDao productesDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	@Test
	public void testOffers() {

		User user = new User("johnwpurcell", "John Purcell", "hellothere",
				"john@caveofprogramming.com", true, "user");

		assertTrue("User creation should return true", usersDao.create(user));

		Producte producte = new Producte(user, "This is a test offer.");

		assertTrue("Offer creation should return true", productesDao.create(producte));

		List<Producte> offers = productesDao.getProductes();

		assertEquals("Should be one offer in database.", 1, offers.size());

		assertEquals("Retrieved offer should match created offer.", producte,
				offers.get(0));

		// Get the offer with ID filled in.
		producte = offers.get(0);

		producte.setText("Updated offer text.");
		assertTrue("Offer update should return true", productesDao.update(producte));

		Producte updated = productesDao.getProducte(producte.getId());

		assertEquals("Updated offer should match retrieved updated offer",
				producte, updated);

		// Test get by ID ///////
		Producte offer2 = new Producte(user, "This is a test offer.");

		assertTrue("Offer creation should return true", productesDao.create(offer2));
		
		List<Producte> userOffers = productesDao.getProductes(user.getUsername());
		assertEquals("Should be two offers for user.", 2, userOffers.size());
		
		List<Producte> secondList = productesDao.getProductes();
		
		for(Producte current: secondList) {
			Producte retrieved = productesDao.getProducte(current.getId());
			
			assertEquals("Offer by ID should match offer from list.", current, retrieved);
		}
		
		// Test deletion
		productesDao.delete(producte.getId());

		List<Producte> finalList = productesDao.getProductes();

		assertEquals("Offers lists should contain one offer.", 1, finalList.size());
	}

}
