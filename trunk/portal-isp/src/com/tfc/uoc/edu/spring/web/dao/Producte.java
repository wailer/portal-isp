package com.tfc.uoc.edu.spring.web.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="offers")
public class Producte {

	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min=20, max=255,groups={PersistenceValidationGroup.class, FormValidationGroup.class})	
	private String text;

	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	public Producte() {
		this.user = new User();	
	}

	public Producte(User user, String text) {
		this.user  = user;		
		this.text = text;
	}

	public Producte(int id, User user, String text) {
		this.id = id;
		this.user = user;		
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	public String getUsername() {
		return user.getUsername();
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
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
