package com.gft.petshop.dto.responses;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CachorroResponse {

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private String nome;
	private String porte;
	private String dono;

	// ----------------------------------------------------------------------------------------------

	public CachorroResponse() {}

	public CachorroResponse(Integer id, LocalDate dataNascimento, String nome, String porte, String dono) {
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.porte = porte;
		this.dono = dono;
	}

	// ----------------------------------------------------------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

}
