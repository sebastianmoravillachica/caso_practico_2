package com.ejerciciopractico2.controller;

import com.ejerciciopractico2.domain.Usuario;
import com.ejerciciopractico2.domain.Rol;
import com.ejerciciopractico2.service.UsuarioService;
import com.ejerciciopractico2.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolRepository.findAll());
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam Long rol, Usuario usuario) {

        Rol rolObj = rolRepository.findById(rol).orElse(null);
        usuario.setRol(rolObj);

        usuarioService.guardar(usuario);

        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.obtener(id));
        model.addAttribute("roles", rolRepository.findAll());
        return "usuarios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
}