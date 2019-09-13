package com.system.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.apirest.model.Cliente;
import com.system.apirest.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteService.listarTodos();
	}
	
	@GetMapping("/{codigo}")
	public Cliente buscarPorCodigo(@PathVariable Long codigo) {
		return clienteService.buscarPorCodigo(codigo);
	}
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@PutMapping("/{codigo}")
	public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable Long codigo) {
		return clienteService.atualizar(cliente, codigo);
	}
}
