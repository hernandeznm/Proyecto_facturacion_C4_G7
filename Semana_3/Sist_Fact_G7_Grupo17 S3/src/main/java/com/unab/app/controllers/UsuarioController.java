package com.unab.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unab.app.models.Usuario;
import com.unab.app.service.interfaces.IUsuarioService;

@CrossOrigin(origins =  "*")
@RestController
@RequestMapping(value="/usuario")
@SessionAttributes("usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	
	@GetMapping("/mostrar")
	public List<Usuario> findAll(){
		return usuarioService.findAll();
	}
	
		
	@PostMapping("/saveUsuarios")
	public Usuario save(@RequestBody Usuario usuario){
		usuarioService.save(usuario);
		return usuario;
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario findOne(@PathVariable("id") Long id){
		return usuarioService.findOne(id);	
	}
	
	@DeleteMapping("/deleteusuario/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		Usuario usuario=usuarioService.findOne(id);
		
		if(usuario.getId()!=null && usuario.getId()>0) {
			usuarioService.delete(id);
			return new ResponseEntity<String> ("El usuario con el id: "+usuario.getId()+ " y de nombre: "+usuario.getUsername()+" fue eliminado con éxito" ,HttpStatus.OK);
		}
		return new ResponseEntity<String> ("El usuario no existe en la base de datos ",HttpStatus.BAD_REQUEST);
	}
	
}
