package com.pavelm.spcloud.msvc.cursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.pavelm.spcloud.msvc.cursos.models.Curso;
import com.pavelm.spcloud.msvc.cursos.repositories.CursoRepository;


@Service
public class CurosServiceImpl implements CursoService{
	
	@Autowired
	private CursoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Curso> listar() {
		// TODO Auto-generated method stub
		return (List<Curso>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Curso> porId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Curso crear(Curso curso) {
		// TODO Auto-generated method stub
		return repository.save(curso);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	
}
