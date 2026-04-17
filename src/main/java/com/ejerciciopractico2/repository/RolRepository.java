package com.ejerciciopractico2.repository;

import com.ejerciciopractico2.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}