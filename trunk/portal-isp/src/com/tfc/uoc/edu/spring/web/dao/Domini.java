package com.tfc.uoc.edu.spring.web.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "productes")
@DiscriminatorValue("Domini")
public class Domini extends Producte {

	private String extensio;

	
	public Domini(String codi, String nom, String descripcio, float preu, boolean actiu, String extensio) {
		super(codi,nom,descripcio, preu, actiu);
		this.extensio = extensio;
	}
	
	public Domini() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((extensio == null) ? 0 : extensio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domini other = (Domini) obj;
		if (extensio == null) {
			if (other.extensio != null)
				return false;
		} else if (!extensio.equals(other.extensio))
			return false;
		return true;
	}

	public String getExtensio() {
		return extensio;
	}

	public void setExtensio(String extensio) {
		this.extensio = extensio;
	}


	

}
