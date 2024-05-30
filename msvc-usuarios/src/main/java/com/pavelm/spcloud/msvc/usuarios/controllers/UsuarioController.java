package com.pavelm.spcloud.msvc.usuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public ResponseEntity<?> porId(Long id){
		if(service.porId(id).isEmpty()) ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(service.porId(id));
	}
	
	
}
