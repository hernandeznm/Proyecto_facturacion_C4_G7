package com.unab.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unab.app.models.Cliente;
import com.unab.app.service.interfaces.IClienteService;

@RestController
@RequestMapping(value="/cliente")
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@Secured("ROLE_USER")
	@GetMapping("/listar")
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/clientesPageable")
	public Page<Cliente> findAllPageable(){
		Pageable pageable=Pageable.ofSize(5);
		return clienteService.findAll(pageable);
	}
	
	@PostMapping("/saveClientes")
	public Cliente save(@RequestBody Cliente cliente){
		clienteService.save(cliente);
		return cliente;
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente findOne(@PathVariable("id") Long id){
		return clienteService.findOne(id);
	}
	
	@DeleteMapping("/deletecliente/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		Cliente cliente=clienteService.findOne(id);
		
		if(cliente.getId()!=null && cliente.getId()>0) {
			clienteService.delete(id);
			return new ResponseEntity<String> ("El cliente con el id: "+cliente.getId()+ " y de nombre: "+cliente.getNombre()+" fue eliminado con éxito" ,HttpStatus.OK);
		}
		return new ResponseEntity<String> ("El cliente no existe en la base de datos ",HttpStatus.BAD_REQUEST);
	}
	
}
