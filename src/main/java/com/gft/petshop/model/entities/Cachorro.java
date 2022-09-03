package com.gft.petshop.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cachorro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@Column(nullable = false)
	private String nome;
	private String porte;

	@ManyToOne
	private Cliente dono;
	
	// ----------------------------------------------------------------------------------------------
	
	public Cachorro() {}

	public Cachorro(Integer id, LocalDate dataNascimento, String nome, String porte, Cliente dono) {
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.porte = porte;
		this.dono = dono;
	}
	
	public Cachorro(LocalDate dataNascimento, String nome, String porte, Cliente dono) {
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

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
	

}
