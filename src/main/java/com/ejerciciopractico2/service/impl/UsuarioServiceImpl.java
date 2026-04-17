package com.ejerciciopractico2.service.impl;

import com.ejerciciopractico2.domain.Usuario;
import com.ejerciciopractico2.repository.UsuarioRepository;
import com.ejerciciopractico2.service.UsuarioService;
import com.ejerciciopractico2.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtener(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Usuario usuario) {

        if (usuario.getActivo() == null) {
            usuario.setActivo(true);
        }

        if (usuario.getFechaCreacion() == null) {
            usuario.setFechaCreacion(LocalDateTime.now());
        }

        usuarioRepository.save(usuario);

        emailService.enviarCorreo(usuario.getEmail());
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}