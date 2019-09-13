package com.system.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.apirest.model.Agendamento;
import com.system.apirest.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	
	public Agendamento salvar(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}
	
}
