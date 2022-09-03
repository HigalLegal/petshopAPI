package com.gft.petshop.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.petshop.dto.EnderecoDTO;
import com.gft.petshop.mapper.MapperDeEntidadeDTO;
import com.gft.petshop.repositories.EnderecoRepository;
import com.gft.petshop.services.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private MapperDeEntidadeDTO mapperDeEntidadeDTO;

	private static final String MENSAGEM_DE_ERRO = "Endereço inexistente.";

	// ---------------------------------------------------------------------------------------------------

	@Override
	public Page<EnderecoDTO> buscarTodos(Pageable pageable) {
		return enderecoRepository.findAll(pageable).map(mapperDeEntidadeDTO::enderecoParaDTO);
	}

	@Override
	public Optional<EnderecoDTO> buscarPorId(Integer id) {

		EnderecoDTO endereco = mapperDeEntidadeDTO.enderecoParaDTO(enderecoRepository.findById(id).get());
				
		return Optional.of(endereco);
	}

	@Override
	public void cadastrar(EnderecoDTO endereco) {
		endereco.setId(null);
		enderecoRepository.save(mapperDeEntidadeDTO.enderecoParaEntidade(endereco));
	}

	@Override
	public void alterar(Integer id, EnderecoDTO endereco) {

		if (enderecoRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}

		endereco.setId(id);
		enderecoRepository.save(mapperDeEntidadeDTO.enderecoParaEntidade(endereco));
	}

	@Override
	public void excluir(Integer id) {

		if (enderecoRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}

		enderecoRepository.deleteById(id);
	}

}
