package com.gft.petshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gft.petshop.dto.CredenciaisDTO;
import com.gft.petshop.dto.TokenDTO;
import com.gft.petshop.mapper.MapperResponseRequestDTO;
import com.gft.petshop.model.entities.Usuario;
import com.gft.petshop.model.exceptions.SenhaInvalidaException;
import com.gft.petshop.requests.UsuarioRequest;
import com.gft.petshop.security.jwt.JwtService;
import com.gft.petshop.services.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private MapperResponseRequestDTO mapperResponseRequestDTO;
	
	// ----------------------------------------------------------------------------------------------------
	
	@PostMapping("/novo")
	public ResponseEntity<Void> cadastrarUsuario(@RequestBody @Valid UsuarioRequest usuario) {
		
		usuarioService.salvar(mapperResponseRequestDTO.usuarioRequestParaEntidade(usuario));
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/auth")
	public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciaisDTO) {
		try {
			
			var usuario = new Usuario();
			
			usuario.setLogin(credenciaisDTO.getLogin());
			usuario.setSenha(credenciaisDTO.getSenha());
			
			usuarioService.autenticar(usuario);
			String token = jwtService.gerarToken(usuario);
			
			return new TokenDTO(usuario.getLogin(), token);
			
		} catch(UsernameNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		} catch(SenhaInvalidaException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

}
