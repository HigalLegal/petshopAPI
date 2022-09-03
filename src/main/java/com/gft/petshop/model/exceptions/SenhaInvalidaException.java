package com.gft.petshop.model.exceptions;

public class SenhaInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public SenhaInvalidaException() {
		super("Login ou senha inválida.");
	}

}
