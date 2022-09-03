package com.gft.petshop.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gft.petshop.dto.EnderecoDTO;

public interface EnderecoService {
	
	Page<EnderecoDTO> buscarTodos(Pageable pageable);
	Optional<EnderecoDTO> buscarPorId(Integer id);
	void cadastrar(EnderecoDTO endereco);
	void alterar(Integer id, EnderecoDTO endereco);
	void excluir(Integer id);

}
