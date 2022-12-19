package com.dodi.helpdesk.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	//Herda os métodos e atributos do Serializer
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}
	
	
}
