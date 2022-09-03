package com.gft.petshop.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.petshop.dto.AtendimentoDTO;
import com.gft.petshop.dto.requests.AtendimentoRequest;
import com.gft.petshop.dto.responses.AtendimentoResponse;
import com.gft.petshop.dto.responses.CachorroPorClienteResponse;
import com.gft.petshop.dto.responses.MedicoVeterinarioResponse;
import com.gft.petshop.mapper.MapperResponseRequestDTO;
import com.gft.petshop.services.AtendimentoService;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;

	@Autowired
	private MapperResponseRequestDTO mapperResponseRequestDTO;

	// --------------------------------------------------------------------------------------

	@GetMapping
	public ResponseEntity<Page<AtendimentoResponse>> listarTodos(@PageableDefault Pageable pageable) {

		Page<AtendimentoResponse> atendimentos = atendimentoService.buscarTodos(pageable)
				.map(mapperResponseRequestDTO::atendimentoDtoParaResponse);

		return new ResponseEntity<>(atendimentos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<AtendimentoResponse>> buscarPeloId(@PathVariable Integer id) {

		AtendimentoDTO atendimentoDTO = atendimentoService.buscarPorId(id).get();

		AtendimentoResponse atendimento = mapperResponseRequestDTO.atendimentoDtoParaResponse(atendimentoDTO);

		return new ResponseEntity<>(Optional.of(atendimento), HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ResponseEntity<Void> adicionar(@RequestBody AtendimentoRequest atendimento) {

		atendimentoService.cadastrar(mapperResponseRequestDTO.atendimentoRequestParaDTO(atendimento));

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PostMapping("/novo/popular-banco")
	public ResponseEntity<Void> popularBanco() {
		var atendimento = new AtendimentoRequest();
		
		atendimento.setData(LocalDate.now());
		atendimento.setHorario(LocalTime.now());
		atendimento.setCachorro(new CachorroPorClienteResponse(1, null, null, null));
		atendimento.setMedicos(List.of(new MedicoVeterinarioResponse(1, null)));
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody AtendimentoRequest atendimento) {

		try {

			atendimentoService.alterar(id, mapperResponseRequestDTO.atendimentoRequestParaDTO(atendimento));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {

		try {
			atendimentoService.excluir(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
