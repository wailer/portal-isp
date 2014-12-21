package com.tfc.uoc.edu.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.ProductesDao;

@Service("productesService")
public class ProductesService {
	
	private ProductesDao productesDao;
	

	@Autowired
	public void setProductesDao(ProductesDao productesDao) {
		this.productesDao = productesDao;
	}

	public List<Producte> getCurrent() {
		return productesDao.getProductes();
		
	}

	
	@Secured("ROLE_ADMIN")
	public void createProducte(Producte producte) {
		productesDao.create(producte);
		
	}

	public void throwTestException() {
		productesDao.getProducte(99999);
		
	}
	
}
