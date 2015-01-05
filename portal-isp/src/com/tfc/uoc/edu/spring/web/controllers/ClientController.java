package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.dao.FormValidationGroups.PasswordEditFormValidationGroup;
import com.tfc.uoc.edu.spring.web.dao.FormValidationGroups.UserEditFormValidationGroup;
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

	@RequestMapping(value = "/client-perfil")
	public String showClientPerfil(Model model, Principal principal) {

		if (principal != null) {
			String nomUsuariActual = principal.getName();
			User usuariActual = usersService.getUser(nomUsuariActual);

			// Comprovacions de seguretat

			// Hem passat totes les comprovacions de seguretat, podem editar
			// l'usuari.
			model.addAttribute("user", usuariActual);
			return "client-perfil";
		}
		logger.error("/client-perfil >> No es detecta l'usuari loguejat.");
		return "errorpermisos";
	}
	
	@RequestMapping(value = "/client-modificar-perfil", method = RequestMethod.POST)
	public String showModificarPerfil(
			@Validated(UserEditFormValidationGroup.class) User user,
			BindingResult result) {

		if (result.hasErrors()) {
			return "client-perfil";
		}

		// Conservem el password actual
		user.setPassword(usersService.getUser(user.getId()).getPassword());
		usersService.update(user);

		return "client";
	}

	@RequestMapping(value = "/client-password", method = RequestMethod.GET)
	public String showAdminPassword(Model model, Principal principal,
			@RequestParam(value = "username", required = false) String nomUsuari) {

		if (principal != null) {
			String nomUsuariActual = principal.getName();
			User usuariActual = usersService.getUser(nomUsuariActual);			

			// Comprovacions de seguretat
		

			// Hem passat totes les comprovacions de seguretat, podem editar
			// l'usuari.

			// Com que el formulari només tindrà el password, creem un objecte
			// que conté la id de l'usuari per tal que el formulari sàpiga quin
			// usuari estem editant.
			usuariActual.setPassword(null);
			model.addAttribute("user", usuariActual);
			return "client-password";
		}
		return "errorpermisos";
	}
	@RequestMapping(value = "/client-modificar-password", method = RequestMethod.POST)	
	public String showModificarPassword(
			@Validated(PasswordEditFormValidationGroup.class) User user,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "client-password";
		}

		// En aquest cas recuperem totes les dades de l'usuari a db i només
		// sobrescribim el password introduït en el formulari
		String passwordModificat = user.getPassword();
		if (passwordModificat == null) {
			logger.error("/client-modificar-Password >> El password és null");
			return "error";
		}		

		int idUsuari = user.getId();
		if (idUsuari <= 0) {
			logger.error("/client-modificar-Password >> La id d'usuari no és vàlida: " + idUsuari);
		}

		User usuariAModificar = usersService.getUser(idUsuari);
		if (usuariAModificar == null) {
			logger.error("/client-modificar-Password >> No es detecta l'usuari a modificar: usuariAModificar");
			logger.info("/client-modificar-Password >> Dades del formulari:"
					+ user.toString());
			return "error";
		}

		usuariAModificar.setPassword(passwordModificat);
		usersService.updatePassword(usuariAModificar);
		return "client";
	}

}
