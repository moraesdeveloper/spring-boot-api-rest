package com.system.apirest.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.apirest.exceptions.ResourceNotFoundException;
import com.system.apirest.model.Cliente;
import com.system.apirest.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorCodigo(Long codigo) {
		Cliente cliente = clienteRepository.findByCodigo(codigo);
		if(cliente == null) {
			throw new ResourceNotFoundException("Não foi encontrado o cliente : " +codigo);
		}
		return cliente;
	}
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente atualizar(Cliente cliente, Long codigo) {
		Cliente entity = clienteRepository.findByCodigo(codigo);
		if(entity == null) {
			throw new ResourceNotFoundException("Não foi encontrado o cliente : " +codigo);

		}
		BeanUtils.copyProperties(cliente, entity, "codigo");
		clienteRepository.save(entity);
		return entity;
	}
	
	public void deletar(Long codigo) {
		Cliente cliente = clienteRepository.findByCodigo(codigo);
		if(cliente == null) {
			throw new ResourceNotFoundException("Não foi encontrado o cliente : " +codigo);
		}
		clienteRepository.delete(cliente);
	}
	
	
}
