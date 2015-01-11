package com.tfc.uoc.edu.spring.web.dao;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="serveis")
public abstract class Servei {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String estat;
	
	private int compra;  // Data compra en format unixtime
	private int alta;   // Data alta en format unixtime
	
	//private Map<String,String> parametres;  // Parametres particulars del servei
	
	
	@Autowired
	@OneToOne	
	private Producte producte;
	
	

}
