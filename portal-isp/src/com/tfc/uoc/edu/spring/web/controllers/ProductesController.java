package com.tfc.uoc.edu.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("productes",productes);
		
		return "productes";
	}

	@RequestMapping("/crearproducte")
	public String createProducte(Model model) {
		
		model.addAttribute("producte", new Producte());
		
		return "crearproducte";
	}

	@RequestMapping(value="/docrearproducte", method=RequestMethod.POST)
	public String doCrearProducte(Model model, @Valid Producte offer, BindingResult result) {
		if(result.hasErrors()) {
			
			return "crearproducte";
		}
		
		productesService.createProducte(offer);
		return "productecreat";
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("ID : " + id);		
		return "home";
	}
}
