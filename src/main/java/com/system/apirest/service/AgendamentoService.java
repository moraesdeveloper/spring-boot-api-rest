package com.system.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.system.apirest.exceptions.ResourceNotFoundException;
import com.system.apirest.model.Agendamento;
import com.system.apirest.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public Page<Agendamento> listarPaginado(int size, int page){
		Pageable pageable = PageRequest.of(page, size);
		return agendamentoRepository.findAll(pageable);
	}
	
	
	public Agendamento salvar(Agendamento agendamento) {
		validaDisponibilidade(agendamento);
		return agendamentoRepository.save(agendamento);
	}
	
	public void validaDisponibilidade(Agendamento agendamento) {
		List<Agendamento> todos = agendamentoRepository.findAll();
		for(Agendamento agendamentos : todos) {
			if(agendamentos.getData().equals(agendamento.getData())
					&& agendamentos.getHorario().equals(agendamento.getHorario())) {
				throw new ResourceNotFoundException("Horário indisponivel para realizar agendamento");
			}
		}
	}
	
	
	
	
}
