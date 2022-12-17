package com.unab.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.app.dao.IUsuarioDAO;
import com.unab.app.models.Usuario;
import com.unab.app.service.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDao;

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

		@Override
	public void save(Usuario usuario) {
			usuarioDao.save(usuario);
	}

	@Override
	public Usuario findOne(Long id) {
		return usuarioDao.findById(id).orElse(new Usuario());
	}

	@Override
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}

}
