package com.gft.petshop.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.petshop.dto.MedicoVeterinarioDTO;
import com.gft.petshop.mapper.MapperDeEntidadeDTO;
import com.gft.petshop.repositories.MedicoVeterinarioRepository;
import com.gft.petshop.services.MedicoVeterinarioService;

@Service
public class MedicoVeterinarioImpl implements MedicoVeterinarioService {

	@Autowired
	private MedicoVeterinarioRepository medicoVeterinarioRepository;

	@Autowired
	private MapperDeEntidadeDTO mapperDeEntidadeDTO;

	private final static String MENSAGEM_DE_ERRO = "Médico inexistente.";

	// ------------------------------------------------------------------------------------------

	@Override
	public Page<MedicoVeterinarioDTO> buscarTodos(Pageable pageable) {
		return medicoVeterinarioRepository.findAll(pageable).map(mapperDeEntidadeDTO::medicoParaDTO);
	}

	@Override
	public Optional<MedicoVeterinarioDTO> buscarPorId(Integer id) {

		MedicoVeterinarioDTO medicoVeterinarioDTO = mapperDeEntidadeDTO
				.medicoParaDTO(medicoVeterinarioRepository.findById(id).get());

		return Optional.of(medicoVeterinarioDTO);
	}

	@Override
	public void cadastrar(MedicoVeterinarioDTO medicoVeterinario) {

		medicoVeterinario.setId(null);

		medicoVeterinarioRepository.save(mapperDeEntidadeDTO.medicoParaEntidade(medicoVeterinario));

	}

	@Override
	public void alterar(Integer id, MedicoVeterinarioDTO medicoVeterinario) {

		if (medicoVeterinarioRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}

		medicoVeterinario.setId(id);
		medicoVeterinarioRepository.save(mapperDeEntidadeDTO.medicoParaEntidade(medicoVeterinario));

	}

	@Override
	public void excluir(Integer id) {

		if (medicoVeterinarioRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}

		medicoVeterinarioRepository.deleteById(id);
	}

}
