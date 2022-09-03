package com.gft.petshop.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gft.petshop.dto.ClienteDTO;

public interface ClienteService {
	
	Page<ClienteDTO> buscarTodos(Pageable pageable);
	Optional<ClienteDTO> buscarPorId(Integer id);
	void cadastrar(ClienteDTO cliente);
	void alterar(Integer id, ClienteDTO cliente);
	void excluir(Integer id);

}
