package com.ejerciciopractico2.repository;

import com.ejerciciopractico2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByRolNombre(String nombreRol);

}