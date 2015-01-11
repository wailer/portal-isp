package com.tfc.uoc.edu.spring.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.tfc.uoc.edu.spring.web.dao.Allotjament;
import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.Servei;
import com.tfc.uoc.edu.spring.web.dao.ServeiAllotjament;
import com.tfc.uoc.edu.spring.web.dao.ServeiDomini;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.ServeisDao;
import com.tfc.uoc.edu.spring.web.dao.User;

@Service("serveisService")
public class ServeisService {

	private ServeisDao serveisDao;

	@Autowired
	public void setServeisDao(ServeisDao serveisDao) {
		this.serveisDao = serveisDao;
	}

	public List<Servei> getServeis(String estat) {
		return serveisDao.getServeis(estat);
	}

	public void saveOrUpdate(Servei servei) {
		serveisDao.saveOrUpdate(servei);
	}

	public void delete(int id) {
		serveisDao.delete(id);
	}

	public List<ServeiDomini> getServeisDomini(String estat) {
		return serveisDao.getServeisDomini(estat);
	}

	public ServeiDomini getServeiDomini(int id) {
		return serveisDao.getServeiDomini(id);
	}

	public void update(ServeiDomini serveiDomini) {
		serveisDao.update(serveiDomini);

	}

	public ServeiAllotjament getServeiAllotjament(int id) {
		return serveisDao.getServeiAllotjament(id);
	}

	public List<ServeiAllotjament> getServeisAllotjament(String estat) {
		return serveisDao.getServeisAllotjament(estat);
	}

	public List<Servei> getServeis(User user, String estat) {
		return serveisDao.getServeis(user,estat);
	}

	public void eliminar(int id) {
		serveisDao.delete(id);
		
	}




}
