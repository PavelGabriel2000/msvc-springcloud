package com.pavelm.spcloud.msvc.cursos.services;

import java.util.List;
import java.util.Optional;

import com.pavelm.spcloud.msvc.cursos.models.Curso;

public interface CursoService {

	List<Curso> listar();
	Optional<Curso> porId(Long id);
	Curso crear(Curso curso);
	void eliminar(Long id);
}
