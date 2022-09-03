package com.gft.petshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.petshop.model.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	Page<Endereco> findAll(Pageable pageable);
	
}
