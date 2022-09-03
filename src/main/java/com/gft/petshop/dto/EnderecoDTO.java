package com.gft.petshop.dto;

public class EnderecoDTO {
	
	private Integer id;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private Integer numero;
	private String complemento;

	private ClienteDTO cliente;

	// ------------------------------------------------------------------------------------------

	public EnderecoDTO() {
	}

	public EnderecoDTO(Integer id, String estado, String cidade, String bairro, String rua, Integer numero,
			String complemento, ClienteDTO cliente) {
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cliente = cliente;
	}

	public EnderecoDTO(String estado, String cidade, String bairro, String rua, Integer numero, String complemento,
			ClienteDTO cliente) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cliente = cliente;
	}

	// ------------------------------------------------------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public ClienteDTO getClienteDTO() {
		return cliente;
	}

	public void setClienteDTO(ClienteDTO cliente) {
		this.cliente = cliente;
	}

}
