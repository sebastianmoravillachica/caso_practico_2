package com.ejerciciopractico2.service.impl;

import com.ejerciciopractico2.domain.Evento;
import com.ejerciciopractico2.repository.EventoRepository;
import com.ejerciciopractico2.service.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento obtener(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void eliminar(Long id) {
        eventoRepository.deleteById(id);
    }
}