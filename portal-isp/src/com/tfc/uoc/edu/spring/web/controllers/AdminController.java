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

import com.tfc.uoc.edu.spring.web.dao.Allotjament;
import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.Missatge;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.dao.User;
import com.tfc.uoc.edu.spring.web.dao.ValidationGroups.FormValidationGroup;
import com.tfc.uoc.edu.spring.web.dao.ValidationGroups.PasswordEditFormValidationGroup;
import com.tfc.uoc.edu.spring.web.dao.ValidationGroups.UserEditFormValidationGroup;
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

	/**
	 * Gestió Dominis
	 *  
	 */

	@RequestMapping("/admin-dominis")
	public String showAdminDominis(Model model, Principal principal) {
		List<Domini> dominis = productesService.getDominis(true);
		model.addAttribute("dominis", dominis);
		return "admin-dominis";
	}

	@RequestMapping(value = "/admin-domini", method = RequestMethod.GET)
	public String showAdminDomini(Model model, Principal principal,
			@RequestParam(value = "codi", required = false) String codiDomini,
			@RequestParam(value = "action", required = false) String action) {		

		if (codiDomini != null) {
			Domini domini = productesService.getDomini(codiDomini);

			// Comprovacions de seguretat

			// Hem passat totes les comprovacions de seguretat, podem editar
			// el domini

			if (action != null && action.equals("delete")) {
				model.addAttribute("domini", domini);
				productesService.delete(domini.getId());
				model.addAttribute(model.addAttribute("missatge", new Missatge(
						"Panell.operacio.ok", false)));
				List<Domini> dominis = productesService.getDominis(true);
				model.addAttribute("dominis", dominis);
				return "admin-dominis";
			} else {
				logger.info("Admin-domini >> Editant un domini existent");
				model.addAttribute("domini", domini);
				return "admin-domini";
			}
		} else {
			logger.info("Admin-domini >> Creant nou domini... ");
			Domini domini = new Domini();
			model.addAttribute("domini", domini);
			return "admin-domini";
		}
	}

	@RequestMapping(value = "/admin-form-domini", method = RequestMethod.POST)
	public String formDomini(
			@Validated(FormValidationGroup.class) Domini domini,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "admin-domini";
		}
		
		logger.info("Admin-form-domini >> Domini editat: " + domini.toString());
		productesService.saveOrUpdate(domini);
		List<Domini> dominis = productesService.getDominis(true);
		model.addAttribute("dominis", dominis);
		model.addAttribute(model.addAttribute("missatge", new Missatge(
				"Panell.operacio.ok", false)));
		return "admin-dominis";
	}
/**
 * Gestió allotjaments
 * 
 */

	@RequestMapping("/admin-allotjaments")
	public String showAdminAllotjaments(Model model, Principal principal) {
		List<Allotjament> allotjaments = productesService.getAllotjaments(true);
		model.addAttribute("allotjaments", allotjaments);
		return "admin-allotjaments";
	}
	
	@RequestMapping(value = "/admin-allotjament", method = RequestMethod.GET)
	public String showAdminAllotjament(Model model, Principal principal,
			@RequestParam(value = "codi", required = false) String codi,
			@RequestParam(value = "action", required = false) String action) {		

		if (codi != null) {
			Allotjament allotjament = productesService.getAllotjament(codi);

			// Comprovacions de seguretat

			// Hem passat totes les comprovacions de seguretat, podem editar
			// el domini

			if (action != null && action.equals("delete")) {
				model.addAttribute("allotjament", allotjament);
				productesService.delete(allotjament.getId());
				model.addAttribute(model.addAttribute("missatge", new Missatge(
						"Panell.operacio.ok", false)));
				List<Allotjament> allotjaments = productesService.getAllotjaments(true);
				model.addAttribute("allotjaments", allotjaments);
				return "admin-allotjaments";
			} else {
				logger.info("Admin-allotjament >> Editant un allotjament existent");
				model.addAttribute("allotjament", allotjament);
				return "admin-allotjament";
			}
		} else {
			logger.info("Admin-allotjament >> Creant nou allotjament... ");
			Allotjament allotjament = new Allotjament();
			model.addAttribute("allotjament", allotjament);
			return "admin-allotjament";
		}
	}

	@RequestMapping(value = "/admin-form-allotjament", method = RequestMethod.POST)
	public String formAllotjament(
			@Validated(FormValidationGroup.class) Allotjament allotjament,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "admin-allotjament";
		}
		
		logger.info("Admin-form-allotjament >> Allotjament editat: " + allotjament.toString());
		productesService.saveOrUpdate(allotjament);
		List<Allotjament> allotjaments = productesService.getAllotjaments(true);
		model.addAttribute("allotjaments", allotjaments);
		model.addAttribute(model.addAttribute("missatge", new Missatge(
				"Panell.operacio.ok", false)));
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

			if (action != null && action.equals("delete")) {
				model.addAttribute("user", usuariParametre);
				usersService.delete(usuariParametre.getId());
				model.addAttribute(model.addAttribute("missatge", new Missatge(
						"Panell.operacio.ok", false)));
				List<User> usuaris = usersService.getUsers();
				model.addAttribute("usuaris", usuaris);
				return "admin-usuaris";
			} else {
				model.addAttribute("user", usuariParametre);
				return "admin-usuari";
			}
		}
		model.addAttribute(model.addAttribute("missatge", new Missatge(
				"Panell.operacio.ko", true)));
		return "admin-usuaris";
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
	

	@RequestMapping(value = "/admin-modificar-usuari", method = RequestMethod.POST)
	public String modificarUsuari(
			@Validated(UserEditFormValidationGroup.class) User user,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "admin-usuari";
		}

		// Conservem el password actual
		user.setPassword(usersService.getUser(user.getId()).getPassword());
		logger.info("Admin-modificar-usuari >> Usuari editat: "+ user.toString());
		usersService.update(user);

		List<User> usuaris = usersService.getUsers();
		model.addAttribute("usuaris", usuaris);
		model.addAttribute("missatge",
				new Missatge("Panell.operacio.ok", false));
		return "admin-usuaris";
	}

	@RequestMapping(value = "/admin-modificar-password", method = RequestMethod.POST)
	public String modificarPassword(
			@Validated(PasswordEditFormValidationGroup.class) User user,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "admin-password";
		}

		// En aquest cas recuperem totes les dades de l'usuari a db i només
		// sobrescribim el password introduït en el formulari
		String passwordModificat = user.getPassword();
		if (passwordModificat == null) {
			logger.error("Admin-Modificar-Password >> El password és null");
			return "error";
		}

		int idUsuari = user.getId();
		if (idUsuari <= 0) {
			logger.error("Admin-Modificar-Password >> La id d'usuari no és vàlida: "
					+ idUsuari);
		}

		User usuariAModificar = usersService.getUser(idUsuari);
		if (usuariAModificar == null) {
			logger.error("Admin-Modificar-Password >> No es detecta l'usuari a modificar: usuariAModificar");
			logger.info("Admin-Modificar-Password >> Dades del formulari:"
					+ user.toString());
			return "error";
		}

		usuariAModificar.setPassword(passwordModificat);
		usersService.updatePassword(usuariAModificar);
		List<User> usuaris = usersService.getUsers();
		model.addAttribute("usuaris", usuaris);
		model.addAttribute("missatge",
				new Missatge("Panell.operacio.ok", false));
		return "admin-usuaris";
	}

}
