package com.gft.petshop.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.petshop.dto.AtendimentoDTO;
import com.gft.petshop.mapper.MapperDeEntidadeDTO;
import com.gft.petshop.repositories.AtendimentoRepository;
import com.gft.petshop.services.AtendimentoService;

@Service
public class AtendimentoServiceImpl implements AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Autowired
	private MapperDeEntidadeDTO mapperDeEntidadeDTO;

	private final static String MENSAGEM_DE_ERRO = "Atendimento inexistente.";

	// ------------------------------------------------------------------------------------------

	@Override
	public Page<AtendimentoDTO> buscarTodos(Pageable pageable) {
		return atendimentoRepository.findAll(pageable)
				.map(atendimento -> mapperDeEntidadeDTO.atendimentoParaDTO(atendimento));
	}

	@Override
	public Optional<AtendimentoDTO> buscarPorId(Integer id) {
		AtendimentoDTO atendimento = mapperDeEntidadeDTO
				.atendimentoParaDTO(atendimentoRepository.findById(id).get());
		
		return Optional.of(atendimento);
	}

	@Override
	public void cadastrar(AtendimentoDTO atendimento) {

		atendimento.setId(null);

		atendimentoRepository.save(mapperDeEntidadeDTO.atendimentoParaEntidade(atendimento));

	}

	@Override
	public void alterar(Integer id, AtendimentoDTO atendimento) {

		if (atendimentoRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}

		atendimento.setId(id);
		atendimentoRepository.save(mapperDeEntidadeDTO.atendimentoParaEntidade(atendimento));

	}

	@Override
	public void excluir(Integer id) {

		if (atendimentoRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}

		atendimentoRepository.deleteById(id);
	}

}
