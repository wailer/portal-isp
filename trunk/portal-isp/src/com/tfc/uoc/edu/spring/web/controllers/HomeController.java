package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tfc.uoc.edu.spring.web.dao.Allotjament;
import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.Servei;
import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.service.CistellaService;
import com.tfc.uoc.edu.spring.web.service.ProductesService;
import com.tfc.uoc.edu.spring.web.service.ServeisService;
import com.tfc.uoc.edu.spring.web.service.UsersService;

@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private ProductesService productesService;
	@Autowired
	private UsersService usersService;

	@Autowired
	private CistellaService cistellaService;


	@RequestMapping(value = { "/", "/home","/dominis"})
	public String showDominis(Model model, Principal principal) {
		logger.info("Showing dominis....");

		if (principal != null) {
			User user = usersService.getUser(principal.getName());
			List<Servei> productesCistella = cistellaService.getServeis(user);
			model.addAttribute("productesCistella", productesCistella);
		}
		List<String> extensions = productesService.getExtensions();
		model.addAttribute("extensions", extensions);
		List<Domini> dominis = productesService.getDominis(false);
		model.addAttribute("dominis", dominis);
		return "dominis";
	}

	@RequestMapping("/allotjaments")
	public String showAllotjaments(Model model, Principal principal) {
		List<Allotjament> allotjaments = productesService
				.getAllotjaments(false);
		model.addAttribute("allotjaments", allotjaments);
		logger.info("Showing allotjaments....");

		if (principal != null) {
			User user = usersService.getUser(principal.getName());
			List<Servei> productesCistella = cistellaService.getServeis(user);
			model.addAttribute("productesCistella", productesCistella);
		}
		return "allotjaments";
	}

	@RequestMapping("/credits")
	public String showCredits(Model model, Principal principal) {
		logger.info("Showing credits....");

		if (principal != null) {
			User user = usersService.getUser(principal.getName());
			List<Servei> productesCistella = cistellaService.getServeis(user);
			model.addAttribute("productesCistella", productesCistella);
		}
		return "credits";
	}

}
