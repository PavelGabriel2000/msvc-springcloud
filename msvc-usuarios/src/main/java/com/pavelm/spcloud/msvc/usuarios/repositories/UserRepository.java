package com.pavelm.spcloud.msvc.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pavelm.spcloud.msvc.usuarios.models.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long>{

}
