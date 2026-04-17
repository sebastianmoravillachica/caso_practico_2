package com.ejerciciopractico2.repository;

import com.ejerciciopractico2.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    
    List<Evento> findByActivo(boolean activo);

    
    List<Evento> findByFechaBetween(LocalDate inicio, LocalDate fin);

    
    List<Evento> findByNombreContaining(String nombre);
}