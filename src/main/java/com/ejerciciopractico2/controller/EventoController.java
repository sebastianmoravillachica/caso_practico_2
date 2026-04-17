package com.ejerciciopractico2.controller;

import com.ejerciciopractico2.domain.Evento;
import com.ejerciciopractico2.service.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("eventos", eventoService.listar());
        return "eventos/lista";
    }

    // NUEVO 
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/formulario";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(Evento evento) {
        eventoService.guardar(evento);
        return "redirect:/eventos";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("evento", eventoService.obtener(id));
        return "eventos/formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        eventoService.eliminar(id);
        return "redirect:/eventos";
    }
}