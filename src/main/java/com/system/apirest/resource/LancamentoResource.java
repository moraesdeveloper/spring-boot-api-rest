package com.system.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.apirest.model.Lancamento;
import com.system.apirest.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
@CrossOrigin(origins = "*")
public class LancamentoResource {
	
	@Autowired
	public LancamentoService lS;
	
	@GetMapping
	public List<Lancamento> listar(){
		return lS.listar();
	}
	
	@PostMapping
	public Lancamento salvar(@RequestBody Lancamento lancamento) {
		return lS.salvar(lancamento);
	}

}
