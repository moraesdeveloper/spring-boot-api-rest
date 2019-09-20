package com.system.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.apirest.model.Lancamento;
import com.system.apirest.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lR;
	
	
	public List<Lancamento> listar(){
		return lR.findAll();
	}
	
	public Lancamento salvar(Lancamento lancamento) {
		return lR.save(lancamento);
	}
	
	
	
	
}
