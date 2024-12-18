package com.example.demo.repository;

import com.example.demo.repository.model.Cosa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CosaRepository extends JpaRepository<Cosa, Long> {
    // Método para obtener todas las cosas asociadas con un propietario

    List<Cosa> findByPropietario(Long propietario);
}
