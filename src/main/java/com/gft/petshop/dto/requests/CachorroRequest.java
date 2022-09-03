package com.gft.petshop.dto.requests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.petshop.dto.responses.ClienteResponseAll;

public class CachorroRequest {

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private String nome;
	private String porte;

	private ClienteResponseAll dono;

	// ----------------------------------------------------------------------------------------------

	public CachorroRequest() {
	}

	public CachorroRequest(LocalDate dataNascimento, String nome, String porte, ClienteResponseAll dono) {
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.porte = porte;
		this.dono = dono;
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

	public ClienteResponseAll getDono() {
		return dono;
	}

	public void setDono(ClienteResponseAll dono) {
		this.dono = dono;
	}

}
