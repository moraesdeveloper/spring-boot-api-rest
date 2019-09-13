package com.system.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.apirest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByCodigo(Long codigo);
	
}
