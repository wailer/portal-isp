package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tfc.uoc.edu.spring.web.rest.ConsultaDomini;
import com.tfc.uoc.edu.spring.web.rest.DominiResponse;
import com.tfc.uoc.edu.spring.web.service.ProductesService;

@RestController
@RequestMapping("/rest")
public class JsonController {
	
	private ProductesService productesService;
	
	@RequestMapping(value="/consultar-domini/{domini}/{extensio}", method=RequestMethod.GET, produces="application/json")
	
	public DominiResponse consultaDomini(@PathVariable("domini") String domini,@PathVariable("extensio") String extensio) {		
		ConsultaDomini consulta = new ConsultaDomini();
		return consulta.dominiDisponible(domini+"."+extensio);		
	}

}
