package com.gft.petshop.dto.responses;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CachorroPorClienteResponse {

	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private String nome;
	private String porte;

	// ----------------------------------------------------------------------------------------------

	public CachorroPorClienteResponse() {}

	public CachorroPorClienteResponse(Integer id, LocalDate dataNascimento, String nome, String porte) {
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.porte = porte;
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

}
