package com.ejerciciopractico2.service.impl;

import com.ejerciciopractico2.domain.Rol;
import com.ejerciciopractico2.repository.RolRepository;
import com.ejerciciopractico2.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public void guardar(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Rol obtener(Long id) {
        return rolRepository.findById(id).orElse(null);
    }
}