package com.example.relacionesjpa.repository;

import com.example.relacionesjpa.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {
}
