package com.unab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unab.app.models.Usuario;
import com.unab.app.service.interfaces.IServicio;

@RestController
@RequestMapping(value="/test")
public class IndexController {
	
//	private IndexService miservicio =new IndexService();	
//	@Autowired
//	private IndexService miservicio;	
	
	@Autowired
	private IServicio iservicio;
	
	@RequestMapping(value="/prueba", method = RequestMethod.GET)
	public String getPrueba() {
		System.out.println("Hola mundo, bienvenidos");
		return "index";
	} 
	
	@GetMapping("/pruebasinretorno")
	public void getPruebsinRetorno() {
		System.out.println("Prueba sin retorno");
	}
	
	@PostMapping("/postUsuario")
	public Usuario getObjecto(@RequestBody Usuario usuario) {
		return iservicio.operacion(usuario);
	}
	
//	@GetMapping("/indexParam/{nombre}")
//	public String indexParam(@PathVariable("nombre") String nombre) {
//		return miservicio.operacion(nombre);
//	}
	
}
