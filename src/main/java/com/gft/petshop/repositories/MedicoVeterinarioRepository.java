package com.gft.petshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.petshop.model.entities.MedicoVeterinario;

public interface MedicoVeterinarioRepository extends JpaRepository<MedicoVeterinario, Integer> {
	
	Page<MedicoVeterinario> findAll(Pageable pageable);
	
}
