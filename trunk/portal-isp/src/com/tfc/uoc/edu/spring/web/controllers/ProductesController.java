package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfc.uoc.edu.spring.web.dao.FormValidationGroup;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.service.ProductesService;

@Controller
public class ProductesController {

	private ProductesService productesService;

	@Autowired
	public void setProductesService(ProductesService productesService) {
		this.productesService = productesService;
	}

	@RequestMapping("/productes")
	public String showProductes(Model model) {

		List<Producte> productes = productesService.getCurrent();
		model.addAttribute("productes", productes);

		return "productes";
	}

	@RequestMapping("/crearproducte")
	public String createProducte(Model model, Principal principal) {

		Producte producte = null;

		if (principal != null) {
			String username = principal.getName();
			producte = productesService.getProducte(username);
		}

		if (producte == null) {
			producte = new Producte();
		}

		model.addAttribute("producte", producte);

		return "crearproducte";
	}

	@RequestMapping(value = "/docrearproducte", method = RequestMethod.POST)
	public String doCrearProducte(Model model, @Validated(value=FormValidationGroup.class)  Producte producte,
			BindingResult result, Principal principal,
			@RequestParam(value = "delete", required = false) String delete) {
		
		if (result.hasErrors()) {

			return "crearproducte";
		}
		
		if(delete == null) {
			String username = principal.getName();
			producte.getUser().setUsername(username);

			productesService.saveOrUpdate(producte);

			return "productecreat";
		} else {
			productesService.delete(producte.getId());
			return "producteeliminat";
		}


	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("ID : " + id);
		return "home";
	}
}
