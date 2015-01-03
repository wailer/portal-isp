package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.service.ProductesService;
import com.tfc.uoc.edu.spring.web.service.UsersService;

@Controller
public class ClientController {

	private static Logger logger = Logger.getLogger(ClientController.class);

	@Autowired
	private ProductesService productesService;
	@Autowired
	private UsersService usersService;

	@RequestMapping("/client")
	public String showAdmin(Model model, Principal principal) {
		List<Producte> productes = productesService.getProductes(true);
		model.addAttribute("productes", productes);
		List<User> users = usersService.getUsers();
		model.addAttribute("users", users);

		return "client";
	}

	@RequestMapping("/client-dominis")
	public String showAdminDominis(Model model, Principal principal) {
		List<Producte> productes = productesService.getProductes(true);
		model.addAttribute("productes", productes);
		List<User> users = usersService.getUsers();
		model.addAttribute("users", users);
		
		return "client-dominis";
	}

	@RequestMapping("/client-allotjaments")
	public String showAdminAllotjaments(Model model, Principal principal) {
		List<Producte> productes = productesService.getProductes(true);
		model.addAttribute("productes", productes);
		List<User> users = usersService.getUsers();
		model.addAttribute("users", users);
		
		return "client-allotjaments";
	}
	
	@RequestMapping("/client-perfil")
	public String showAdminUsuaris(Model model, Principal principal) {
		List<Producte> productes = productesService.getProductes(true);
		model.addAttribute("productes", productes);
		List<User> users = usersService.getUsers();
		model.addAttribute("users", users);
		
		return "client-perfil";
	}
	
	
	
	
}
