package com.gft.petshop.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horario;
	
	@OneToOne
	private Cachorro cachorro;
	
	@OneToMany
	private List<MedicoVeterinario> medicos = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------------
	
	public Atendimento() {}

	public Atendimento(Integer id, LocalDate data, LocalTime horario, Cliente cliente, Cachorro cachorro,
			List<MedicoVeterinario> medicos) {
		this.id = id;
		this.data = data;
		this.horario = horario;
		this.cachorro = cachorro;
		this.medicos.addAll(medicos);
	}
	
	public Atendimento(LocalDate data, LocalTime horario, Cliente cliente, Cachorro cachorro,
			List<MedicoVeterinario> medicos) {
		this.data = data;
		this.cachorro = cachorro;
		this.medicos.addAll(medicos);
	}
	
	// ----------------------------------------------------------------------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public LocalTime getHorario() {
		return horario;
	}
	
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Cachorro getCachorro() {
		return cachorro;
	}

	public void setCachorro(Cachorro cachorro) {
		this.cachorro = cachorro;
	}

	public List<MedicoVeterinario> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<MedicoVeterinario> medicos) {
		this.medicos.addAll(medicos);
	}
	

}
