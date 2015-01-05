package com.tfc.uoc.edu.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		ex.printStackTrace();
		return "errordb";
	}	
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDeniedException(AccessDeniedException ex) {
		ex.printStackTrace();
		return "errorpermisos";
	}	
	
	@ExceptionHandler(ClassNotFoundException.class)
	public String handleClassNotFoundException(ClassNotFoundException ex) {
		ex.printStackTrace();
		return "error";
	}	
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex) {
		ex.printStackTrace();
		return "error";
	}	
	
}
