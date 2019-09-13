package com.system.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.system.apirest.model.Profissional;
import com.system.apirest.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public Page<Profissional> listarPaginado(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return profissionalRepository.findAll(pageable);
	}
	
	public Profissional salvar(Profissional profissional) {
		return profissionalRepository.save(profissional);
	}
	
	
	
}
