package com.pavelm.spcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.pavelm.spcloud.msvc.usuarios.models.Usuario;

public interface UsuarioService {
	List<Usuario> Listar();
	Optional<Usuario> porId(Long id);
	Usuario guardar(Usuario usuario);
	void eliminar(Long id);
}
