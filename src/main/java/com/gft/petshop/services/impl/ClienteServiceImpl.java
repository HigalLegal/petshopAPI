package com.gft.petshop.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.petshop.dto.ClienteDTO;
import com.gft.petshop.mapper.MapperDeEntidadeDTO;
import com.gft.petshop.repositories.ClienteRepository;
import com.gft.petshop.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private MapperDeEntidadeDTO mapperDeEntidadeDTO;
	
	private final static String MENSAGEM_DE_ERRO = "Cliente inexistente.";
	
	// --------------------------------------------------------------------------------------

	@Override
	public Page<ClienteDTO> buscarTodos(Pageable pageable) {
		return clienteRepository.findAll(pageable).map(mapperDeEntidadeDTO::clienteParaDTO);
	}

	@Override
	public Optional<ClienteDTO> buscarPorId(Integer id) {
		
		ClienteDTO cliente = mapperDeEntidadeDTO.clienteParaDTO(clienteRepository.findById(id).get());
		
		return Optional.of(cliente);
	}

	@Override
	public void cadastrar(ClienteDTO cliente) {
		
		cliente.setId(null);
		
		clienteRepository.save(mapperDeEntidadeDTO.clienteParaEntidade(cliente));
		
	}

	@Override
	public void alterar(Integer id, ClienteDTO cliente) {
		
		if(clienteRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}
		
		cliente.setId(id);
		clienteRepository.save(mapperDeEntidadeDTO.clienteParaEntidade(cliente));
		
	}

	@Override
	public void excluir(Integer id) {
		
		if(clienteRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}
		
		clienteRepository.deleteById(id);
	}

}
