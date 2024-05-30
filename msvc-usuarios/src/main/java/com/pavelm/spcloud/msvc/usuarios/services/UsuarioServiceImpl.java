package com.pavelm.spcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavelm.spcloud.msvc.usuarios.models.Usuario;
import com.pavelm.spcloud.msvc.usuarios.repositories.UserRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UserRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> Listar() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> porId(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

}
