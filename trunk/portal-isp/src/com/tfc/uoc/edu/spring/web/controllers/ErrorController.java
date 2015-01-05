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
public class ErrorController {

	private static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private ProductesService productesService;
	@Autowired
	private UsersService usersService;

	@RequestMapping("/errorpermisos")
	public String showErrorPermisos(Model model, Principal principal) {
		return "errorpermisos";
	}
	
	@RequestMapping("/errordb")
	public String showHome(Model model, Principal principal) {
		return "errordb";
	}

	@RequestMapping("/error")
	public String showError(Model model, Principal principal) {
		return "error";
	}
	

}
