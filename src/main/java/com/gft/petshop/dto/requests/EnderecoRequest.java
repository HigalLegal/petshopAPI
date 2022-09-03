package com.gft.petshop.dto.requests;

import com.gft.petshop.dto.responses.ClienteResponseAll;

public class EnderecoRequest {

	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private Integer numero;
	private String complemento;

	private ClienteResponseAll cliente;

	// ------------------------------------------------------------------------------------------

	public EnderecoRequest() {}

	public EnderecoRequest(String estado, String cidade, String bairro, String rua, Integer numero,
			String complemento, ClienteResponseAll cliente) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cliente = cliente;
	}

	// ------------------------------------------------------------------------------------------

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public ClienteResponseAll getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResponseAll cliente) {
		this.cliente = cliente;
	}

}
