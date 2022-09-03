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

import com.gft.petshop.dto.requests.EnderecoRequest;
import com.gft.petshop.dto.responses.ClienteResponseAll;
import com.gft.petshop.dto.responses.EnderecoResponse;
import com.gft.petshop.mapper.MapperResponseRequestDTO;
import com.gft.petshop.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private MapperResponseRequestDTO mapperResponseRequestDTO;

	// ---------------------------------------------------------------------------------------------------

	@GetMapping
	public ResponseEntity<Page<EnderecoResponse>> listarTodos(@PageableDefault Pageable pageable) {

		Page<EnderecoResponse> enderecos = enderecoService.buscarTodos(pageable)
				.map(mapperResponseRequestDTO::enderecoDtoParaResponse);

		return new ResponseEntity<>(enderecos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<EnderecoResponse>> buscarPeloId(@PathVariable Integer id) {

		EnderecoResponse endereco = mapperResponseRequestDTO
				.enderecoDtoParaResponse(enderecoService.buscarPorId(id).get());

		return new ResponseEntity<>(Optional.of(endereco), HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ResponseEntity<Void> adicionar(@RequestBody EnderecoRequest endereco) {

		enderecoService.cadastrar(mapperResponseRequestDTO.enderecoRequestParaDTO(endereco));

		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@PostMapping("/novo/popular-banco")
	public ResponseEntity<Void> popularBanco() {

		var endereco = new EnderecoRequest();
		
		endereco.setEstado("Ceará");
		endereco.setCidade("Icó");
		endereco.setBairro("Gerência");
		endereco.setRua("Rua C");
		endereco.setNumero(14);
		endereco.setComplemento("casa");
		endereco.setCliente(new ClienteResponseAll(1, null, null, null));
		
		enderecoService.cadastrar(mapperResponseRequestDTO.enderecoRequestParaDTO(endereco));

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody EnderecoRequest endereco) {

		try {
			enderecoService.alterar(id, mapperResponseRequestDTO.enderecoRequestParaDTO(endereco));

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {

		try {
			enderecoService.excluir(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
