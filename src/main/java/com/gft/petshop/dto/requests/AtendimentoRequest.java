package com.gft.petshop.dto.requests;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.petshop.dto.responses.CachorroPorClienteResponse;
import com.gft.petshop.dto.responses.ClienteResponseAll;
import com.gft.petshop.dto.responses.MedicoVeterinarioResponse;

public class AtendimentoRequest {

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime horario;
	
	private CachorroPorClienteResponse cachorro;

	private List<MedicoVeterinarioResponse> medicos = new ArrayList<>();

	// ----------------------------------------------------------------------------------------------------------

	public AtendimentoRequest() {
	}

	public AtendimentoRequest(LocalDate data, LocalTime horario, ClienteResponseAll cliente,
			CachorroPorClienteResponse cachorro, List<MedicoVeterinarioResponse> medicos) {
		this.data = data;
		this.cachorro = cachorro;
		this.medicos.addAll(medicos);
	}

	// ----------------------------------------------------------------------------------------------------------

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

	public CachorroPorClienteResponse getCachorro() {
		return cachorro;
	}

	public void setCachorro(CachorroPorClienteResponse cachorro) {
		this.cachorro = cachorro;
	}

	public List<MedicoVeterinarioResponse> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<MedicoVeterinarioResponse> medicos) {
		this.medicos.addAll(medicos);
	}

}
