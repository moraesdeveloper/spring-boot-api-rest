package com.system.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.apirest.model.Agendamento;
import com.system.apirest.repository.AgendamentoRepository;
import com.system.apirest.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@GetMapping
	public List<Agendamento> listaTodos(){
		return agendamentoRepository.findAll();
	}
	
	
	@PostMapping
	public Agendamento salvar(@RequestBody Agendamento agendamento) {
		return agendamentoService.salvar(agendamento);
	}
	
}
