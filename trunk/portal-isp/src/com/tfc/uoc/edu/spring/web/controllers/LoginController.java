package com.tfc.uoc.edu.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.service.UsersService;

@Controller
public class LoginController {
	
	private UsersService usersService;
	
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/loggedout")
	public String showLogout() {
		return "loggedout";
	}
	
	@RequestMapping("/nouusuari")
	public String showNouUsuari(Model model) {
		
		model.addAttribute("user", new User());
		return "nouusuari";
	}

	@RequestMapping(value="/crearusuari", method=RequestMethod.POST)
	public String crearUsuari(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "nouusuari";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())) {
			System.out.println("Caught duplicate username");
			result.rejectValue("username", "DuplicateKey.user.username");			
			return "nouusuari";
		}
		
		usersService.create(user);
	
		return "usuaricreat";
	}
}
