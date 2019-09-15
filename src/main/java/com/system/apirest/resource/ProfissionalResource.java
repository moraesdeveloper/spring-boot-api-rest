package com.system.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.system.apirest.model.Profissional;
import com.system.apirest.repository.ProfissionalRepository;
import com.system.apirest.service.ProfissionalService;

@RestController
@RequestMapping("/profissionais")
@CrossOrigin(origins = "*")
public class ProfissionalResource {

	@Autowired
	private ProfissionalService profissionalService;
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@GetMapping
	public List<Profissional> listarTodos(){
		return profissionalRepository.findAll();
	}
	
	/*
	@GetMapping
	public Page<Profissional> listarTodos(@RequestParam(value = "page", defaultValue = "0") int page,
										  @RequestParam(value = "size", defaultValue = "5") int size){
		return profissionalService.listarPaginado(page, size);
	}
	*/
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Profissional salvar(@RequestBody Profissional profissional) {
		return profissionalService.salvar(profissional);
	}
	
}
