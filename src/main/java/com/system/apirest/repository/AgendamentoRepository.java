package com.system.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.apirest.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	Agendamento findByCodigo(Long codigo);
	
}
