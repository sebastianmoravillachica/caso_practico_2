package com.ejerciciopractico2.service;

import com.ejerciciopractico2.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    void guardar(Usuario usuario);

    void eliminar(Long id);

    Usuario obtener(Long id);

    List<Usuario> buscarPorRol(String rol);
}