package com.tfc.uoc.edu.spring.web.controllers;

import javax.servlet.ServletException;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.apache.tiles.request.render.CannotRenderException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.NestedServletException;

@ControllerAdvice
public class ErrorHandler {
	
	private static Logger logger = Logger.getLogger(ErrorHandler.class);

	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		logger.error(ex.toString());
		return "errordb";
	}	
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDeniedException(AccessDeniedException ex) {
		logger.error(ex.toString());
		ex.printStackTrace();
		return "errorpermisos";
	}	
	
	@ExceptionHandler(ClassNotFoundException.class)
	public String handleClassNotFoundException(ClassNotFoundException ex) {
		logger.error(ex.toString());
		ex.printStackTrace();
		return "error";
	}	
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex) {
		logger.error(ex.toString());
		ex.printStackTrace();
		return "error";
	}	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public String handleConstraintViolationException(ConstraintViolationException ex) {
		logger.error(ex.toString());
		ex.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public String handleIllegalStateException(IllegalStateException ex) {
		logger.error(ex.toString());
		ex.printStackTrace();
		return "error";
	}	
	
	@ExceptionHandler(CannotRenderException.class)
	public String handleCannotRenderException(CannotRenderException ex) {
		logger.error(ex.toString());
		ex.printStackTrace();
		return "error";
	}	
	
	@ExceptionHandler(ServletException.class)
	public String handleServletException(ServletException ex) {
		logger.error(ex.toString());
		ex.printStackTrace();
		return "error";
	}	
	
	@ExceptionHandler(NestedServletException.class)
	public String handleNestedServletException(NestedServletException ex) {
		logger.error(ex.toString());
		ex.printStackTrace();
		return "error";
	}	
}
