package com.tfc.uoc.edu.spring.web.controllers;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	private static Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String showHome(Model model) {	
		logger.info("Showing home....");
		return "home";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {		
		return "denied";
	}
}
