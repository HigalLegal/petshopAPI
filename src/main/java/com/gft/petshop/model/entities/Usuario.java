package com.gft.petshop.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private Boolean admin;

	// --------------------------------------------------------

	public Usuario() {
	}

	public Usuario(Long id, String login, String senha,  Boolean admin) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.admin = admin;
	}

	public Usuario(String login, String senha, Boolean admin) {
		this.login = login;
		this.senha = senha;
		this.admin = admin;
	}

	// --------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	

}