package com.tfc.uoc.edu.spring.web.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "serveis")
@DiscriminatorValue("Allotjament")
public class ServeiAllotjament extends Servei {
		

	private int idServidor; // Servidor on està ubicat l'allotjament

	public ServeiAllotjament(Allotjament allotjament, User user) {
		super(allotjament,user);
		this.setProducte(allotjament);
		this.setUser(user);
		this.setEstat("CISTELLA");		
	}
	
	public ServeiAllotjament() {
		
	}

	@Override
	public String toString() {
		return "ServeiAllotjament [idServidor=" + idServidor + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode()
				+ ", getId()=" + getId() + ", getEstat()=" + getEstat()
				+ ", getCompra()=" + getCompra() + ", getAlta()=" + getAlta()
				+ ", getProducte()=" + getProducte() + ", getClass()="
				+ getClass() + "]";
	}

	public int getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}
	
	

}
