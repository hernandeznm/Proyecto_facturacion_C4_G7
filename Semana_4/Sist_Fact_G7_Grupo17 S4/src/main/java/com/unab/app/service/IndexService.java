package com.unab.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.unab.app.models.Usuario;
import com.unab.app.service.interfaces.IServicio;

@Service
public class IndexService implements IServicio {

	@Value("${text.indexController.titulo}")
	private String USERNAME;

	private static final String MESSAGE_ONE = "Proyecto 1";

	@Override
	public Usuario operacion(Usuario usuario) {
		System.out.println(USERNAME + " - " + MESSAGE_ONE);
		System.out.println(usuario.getUsername());
		System.out.println(usuario.getPassword());
		return usuario;
	}
}
