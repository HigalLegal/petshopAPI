package com.gft.petshop.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.petshop.dto.ClienteDTO;
import com.gft.petshop.dto.requests.CachorroPorClienteRequest;
import com.gft.petshop.dto.requests.ClienteRequest;
import com.gft.petshop.dto.requests.EnderecoPorClienteRequest;
import com.gft.petshop.dto.responses.ClienteResponse;
import com.gft.petshop.dto.responses.ClienteResponseAll;
import com.gft.petshop.mapper.MapperResponseRequestDTO;
import com.gft.petshop.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MapperResponseRequestDTO mapperResponseRequestDTO;

	// --------------------------------------------------------------------------------------
	
	//@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	@GetMapping
	public ResponseEntity<Page<ClienteResponseAll>> listarTodos(@PageableDefault Pageable pageable) {

		Page<ClienteResponseAll> clientes = clienteService.buscarTodos(pageable)
				.map(mapperResponseRequestDTO::clienteDtoParaResponseAll);

		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<ClienteResponse>> buscarPeloId(@PathVariable Integer id) {

		ClienteResponse cliente = mapperResponseRequestDTO
				.clienteDtoParaResponse(clienteService.buscarPorId(id).get());

		return new ResponseEntity<>(Optional.of(cliente), HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ResponseEntity<Void> adicionar(@RequestBody ClienteRequest cliente) {
		
		ClienteDTO clienteSalvo = mapperResponseRequestDTO.clienteRequestParaDTO(cliente);

		clienteService.cadastrar(clienteSalvo);

		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@PostMapping("/novo/popular-banco")
	public ResponseEntity<Void> popularBanco() {
		
		var cliente = new ClienteRequest();
		
		cliente.setNome("Ednaldo Pereira");
		cliente.setApelido("Mestre");
		cliente.setIdade(56);
		cliente.setCachorros(List.of(new CachorroPorClienteRequest(LocalDate.now(), "Kaique", "Pequeno")));
		cliente.setEnderecos(List.of(new EnderecoPorClienteRequest("Paraíba", "Guarabira", "Distrito de Cachoeiras", 
				"não sei", 611, "casa")));
		
		clienteService.cadastrar(mapperResponseRequestDTO.clienteRequestParaDTO(cliente));

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody ClienteRequest cliente) {

		try {
			clienteService.alterar(id, mapperResponseRequestDTO.clienteRequestParaDTO(cliente));

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/excluir/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {

		try {
			clienteService.excluir(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
