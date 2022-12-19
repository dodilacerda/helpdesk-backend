package com.dodi.helpdesk.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
	//Herda os métodos e atributos do Serializer
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}
	
	
}
