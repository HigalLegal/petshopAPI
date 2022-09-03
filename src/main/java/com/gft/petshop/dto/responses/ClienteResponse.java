package com.gft.petshop.dto.responses;

import java.util.ArrayList;
import java.util.List;

public class ClienteResponse {

	private Integer id;
	private String nome;
	private Integer idade;
	private String apelido;
	private List<CachorroPorClienteResponse> cachorros = new ArrayList<>();
	private List<EnderecoPorClienteResponse> enderecos = new ArrayList<>();

	// -----------------------------------------------------------------------------------------------

	public ClienteResponse() {}

	public ClienteResponse(Integer id, String nome, Integer idade, String apelido, List<CachorroPorClienteResponse> cachorros,
			List<EnderecoPorClienteResponse> enderecos) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.apelido = apelido;
		this.cachorros.addAll(cachorros);
		this.enderecos.addAll(enderecos);
	}

	public ClienteResponse(String nome, Integer idade, String apelido, List<CachorroPorClienteResponse> cachorros,
			List<EnderecoPorClienteResponse> enderecos) {
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

	public List<CachorroPorClienteResponse> getCachorros() {
		return cachorros;
	}

	public void setCachorros(List<CachorroPorClienteResponse> cachorros) {
		this.cachorros.addAll(cachorros);
	}

	public List<EnderecoPorClienteResponse> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoPorClienteResponse> enderecos) {
		this.enderecos.addAll(enderecos);
	}

}
