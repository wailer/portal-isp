package com.tfc.uoc.edu.spring.web.dao;

/**
 * Missatges que s'utilitzaran per notificar el resultat de les operacions a
 * l'usuari, dins del panell de control. El missatge no cotindrà cap text, sinó
 * la clau que referencia al text dins del fitxer messages.properties * 
 */

public class Missatge {

	private String key;
	private boolean error;

	public Missatge(String key, boolean error) {		
		this.key = key;
		this.error = error;
	}
	
	public Missatge() {
		
	}

	public String getKey() {
		return key;
	}

	public void seKey(String key) {
		this.key = key;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
