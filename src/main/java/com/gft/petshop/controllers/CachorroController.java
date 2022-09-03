package com.gft.petshop.controllers;

import java.time.LocalDate;
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

import com.gft.petshop.dto.CachorroDTO;
import com.gft.petshop.dto.requests.CachorroRequest;
import com.gft.petshop.dto.responses.CachorroResponse;
import com.gft.petshop.dto.responses.ClienteResponseAll;
import com.gft.petshop.mapper.MapperResponseRequestDTO;
import com.gft.petshop.services.CachorroService;

@RestController
@RequestMapping("/cachorros")
public class CachorroController {

	@Autowired
	private CachorroService cachorroService;
	
	@Autowired
	private MapperResponseRequestDTO mapperResponseRequestDTO;

	// --------------------------------------------------------------------------------------

	@GetMapping
	public ResponseEntity<Page<CachorroResponse>> listarTodos(@PageableDefault Pageable pageable) {

		Page<CachorroResponse> cachorros = cachorroService.buscarTodos(pageable)
				.map(mapperResponseRequestDTO::cachorroDtoParaResponse);

		return new ResponseEntity<>(cachorros, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<CachorroResponse>> buscarPeloId(@PathVariable Integer id) {

		CachorroDTO cachorroDTO = cachorroService.buscarPorId(id).get();
		CachorroResponse cachorro = mapperResponseRequestDTO.cachorroDtoParaResponse(cachorroDTO);

		return new ResponseEntity<>(Optional.of(cachorro), HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ResponseEntity<Void> adicionar(@RequestBody CachorroRequest cachorro) {

		cachorroService.cadastrar(mapperResponseRequestDTO.cachorroRequestParaDTO(cachorro));

		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@PostMapping("/novo/popular-banco")
	public ResponseEntity<Void> popularBanco() {

		var cachorro = new CachorroRequest();
		
		cachorro.setNome("Astolfo");
		cachorro.setDataNascimento(LocalDate.now());
		cachorro.setPorte("Médio");
		cachorro.setDono(new ClienteResponseAll(1, null, null, null));
		
		cachorroService.cadastrar(mapperResponseRequestDTO.cachorroRequestParaDTO(cachorro));

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody CachorroRequest cachorro) {

		try {
			cachorroService.alterar(id, mapperResponseRequestDTO.cachorroRequestParaDTO(cachorro));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {

		try {
			cachorroService.excluir(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
