package com.ejerciciopractico2.service;

import com.ejerciciopractico2.domain.Evento;
import java.util.List;

public interface EventoService {

    List<Evento> listar();
    Evento obtener(Long id);
    void guardar(Evento evento);
    void eliminar(Long id);
}