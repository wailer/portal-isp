package com.tfc.uoc.edu.spring.web.rest;


public class DominiResponse extends RestResponse {
	private String status;
	private String domain;
	private boolean available;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "DominiResponse [status=" + status + ", domain=" + domain
				+ ", available=" + available + "]";
	}

	
}
