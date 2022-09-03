package com.gft.petshop.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gft.petshop.dto.AtendimentoDTO;

public interface AtendimentoService {
	
	
	Page<AtendimentoDTO> buscarTodos(Pageable pageable);
	Optional<AtendimentoDTO> buscarPorId(Integer id);
	void cadastrar(AtendimentoDTO atendimento);
	void alterar(Integer id, AtendimentoDTO atendimento);
	void excluir(Integer id);

}
