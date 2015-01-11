package com.tfc.uoc.edu.spring.web.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "serveis")
@DiscriminatorValue("Domini")
public class ServeiDomini extends Servei {
	

	private String nom;    //nom del domini sense el tld
	
	public ServeiDomini(String nom,Domini domini,User user) {
		super(domini,user);
		this.setEstat("CISTELLA");
		this.setProducte(domini);
		this.nom = nom;
	}
	
	public ServeiDomini() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "ServeiDomini [nom=" + nom + ", getNom()=" + getNom()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}


	

}
