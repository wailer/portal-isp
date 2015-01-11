package com.tfc.uoc.edu.spring.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.tfc.uoc.edu.spring.web.dao.Allotjament;
import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.ProductesDao;

@Service("productesService")
public class ProductesService {

	private ProductesDao productesDao;

	@Autowired
	public void setProductesDao(ProductesDao productesDao) {
		this.productesDao = productesDao;
	}

	public List<Producte> getProductes(boolean inactius) {
		return productesDao.getProductes(inactius);

	}

	@Secured("ROLE_ADMIN")
	public void saveOrUpdate(Producte producte) {
		productesDao.saveOrUpdate(producte);		
	}

	public void delete(int id) {
		productesDao.delete(id);		
	}

	public List<Domini> getDominis(boolean inactius) {
		return productesDao.getDominis(true);		
	}

	public Domini getDomini(String codiDomini) {
		return productesDao.getDomini(codiDomini);
	}

	public void update(Domini domini) {
		productesDao.update(domini);
		
	}

	public Allotjament getAllotjament(String codi) {
		return productesDao.getAllotjament(codi);
	}

	public List<Allotjament> getAllotjaments(boolean inactius) {
		return productesDao.getAllotjaments(inactius);
	}

	public List<String> getExtensions() {
		List<Domini> dominis = productesDao.getDominis(false);
		Iterator<Domini> itr = dominis.iterator();
		
		List<String> extensions = new ArrayList<String>();
		while(itr.hasNext()) {
			extensions.add(itr.next().getExtensio());		
		}
		
		return extensions;		
	}

	public Producte getProducte(String codi) {
		return productesDao.getProducte(codi);
	}


}
