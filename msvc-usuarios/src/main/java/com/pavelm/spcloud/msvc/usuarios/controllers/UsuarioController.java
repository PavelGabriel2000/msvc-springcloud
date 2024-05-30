package com.pavelm.spcloud.msvc.usuarios.controllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pavelm.spcloud.msvc.usuarios.models.Usuario;
import com.pavelm.spcloud.msvc.usuarios.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<Usuario> listar() {
		return service.Listar();
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> porId(@PathVariable Long id){
		if(service.porId(id).isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(service.porId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> o = service.porId(id);
		if(o.isEmpty()) return ResponseEntity.notFound().build();
		
		Usuario u = o.get();
		
		u.setNombre(usuario.getNombre());
		u.setEmail(usuario.getEmail());
		u.setPassword(usuario.getPassword());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(u));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		Optional<Usuario> o = service.porId(id);
		
		if(o.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		service.eliminar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
