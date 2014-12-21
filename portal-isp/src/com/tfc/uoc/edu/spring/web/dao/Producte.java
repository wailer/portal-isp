package com.tfc.uoc.edu.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tfc.uoc.edu.spring.web.validation.ValidEmail;

public class Producte {

	private int id;
	@NotNull
	@Size(min=5, max=100, message="El nom ha de tenir entre 5 i 100 caràcters")
	private String name;
	
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*", message="No sembla un correu vàlid")
	@ValidEmail(min=5)
	private String email;
	
	@NotNull
	@Size(min=20, max=255, message="El nom ha de tenir entre 20 i 255 caràcters")
	private String text;

	public Producte() {

	}

	public Producte(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Producte(int id, String name, String email, String text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}

}
