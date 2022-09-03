package com.gft.petshop.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.petshop.dto.CachorroDTO;
import com.gft.petshop.mapper.MapperDeEntidadeDTO;
import com.gft.petshop.repositories.CachorroRepository;
import com.gft.petshop.services.CachorroService;

@Service
public class CachorroServiceImpl implements CachorroService {

	@Autowired
	private CachorroRepository cachorroRepository;

	@Autowired
	private MapperDeEntidadeDTO mapperDeEntidadeDTO;

	private final static String MENSAGEM_DE_ERRO = "Cão inexistente.";

	// -------------------------------------------------------------------------------------------------------

	@Override
	public Page<CachorroDTO> buscarTodos(Pageable pageable) {
		return cachorroRepository.findAll(pageable).map(cachorro -> mapperDeEntidadeDTO.cachorroParaDTO(cachorro));
	}

	@Override
	public Optional<CachorroDTO> buscarPorId(Integer id) {
		CachorroDTO cachorro = mapperDeEntidadeDTO.cachorroParaDTO(cachorroRepository.findById(id).get());
		return Optional.of(cachorro);
	}

	@Override
	public void cadastrar(CachorroDTO cachorro) {

		cachorro.setId(null);

		cachorroRepository.save(mapperDeEntidadeDTO.cachorroParaEntidade(cachorro));

	}

	@Override
	public void alterar(Integer id, CachorroDTO cachorro) {

		if (cachorroRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}

		cachorro.setId(id);
		cachorroRepository.save(mapperDeEntidadeDTO.cachorroParaEntidade(cachorro));

	}

	@Override
	public void excluir(Integer id) {

		if (cachorroRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException(MENSAGEM_DE_ERRO);
		}

		cachorroRepository.deleteById(id);
	}

}
