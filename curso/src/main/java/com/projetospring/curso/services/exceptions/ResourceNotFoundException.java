package com.projetospring.curso.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Id não encontrado. id" + id);
	}
	
}
