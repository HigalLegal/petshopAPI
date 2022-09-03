package com.gft.petshop.handlers;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gft.petshop.model.erros.MensagemDeErro;
import com.gft.petshop.model.exceptions.SenhaInvalidaException;

@ControllerAdvice
public class RestHandlerException {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<MensagemDeErro> handlerEntityNotFoundException(EntityNotFoundException exception) {
		var error = new MensagemDeErro("Not found", HttpStatus.NOT_FOUND.value(), exception.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<MensagemDeErro> handlerUsernameNotFoundException(UsernameNotFoundException exception) {
		var error = new MensagemDeErro("Credenciais inválidas.", HttpStatus.NOT_FOUND.value(), exception.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SenhaInvalidaException.class)
	public ResponseEntity<MensagemDeErro> handlerSenhaInvalidaException(SenhaInvalidaException exception) {
		var error = new MensagemDeErro("Credenciais inválidas.", HttpStatus.NOT_FOUND.value(), exception.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
