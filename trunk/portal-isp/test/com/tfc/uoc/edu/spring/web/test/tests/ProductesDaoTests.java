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

import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.ProductesDao;

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
	private DataSource dataSource;

	private Domini domini1 = new Domini("com", ".com", "descripcio1", 19.99f, "com");
	private Domini domini2 = new Domini("es", ".es", "descripcio2", 29.99f, "es");
	private Domini domini3 = new Domini("cat", ".cat", "descripcio3", 39.99f, "cat");
	private Domini domini4 = new Domini("net", ".net", "descripcio4", 19.99f, "net");
	private Domini domini5 = new Domini("biz", ".biz", "descripcio5", 19.99f, "biz");
	private Domini domini6 = new Domini("info", ".info", "descripcio6", 19.99f, "info");
	private Domini domini7 = new Domini("org", ".org", "descripcio7", 14.99f, "org");
	

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from productes");
		
	}
	
	@Test
	public void testDelete() {

		ProductesDao.saveOrUpdate(domini1);
		ProductesDao.saveOrUpdate(domini2);
		ProductesDao.saveOrUpdate(domini3);
		ProductesDao.saveOrUpdate(domini4);
		ProductesDao.saveOrUpdate(domini5);
		ProductesDao.saveOrUpdate(domini6);
		ProductesDao.saveOrUpdate(domini7);		
		
		Domini retrieved1 = (Domini) ProductesDao.getProducte(domini1.getCodi());
		assertNotNull("Producte with ID " + retrieved1.getId() + " should not be null (deleted, actual)", retrieved1);
		
		ProductesDao.delete(domini7.getId());
		
		Domini retrieved2 = (Domini) ProductesDao.getProducte(domini7.getCodi());
		assertNull("Producte with ID " + retrieved1.getId() + " should be null (deleted, actual)", retrieved2);
	}
	
	@Test
	public void testGetByCodi() {

		ProductesDao.saveOrUpdate(domini1);
		ProductesDao.saveOrUpdate(domini2);
		ProductesDao.saveOrUpdate(domini3);
		ProductesDao.saveOrUpdate(domini4);
		ProductesDao.saveOrUpdate(domini5);
		ProductesDao.saveOrUpdate(domini6);
		ProductesDao.saveOrUpdate(domini7);	
		
		Domini retrieved1 = (Domini) ProductesDao.getProducte(domini1.getCodi());		
		assertEquals("Productes should match", domini1, retrieved1);		
		
		Domini retrieved2 = (Domini) ProductesDao.getProducte(domini2.getCodi());
		assertEquals("Productes should match", domini2, retrieved2);	
		
		Domini retrieved3 = (Domini) ProductesDao.getProducte(domini3.getCodi());
		assertEquals("Productes should match", domini3, retrieved3);	
	}

	@Test
	public void testCreateRetrieve() {
		
		ProductesDao.saveOrUpdate(domini1);

		List<Producte> dominis = ProductesDao.getProductes(true);
		assertEquals("Hauria de retornar 1 producte.", 1, dominis.size());

		assertEquals("Retrieved offer should equal inserted offer.", domini1,
				dominis.get(0));

		ProductesDao.saveOrUpdate(domini2);
		ProductesDao.saveOrUpdate(domini3);
		ProductesDao.saveOrUpdate(domini4);
		ProductesDao.saveOrUpdate(domini5);
		ProductesDao.saveOrUpdate(domini6);
		ProductesDao.saveOrUpdate(domini7);			
		
		List<Producte> dominis2 = ProductesDao.getProductes(true);
		assertEquals("Hauria de retornar 7 dominis.", 7,
				dominis2.size());

	}
	
	@Test
	public void testUpdate() {

		ProductesDao.saveOrUpdate(domini2);
		ProductesDao.saveOrUpdate(domini3);
		ProductesDao.saveOrUpdate(domini4);
		ProductesDao.saveOrUpdate(domini5);
		ProductesDao.saveOrUpdate(domini6);
		ProductesDao.saveOrUpdate(domini7);	
		
		domini3.setDescripcio("Descripcio actualitzada per aquest domini.");
		ProductesDao.saveOrUpdate(domini3);
		
		Domini retrieved = (Domini) ProductesDao.getProducte(domini3.getCodi());
		assertEquals("Retrieved offer should be updated.", domini3, retrieved);
	}


}
	
