package com.gft.petshop.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AtendimentoDTO {

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horario;
	private CachorroDTO cachorro;

	private List<MedicoVeterinarioDTO> medicos = new ArrayList<>();

	// ----------------------------------------------------------------------------------------------------------

	public AtendimentoDTO() {}

	public AtendimentoDTO(Integer id, LocalDate data, LocalTime horario, ClienteDTO cliente, CachorroDTO cachorro,
			List<MedicoVeterinarioDTO> medicos) {
		this.id = id;
		this.data = data;
		this.horario = horario;
		this.cachorro = cachorro;
		this.medicos.addAll(medicos);
	}

	public AtendimentoDTO(LocalDate data, LocalTime horario, CachorroDTO cachorro,
			List<MedicoVeterinarioDTO> medicos) {
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

	public CachorroDTO getCachorro() {
		return cachorro;
	}

	public void setCachorro(CachorroDTO cachorro) {
		this.cachorro = cachorro;
	}

	public List<MedicoVeterinarioDTO> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<MedicoVeterinarioDTO> medicos) {
		this.medicos.addAll(medicos);
	}

}
