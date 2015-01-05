package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.service.ProductesService;
import com.tfc.uoc.edu.spring.web.service.UsersService;

@Controller

public class AdminController {

	private static Logger logger = Logger.getLogger(AdminController.class);

	@Autowired
	private ProductesService productesService;
	@Autowired
	private UsersService usersService;

	@RequestMapping("/admin")
	public String showAdmin(Model model, Principal principal) {
		return "admin";
	}

	@RequestMapping("/admin-dominis")
	public String showAdminDominis(Model model, Principal principal) {
		List<Producte> productes = productesService.getProductes(true);
		model.addAttribute("productes", productes);
		return "admin-dominis";
	}

	@RequestMapping("/admin-allotjaments")
	public String showAdminAllotjaments(Model model, Principal principal) {
		List<Producte> productes = productesService.getProductes(true);
		model.addAttribute("productes", productes);
		return "admin-allotjaments";
	}

	@RequestMapping("/admin-usuaris")
	public String showAdminUsuaris(Model model, Principal principal) {
		List<User> usuaris = usersService.getUsers();
		model.addAttribute("usuaris", usuaris);
		return "admin-usuaris";
	}

	/**
	 * Gestió d'usuaris
	 */

	@RequestMapping(value = "/admin-usuari", method = RequestMethod.GET)
	public String showAdminUsuari(
			Model model,
			Principal principal,
			@RequestParam(value = "username", required = false) String nomUsuari,
			@RequestParam(value = "action", required = false) String action) {

		User usuari = null;

		if (principal != null) {
			String nomUsuariActual = principal.getName();
			User usuariActual = usersService.getUser(nomUsuariActual);
			User usuariParametre = usersService.getUser(nomUsuari);

			// Comprovacions de seguretat
			if (usuariActual != usuariParametre
					&& usuariActual.getAuthority() == "ROLE_USER") {
				return "errorpermisos";
			}

			if (usuariParametre == null) {
				logger.error("L'usuari " + nomUsuari + " no existeix");
				return "errorpermisos";
			}

			if (!usuariParametre.getUsername().equals(principal.getName())
					&& !usuariActual.getAuthority().equals("ROLE_ADMIN")) {
				logger.error("L'usuari " + nomUsuari
						+ " no coincideix amb l'usuari de la sessió: "
						+ principal.getName());
				return "errorpermisos";
			}

			// Hem passat totes les comprovacions de seguretat, podem editar
			// l'usuari.
			model.addAttribute("user", usuariParametre);
			return "admin-usuari";
		}
		return "errorpermisos";
	}


	@RequestMapping(value = "/admin-password", method = RequestMethod.GET)
	public String showAdminPassword(Model model, Principal principal,
			@RequestParam(value = "username", required = false) String nomUsuari) {
		

		
		if (principal != null) {
			String nomUsuariActual = principal.getName();
			User usuariActual = usersService.getUser(nomUsuariActual);
			User usuariParametre = usersService.getUser(nomUsuari);

			// Comprovacions de seguretat
			if (usuariActual != usuariParametre
					&& usuariActual.getAuthority() == "ROLE_USER") {
				return "errorpermisos";
			}

			if (usuariParametre == null) {
				logger.error("L'usuari " + nomUsuari + " no existeix");
				return "errorpermisos";
			}

			if (!usuariParametre.getUsername().equals(principal.getName())
					&& !usuariActual.getAuthority().equals("ROLE_ADMIN")) {
				logger.error("L'usuari " + nomUsuari
						+ " no coincideix amb l'usuari de la sessió: "
						+ principal.getName());
				return "errorpermisos";
			}

			// Hem passat totes les comprovacions de seguretat, podem editar
			// l'usuari.

			// Com que el formulari només tindrà el password, creem un objecte
			// que conté la id de l'usuari per tal que el formulari sàpiga quin
			// usuari estem editant.			
			usuariParametre.setPassword(null);
			model.addAttribute("user", usuariParametre);
			return "admin-password";
		}
		return "errorpermisos";
	}

	/**
	 * Respostes Genèriques
	 * 
	 */
	@RequestMapping("/admin-ok")
	public String showAdminOk(Model model, Principal principal) {
		return "admin-ok";
	}

	/**
	 * Errors
	 */
	@RequestMapping("/admin-error")
	public String showAdminError(Model model, Principal principal) {
		return "admin-error";
	}
}
