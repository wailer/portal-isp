package com.tfc.uoc.edu.spring.web.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tfc.uoc.edu.spring.web.dao.Domini;
import com.tfc.uoc.edu.spring.web.dao.Producte;
import com.tfc.uoc.edu.spring.web.service.ProductesService;

@Controller
public class JsonController {
	
	private ProductesService productesService;
	
	@RequestMapping(value="/getStatus", method=RequestMethod.GET, produces="application/json")
	@ResponseBody 
	public Map<String, Object> getStatus(Principal principal) {
		Producte producte = null;
		
		if(principal == null) {
			producte = new Domini();			
		} 
		Map<String, Object> jsonData = new HashMap<String, Object>();
		jsonData.put("producte", producte);		
		return jsonData;
	}

}
