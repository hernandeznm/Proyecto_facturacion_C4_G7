package com.unab.app.service.interfaces;

import java.util.List;


import com.unab.app.models.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();    //listar clientes
	public void save(Usuario usuario);  //Crear
	public Usuario findOne(Long id);   //Consultar por id
	public void delete(Long id);    //Eliminar
}
