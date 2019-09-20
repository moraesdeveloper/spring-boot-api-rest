package com.system.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.apirest.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	Lancamento findByCodigo(Long codigo);
	
}
