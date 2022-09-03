package com.gft.petshop.dto;

import java.time.LocalDate;

public class CachorroDTO {

	private Integer id;
	private LocalDate dataNascimento;
	private String nome;
	private String porte;
	private ClienteDTO dono;

	// ----------------------------------------------------------------------------------------------

	public CachorroDTO() {}

	public CachorroDTO(Integer id, LocalDate dataNascimento, String nome, String porte, ClienteDTO dono) {
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.porte = porte;
		this.dono = dono;
	}

	public CachorroDTO(LocalDate dataNascimento, String nome, String porte, ClienteDTO dono) {
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

	public ClienteDTO getDono() {
		return dono;
	}

	public void setDono(ClienteDTO dono) {
		this.dono = dono;
	}

}
