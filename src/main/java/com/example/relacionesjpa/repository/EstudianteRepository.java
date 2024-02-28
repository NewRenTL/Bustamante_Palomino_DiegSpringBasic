package com.example.relacionesjpa.repository;

import com.example.relacionesjpa.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {
}
