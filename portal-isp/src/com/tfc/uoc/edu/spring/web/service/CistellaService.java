package com.tfc.uoc.edu.spring.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfc.uoc.edu.spring.web.dao.Allotjament;
import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.Servei;
import com.tfc.uoc.edu.spring.web.dao.ServeiAllotjament;
import com.tfc.uoc.edu.spring.web.dao.ServeiDomini;
import com.tfc.uoc.edu.spring.web.dao.ServeisDao;
import com.tfc.uoc.edu.spring.web.dao.User;

@Service("cistellaService")
public class CistellaService {

	private static Logger logger = Logger.getLogger(CistellaService.class);

	private ServeisDao serveisDao;
	private ServeisService serveisService;

	@Autowired
	public void setServeisDao(ServeisDao serveisDao) {
		this.serveisDao = serveisDao;
	}

	@Autowired
	public void setServeisService(ServeisService serveisService) {
		this.serveisService = serveisService;
	}

	public void afegir(Producte producte, User user) {

		if (producte.getClass().toString().endsWith("Allotjament")) {
			ServeiAllotjament servei = new ServeiAllotjament(
					(Allotjament) producte, user);
			servei.setEstat("CISTELLA");
			logger.info("CistellaService >> Grabant producte a la cistella...");
			serveisDao.saveOrUpdate(servei);
		} else {
			logger.error("CistellaService >> La classe del producte no està soportada per aquest servei: "
					+ producte.getClass().toString());
		}
	}

	public void afegir(String nom, Producte producte, User user) {

		if (producte.getClass().toString().endsWith("Domini")) {
			ServeiDomini servei = new ServeiDomini(nom, (Domini) producte, user);
			servei.setEstat("CISTELLA");
			logger.info("CistellaService >> Grabant producte a la cistella...");
			serveisDao.saveOrUpdate(servei);
		} else {
			logger.error("CistellaService >> La classe del producte no està soportada per aquest servei: "
					+ producte.getClass().toString());
		}
	}

	public List<Servei> getServeis(User user) {
		if (user == null) {
			logger.error("cistellaService >> getServeis(User user): L'usuari és null");
		}
		return serveisService.getServeis(user, "CISTELLA");
	}
}
