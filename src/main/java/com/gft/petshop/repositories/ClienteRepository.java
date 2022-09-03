package com.gft.petshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.petshop.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Page<Cliente> findAll(Pageable pageable);
	
}
