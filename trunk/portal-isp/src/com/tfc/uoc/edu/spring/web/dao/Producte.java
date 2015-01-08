package com.tfc.uoc.edu.spring.web.dao;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.tfc.uoc.edu.spring.web.dao.ValidationGroups.FormValidationGroup;
import com.tfc.uoc.edu.spring.web.dao.ValidationGroups.PersistenceValidationGroup;

@Entity
@Table(name = "productes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipus", discriminatorType = DiscriminatorType.STRING)
public abstract class Producte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotBlank
	private int id;	
	
	@NotBlank
	@Size(min = 2, max = 20, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	@Column(name = "codi", unique = true)
	private String codi;

	@NotBlank
	@Size(min = 2, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String nom;

	@NotBlank
	@Size(max = 100, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String descripcio;

	@NotBlank
	private float preu;
	
	@NotBlank
	private boolean actiu;


	public Producte() {

	}

	public Producte(String codi, String nom, String descripcio, float preu, boolean actiu) {	
		this.codi = codi;
		this.nom = nom;
		this.descripcio = descripcio;
		this.preu = preu;
		this.actiu = actiu;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codi == null) ? 0 : codi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producte other = (Producte) obj;
		if (codi == null) {
			if (other.codi != null)
				return false;
		} else if (!codi.equals(other.codi))
			return false;
		return true;
	}

	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public int getId() {
		return id;
	}


	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isActiu() {
		return actiu;
	}

	public void setActiu(boolean actiu) {
		this.actiu = actiu;
	}

	public void setId(int id) {
		this.id = id;
	}


}
