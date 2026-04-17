package com.ejerciciopractico2.service;

import com.ejerciciopractico2.domain.Usuario;
import com.ejerciciopractico2.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return User.builder()
                .username(usuario.getEmail())
                .password("{noop}" + usuario.getPassword()) //
                .roles(usuario.getRol().getNombre())
                .build();
    }
}