package com.gft.petshop.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gft.petshop.dto.CachorroDTO;

public interface CachorroService {
	
	Page<CachorroDTO> buscarTodos(Pageable pageable);
	Optional<CachorroDTO> buscarPorId(Integer id);
	void cadastrar(CachorroDTO cachorro);
	void alterar(Integer id, CachorroDTO cachorro);
	void excluir(Integer id);

}
