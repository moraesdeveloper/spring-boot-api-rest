package com.system.apirest.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.system.apirest.model.Agendamento;
import com.system.apirest.repository.AgendamentoRepository;
import com.system.apirest.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	
	@GetMapping
	public List<Agendamento> listar(){
		return agendamentoRepository.findAll();
	}
	
	/*
	@GetMapping
	public Page<Agendamento> listarPaginado(@RequestParam(value = "page", defaultValue="0") int page,
											@RequestParam(value = "size", defaultValue="5") int size){
		return agendamentoService.listarPaginado(size, page);
	}
	*/
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Agendamento salvar(@Valid @RequestBody Agendamento agendamento) {
		return agendamentoService.salvar(agendamento);
	}
	
	
	@DeleteMapping("/{codigo}")
	public void excluir(@PathVariable Long codigo) {
		Agendamento agendamento = agendamentoRepository.findByCodigo(codigo);
		agendamentoRepository.delete(agendamento);
	}
	
	
}
