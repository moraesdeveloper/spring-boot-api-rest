package com.system.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.apirest.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

	Profissional findByCodigo(Long codigo);
	
}
