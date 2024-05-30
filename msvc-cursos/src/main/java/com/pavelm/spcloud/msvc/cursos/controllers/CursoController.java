package com.pavelm.spcloud.msvc.cursos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pavelm.spcloud.msvc.cursos.models.Curso;
import com.pavelm.spcloud.msvc.cursos.services.CursoService;

@RestController
public class CursoController {

	@Autowired 
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> porId(@PathVariable Long id){
		Optional<Curso> o = service.porId(id);
		if(o.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Curso curso){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(curso));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Curso curso, @PathVariable Long id){
		Optional<Curso> o = service.porId(id);
		
		if(o.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		Curso c = o.get();
		
		c.setNombre(curso.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(c));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		Optional<Curso> o = service.porId(id);
		if(o.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		service.eliminar(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
