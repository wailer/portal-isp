package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfc.uoc.edu.spring.web.dao.Allotjament;
import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.Missatge;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.Servei;
import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.service.CistellaService;
import com.tfc.uoc.edu.spring.web.service.ProductesService;
import com.tfc.uoc.edu.spring.web.service.ServeisService;
import com.tfc.uoc.edu.spring.web.service.UsersService;

@Controller
public class CistellaController {

	private static Logger logger = Logger.getLogger(CistellaController.class);

	@Autowired
	private ProductesService productesService;

	@Autowired
	private UsersService usersService;

	@Autowired
	private ServeisService serveisService;

	@Autowired
	private CistellaService cistellaService;

	@RequestMapping(value = "/afegir-cistella", method = RequestMethod.GET)
	public String afegirCistella(Model model, Principal principal,
			@RequestParam(value = "codi", required = false) String codi,
			@RequestParam(value = "nom", required = false) String nom) {

		logger.info("Afegir a la cistella....");

		Producte producte = productesService.getProducte(codi);
		User user = usersService.getUser(principal.getName());

		// Comprovacions de seguretat

		if (producte == null) {
			model.addAttribute("missatge", new Missatge("Panell.operacio.ko",
					true));
			return "cistella";
		}

		if (user == null) {
			model.addAttribute("missatge", new Missatge("Panell.operacio.ko",
					true));
			return "cistella";
		}
		
		if(producte.getClass().toString().endsWith("Domini") && nom == null) {
			model.addAttribute("missatge", new Missatge("Panell.operacio.ko",
					true));
			return "cistella";
		}

		// Hem passat les comprovacions de seguretat , podem afegir el producte
		// a la cistella

		if(producte.getClass().toString().endsWith("Domini")) {
			cistellaService.afegir(nom, producte, user);
		} else if (producte.getClass().toString().endsWith("Allotjament")) {
			cistellaService.afegir(producte, user);	
		}
		
		List<Servei> productesCistella = cistellaService.getServeis(user);

		model.addAttribute("productesCistella", productesCistella);
		model.addAttribute("missatge", new Missatge("Cistella.operacio.ok",
				false));
		return "cistella";
	}

	@RequestMapping(value = "/cistella", method = RequestMethod.GET)
	public String showCistella(Model model, Principal principal,
			@RequestParam(value = "accio", required = false) String accio,
			@RequestParam(value = "id", required = false) String id) {

		logger.info("Mostrant cistella....accio:" + accio + " id: " + id);

		User user = usersService.getUser(principal.getName());

		if (accio != null && accio.equals("eliminar")) {
			logger.info("Sol·licitud d'eliminar producte amb id " + id);
			// Comprovacions de seguretat

			int idServei;

			try {
				idServei = Integer.parseInt(id);
			} catch (NumberFormatException e) {
				model.addAttribute("missatge", new Missatge(
						"Cistella.operacio.ko", true));
				return "cistella";
			}

			// Hem passat les comprovacions de seguretat, podem eliminar el
			// producte de la cistella
			logger.info("Eliminant servei: " + idServei);
			serveisService.eliminar(idServei);

			List<Servei> productesCistella = cistellaService.getServeis(user);
			model.addAttribute("productesCistella", productesCistella);
			model.addAttribute("missatge", new Missatge("Cistella.operacio.ok",
					false));
			return "cistella";
		}

		List<Servei> productesCistella = cistellaService.getServeis(user);
		model.addAttribute("productesCistella", productesCistella);
		return "cistella";
	}

}
