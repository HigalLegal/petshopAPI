package com.gft.petshop.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	private Integer idade;
	private String apelido;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Cachorro> cachorros = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	// -----------------------------------------------------------------------------------------------
	
	public Cliente() {}

	public Cliente(Integer id, String nome, Integer idade, String apelido, List<Cachorro> cachorros,
			List<Endereco> enderecos) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.apelido = apelido;
		this.cachorros.addAll(cachorros);
		this.enderecos.addAll(enderecos);
	}
	
	public Cliente(String nome, Integer idade, String apelido, List<Cachorro> cachorros,
			List<Endereco> enderecos) {
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

	public List<Cachorro> getCachorros() {
		return cachorros;
	}

	public void setCachorros(List<Cachorro> cachorros) {
		this.cachorros.addAll(cachorros);
		this.cachorros.forEach((cachorro) -> {
			cachorro.setDono(this);
		});
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos.addAll(enderecos);
		this.enderecos.forEach((endereco) -> {
			endereco.setCliente(this);
		});
	}
	
	

}
