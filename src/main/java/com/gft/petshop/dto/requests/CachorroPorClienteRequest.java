package com.gft.petshop.dto.requests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CachorroPorClienteRequest {
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private String nome;
	private String porte;
	
	// ----------------------------------------------------------------------------------------------

	public CachorroPorClienteRequest() {}

	public CachorroPorClienteRequest(LocalDate dataNascimento, String nome, String porte) {
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.porte = porte;
	}

	// ----------------------------------------------------------------------------------------------

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}
}
