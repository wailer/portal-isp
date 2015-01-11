package com.tfc.uoc.edu.spring.web.test.tests;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfc.uoc.edu.spring.web.dao.Allotjament;
import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.ProductesDao;
import com.tfc.uoc.edu.spring.web.dao.ServeiAllotjament;
import com.tfc.uoc.edu.spring.web.dao.ServeiDomini;
import com.tfc.uoc.edu.spring.web.dao.ServeisDao;
import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/tfc/uoc/edu/spring/web/config/dao-context.xml",
		"classpath:com/tfc/uoc/edu/spring/web/config/security-context.xml",
		"classpath:com/tfc/uoc/edu/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ServeisDaoTests {

	@Autowired
	private ServeisDao serveisDao;

	@Autowired
	private ProductesDao productesDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	private User user1 = new User("test1", "test1", true, "ROLE_USER",
			"test1@tfc.uoc", "usuari1", "de test1", "12345678K", "972000001",
			"C/ test nº1", "17241", "Quart", "Testing1 S.L.");
	
	private Domini domini1 = new Domini("com", ".com", "descripcio1", 19.99f,
			true, "com");
	
	private Allotjament allotjament1 = new Allotjament("allotjament1",
			"allotjament 1", "descripcio1", 150f, true, "", 5, 1, 5);
	
	private ServeiAllotjament serveiAllotjament1 = new ServeiAllotjament(allotjament1,user1);
	
	private ServeiDomini serveiDomini1 = new ServeiDomini("testing",domini1,user1);

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from serveis");
		jdbc.execute("delete from productes");		
		jdbc.execute("delete from users");

	}

	@Test
	public void testSave() {
		
		usersDao.saveOrUpdate(user1, true);
		productesDao.saveOrUpdate(allotjament1);
		productesDao.saveOrUpdate(domini1);
		serveisDao.saveOrUpdate(serveiDomini1);
		serveisDao.saveOrUpdate(serveiAllotjament1);
		
		ServeiAllotjament retrieved1 = serveisDao.getServeiAllotjament(serveiAllotjament1.getId());
		assertEquals("Els serveis han de coincidir", serveiAllotjament1, retrieved1);
		
		ServeiDomini retrieved2 = serveisDao.getServeiDomini(serveiDomini1.getId());
		assertEquals("Els serveis han de coincidir", serveiDomini1, retrieved2);
		
		
	}

}
