package com.gft.petshop.dto;

public class MedicoVeterinarioDTO {
	
	private Integer id;
	private String nome;
	
	// -------------------------------------------------------------------------------------------
	
	public MedicoVeterinarioDTO() {}

	public MedicoVeterinarioDTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public MedicoVeterinarioDTO(String nome) {
		this.nome = nome;
	}
	
	// -------------------------------------------------------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
