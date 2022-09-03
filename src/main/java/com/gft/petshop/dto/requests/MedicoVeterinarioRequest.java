package com.gft.petshop.dto.requests;

public class MedicoVeterinarioRequest {
	
	private String nome;
	
	// -------------------------------------------------------------------------------------------
	
	public MedicoVeterinarioRequest() {}
	
	public MedicoVeterinarioRequest(String nome) {
		this.nome = nome;
	}
	
	// -------------------------------------------------------------------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
