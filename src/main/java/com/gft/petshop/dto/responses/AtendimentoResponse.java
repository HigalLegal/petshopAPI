package com.gft.petshop.dto.responses;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AtendimentoResponse {
	
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horario;
	private CachorroResponse cachorro;

	private List<MedicoVeterinarioResponse> medicos = new ArrayList<>();

	// ----------------------------------------------------------------------------------------------------------

	public AtendimentoResponse() {}

	public AtendimentoResponse(Integer id, LocalDate data, LocalTime horario, CachorroResponse cachorro,
			List<MedicoVeterinarioResponse> medicos) {
		this.id = id;
		this.data = data;
		this.horario = horario;
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
	public CachorroResponse getCachorro() {
		return cachorro;
	}

	public void setCachorro(CachorroResponse cachorro) {
		this.cachorro = cachorro;
	}

	public List<MedicoVeterinarioResponse> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<MedicoVeterinarioResponse> medicos) {
		this.medicos.addAll(medicos);
	}

}
