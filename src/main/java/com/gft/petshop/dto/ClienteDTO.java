package com.gft.petshop.dto;

import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {

	private Integer id;
	private String nome;
	private Integer idade;
	private String apelido;
	private List<CachorroDTO> cachorros = new ArrayList<>();
	private List<EnderecoDTO> enderecos = new ArrayList<>();

	// -----------------------------------------------------------------------------------------------

	public ClienteDTO() {
	}

	public ClienteDTO(Integer id, String nome, Integer idade, String apelido, List<CachorroDTO> cachorros,
			List<EnderecoDTO> enderecos) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.apelido = apelido;
		this.cachorros.addAll(cachorros);
		this.enderecos.addAll(enderecos);
	}

	public ClienteDTO(String nome, Integer idade, String apelido, List<CachorroDTO> cachorros,
			List<EnderecoDTO> enderecos) {
		this.nome = nome;
		this.idade = idade;
		this.apelido = apelido;
		this.cachorros.addAll(cachorros);
		this.enderecos.addAll(enderecos);
	}

	// -----------------------------------------------------------------------------------------------

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public List<CachorroDTO> getCachorros() {
		return cachorros;
	}

	public void setCachorros(List<CachorroDTO> cachorros) {
		this.cachorros.addAll(cachorros);
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos.addAll(enderecos);
	}
	
	// -----------------------------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return nome;
	}

}
