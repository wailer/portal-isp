package com.tfc.uoc.edu.spring.web.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productes")
@DiscriminatorValue("Allotjament")
public class Allotjament extends Producte {

	private String plantillaPlesk;
	
	@NotNull
	private boolean destacat; // Si és cert, es destaca a la portada

	@NotNull
	private float espai; // Gb

	@NotNull
	private int dominis;

	@NotNull
	private int busties; // Bústies de correu
	
	public Allotjament() {
		super();
	}

	public Allotjament(String codi, String nom, String descripcio, float preu, boolean actiu,
			String plantillaPlesk, float espai, int dominis, int busties) {
		super(codi,nom,descripcio, preu, actiu);
		this.plantillaPlesk = plantillaPlesk;
		this.espai = espai;
		this.dominis = dominis;
		this.busties = busties;
	}

	public String getPlantillaPlesk() {
		return plantillaPlesk;
	}

	public void setPlantillaPlesk(String plantillaPlesk) {
		this.plantillaPlesk = plantillaPlesk;
	}

	public float getEspai() {
		return espai;
	}

	public void setEspai(float espai) {
		this.espai = espai;
	}

	public int getDominis() {
		return dominis;
	}

	public void setDominis(int dominis) {
		this.dominis = dominis;
	}

	public int getBusties() {
		return busties;
	}

	public void setBusties(int busties) {
		this.busties = busties;
	}

	
	public boolean isDestacat() {
		return destacat;
	}

	public void setDestacat(boolean destacat) {
		this.destacat = destacat;
	}

	@Override
	public String toString() {
		return "Allotjament [plantillaPlesk=" + plantillaPlesk + ", espai="
				+ espai + ", dominis=" + dominis + ", busties=" + busties
				+ ", getPlantillaPlesk()=" + getPlantillaPlesk()
				+ ", getEspai()=" + getEspai() + ", getDominis()="
				+ getDominis() + ", getBusties()=" + getBusties()
				+ ", hashCode()=" + hashCode() + ", getCodi()=" + getCodi()
				+ ", getPreu()=" + getPreu() + ", getId()=" + getId()
				+ ", getDescripcio()=" + getDescripcio() + ", getNom()="
				+ getNom() + ", isActiu()=" + isActiu() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
	

}
