package com.tfc.uoc.edu.spring.web.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Scope("singleton")
public class ConsultaDomini {

	private static Logger logger = Logger.getLogger(ConsultaDomini.class);

	@Autowired
	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private HttpEntity<?> requestEntity;
	
	private List<HttpMessageConverter<?>> converters;

	public ConsultaDomini() {
		restTemplate = new RestTemplate();
		converters = restTemplate.getMessageConverters();
		configureMessageConverters(this.converters);
		restTemplate.setMessageConverters(converters);
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestEntity = new HttpEntity<Object>(headers);
		
		logger.info("HTTP converters disponibles >> "
				+ restTemplate.getMessageConverters().toString());
	}

	public DominiResponse dominiDisponible(String domini) {

		ResponseEntity<DominiResponse> responseEntity = restTemplate.exchange(
				"http://freedomainapi.com?key=jc8l2uzf2r&domain=" + domini,
				HttpMethod.GET, requestEntity, DominiResponse.class);
		DominiResponse result = responseEntity.getBody();

		logger.info("REST: ConsultaDomini >> " + result.toString());
		return result;
	}

	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		logger.info("REST: ConsultaDomini >> Configurant converters...");
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	    List<MediaType> jsonTypes = new ArrayList<>(jsonConverter.getSupportedMediaTypes());
	    jsonTypes.add(MediaType.parseMediaType("text/json; charset=utf-8"));
	    jsonConverter.setSupportedMediaTypes(jsonTypes);
	    this.converters.add(jsonConverter);
	}

	public List<HttpMessageConverter<?>> getConverters() {
		return converters;
	}

	public void setConverters(List<HttpMessageConverter<?>> converters) {
		this.converters = converters;
	}
}
