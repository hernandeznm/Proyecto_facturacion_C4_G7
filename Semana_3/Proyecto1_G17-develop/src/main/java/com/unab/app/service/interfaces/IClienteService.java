package com.unab.app.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unab.app.models.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();    //listar clientes
	public Page<Cliente> findAll(Pageable pageable);   //listar a partir de un pageable
	public void save(Cliente cliente);  //Crear
	public Cliente findOne(Long id);   //Consultar por id
	public void delete(Long id);    //Eliminar
}
