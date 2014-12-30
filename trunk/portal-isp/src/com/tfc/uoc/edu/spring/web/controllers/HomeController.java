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
public class HomeController {
	
	private static Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private ProductesService productesService;
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {	
		logger.info("Showing home....");
		List<Producte> productes = productesService.getCurrent();
		model.addAttribute("productes", productes);
		boolean hasProductes = false;
		
		if (principal != null) {
			hasProductes = productesService.hasProductes(principal.getName());
		}
		
		model.addAttribute("hasProductes", hasProductes);
		return "home";
	}
	
	@RequestMapping("/dominis")
	public String showDominis(Model model, Principal principal) {	
		logger.info("Showing dominis....");		
		return "dominis";
	}
	
	@RequestMapping("/allotjaments")
	public String showAllotjaments(Model model, Principal principal) {	
		logger.info("Showing allotjaments....");
		return "allotjaments";
	}
	

}
