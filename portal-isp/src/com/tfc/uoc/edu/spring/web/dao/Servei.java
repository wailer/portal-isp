package com.tfc.uoc.edu.spring.web.dao;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="serveis")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipus", discriminatorType = DiscriminatorType.STRING)
public abstract class Servei {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String estat;	// El possibles estats són {CISTELLA, COMANDA, ACTIU, DESACTIVAT, CADUCAT}
	
	private int compra;  // Data compra en format unixtime
	
	private int alta;   // Data alta en format unixtime	
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="producte_id")
	@NotNull
	private Producte producte;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="user_id")
	@NotNull
	private User user;
	

	public Servei(Producte producte, User user) {
		super();		
		this.estat = "CISTELLA";
		this.compra = compra;
		this.alta = alta;
		this.producte = producte;
		this.user = user;
	}

		
	public Servei() {
	
	}



	@Override
	public String toString() {
		return "Servei [id=" + id + ", estat=" + estat + ", compra=" + compra
				+ ", alta=" + alta + ", producte=" + producte + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Servei other = (Servei) obj;
		if (id != other.id)
			return false;
		return true;
	}

	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}

	public int getCompra() {
		return compra;
	}

	public void setCompra(int compra) {
		this.compra = compra;
	}

	public int getAlta() {
		return alta;
	}

	public void setAlta(int alta) {
		this.alta = alta;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
