package com.gft.petshop.controllers;

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

import com.gft.petshop.dto.MedicoVeterinarioDTO;
import com.gft.petshop.dto.requests.MedicoVeterinarioRequest;
import com.gft.petshop.dto.responses.MedicoVeterinarioResponse;
import com.gft.petshop.mapper.MapperResponseRequestDTO;
import com.gft.petshop.services.MedicoVeterinarioService;

@RestController
@RequestMapping("/medicos")
public class MedicoVeterinarioController {

	@Autowired
	private MedicoVeterinarioService medicoVeterinarioService;

	@Autowired
	private MapperResponseRequestDTO mapperResponseRequestDTO;

	// --------------------------------------------------------------------------------------

	@GetMapping
	public ResponseEntity<Page<MedicoVeterinarioResponse>> listarTodos(@PageableDefault Pageable pageable) {

		Page<MedicoVeterinarioResponse> medicos = medicoVeterinarioService.buscarTodos(pageable)
				.map(mapperResponseRequestDTO::medicoDtoParaResponse);

		return new ResponseEntity<>(medicos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<MedicoVeterinarioResponse>> buscarPeloId(@PathVariable Integer id) {

		MedicoVeterinarioDTO medicoDTO = medicoVeterinarioService.buscarPorId(id).get();

		MedicoVeterinarioResponse medico = mapperResponseRequestDTO.medicoDtoParaResponse(medicoDTO);

		return new ResponseEntity<>(Optional.of(medico), HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ResponseEntity<Void> adicionar(@RequestBody MedicoVeterinarioRequest medicoVeterinario) {

		medicoVeterinarioService.cadastrar(mapperResponseRequestDTO.medicoRequestParaDTO(medicoVeterinario));

		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@PostMapping("/novo/popular-banco")
	public ResponseEntity<Void> popularBanco() {

		var medico = new MedicoVeterinarioRequest("Bluezão");
		
		medicoVeterinarioService.cadastrar(mapperResponseRequestDTO.medicoRequestParaDTO(medico));

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id,
			@RequestBody MedicoVeterinarioRequest medicoVeterinario) {

		try {
			medicoVeterinarioService.alterar(id,
					mapperResponseRequestDTO.medicoRequestParaDTO(medicoVeterinario));

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {

		try {
			medicoVeterinarioService.excluir(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
