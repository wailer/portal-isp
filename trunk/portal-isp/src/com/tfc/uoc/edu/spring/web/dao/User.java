package com.tfc.uoc.edu.spring.web.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.tfc.uoc.edu.spring.web.dao.FormValidationGroups.FormValidationGroup;
import com.tfc.uoc.edu.spring.web.dao.FormValidationGroups.PersistenceValidationGroup;
import com.tfc.uoc.edu.spring.web.validation.ValidEmail;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank(groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	@Size(min = 5, max = 15, message = "", groups = {
			PersistenceValidationGroup.class, FormValidationGroup.class })
	@Pattern(regexp = "^\\w{5,}$", groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	@Column(name = "username", unique = true)
	private String username;

	@NotBlank(groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	@Pattern(regexp = "^\\S+$", groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	@Size(min = 5, max = 15, groups = { FormValidationGroup.class })
	private String password;

	private boolean enabled = false;

	private String authority;

	@ValidEmail(groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String email;

	@NotBlank
	@Size(min = 2, max = 20, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String nom;

	@NotBlank
	@Size(min = 5, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String cognoms;

	@NotBlank
	@Size(min = 9, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String dni;

	@NotBlank
	@Size(min = 9, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String telefon;

	@NotBlank
	@Size(min = 5, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String direccio;

	@NotBlank
	@Size(min = 5, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String codiPostal;

	@NotBlank
	@Size(min = 2, groups = { PersistenceValidationGroup.class,
			FormValidationGroup.class })
	private String poblacio;

	private String empresa;

	public User() {

	}

	public User(String username, String password, boolean enabled,
			String authority, String email, String nom, String cognoms,
			String dni, String telefon, String direccio, String codiPostal,
			String poblacio, String empresa) {	
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.email = email;
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
		this.telefon = telefon;
		this.direccio = direccio;
		this.codiPostal = codiPostal;
		this.poblacio = poblacio;
		this.empresa = empresa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public String getCodiPostal() {
		return codiPostal;
	}

	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", enabled=" + enabled + ", authority="
				+ authority + ", email=" + email + ", nom=" + nom
				+ ", cognoms=" + cognoms + ", dni=" + dni + ", telefon="
				+ telefon + ", direccio=" + direccio + ", codiPostal="
				+ codiPostal + ", poblacio=" + poblacio + ", empresa="
				+ empresa + "]";
	}

}
