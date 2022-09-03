package com.gft.petshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gft.petshop.model.entities.Usuario;
import com.gft.petshop.model.exceptions.SenhaInvalidaException;
import com.gft.petshop.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService {
	
	@Autowired @Lazy
	private PasswordEncoder encoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// -----------------------------------------------------------------------------------------------
	
	public void salvar(Usuario usuario) {
		
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		
		usuario.setId(null);
		usuario.setSenha(senhaCriptografada);
		
		usuarioRepository.save(usuario);
	}
	
	public UserDetails autenticar(Usuario usuario) {
		
		UserDetails user = loadUserByUsername(usuario.getLogin());
		boolean senhasBatem = encoder.matches(usuario.getSenha(), user.getPassword());
		
		if(senhasBatem) {
			return user;
		}
		
		throw new SenhaInvalidaException();
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(username).orElseThrow(() -> {
			return new UsernameNotFoundException("Usuário inexistente.");
		});
		
		String[] permissoes = usuario.getAdmin() ? new String[] {"ADMIN", "USER"} : new String[] {"USER"};
		
		return User
				.builder()
				.username(usuario.getLogin())
				.password(usuario.getSenha())
				.roles(permissoes)
				.build();
	}
}
