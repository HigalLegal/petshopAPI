package com.gft.petshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.petshop.model.entities.Cachorro;

public interface CachorroRepository extends JpaRepository<Cachorro, Integer> {
	
	Page<Cachorro> findAll(Pageable pageable);
	
}
