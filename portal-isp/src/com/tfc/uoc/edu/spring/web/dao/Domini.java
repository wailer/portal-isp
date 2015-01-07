package com.tfc.uoc.edu.spring.web.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "productes")
@DiscriminatorValue("Domini")
public class Domini extends Producte {

	@NotBlank
	private String extensio;

	
	public Domini(String codi, String nom, String descripcio, float preu, boolean actiu, String extensio) {
		super(codi,nom,descripcio, preu, actiu);
		this.extensio = extensio;
	}
	
	public Domini() {
		super();
	}


	public String getExtensio() {
		return extensio;
	}

	public void setExtensio(String extensio) {
		this.extensio = extensio;
	}


	

}
