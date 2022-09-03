package com.gft.petshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.petshop.model.entities.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
	
	Page<Atendimento> findAll(Pageable pageable);
	
}
