package com.gft.petshop.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioRequest {
	
	@NotNull @NotEmpty
	private String login;
	
	@NotNull @NotEmpty
	private String senha;
	
	@NotNull
	private Boolean admin;

	// --------------------------------------------------------

	public UsuarioRequest() {}

	public UsuarioRequest(String login, String senha, Boolean admin) {
		this.login = login;
		this.senha = senha;
		this.admin = admin;
	}

	// --------------------------------------------------------

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
