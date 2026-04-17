package com.ejerciciopractico2.service;

import com.ejerciciopractico2.domain.Evento;
import java.util.List;

public interface EventoService {

    List<Evento> listar();

    void guardar(Evento evento);

    void eliminar(Long id);

    Evento obtener(Long id);
}