package com.ejerciciopractico2.service;

import com.ejerciciopractico2.domain.Rol;
import java.util.List;

public interface RolService {

    List<Rol> listar();

    void guardar(Rol rol);

    void eliminar(Long id);

    Rol obtener(Long id);
}