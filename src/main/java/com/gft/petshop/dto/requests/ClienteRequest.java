package com.gft.petshop.dto.requests;

import java.util.ArrayList;
import java.util.List;

public class ClienteRequest {
	
	private String nome;
	private Integer idade;
	private String apelido;
	private List<CachorroPorClienteRequest> cachorros = new ArrayList<>();
	private List<EnderecoPorClienteRequest> enderecos = new ArrayList<>();

	// -----------------------------------------------------------------------------------------------

	public ClienteRequest() {}

	public ClienteRequest(String nome, Integer idade, String apelido, List<CachorroPorClienteRequest> cachorros,
			List<EnderecoPorClienteRequest> enderecos) {
		this.nome = nome;
		this.idade = idade;
		this.apelido = apelido;
		this.cachorros.addAll(cachorros);
		this.enderecos.addAll(enderecos);
	}

	// -----------------------------------------------------------------------------------------------

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

	public List<CachorroPorClienteRequest> getCachorros() {
		return cachorros;
	}

	public void setCachorros(List<CachorroPorClienteRequest> cachorros) {
		this.cachorros.addAll(cachorros);
	}

	public List<EnderecoPorClienteRequest> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoPorClienteRequest> enderecos) {
		this.enderecos.addAll(enderecos);
	}

}
