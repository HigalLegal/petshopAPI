package com.gft.petshop.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gft.petshop.dto.MedicoVeterinarioDTO;

public interface MedicoVeterinarioService {
	
	Page<MedicoVeterinarioDTO> buscarTodos(Pageable pageable);
	Optional<MedicoVeterinarioDTO> buscarPorId(Integer id);
	void cadastrar(MedicoVeterinarioDTO medicoVeterinario);
	void alterar(Integer id, MedicoVeterinarioDTO medicoVeterinario);
	void excluir(Integer id);

}
