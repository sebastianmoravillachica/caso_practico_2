package com.ejerciciopractico2.service;

import com.ejerciciopractico2.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    Usuario obtener(Long id);

    void guardar(Usuario usuario);

    void eliminar(Long id);
}