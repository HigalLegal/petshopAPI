package com.gft.petshop.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicoVeterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	// -------------------------------------------------------------------------------------------
	
	public MedicoVeterinario() {}

	public MedicoVeterinario(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public MedicoVeterinario(String nome) {
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
