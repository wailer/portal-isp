package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.dao.FormValidationGroups.FormValidationGroup;
import com.tfc.uoc.edu.spring.web.dao.FormValidationGroups.PasswordEditFormValidationGroup;
import com.tfc.uoc.edu.spring.web.dao.FormValidationGroups.UserEditFormValidationGroup;
import com.tfc.uoc.edu.spring.web.service.UsersService;

@Controller
public class UserController {

	private UsersService usersService;
	private static Logger logger = Logger.getLogger(UserController.class);

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

	@RequestMapping(value = "/usuari", method = RequestMethod.GET)
	public String showUsuari(Model model) {
		model.addAttribute("user", new User());
		return "usuari";
	}

	@RequestMapping(value = "/crearusuari", method = RequestMethod.POST)
	public String crearUsuari(@Validated(FormValidationGroup.class) User user,
			BindingResult result) {

		if (result.hasErrors()) {
			return "usuari";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		if (usersService.exists(user.getUsername())) {
			System.out.println("Caught duplicate username");
			result.rejectValue("username", "DuplicateKey.user.username");
			return "usuari";
		}

		usersService.save(user);

		return "usuaricreat";
	}

	@RequestMapping(value = "/modificar-usuari", method = RequestMethod.POST)
	public String modificarUsuari(
			@Validated(UserEditFormValidationGroup.class) User user,
			BindingResult result) {

		if (result.hasErrors()) {
			return "usuari";
		}

		// Conservem el password actual
		user.setPassword(usersService.getUser(user.getId()).getPassword());
		usersService.update(user);

		return "usuaricreat";
	}

	@RequestMapping(value = "/modificar-password", method = RequestMethod.POST)	
	public String modificarPassword(
			@Validated(PasswordEditFormValidationGroup.class) User user,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "modificar-password";
		}

		// En aquest cas recuperem totes les dades de l'usuari a db i només
		// sobrescribim el password introduït en el formulari
		String passwordModificat = user.getPassword();
		if (passwordModificat == null) {
			logger.error("Modificar-Password >> El password és null");
			return "error";
		}		

		int idUsuari = user.getId();
		if (idUsuari <= 0) {
			logger.error("Modificar-Password >> La id d'usuari no és vàlida: " + idUsuari);
		}

		User usuariAModificar = usersService.getUser(idUsuari);
		if (usuariAModificar == null) {
			logger.error("Modificar-Password >> No es detecta l'usuari a modificar: usuariAModificar");
			logger.info("Modificar-Password >> Dades del formulari:"
					+ user.toString());
			return "error";
		}

		usuariAModificar.setPassword(passwordModificat);
		usersService.updatePassword(usuariAModificar);
		return "admin-usuaris";
	}
}
